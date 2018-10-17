package zhiren.vendingmachine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mylibrary.serialportlibrary.WMSerialportManager;
import com.example.mylibrary.serialportlibrary.listener.WMSerialportCallBack;
import com.example.mylibrary.serialportlibrary.protocol.WMSSendType;
import com.mylhyl.zxing.scanner.encode.QREncode;
import com.xuhao.android.common.basic.bean.OriginalData;
import com.xuhao.android.common.interfacies.client.msg.ISendable;
import com.xuhao.android.libsocket.sdk.OkSocket;
import com.xuhao.android.libsocket.sdk.client.ConnectionInfo;
import com.xuhao.android.libsocket.sdk.client.OkSocketOptions;
import com.xuhao.android.libsocket.sdk.client.action.SocketActionAdapter;
import com.xuhao.android.libsocket.sdk.client.bean.IPulseSendable;
import com.xuhao.android.libsocket.sdk.client.connection.IConnectionManager;
import com.xuhao.android.libsocket.sdk.client.connection.NoneReconnect;

import java.nio.charset.Charset;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import data.DefaultSendBean;
import model.PayOrder;
import model.Product;
import retrofit.Api;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.SPHelper;
import utils.ToastUtil;

public class GoodsDetailActivity extends AppCompatActivity implements WMSerialportCallBack {

    @BindView(R.id.tvNo)
    TextView tvNo;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvMoney)
    TextView tvMoney;
    @BindView(R.id.tvGoodsNo)
    TextView tvGoodsNo;
    @BindView(R.id.tvDetail)
    TextView tvDetail;
    @BindView(R.id.chronometer)
    Chronometer chronometer;
    @BindView(R.id.llBack)
    LinearLayout llBack;
    @BindView(R.id.tvPay)
    TextView tvPay;

    private int id;
    private IConnectionManager mManager;
    private ConnectionInfo mInfo;
    private OkSocketOptions mOkOptions;
    private Dialog dialog;
    private static final String ServerIP = "120.79.10.40";
    private static final int ServerPort = 10001;
    private SocketActionAdapter adapter = new SocketActionAdapter() {

        @Override
        public void onSocketConnectionSuccess(Context context, ConnectionInfo info, String action) {
            Log.d("strstrstr", action);
            DefaultSendBean sendBean = new DefaultSendBean();
            sendBean.setContent(SPHelper.getString(GoodsDetailActivity.this, "no"));
            mManager.send(sendBean);
        }

        @Override
        public void onSocketDisconnection(Context context, ConnectionInfo info, String action, Exception e) {
            if (e != null) {
                Log.d("strstrstr", "异常断开:" + e.getMessage());
            } else {
                Log.d("strstrstr", "正常断开");
            }
        }

        @Override
        public void onSocketConnectionFailed(Context context, ConnectionInfo info, String action, Exception e) {
            Log.d("strstrstr", "连接失败");
        }

        @Override
        public void onSocketReadResponse(Context context, ConnectionInfo info, String action, OriginalData data) {
            super.onSocketReadResponse(context, info, action, data);
            String str = new String(data.getBodyBytes(), Charset.forName("utf-8"));
            Log.d("strstrstr", "str=" + str);
            int chanelNoId = Integer.parseInt(str);
//          吐货
            String serialtype = SPHelper.getString(GoodsDetailActivity.this, "serialtype");
            Log.d("strstrstr", "chanelNoId=" + chanelNoId);
            Log.d("strstrstr", "serialtype=" + serialtype);
            WMSerialportManager.openSerialPort(serialtype, GoodsDetailActivity.this);
            WMSerialportManager.setDeliver(0, chanelNoId, 0, 15 * 1000, GoodsDetailActivity.this);
            startActivity(new Intent(GoodsDetailActivity.this, GoodsListActivity.class));
            finish();
        }

        @Override
        public void onSocketWriteResponse(Context context, ConnectionInfo info, String action, ISendable data) {
            super.onSocketWriteResponse(context, info, action, data);
            String str = new String(data.parse(), Charset.forName("utf-8"));
            Log.d("strstrstr", str);
        }

        @Override
        public void onPulseSend(Context context, ConnectionInfo info, IPulseSendable data) {
            super.onPulseSend(context, info, data);
            String str = new String(data.parse(), Charset.forName("utf-8"));
            Log.d("strstrstr", str);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        chronometer.setBase(SystemClock.elapsedRealtime());//计时前时间清零
        chronometer.start();
        id = getIntent().getIntExtra("id", 0);
        Log.d("totaltokl", id + "");
        WMSerialportManager.initWMSerialport(getApplicationContext(), 15 * 1000);

        initManager();
        getDetail(id);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
//              用户三分钟没有触摸屏幕就会跳转到广告页面
                if (chronometer.getText().toString().substring(1, 2).equals("3")) {
                    chronometer.stop();
                    startActivity(new Intent(GoodsDetailActivity.this, WelcomeActivity.class));
                }

            }
        });
    }

    @OnClick({R.id.llBack, R.id.tvPay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llBack:
                chronometer.stop();
                finish();
                break;
            case R.id.tvPay:
                if (dialog == null || (dialog != null && !dialog.isShowing())) {
                    getPayQR(id);
                }
                break;
        }
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                //有按下动作时取消定时
//                //stopTimer();
//                chronometer.stop();
//                break;
//            case MotionEvent.ACTION_UP:
//                //抬起时启动定时
//                //startTimer();
//                chronometer.setBase(SystemClock.elapsedRealtime());//计时前时间清零
//                chronometer.start();
//                break;
//        }
//        return super.dispatchTouchEvent(ev);
//    }

    private void initManager() {
        mInfo = new ConnectionInfo(ServerIP, ServerPort);
        mOkOptions = new OkSocketOptions.Builder()
                .setReconnectionManager(new NoneReconnect())
                .setWritePackageBytes(1024)
                .setCallbackInThread(false)
                .build();
        mManager = OkSocket.open(mInfo).option(mOkOptions);
        mManager.connect();
        mManager.registerReceiver(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mManager != null) {
            mManager.disconnect();
            mManager.unRegisterReceiver(adapter);
        }
    }

    public void getDetail(int id) {
        String no = SPHelper.getString(this, "no");
        //  缓存的机器编号为空字符就重新登陆
        if (no.equals("")) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            tvNo.setText(String.format("本机编号：%s", no));
            Api.getDefault().getProductInfo(id)
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Product>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Product product) {
                            tvName.setText(product.getProductname());
                            tvDetail.setText(product.getDescr());
                            tvMoney.setText(String.format("%s 元", product.getPrice()));
                            tvGoodsNo.setText(product.getLotno());
                            Glide.with(GoodsDetailActivity.this).load(product.getImg_b()).into(iv);
                        }
                    });
        }
    }

    public void getPayQR(int id) {
        Api.getDefault().pay(id)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PayOrder>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PayOrder payOrder) {
                        if (payOrder.getCode() == 0) {
                            ToastUtil.showToast(GoodsDetailActivity.this, payOrder.getMsg());
                        } else {
                            Log.d("dialogdialog", "dialog");
                            AlertDialog.Builder builder = new AlertDialog.Builder(GoodsDetailActivity.this);
                            View v = LayoutInflater.from(GoodsDetailActivity.this).inflate(R.layout.dialog_scan_qr, null);
                            ImageView ivCancel = v.findViewById(R.id.ivCancel);
                            ImageView ivQR = v.findViewById(R.id.ivQR);
                            dialog = builder.create();
                            dialog.show();
                            dialog.getWindow().setContentView(v);
                            ivCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            Bitmap bitmap = new QREncode.Builder(GoodsDetailActivity.this)
                                    .setColor(getResources().getColor(R.color.color_light_black))//二维码颜色
                                    //.setParsedResultType(ParsedResultType.TEXT)//默认是TEXT类型
                                    .setContents(payOrder.getQrcodeurl())//二维码内容
                                    //.setLogoBitmap(logoBitmap)//二维码中间logo
                                    .build().encodeAsBitmap();
                            Glide.with(GoodsDetailActivity.this).load(bitmap).into(ivQR);
                        }
                    }
                });
    }

    @Override
    public void onSucceed(WMSSendType wmsSendType, Object o) {
        Log.d("WMSSendTypeWMSSendType", "onSucceed WMSSendType:" + wmsSendType + "  Object:" + o);
    }

    @Override
    public void onFailed(WMSSendType wmsSendType, int i) {
        Log.d("WMSSendTypeWMSSendType", "onFailed WMSSendType:" + wmsSendType + "  int:" + i);
    }
}
