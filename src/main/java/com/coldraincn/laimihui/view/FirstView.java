package com.coldraincn.laimihui.view;

import com.coldraincn.laimihui.entity.FreshOnLine;
import com.coldraincn.laimihui.entity.HomeHoteData;
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
    void onError(String result);
    void onLoadActivityList(List images);
    void onSuccess6(Product mLactivity);
    void onSuccess7(HomeHoteData mLactivity);
    }

