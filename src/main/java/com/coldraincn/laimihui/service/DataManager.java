package com.coldraincn.laimihui.service;

import android.content.Context;


import com.coldraincn.laimihui.entity.AddAddress;
import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.AddressList;
import com.coldraincn.laimihui.entity.Area;
import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.COrderlist;
import com.coldraincn.laimihui.entity.DefaltAddress;
import com.coldraincn.laimihui.entity.DeleteAddress;
import com.coldraincn.laimihui.entity.FreshOnLine;
import com.coldraincn.laimihui.entity.GetAddress;
import com.coldraincn.laimihui.entity.HomeHoteData;
import com.coldraincn.laimihui.entity.Lactivity;
import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.OrderList;
import com.coldraincn.laimihui.entity.Product;
import com.coldraincn.laimihui.entity.ProductDetail;
import com.coldraincn.laimihui.entity.SeasonSell;
import com.coldraincn.laimihui.entity.SelectTopic;
import com.coldraincn.laimihui.entity.TodayExplosion;
import com.coldraincn.laimihui.entity.UpdateAddress;
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
//    public Observable<TodayExplosion> getTodayExplosionList(String token){
//        return mRetrofitService.getTodayExplosionList(token);
//    }
//    public Observable<FreshOnLine> getExcellentFreshOnLineList(String token){
//        return mRetrofitService.getExcellentFreshOnLineList(token);
//    }
//    public Observable<SeasonSell> getSeasonSellList(String token){
//        return mRetrofitService.getSeasonSellList(token);
//    }
//    public Observable<VipProduct> getVipProductList(String token){
//        return mRetrofitService.getVipProductList(token);
//    }
//    public Observable<SelectTopic> getSelectTopicList(String token){
//        return mRetrofitService.getSelectTopicList(token);
//    }
    public Observable<HomeHoteData> getHomeHoteList(String token){
        return mRetrofitService.getHomeHoteList(token);
    }
    public Observable<Product> getProductList(String token, String pageNo , String pageSize){
        return mRetrofitService.getProductList(token,pageNo,pageSize);
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
    public Observable<DefaltAddress> getDefaultAddress(String token){
        return mRetrofitService.getDefaultAddress(token);
    }
    public Observable<OrderList> getUserOrderList(String token, String orderStatus){
        return mRetrofitService.getUserOrderList(token,orderStatus);
    }
    public Observable<BindPhone> saveNewPhone(String token, String phone, long userId, String phone2) {
        return mRetrofitService.saveNewPhone(token, phone, userId, phone2);
    }

    public Observable<BindPhone> savePersonData(String token, String name, String idCard) {
        return mRetrofitService.savePersonData(token, name, idCard);
    }

    public Observable<COrderlist> getCommunityOrderList(String token, String communityOid, String orderStatus) {
        return mRetrofitService.getCommunityOrderList(token, communityOid, orderStatus);
    }
    public Observable<AddressList> getAddressList(String token) {
        return mRetrofitService.getAddressList(token);
    }

    public Observable<Area> getAreaData(String token, int pid) {
        return mRetrofitService.getAreaData(token, pid);
    }

    public Observable<GetAddress> getAddress(String token, long addressid) {
        return mRetrofitService.getAddress(token, addressid);
    }
    public Observable<DeleteAddress> deleteAddress(String token, long addressid) {
        return mRetrofitService.deleteAddress(token, addressid);
    }

    public Observable<AddAddress> addAddress(String token, String receiverName,
                                             String receiverPhoneNo,
                                             String receiverAddress,
                                             int isDefault,
                                             String postCode,
                                             int provinceCode,
                                             int cityCode,
                                             int areaCode) {
        return mRetrofitService.addAddress(token, receiverName, receiverPhoneNo, receiverAddress
                , isDefault, postCode, provinceCode, cityCode, areaCode);
    }

    public Observable<UpdateAddress> updateAddress(String token,
                                                   long objectId,
                                                   String receiverName,
                                                   String receiverPhoneNo,
                                                   String receiverAddress,
                                                   int isDefault,
                                                   String postCode,
                                                   int provinceCode,
                                                   int cityCode,
                                                   int areaCode) {
        return mRetrofitService.updateAddress(token, objectId, receiverName, receiverPhoneNo, receiverAddress
                , isDefault, postCode, provinceCode, cityCode, areaCode);
    }
}
