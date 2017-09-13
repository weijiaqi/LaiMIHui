package com.coldraincn.laimihui.model;

import com.coldraincn.laimihui.entity.OrderList.OrderItem;

public class UIOrder
{
    private final OrderItem source;

    public UIOrder(OrderItem source)
    {
        this.source = source;
    }

    public String getOrderNum()
    {
        return "订单编号：" + source.getOrderNo();
    }

    public String getOrderNum2()
    {
        return getOrderNum() + "  " + source.getTradeDate("HH:mm:ss");
    }

    public String getOrderStatus()
    {
        return source.getOrderStatusName();
    }

    public String getName()
    {
        return source.getProctName();
    }

    public String getImageUrl()
    {
        return "http://api.17yun.com.cn/" + source.getCoverId();
    }

    public String getTotalPrice()
    {
        return "订单总额：￥" + source.getTotalPrice();
    }

    public String getWeiXinPrice()
    {
        return "微信支付：￥" + source.getWechatprice();
    }

    public String getCountLinePrice()
    {
        return "钱包支付：￥" + source.getLineprice();
    }

    public String getReducedPrice()
    {
        return "优惠金额：￥" + source.getRechargeprice();
    }

    public String getFreightCharge()
    {
        return "运        费：" + (source.getFreight() <= 0 ? "包邮" : source.getFreight());
    }

    public String getExpressName()
    {
        return "快递公司：" + source.getCompanyCode();// FIXME: XY
    }

    public String getLogisticsNumber()
    {
        return "运 单 号：" + source.getLogisticsNumber();
    }

    public String getReceivingName()
    {
        return source.getReceiverName();
    }

    public String getReceivingPhoneNum()
    {
        return source.getReceiverPhoneNo();
    }

    public String getReceivingAddress()
    {
        return source.getReceiverAddress();
    }

    public String getComment()
    {
        return "送件请电话联系";
    }
}
