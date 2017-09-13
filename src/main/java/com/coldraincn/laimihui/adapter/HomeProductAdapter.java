package com.coldraincn.laimihui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.entity.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/12 0012.
 */

public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.ProductViewHolder>{
    //    private List<Product.DataBean.DatalistBean> mDataBean = new ArrayList<>();
    private List<Map<String, Object>> listItems;
    private final Context mContext;
    public HomeProductAdapter(Context context , List<Map<String, Object>> listItems) {
//        this.mDataBean = mProduct;
        this.listItems = listItems;
        this.mContext = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_product_list,parent,false));
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        if (listItems.size() > 0 ){
//            Product.DataBean.DatalistBean itemBean = mDataBean.get(position);
            Picasso.with(mContext).load(listItems.get(position).get("pic").toString()).into(holder.product_pic);
            holder.product_name.setText(listItems.get(position).get("name").toString());
            holder.product_price.setText("￥" + listItems.get(position).get("price").toString());
        }
    }

    @Override
    public int getItemCount() {
        return listItems == null ? 0 : listItems.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.product_pic)
        ImageView product_pic;
        @BindView(R.id.product_name)
        TextView product_name;
        @BindView(R.id.product_price)
        TextView product_price;
        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
