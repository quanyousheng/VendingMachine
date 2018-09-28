package zhiren.vendingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
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
import model.ProductById;
import retrofit.Api;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    private int page=1;//当前页数
    private int id;//机器id
    private int no;//机器no
    private List<ProductById.Ds> dataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        chronometer.setBase(SystemClock.elapsedRealtime());//计时前时间清零
        chronometer.start();
        getGoodsList(id,page);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int dataId=dataList.get(position).getProductid();
                Intent intent=new Intent(GoodsListActivity.this,GoodsDetailActivity.class);
                intent.putExtra("id",dataId);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.tvLast, R.id.llBack, R.id.tvNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLast:
                break;
            case R.id.llBack:
                chronometer.stop();
                finish();
                break;
            case R.id.tvNext:
                break;
        }
    }

    public void getGoodsList(int id,int page){
        Api.getDefault().getMachineProductByID(id,24,page)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductById>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ProductById productById) {
                       dataList= productById.getDs();
                       grid.setAdapter(new GoodsListAdapter(GoodsListActivity.this,dataList,R.layout.goods_item));
                    }
                });
    }
}
