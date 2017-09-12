package com.coldraincn.laimihui.entity;

import java.io.Serializable;

/**
 * Created by hd on 2017/9/10.
 */

public class createOrder implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * status : OK
     * data : {"appid":"wx3bb6d108dec83903","body":"补拍邮费","money":"10.1","nonceStr":"b294504229c668e750dfcc4ea9617f0a","orderNo":"1505202225894","payNotifyUrl":"http://api.17yun.com.cn/mall/order/aliPayNotify.do","paySign":"81519B699E635A565343A4238DE41931","prepayId":"wx20170912153713f072c15b6c0072182258","receiverAddress":"北京市海淀区中关村南大街","receiverName":"赵宝","receiverPhoneNo":"13522890823","timeStamp":"1505202228405"}
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

    public static class DataBean implements Serializable{
        private static final long serialVersionUID = 1L;
        /**
         * appid : wx3bb6d108dec83903
         * body : 补拍邮费
         * money : 10.1
         * nonceStr : b294504229c668e750dfcc4ea9617f0a
         * orderNo : 1505202225894
         * payNotifyUrl : http://api.17yun.com.cn/mall/order/aliPayNotify.do
         * paySign : 81519B699E635A565343A4238DE41931
         * prepayId : wx20170912153713f072c15b6c0072182258
         * receiverAddress : 北京市海淀区中关村南大街
         * receiverName : 赵宝
         * receiverPhoneNo : 13522890823
         * timeStamp : 1505202228405
         */

        private String appid;
        private String body;
        private String money;
        private String nonceStr;
        private String orderNo;
        private String payNotifyUrl;
        private String paySign;
        private String prepayId;
        private String receiverAddress;
        private String receiverName;
        private String receiverPhoneNo;
        private String timeStamp;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

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

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
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

        public String getPaySign() {
            return paySign;
        }

        public void setPaySign(String paySign) {
            this.paySign = paySign;
        }

        public String getPrepayId() {
            return prepayId;
        }

        public void setPrepayId(String prepayId) {
            this.prepayId = prepayId;
        }

        public String getReceiverAddress() {
            return receiverAddress;
        }

        public void setReceiverAddress(String receiverAddress) {
            this.receiverAddress = receiverAddress;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getReceiverPhoneNo() {
            return receiverPhoneNo;
        }

        public void setReceiverPhoneNo(String receiverPhoneNo) {
            this.receiverPhoneNo = receiverPhoneNo;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }
    }
}
