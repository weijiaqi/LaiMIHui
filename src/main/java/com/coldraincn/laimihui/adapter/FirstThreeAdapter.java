package com.coldraincn.laimihui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.coldraincn.laimihui.ProductDetailActivity;
import com.coldraincn.laimihui.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

/**
 * Created by hd on 2017/9/10.
 */

public class FirstThreeAdapter extends RecyclerView.Adapter<FirstThreeAdapter.MyViewHolder>{
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<Map<String, Object>> listItems;
    private String productOid;


    public FirstThreeAdapter(Context context, List<Map<String, Object>> listItems
    ) {
        mContext = context;

        mLayoutInflater = LayoutInflater.from(context);
        this.listItems = listItems;


    }
    @Override
    public FirstThreeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FirstThreeAdapter.MyViewHolder holder = new FirstThreeAdapter.MyViewHolder(mLayoutInflater.inflate(R.layout.item_first_card, parent, false), this);
        return holder;

    }

    @Override
    public void onBindViewHolder(FirstThreeAdapter.MyViewHolder holder, int position) {
        String url=listItems.get(position).get("img").toString();
        productOid =listItems.get(position).get("url").toString();
        Picasso.with(mContext).load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listItems == null ? 0 : listItems.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {


        public ImageView image;

        public FirstThreeAdapter mAdapter;
        public MyViewHolder(View itemView, FirstThreeAdapter adapter) {
            super(itemView);
            mAdapter = adapter;


            image = (ImageView) itemView.findViewById(R.id.imageView2);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    Intent intent = new Intent(mAdapter.mContext, ProductDetailActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("productOid",productOid);
                    intent.putExtras(bundle);
                    mAdapter.mContext.startActivity(intent);
                }
            });

        }


    }
}