package zhiren.vendingmachine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Product;
import retrofit.Api;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        int id=getIntent().getIntExtra("id",0);
        getDetail(id);
    }

    @OnClick({R.id.llBack, R.id.tvPay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llBack:
                finish();
                break;
            case R.id.tvPay:
                break;
        }
    }

    public void getDetail(int id){
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
                      tvNo.setText(product.getLotno());
                      tvName.setText(product.getProductname());
                      tvDetail.setText(product.getDescr());
                      tvMoney.setText(product.getCostprice()+"");
                    }
                });

    }
}
