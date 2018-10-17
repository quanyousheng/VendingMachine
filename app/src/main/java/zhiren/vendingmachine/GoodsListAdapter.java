package zhiren.vendingmachine;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

import model.ProductByNO;

public class GoodsListAdapter extends SuperAdapter<ProductByNO.DsBean> {

    public GoodsListAdapter(Context context, List<ProductByNO.DsBean> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, ProductByNO.DsBean item) {
        holder.setText(R.id.tvName, item.getProductname());
        holder.setText(R.id.tvMoney, String.format("%s 元", item.getPrice()));
        ImageView imageView = holder.findViewById(R.id.image);
        LinearLayout llBg = holder.findViewById(R.id.llBg);
        Context context = imageView.getContext();
        Glide.with(context).load(item.getImg_s()).into(imageView);
//        if (item.getCurrentnum() == 0) {
//            llBg.setBackgroundColor(context.getResources().getColor(R.color.color_light_black));
////            llBg.setClickable(false);
//        }
    }

}
