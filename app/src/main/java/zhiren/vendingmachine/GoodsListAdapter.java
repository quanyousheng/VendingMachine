package zhiren.vendingmachine;

import android.content.Context;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

import model.ProductById;

public class GoodsListAdapter extends SuperAdapter<ProductById.Ds> {

    public GoodsListAdapter(Context context, List<ProductById.Ds> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, ProductById.Ds item) {
        holder.setText(R.id.tvNo,item.getAisleno());
        holder.setText(R.id.tvName,item.getProductname());
        holder.setText(R.id.tvMoney,item.getPrice()+"");
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
