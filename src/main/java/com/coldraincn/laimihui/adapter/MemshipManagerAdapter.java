package com.coldraincn.laimihui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.entity.Memship;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/09/13.
 */

public class MemshipManagerAdapter extends RecyclerView.Adapter<MemshipManagerAdapter.MyViewHolder> {
    private Context mContext;
    private List<Memship.DataBean> data;
    private LayoutInflater mLayoutInflater;

    public MemshipManagerAdapter(Context context, List<Memship.DataBean> data
    ) {
        mContext = context;

        mLayoutInflater = LayoutInflater.from(context);
        this.data = data;


    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(
                mLayoutInflater.inflate(R.layout.item_memship, parent,
                        false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//
                .cacheOnDisk(true)//
                .bitmapConfig(Bitmap.Config.RGB_565)//
                .build();
        final Memship.DataBean dataBean=data.get(position);
        ImageLoader.getInstance().displayImage(dataBean.getWxHeadImg(),
                holder.vxpicture, options);
        holder.shopname.setText(dataBean.getCommunityName());
        holder.username.setText("店主姓名:"+dataBean.getShopKeeper());
        holder.buyprice.setText("销售金额:"+dataBean.getTotalSales()+"");
        holder.ordernumber.setText("订单数量:"+dataBean.getTotalOrders()+"");
        holder.shouyi.setText("累计收益:"+dataBean.getRevenueTarget()+"");
        holder.nicheng.setText(dataBean.getWxNicName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView vxpicture;
        TextView  shopname,username,buyprice,ordernumber,shouyi,nicheng;

        public MyViewHolder(View itemView) {
            super(itemView);
            vxpicture=itemView.findViewById(R.id.weixintupian);
            shopname=itemView.findViewById(R.id.shangpinname);
            username=itemView.findViewById(R.id.dianzhu_name);
            buyprice=itemView.findViewById(R.id.xiaoshou_price);
            ordernumber=itemView.findViewById(R.id.dingdan_numbers);
            shouyi=itemView.findViewById(R.id.leiji_shouyi);
            nicheng=itemView.findViewById(R.id.weixin_nicheng);
        }
    }


}
