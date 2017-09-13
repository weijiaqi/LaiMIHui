package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by hd on 2017/9/14.
 */

public class COrderlist {
    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {


        private long addressOid;
        private String area;
        private double buyingPrice;
        private double cashprice;
        private String city;
        private long communityOid;
        private String companyCode;
        private String companyname;
        private String coverId;
        private String createTime;
        private String endTime;
        private int freight;
        private int invoicestate;
        private String isDelete;
        private int isrecord;
        private double lineprice;
        private String logisticsNumber;
        private long objectId;
        private String orderNo;
        private String orderRemark;
        private String orderStatus;
        private String orderStatusName;
        private String orderType;
        private int payType;
        private int pin_count;
        private int pincode;
        private int pintype;
        private int pinusertype;
        private String postCode;
        private String productName;
        private String productOid;
        private String province;
        private double rechargeprice;
        private String sendTimeStr;
        private Object sendtime;
        private String seralOid;
        private double totalPrice;
        private String tradeCount;
        private String tradePrice;
        private String tradeTime;
        private String userOid;
        private String userWxNickname;
        private double wechatprice;

        public long getAddressOid() {
            return addressOid;
        }

        public void setAddressOid(long addressOid) {
            this.addressOid = addressOid;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public double getBuyingPrice() {
            return buyingPrice;
        }

        public void setBuyingPrice(double buyingPrice) {
            this.buyingPrice = buyingPrice;
        }

        public double getCashprice() {
            return cashprice;
        }

        public void setCashprice(double cashprice) {
            this.cashprice = cashprice;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public long getCommunityOid() {
            return communityOid;
        }

        public void setCommunityOid(long communityOid) {
            this.communityOid = communityOid;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public String getCoverId() {
            return coverId;
        }

        public void setCoverId(String coverId) {
            this.coverId = coverId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getFreight() {
            return freight;
        }

        public void setFreight(int freight) {
            this.freight = freight;
        }

        public int getInvoicestate() {
            return invoicestate;
        }

        public void setInvoicestate(int invoicestate) {
            this.invoicestate = invoicestate;
        }

        public String getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(String isDelete) {
            this.isDelete = isDelete;
        }

        public int getIsrecord() {
            return isrecord;
        }

        public void setIsrecord(int isrecord) {
            this.isrecord = isrecord;
        }

        public double getLineprice() {
            return lineprice;
        }

        public void setLineprice(double lineprice) {
            this.lineprice = lineprice;
        }

        public String getLogisticsNumber() {
            return logisticsNumber;
        }

        public void setLogisticsNumber(String logisticsNumber) {
            this.logisticsNumber = logisticsNumber;
        }

        public long getObjectId() {
            return objectId;
        }

        public void setObjectId(long objectId) {
            this.objectId = objectId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getOrderRemark() {
            return orderRemark;
        }

        public void setOrderRemark(String orderRemark) {
            this.orderRemark = orderRemark;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getOrderStatusName() {
            return orderStatusName;
        }

        public void setOrderStatusName(String orderStatusName) {
            this.orderStatusName = orderStatusName;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public int getPin_count() {
            return pin_count;
        }

        public void setPin_count(int pin_count) {
            this.pin_count = pin_count;
        }

        public int getPincode() {
            return pincode;
        }

        public void setPincode(int pincode) {
            this.pincode = pincode;
        }

        public int getPintype() {
            return pintype;
        }

        public void setPintype(int pintype) {
            this.pintype = pintype;
        }

        public int getPinusertype() {
            return pinusertype;
        }

        public void setPinusertype(int pinusertype) {
            this.pinusertype = pinusertype;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductOid() {
            return productOid;
        }

        public void setProductOid(String productOid) {
            this.productOid = productOid;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public double getRechargeprice() {
            return rechargeprice;
        }

        public void setRechargeprice(double rechargeprice) {
            this.rechargeprice = rechargeprice;
        }

        public String getSendTimeStr() {
            return sendTimeStr;
        }

        public void setSendTimeStr(String sendTimeStr) {
            this.sendTimeStr = sendTimeStr;
        }

        public Object getSendtime() {
            return sendtime;
        }

        public void setSendtime(Object sendtime) {
            this.sendtime = sendtime;
        }

        public String getSeralOid() {
            return seralOid;
        }

        public void setSeralOid(String seralOid) {
            this.seralOid = seralOid;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getTradeCount() {
            return tradeCount;
        }

        public void setTradeCount(String tradeCount) {
            this.tradeCount = tradeCount;
        }

        public String getTradePrice() {
            return tradePrice;
        }

        public void setTradePrice(String tradePrice) {
            this.tradePrice = tradePrice;
        }

        public String getTradeTime() {
            return tradeTime;
        }

        public void setTradeTime(String tradeTime) {
            this.tradeTime = tradeTime;
        }

        public String getUserOid() {
            return userOid;
        }

        public void setUserOid(String userOid) {
            this.userOid = userOid;
        }

        public String getUserWxNickname() {
            return userWxNickname;
        }

        public void setUserWxNickname(String userWxNickname) {
            this.userWxNickname = userWxNickname;
        }

        public double getWechatprice() {
            return wechatprice;
        }

        public void setWechatprice(double wechatprice) {
            this.wechatprice = wechatprice;
        }


        public String getCompanyname() {
            return companyname;
        }

        public void setCompanyname(String companyname) {
            this.companyname = companyname;
        }
    }
}
