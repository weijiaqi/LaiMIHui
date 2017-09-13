package com.coldraincn.laimihui.entity;

/**
 * Created by hd on 2017/9/14.
 */



        import java.io.Serializable;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.List;
        import java.util.Locale;


public class OrderList
{
    /**
     * status : OK
     * data : [{"agentOid": 0}]
     */

    private String status;

    private List<OrderItem> data;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List<OrderItem> getOrderItems()
    {
        return data;
    }

    public void setData(List<OrderItem> data)
    {
        this.data = data;
    }

    public static class OrderItem implements Serializable
    {
        //        {
        //            "addressOid": 67164315347712,
        //                "agentOid": 0,
        //                "agentbouns": 0,
        //                "areaname": "市辖区",
        //                "baseBonus": "0.0",
        //                "buyUserName": "",
        //                "buyingPrice": 0,
        //                "cashprice": 187.6,
        //                "cityname": "秦皇岛市",
        //                "communityBonus": 10,
        //                "communityName": "",
        //                "communityOid": 1,
        //                "companyCode": "",
        //                "companyname": "",
        //                "couponid": 0,
        //                "couponmoney": 0,
        //                "coverId": "/home/thinker/wwwroot/dev.wecity.co/upload/20170731/533821041184991.jpg",
        //                "createTime": "2017-08-22",
        //                "endTime": "",
        //                "forwardLeaderOid": 0,
        //                "forwardUserOid": 0,
        //                "freight": 0,
        //                "groupBonus": 0,
        //                "groupLeaderName": "",
        //                "groupName": "",
        //                "groupid": 0,
        //                "highBonus": "0.0",
        //                "invoicestate": 0,
        //                "isDelete": "0",
        //                "ismyorderbj": "",
        //                "isrecord": 0,
        //                "items": 0,
        //                "lineprice": 17.4,
        //                "logisticsNumber": "",
        //                "memberBonus": 0,
        //                "objectId": 1503369617494,
        //                "orderNo": "67268792303077",
        //                "orderRemark": "",
        //                "orderStatus": "2",
        //                "orderStatusName": "已付款",
        //                "orderType": "",
        //                "pin_count": 0,
        //                "pincode": 0,
        //                "pintype": 0,
        //                "pinusertype": 0,
        //                "postCode": "",
        //                "productName": "测试收货地址",
        //                "productOid": "533840800783484",
        //                "profitNum": "",
        //                "provincename": "河北省",
        //                "receiverAddress": "五阿胶浆额",
        //                "receiverName": "英渌鸣",
        //                "receiverPhoneNo": "13811370313",
        //                "rechargeprice": 0,
        //                "rowspanCount": "",
        //                "sendTimeStr": "",
        //                "sendtime": null,
        //                "seralOid": "67268809786008",
        //                "startIndex": 0,
        //                "startTime": "",
        //                "supplierAddress": "",
        //                "supplierContacts": "",
        //                "supplierName": "",
        //                "supplierPhoneNo": "",
        //                "taobaoNumber": "",
        //                "taskoid": 0,
        //                "totalPrice": 205,
        //                "tradeCount": "1",
        //                "tradePrice": "199.0",
        //                "tradeTime": "2017-08-22 10:40:13",
        //                "updateTime": "2017-08-22",
        //                "userOid": "605146404038301",
        //                "userWxNickname": "susu",
        //                "wechatprice": 0
        //        }

        private String orderNo;
        private String totalPrice;
        private String wechatprice;
        private String lineprice;
        private String rechargeprice;
        private String orderStatus;
        private String coverId;
        private String orderStatusName;
        private String tradeTime;
        private Date tradeDate;
        private String proctName;
        private double freight;
        private String companyCode;
        private String logisticsNumber;
        private String receiverName;
        private String receiverAddress;
        private String receiverPhoneNo;

        public String getReceiverPhoneNo()
        {
            return receiverPhoneNo;
        }

        public String getReceiverAddress()
        {
            return receiverAddress;
        }

        public String getReceiverName()
        {
            return receiverName;
        }

        public String getOrderNo()
        {
            return orderNo;
        }

        public String getCoverId()
        {
            return coverId;
        }

        public String getTotalPrice()
        {
            return totalPrice;
        }

        public String getWechatprice()
        {
            return wechatprice;
        }

        public String getLineprice()
        {
            return lineprice;
        }

        public String getRechargeprice()
        {
            return rechargeprice;
        }

        public String getCompanyCode()
        {
            return companyCode;
        }

        public String getOrderStatus()
        {
            return orderStatus;
        }

        public String getOrderStatusName()
        {
            return orderStatusName;
        }

        public String getTradeTime()
        {
            return tradeTime;
        }

        public double getFreight()
        {
            return freight;
        }

        public String getLogisticsNumber()
        {
            return logisticsNumber;
        }

        public Date getTradeDate()
        {
            //"tradeTime": "2017-08-22 10:40:13", yyyy-MM-dd'T'HH:mm:ss.SSSZ
            if (tradeDate == null)
            {
                try
                {
                    tradeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(tradeTime);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
            }

            return tradeDate;
        }

        public String getTradeDate(String pattern)
        {
            Date date = getTradeDate();

            return date == null ? "" : new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
        }

        public String getProctName()
        {
            return proctName;
        }
    }
}

