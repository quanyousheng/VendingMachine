package zhiren.vendingmachine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.DeviceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.MachineLogin;
import retrofit.Api;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.CheckNetwork;
import utils.SPHelper;
import utils.ToastUtil;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etNo)
    EditText etNo;
    @BindView(R.id.btnEnter)
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//      设备编号no存在就直接跳转到广告页
        if (!SPHelper.getString(this, "no").equals("")) {
            startActivity(new Intent(this, WelcomeActivity.class));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEnter)
    public void onViewClicked() {
        hideSoftInput();
        boolean connected = CheckNetwork.isNetworkConnected(this);
        if (connected) {
            final String no = etNo.getText().toString().trim();
            if (no == null || no.equals("")) {
                ToastUtil.showToast(this, "请输入本机编号");
                return;
            }
            String macAddress = DeviceUtils.getMacAddress();
            Log.d("macAddress", macAddress);
            Api.getDefault().login(no, macAddress)
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<MachineLogin>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(MachineLogin machineLogin) {
                            if (machineLogin.getCode() == 0) {
                                ToastUtil.showToast(LoginActivity.this, machineLogin.getMsg());
                            } else {
//                              存储设备编号no、串口类型，根据该编号no获取设备关联的商品
                                SPHelper.putString(LoginActivity.this, "no", no);
                                SPHelper.putString(LoginActivity.this, "serialtype", machineLogin.getModel().getSerialtype());
                                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                                startActivity(intent);
                            }
                        }
                    });

        } else {
            ToastUtil.showToast(this, "网络未连接");
        }
    }

    /**
     * 收起键盘
     */
    public void hideSoftInput() {
        // 收起键盘
        View view = getWindow().peekDecorView();// 用于判断虚拟软键盘是否是显示的
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
