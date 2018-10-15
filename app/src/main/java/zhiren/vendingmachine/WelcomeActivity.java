package zhiren.vendingmachine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Ad;
import retrofit.Api;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.SPHelper;
import utils.ToastUtil;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.btnEnter)
    Button mBtnEnter;
    @BindView(R.id.rlBg)
    RelativeLayout mRlBg;
    @BindView(R.id.iv)
    ImageView mIv;

    private List<String> pathList = new ArrayList<>();
    private List<Integer> timeList = new ArrayList<>();
    private int num = 0;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 0) {
                loadImage(pathList.get(num), timeList.get(num));
                return true;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        getAd();
        mIv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WelcomeActivity.this);
                View view = LayoutInflater.from(WelcomeActivity.this).inflate(R.layout.dialog_edit, null);
                final Dialog dialog = builder.create();
                dialog.show();
//              避免dialog里的输入框无法弹出软键盘
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                dialog.getWindow().setContentView(view);
                final EditText editText = view.findViewById(R.id.et);
                Button button = view.findViewById(R.id.btnEnter);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (editText.getText().toString().trim().equals(SPHelper.getString(WelcomeActivity.this, "no"))) {
                            Intent intent = new Intent(Settings.ACTION_SETTINGS);
                            startActivity(intent);
                        } else {
                            ToastUtil.showToast(WelcomeActivity.this, "机器编号错误");
                        }
                    }
                });
                return true;
            }
        });
    }

    @OnClick(R.id.btnEnter)
    public void onViewClicked() {
        startActivity(new Intent(this, GoodsListActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    public void getAd() {
        Api.getDefault().getAdvList()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Ad>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Ad ad) {
                        List<Ad.Ds> adList = ad.getDs();
                        for (Ad.Ds ds : adList) {
                            String imgPath = ds.getImg();
                            int lastTime = ds.getSeconds();
                            pathList.add(imgPath);
                            timeList.add(lastTime);
                        }
                        if (adList.size() > 0) {
                            loadImage(pathList.get(0), timeList.get(0));
                        }
                    }
                });
    }

    public void loadImage(final String path, final int time) {
        Glide.with(WelcomeActivity.this).load(path).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                if (num < pathList.size()) {
                    num++;
                    if (num == pathList.size()) {
                        num = 0;
                    }
                }
                Log.d("numnum", "num=" + num);
                Log.d("numnum", "path=" + path);
                Log.d("numnum", "time=" + time);
                mRlBg.setBackground(resource);
                mHandler.sendEmptyMessageDelayed(0, time * 1000);
            }
        });
    }
}
