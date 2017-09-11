package com.coldraincn.laimihui.entity;

/**
 * Created by hd on 2017/9/10.
 */

public class createOrder {

    /**
     * status : OK
     * data : {"body":"补拍邮费","money":"50","orderNo":"1504682201568","payNotifyUrl":"http://dev.wecity.co/lmhapi/mall/order/wechatPayNotify.do","payType":2}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * body : 补拍邮费
         * money : 50
         * orderNo : 1504682201568
         * payNotifyUrl : http://dev.wecity.co/lmhapi/mall/order/wechatPayNotify.do
         * payType : 2
         */

        private String body;
        private String money;
        private String orderNo;
        private String payNotifyUrl;
        private int payType;

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getPayNotifyUrl() {
            return payNotifyUrl;
        }

        public void setPayNotifyUrl(String payNotifyUrl) {
            this.payNotifyUrl = payNotifyUrl;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }
    }
}
