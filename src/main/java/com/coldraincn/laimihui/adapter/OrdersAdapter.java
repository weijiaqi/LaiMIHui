package com.coldraincn.laimihui.adapter;

/**
 * Created by hd on 2017/9/14.
 */



        import android.content.Context;
        import android.support.v7.widget.AppCompatImageView;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.RecyclerView.ViewHolder;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.coldraincn.laimihui.R;
        import com.coldraincn.laimihui.UserOrderDetailActivity;
        import com.coldraincn.laimihui.adapter.OrdersAdapter.OrderHolder;
        import com.coldraincn.laimihui.entity.OrderList.OrderItem;

        import java.util.List;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;
        import common.ImageLoaderUtil;


public class OrdersAdapter extends RecyclerView.Adapter<OrderHolder>
{
    private final List<OrderItem> orderItems;

    private final LayoutInflater layoutInflater;

    public OrdersAdapter(Context context, List<OrderItem> orderItems)
    {
        this.layoutInflater = LayoutInflater.from(context);

        this.orderItems = orderItems;
    }

    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new OrderHolder(layoutInflater.inflate(R.layout.item_order, parent, false));
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position)
    {
        holder.setData(orderItems.get(position));
    }

    @Override
    public int getItemCount()
    {
        return orderItems == null ? 0 : orderItems.size();
    }

    public static class OrderHolder extends ViewHolder
    {
        @BindView(R.id.order_root)
        ViewGroup rootView;
        @BindView(R.id.order_num)
        TextView orderNum;
        @BindView(R.id.order_status)
        TextView orderStatus;
        @BindView(R.id.order_price)
        TextView orderPrice;
        @BindView(R.id.order_img)
        AppCompatImageView orderImg;
        @BindView(R.id.order_btn_check)
        TextView orderBtnCheck;
        @BindView(R.id.order_btn_confirm)
        TextView orderBtnConfirm;

        public OrderHolder(View itemView)
        {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.order_btn_check, R.id.order_btn_confirm, R.id.order_root})
        public void onViewClicked(View view)
        {
            //1: 待付款  2: 待发货  3: 待收货
            final OrderItem item = (OrderItem) view.getTag();

            switch (view.getId())
            {
                case R.id.order_root:

                    UserOrderDetailActivity.toOrderDetail(view.getContext(), item);

                    break;
                case R.id.order_btn_check:

                    //TODO to 查看物流

                    break;
                case R.id.order_btn_confirm:

                    if ("1".equals(item.getOrderStatus()))
                    {
                        //TODO to 去付款
                    }
                    else if ("3".equals(item.getOrderStatus()))
                    {
                        //TODO to 确认收货
                    }

                    break;
            }
        }

        public void setData(OrderItem item)
        {
            rootView.setTag(item);

            orderNum.setText("订单编号:  " + item.getOrderNo());

            orderStatus.setText("订单状态:  " + item.getOrderStatusName());

            orderPrice.setText("¥" + item.getTotalPrice());

            ImageLoaderUtil.displayImage(orderImg.getContext(), orderImg, "http://api.17yun.com.cn/" + item.getCoverId(), ImageLoaderUtil.getPhotoImageOption(), null);
            //            ImageLoaderUtil.displayImage(orderImg.getContext(), orderImg
            //                    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505147185610&di=1f8e565a91208f22fff033b2b6aa5db2&imgtype=jpg&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f856b141ef91f3a292cf578eb.jpg"
            //                    , ImageLoaderUtil.getPhotoImageOption(), null);

            //1: 待付款  2: 待发货    3: 待收货


            orderBtnCheck.setTag(item);

            orderBtnConfirm.setTag(item);

            if ("1".equals(item.getOrderStatus()))
            {
                orderBtnCheck.setVisibility(View.GONE);

                orderBtnConfirm.setVisibility(View.VISIBLE);

                orderBtnConfirm.setText("去付款");
            }
            else if ("2".equals(item.getOrderStatus()))
            {
                orderBtnCheck.setVisibility(View.GONE);

                orderBtnConfirm.setVisibility(View.GONE);
            }
            else if ("3".equals(item.getOrderStatus()))
            {
                orderBtnCheck.setVisibility(View.VISIBLE);

                orderBtnCheck.setText("查看物流");

                orderBtnConfirm.setVisibility(View.VISIBLE);

                orderBtnConfirm.setText("确认收货");
            }
        }
    }
}
