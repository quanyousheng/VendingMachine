package zhiren.vendingmachine;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayActivity extends Activity {

    @BindView(R.id.ivQR)
    ImageView ivQR;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.ivCancel)
    ImageView ivCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCancel)
    public void onViewClicked() {
        finish();
    }
}
