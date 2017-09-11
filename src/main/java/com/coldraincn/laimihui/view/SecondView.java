package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.entity.TodayExplosion;

/**
 * Created by hd on 2017/9/9.
 */

public interface SecondView extends BaseView {
    void onSuccess(ListMessage data);
    void onError(String result);
}
