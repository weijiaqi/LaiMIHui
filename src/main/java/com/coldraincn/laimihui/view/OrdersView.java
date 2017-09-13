package com.coldraincn.laimihui.view;

/**
 * Created by hd on 2017/9/14.
 */

import com.coldraincn.laimihui.entity.OrderList;


public interface OrdersView extends BaseView
{
    void onSuccess(OrderList orderList);

    void onError(String result);
}
