package zhiren.vendingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mylibrary.serialportlibrary.WMSerialportManager;
import com.example.mylibrary.serialportlibrary.listener.WMDeviceToAppCallBack;
import com.example.mylibrary.serialportlibrary.listener.WMSerialportCallBack;
import com.example.mylibrary.serialportlibrary.protocol.WMSSendType;
import com.example.mylibrary.serialportlibrary.utils.Byte2Hex;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mylibrary.serialportlibrary.utils.Byte2Hex.bytes2HexString;

public class WelcomeActivity extends AppCompatActivity implements WMSerialportCallBack {

    @BindView(R.id.btnEnter)
    Button mBtnEnter;
    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        WMSerialportManager.initWMSerialport(getApplicationContext(), 15 * 1000);
        WMSerialportManager.addWMDeviceToAppCallBack(new WMDeviceToAppCallBack() {
            @Override
            public void onSuccess(byte[] bytes) {
                String order = bytes2HexString(bytes).substring(18, 34);
                String state = Byte2Hex.bytes2HexString(bytes).substring(34, 36);
                System.out.println("order: " + order);
                System.out.println("状态: " + state);

                Message message = handler.obtainMessage();
                message.what = 2;
                message.obj = (String) ("自动上报数据为: order: " + order + "  state:" + state);
                handler.sendMessage(message);
            }
        });
    }

    @OnClick(R.id.btnEnter)
    public void onViewClicked() {
        startActivity(new Intent(this, GoodsListActivity.class));
//        WMSerialportManager.setDeliver(0, 91, 0, 15 * 1000, this);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
//                    textView.setText((String)msg.obj);
                    break;
                case 2:
//                    textView2.setText((String)msg.obj);
                    break;
            }

        }
    };

    @Override
    public void onSucceed(WMSSendType wmsSendType, Object o) {
        // System.out.println("MainActivity onSucceed WMSSendType:"+ wmsSendType +"  date:"+o);
        Log.d("WMSSendTypeWMSSendType", "MainActivity onSucceed WMSSendType:" + wmsSendType + "  ob:" + o);

    }

    @Override
    public void onFailed(WMSSendType wmsSendType, int i) {
        Log.d("WMSSendTypeWMSSendType", "MainActivity onSucceed WMSSendType:" + wmsSendType + "  date:" + i);
    }

    @OnClick(R.id.iv)
    public void onViewClicked1() {
        WMSerialportManager.openSerialPort("ttyS1", this);
    }
}
