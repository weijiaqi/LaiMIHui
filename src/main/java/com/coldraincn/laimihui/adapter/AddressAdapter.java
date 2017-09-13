package com.coldraincn.laimihui.adapter;

import android.content.Context;
import android.widget.TextView;

import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.entity.AddressList;

import java.util.List;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 14:00
 */

public class AddressAdapter extends BaseAdapter<AddressList.DataBean>{
    public AddressAdapter(Context context, List<AddressList.DataBean> dataList) {
        super(context, dataList);
    }

    @Override
    public void convert(ViewHolder holder, AddressList.DataBean dataBean) {
        TextView tv_name = holder.getView(R.id.tv_name);
        TextView tv_phone = holder.getView(R.id.tv_phone);
        TextView tv_address = holder.getView(R.id.tv_address);
        tv_name.setText(dataBean.getReceiverName());
        tv_phone.setText(dataBean.getReceiverPhoneNo());
        tv_address.setText(dataBean.getReceiverAddress());
    }

    @Override
    public int setLayoutId() {
        return R.layout.item_address;
    }
}
