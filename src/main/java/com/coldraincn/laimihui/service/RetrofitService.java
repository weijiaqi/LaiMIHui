package com.coldraincn.laimihui.service;


import com.coldraincn.laimihui.entity.AddAddress;
import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.AddressList;
import com.coldraincn.laimihui.entity.Area;
import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.COrderlist;
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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hd on 2017/9/6.
 */

public interface RetrofitService {
 //短信
 @GET("user/getCode.do")
 Observable<MessageCode> getCode(@Query("phone") String phone);

   //登录
    @GET("user/login.do")
    Observable<User> userLogin(@Query("phone") String phone);
 //微信登录
    @FormUrlEncoded
    @POST("user/weixinLogin.do")
    Observable<User> weixinLogin(@Field("userWxNickname") String userWxNickname,
                                 @Field("userSex") String userSex,
                                 @Field("userWxCountry") String userWxCountry,
                                 @Field("userWxProvince") String userWxProvince,
                                 @Field("userWxCity") String userWxCity,
                                 @Field("userWxHeadimgurl") String userWxHeadimgurl,
                                 @Field("unionid") String unionid);

    //绑定手机号
    @GET("user/bindPhone.do")
    Observable<BindPhone> bindPhone(@Header("token") String token, @Query("phone") String phone);
    //活动入口
    @GET("activity/getActivityList.do")
    Observable<Lactivity> getActivityList(@Header("token") String token);
//    //今日爆款
//    @GET("hot/getTodayExplosionList.do")
//    Observable<TodayExplosion> getTodayExplosionList(@Header("token") String token);
//    //3. 优鲜上线
//    @GET("hot/getExcellentFreshOnLineList.do")
//    Observable<FreshOnLine> getExcellentFreshOnLineList(@Header("token") String token);
//    //4. 当季热销
//    @GET("hot/getSeasonSellList.do")
//    Observable<SeasonSell> getSeasonSellList(@Header("token") String token);
//    //VIP特供
//    @GET("hot/getVipProductList.do")
//    Observable<VipProduct> getVipProductList(@Header("token") String token);
//    //5. 精选专题
//    @GET("hot/getSelectTopicList.do")
//    Observable<SelectTopic> getSelectTopicList(@Header("token") String token);
    //首页列表数据获取
    @GET("hot/getHomeHoteList.do")
    Observable<HomeHoteData> getHomeHoteList(@Header("token") String token);
    //5. 商品列表
    @GET("product/getProductList.do")
    Observable<Product> getProductList(@Header("token") String token, @Query("pageNo") String pageNo, @Query("pageSize") String pageSize);
    //推荐
 @GET("dynamic/getlistMessage.do")
 Observable<ListMessage> getlistMessage(@Header("token") String token, @Query("communityOid") String communityOid);
    //商品详情
    @GET("product/productDetail.do")
    Observable<ProductDetail> productDetail(@Header("token") String token, @Query("productOid") String productOid);
    //订单
    @FormUrlEncoded
    @POST("order/createOrder.do")
    Observable<createOrder> createOrder(@Header("token") String token,
                                        @Field("productOid") String productOid,
                                        @Field("addressOid") String addressOid,
                                        @Field("communityOid") String communityOid,
                                        @Field("tradeCount") String tradeCount,
                                        @Field("spbillCreateIp") String spbillCreateIp,
                                        @Field("freight") String freight,
                                        @Field("orderRemark") String orderRemark);

    //订单列表
    @POST("order/getUserOrderList.do")
    Observable<OrderList> getUserOrderList(@Header("token") String token, @Query("orderStatus") String orderStatus);
    //获取默认地址
    @GET("address/getDefaultAddress.do")
    Observable<Address> getDefaultAddress(@Header("token") String token);

    @FormUrlEncoded
    @POST("cashAccount/saveNewPhone.do")
    Observable<BindPhone> saveNewPhone(
            @Header("token") String token,
            @Header("phone") String phone,
            @Field("userId") long userId,
            @Field("phone") String phone1);

    @FormUrlEncoded
    @POST("cashAccount/savePersonData.do")
    Observable<BindPhone> savePersonData(
            @Header("token") String token,
            @Field("name") String name,
            @Field("idCard") String idCard);
    @GET("community/getCommunityOrderList.do")
    Observable<COrderlist> getCommunityOrderList(
            @Header("token") String token,
            @Query("communityOid") String communityOid,
            @Query("orderStatus") String orderStatus
    );

    //地址列表
    @GET("address/getAddressList.do")
    Observable<AddressList> getAddressList(@Header("token") String token);
    //行政区域信息
    @GET("address/getAreaData.do")
    Observable<Area> getAreaData(@Header("token") String token, @Query("pid") int pid);
    //获取详细收货地址
    @GET("address/getAddress.do")
    Observable<GetAddress> getAddress(@Header("token") String token, @Query("addressid") long addressid);
    //删除收货地址
    @GET("address/deleteAddress.do")
    Observable<DeleteAddress> deleteAddress(@Header("token") String token, @Query("addressid") long addressid);
    //添加收货地址
    @FormUrlEncoded
    @POST("address/addAddress.do")
    Observable<AddAddress> addAddress(@Header("token") String token,
                                      @Field("receiverName") String receiverName,
                                      @Field("receiverPhoneNo") String receiverPhoneNo,
                                      @Field("receiverAddress") String receiverAddress,
                                      @Field("isDefault") int isDefault,
                                      @Field("postCode") String postCode,
                                      @Field("provinceCode") int provinceCode,
                                      @Field("cityCode") int cityCode,
                                      @Field("areaCode") int areaCode);
    //10、修改收货地址
    @FormUrlEncoded
    @POST("address/updateAddress.do")
    Observable<UpdateAddress> updateAddress(@Header("token") String token,
                                            @Field("objectId") long objectId,
                                            @Field("receiverName") String receiverName,
                                            @Field("receiverPhoneNo") String receiverPhoneNo,
                                            @Field("receiverAddress") String receiverAddress,
                                            @Field("isDefault") int isDefault,
                                            @Field("postCode") String postCode,
                                            @Field("provinceCode") int provinceCode,
                                            @Field("cityCode") int cityCode,
                                            @Field("areaCode") int areaCode);


}
