package com.coldraincn.laimihui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * <Pre>
 * 通用Adapter
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p>
 *          Create by 2017/6/26 14:50
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected List<T> mDataList;
    protected OnItemClickListener mOnItemClickListener;

    public BaseAdapter(Context context, List<T> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, viewGroup, setLayoutId());
        setListener(viewHolder);
        return viewHolder;

    }

    protected void setListener(final ViewHolder viewHolder) {
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                mOnItemClickListener.onItemClick(view, viewHolder, position);
            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (position == mDataList.size()) {
            return;
        }
        convert(viewHolder, mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mDataList.size();
    }
    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public abstract void convert(ViewHolder holder, T t);

    public abstract int setLayoutId();

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View view) {
            super(view);
        }
    }
}
