package com.coldraincn.laimihui.view;

/**
 * Created by hd on 2017/9/14.
 */

import com.coldraincn.laimihui.entity.BindPhone;

/**
 * Created by wjq on 2017/9/7.
 */

public interface ChangeInfoView extends BaseView{
    void onSuccess(BindPhone mUser);
    void onError(String result);
}

