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
    private GoodsListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new GoodsListAdapter(this, dataList, R.layout.goods_item);
        grid.setAdapter(mAdapter);
        getGoodsList(page);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chronometer.stop();
                int dataId = dataList.get(position).getId();
                Intent intent = new Intent(GoodsListActivity.this, GoodsDetailActivity.class);
                intent.putExtra("id", dataId);
                startActivity(intent);
            }
        });
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
//                三分钟内用户没有操作屏幕就会跳转到广告页面
                if (chronometer.getText().toString().substring(1, 2).equals("2")) {
                    chronometer.stop();
                    startActivity(new Intent(GoodsListActivity.this, WelcomeActivity.class));
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        chronometer.setBase(SystemClock.elapsedRealtime());//计时前时间清零
        chronometer.start();
    }

    @OnClick({R.id.tvLast, R.id.llBack, R.id.tvNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLast:
                page--;
                if (page == 1) {
                    tvLast.setVisibility(View.INVISIBLE);
                }
                Log.d("totaltotal", "page=" + page);
                getGoodsList(page);
                break;
            case R.id.llBack:
                chronometer.stop();
                finish();
                break;
            case R.id.tvNext:
                page++;
                if (page > 1) {
                    tvLast.setVisibility(View.VISIBLE);
                }

                Log.d("totaltotal", "page=" + page);
                getGoodsList(page);
                break;
        }
    }

    public void getGoodsList(final int page) {
        String no = SPHelper.getString(this, "no");
        Log.d("totaltotal", no);
        //  缓存的编号为空字符就重新登陆
        if (no.equals("")) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            tvNo.setText(String.format("本机号码：%s", no));
            Api.getDefault().getMachineProductByNO(no, 24, page)
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ProductByNO>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("totaltotal", e.toString());
                        }

                        @Override
                        public void onNext(ProductByNO productByNO) {
                            dataList.clear();
                            total = productByNO.getPagecount();
                            Log.d("totaltotal", total + "");
                            if (total > 1) {
                                tvNext.setVisibility(View.VISIBLE);
                            }
                            if (total == page) {
                                tvNext.setVisibility(View.INVISIBLE);
                            }
                            dataList.addAll(productByNO.getDs());
                            Log.d("totaltotal", dataList.size() + "");
                            mAdapter.notifyDataSetHasChanged();
                        }
                    });
        }
    }

    //    监听用户有无屏幕触摸操作
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
}
