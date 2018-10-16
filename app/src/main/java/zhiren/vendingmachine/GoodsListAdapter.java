package zhiren.vendingmachine;

import android.content.Context;
import android.widget.ImageView;

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
        holder.setText(R.id.tvNo,item.getAisleno());
        holder.setText(R.id.tvName,item.getProductname());
        holder.setText(R.id.tvMoney,String.format("%s 元",item.getPrice()));
        ImageView imageView=holder.findViewById(R.id.image);
        Glide.with(imageView.getContext()).load(item.getImg_s()).into(imageView);
    }

}
