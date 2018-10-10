package zhiren.vendingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.ProductByNO;
import retrofit.Api;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.SPHelper;
import utils.ToastUtil;

public class GoodsListActivity extends AppCompatActivity {

    @BindView(R.id.tvNo)
    TextView tvNo;
    @BindView(R.id.grid)
    GridView grid;
    @BindView(R.id.tvLast)
    TextView tvLast;
    @BindView(R.id.chronometer)
    Chronometer chronometer;
    @BindView(R.id.llBack)
    LinearLayout llBack;
    @BindView(R.id.tvNext)
    TextView tvNext;

    private int page = 1;//当前页数
    private int total;//商品总页数
    private List<ProductByNO.DsBean> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        chronometer.setBase(SystemClock.elapsedRealtime());//计时前时间清零
        chronometer.start();
        getGoodsList(page);
        if (total > 1) {
            tvNext.setVisibility(View.VISIBLE);
        }
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int dataId = dataList.get(position).getId();
                Intent intent = new Intent(GoodsListActivity.this, GoodsDetailActivity.class);
                intent.putExtra("id", dataId);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.tvLast, R.id.llBack, R.id.tvNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLast:
                ToastUtil.showToast(this, page + "");
                page--;
                if (page == 1) {
                    tvLast.setVisibility(View.INVISIBLE);
                }
                getGoodsList(page);
                break;
            case R.id.llBack:
                chronometer.stop();
                finish();
                break;
            case R.id.tvNext:
                ToastUtil.showToast(this, page + "");
                page++;
                if (page > 1) {
                    tvLast.setVisibility(View.VISIBLE);
                }
                if (total == page) {
                    tvNext.setVisibility(View.INVISIBLE);
                    return;
                }
                getGoodsList(page);
                break;
        }
    }

    public void getGoodsList(int page) {
        String no = SPHelper.getString(this, "no");
        //  缓存的编号为空字符就重新登陆
        if (no.equals("")) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            tvNo.setText(String.format("本机号码：%s",no));
            Api.getDefault().getMachineProductByNO(no, 24, page)
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ProductByNO>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(ProductByNO productByNO) {
                            total = productByNO.getPagecount();
                            Log.d("totaltotal", total + "");
                            dataList = productByNO.getDs();
                            grid.setAdapter(new GoodsListAdapter(GoodsListActivity.this, dataList, R.layout.goods_item));
                        }
                    });
        }
    }
}
