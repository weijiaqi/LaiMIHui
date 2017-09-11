package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;

/**
 * Created by hd on 2017/9/9.
 */

public interface WXView extends BaseView{
    void onSuccess(User mUser);
    void onError(String result);

}
