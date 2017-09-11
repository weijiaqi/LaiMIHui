package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;

/**
 * Created by hd on 2017/9/7.
 */

public interface LoginView extends BaseView{
    void onSuccess(User mUser);
    void onError(String result);
    void oncode(MessageCode result);
}
