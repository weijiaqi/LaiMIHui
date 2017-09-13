package com.coldraincn.laimihui.adapter;

/**
 * Created by hd on 2017/9/13.
 */



        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.coldraincn.laimihui.R;
        import com.coldraincn.laimihui.entity.ListMessage;

        import java.util.List;

        import common.ImageLoaderUtil;

public class MerchandiseAdapter extends BaseAdapter {
    private Context context;
    private List<ListMessage.DataBean.DatalistBean.ProductListBean> list;

    public MerchandiseAdapter(Context context, List<ListMessage.DataBean.DatalistBean.ProductListBean> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder = null;
        if (convertView == null) {
            mHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            mHolder.name = (TextView) convertView.findViewById(R.id.textView_name);
            mHolder.image = (ImageView) convertView.findViewById(R.id.imageView_head);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        mHolder.name.setText(list.get(position).getProductName());
        ImageLoaderUtil.getImageLoader(context).displayImage(list.get(position).getCoverId(), mHolder.image, ImageLoaderUtil.getPhotoImageOption());
        return convertView;
    }

    public class ViewHolder {
        private ImageView image;
        private TextView name;
    }

}
