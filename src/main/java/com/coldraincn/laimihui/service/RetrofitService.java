package com.coldraincn.laimihui.service;


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
    //今日爆款
    @GET("hot/getTodayExplosionList.do")
    Observable<TodayExplosion> getTodayExplosionList(@Header("token") String token);
    //3. 优鲜上线
    @GET("hot/getExcellentFreshOnLineList.do")
    Observable<FreshOnLine> getExcellentFreshOnLineList(@Header("token") String token);
    //4. 当季热销
    @GET("hot/getSeasonSellList.do")
    Observable<SeasonSell> getSeasonSellList(@Header("token") String token);
    //VIP特供
    @GET("hot/getVipProductList.do")
    Observable<VipProduct> getVipProductList(@Header("token") String token);
    //5. 精选专题
    @GET("hot/getSelectTopicList.do")
    Observable<SelectTopic> getSelectTopicList(@Header("token") String token);
 //5. 商品列表
 @GET("product/getProductList.do")
 Observable<Product> getProductList(@Header("token") String token);
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
                                        @Query("productOid") String productOid,
                                        @Query("addressOid") String addressOid,
                                        @Query("communityOid") String communityOid,
                                        @Query("tradeCount") String tradeCount,
                                        @Query("payType") String payType,
                                        @Query("freight") String freight,
                                        @Query("orderRemark") String orderRemark);
}
