package zhiren.vendingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Product;
import retrofit.Api;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.SPHelper;

public class GoodsDetailActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        chronometer.setBase(SystemClock.elapsedRealtime());//计时前时间清零
        chronometer.start();
        int id = getIntent().getIntExtra("id", 0);
        Log.d("totaltokl", id + "");
        getDetail(id);
    }

    @OnClick({R.id.llBack, R.id.tvPay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llBack:
                chronometer.stop();
                finish();
                break;
            case R.id.tvPay:
                startActivity(new Intent(this, PayActivity.class));
                break;
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
            tvNo.setText(String.format("本机号码：%s",no));
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
                            tvMoney.setText(product.getPrice() + "");
                            tvGoodsNo.setText(product.getLotno());
                            Glide.with(GoodsDetailActivity.this).load(product.getImg_b()).into(iv);
                        }
                    });
        }
    }
}
