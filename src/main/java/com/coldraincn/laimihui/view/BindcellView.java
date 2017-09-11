package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;

/**
 * Created by hd on 2017/9/9.
 */


public interface BindcellView extends BaseView{
    void onSuccess(BindPhone mBindPhone);
    void onError(String result);
    void oncode(MessageCode result);
}
