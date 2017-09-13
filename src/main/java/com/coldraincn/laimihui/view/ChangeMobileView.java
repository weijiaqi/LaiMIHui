package com.coldraincn.laimihui.view;

/**
 * Created by hd on 2017/9/14.
 */

import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.MessageCode;

/**
 * Created by wjq on 2017/9/7.
 */

public interface ChangeMobileView extends BaseView{
    void onSuccess(BindPhone mUser);
    void onError(String result);
    void oncode(MessageCode result);
}
