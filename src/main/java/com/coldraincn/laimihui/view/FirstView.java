package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.FreshOnLine;
import com.coldraincn.laimihui.entity.Lactivity;
import com.coldraincn.laimihui.entity.Product;
import com.coldraincn.laimihui.entity.SeasonSell;
import com.coldraincn.laimihui.entity.SelectTopic;
import com.coldraincn.laimihui.entity.TodayExplosion;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.entity.VipProduct;

import java.util.List;

/**
 * Created by hd on 2017/9/8.
 */


    public interface FirstView extends BaseView{
        void onSuccess1(TodayExplosion mLactivity);
        void onError(String result);
        void onLoadActivityList(List images);
        void onSuccess2(FreshOnLine mLactivity);
        void onSuccess3(SeasonSell mLactivity);
        void onSuccess4(VipProduct mLactivity);
        void onSuccess5(SelectTopic mLactivity);
        void onSuccess6(Product mLactivity);
    }

