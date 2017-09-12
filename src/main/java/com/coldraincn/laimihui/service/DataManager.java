package com.coldraincn.laimihui.service;

import android.content.Context;


import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.FreshOnLine;
import com.coldraincn.laimihui.entity.Lactivity;
import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.Product;
import com.coldraincn.laimihui.entity.ProductDetail;
import com.coldraincn.laimihui.entity.SeasonSell;
import com.coldraincn.laimihui.entity.SelectTopic;
import com.coldraincn.laimihui.entity.TodayExplosion;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.entity.VipProduct;
import com.coldraincn.laimihui.entity.createOrder;

import io.reactivex.Observable;

/**
 * Created by hd on 2017/9/6.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    public Observable<MessageCode> getCode(String phone){
        return mRetrofitService.getCode(phone);
    }

    public Observable<User> userLogin(String phone){
        return mRetrofitService.userLogin(phone);
    }
    public Observable<User> weixinLogin(String userWxNickname,String userSex,String userWxCountry,String userWxProvince,String userWxCity,String userWxHeadimgurl,String unionid){
        return mRetrofitService.weixinLogin(userWxNickname,userSex,userWxCountry,userWxProvince,userWxCity,userWxHeadimgurl,unionid);
    }
    public Observable<BindPhone> bindPhone(String token, String phone){
        return mRetrofitService.bindPhone(token,phone);
    }
    public Observable<Lactivity> getActivityList(String token){
        return mRetrofitService.getActivityList(token);
    }
    public Observable<TodayExplosion> getTodayExplosionList(String token){
        return mRetrofitService.getTodayExplosionList(token);
    }
    public Observable<FreshOnLine> getExcellentFreshOnLineList(String token){
        return mRetrofitService.getExcellentFreshOnLineList(token);
    }
    public Observable<SeasonSell> getSeasonSellList(String token){
        return mRetrofitService.getSeasonSellList(token);
    }
    public Observable<VipProduct> getVipProductList(String token){
        return mRetrofitService.getVipProductList(token);
    }
    public Observable<SelectTopic> getSelectTopicList(String token){
        return mRetrofitService.getSelectTopicList(token);
    }
    public Observable<Product> getProductList(String token){
        return mRetrofitService.getProductList(token);
    }
    public Observable<ListMessage> getlistMessage(String token,String communityOid){
        return mRetrofitService.getlistMessage(token,communityOid);
    }
    public Observable<ProductDetail> productDetail(String token, String productOid){
        return mRetrofitService.productDetail(token,productOid);
    }
    public Observable<createOrder> createOrder(String token, String productOid,String addressOid,String communityOid,
                                               String tradeCount,String spbillCreateIp,String freight,String orderRemark){

        String a=token;
        String sss=productOid;
        String ssc=addressOid;
        String svs=communityOid;
        String sbs=tradeCount;
        String sns=spbillCreateIp;
        String sms=freight;
        String ss=orderRemark;
        return mRetrofitService.createOrder(token,productOid,addressOid,communityOid,
                tradeCount,spbillCreateIp,freight,orderRemark);
    }
    public Observable<Address> getDefaultAddress(String token){
        return mRetrofitService.getDefaultAddress(token);
    }
}
