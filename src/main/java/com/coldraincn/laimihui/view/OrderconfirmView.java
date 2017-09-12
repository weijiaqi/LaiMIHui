package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.entity.createOrder;
import com.coldraincn.laimihui.presenter.BasePresenter;

/**
 * Created by hd on 2017/9/12.
 */

public interface OrderconfirmView extends BaseView{
    void onAddress(Address result);
    void onError(String result);
    void onCreateOrder(createOrder result);
}
