package com.coldraincn.laimihui.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hd on 2017/9/10.
 */

public class ProductDetail implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * status : OK
     * data : {"coverId":"http://api.17yun.com.cn/upload/20170704/19080749993030166.jpg","imglist":["http://dev.wecity.co/upload/20170904/245788401617884.jpg","http://dev.wecity.co/upload/20170904/245792444547730.jpg","http://dev.wecity.co/upload/20170904/245797451505722.jpg"],"marketPrice":0.1,"objectId":537580830664190,"postPrice":0,"productInfo":"<p><span style=\"font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;\">此项非常规商品，用于较偏远地区邮费差价。拍前请联系客服，请勿自行购买。<\/span><\/p><p><span style=\"font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;\"><img src=\"http://dev.wecity.co/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509793370068373.jpg\" title=\"1504509793370068373.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831103044.jpg\"/><\/span><\/p>","productKey":"其他，此项非常规商品，拍前请联系客服，请勿自行购买。邮费，其他","productName":"补拍邮费","productQuota":-1,"productStatus":"3","productStatusName":"进行中","servicePhoneNo":"4000082910","shareDescribe":" 此项非常规商品，请联系客服后购买","shareImg":"http://dev.wecity.co/upload/20170710/19579510208129592.jpg","shareTitle":"邮费补拍","showCostPrice":0.1,"showSalePrice":0.01,"singleSellPrice":0.1,"taobaoPrice":0.1}
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
         * coverId : http://api.17yun.com.cn/upload/20170704/19080749993030166.jpg
         * imglist : ["http://dev.wecity.co/upload/20170904/245788401617884.jpg","http://dev.wecity.co/upload/20170904/245792444547730.jpg","http://dev.wecity.co/upload/20170904/245797451505722.jpg"]
         * marketPrice : 0.1
         * objectId : 537580830664190
         * postPrice : 0
         * productInfo : <p><span style="font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;">此项非常规商品，用于较偏远地区邮费差价。拍前请联系客服，请勿自行购买。</span></p><p><span style="font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;"><img src="http://dev.wecity.co/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509793370068373.jpg" title="1504509793370068373.jpg" style="width:100%;" alt="微信图片_20170831103044.jpg"/></span></p>
         * productKey : 其他，此项非常规商品，拍前请联系客服，请勿自行购买。邮费，其他
         * productName : 补拍邮费
         * productQuota : -1
         * productStatus : 3
         * productStatusName : 进行中
         * servicePhoneNo : 4000082910
         * shareDescribe :  此项非常规商品，请联系客服后购买
         * shareImg : http://dev.wecity.co/upload/20170710/19579510208129592.jpg
         * shareTitle : 邮费补拍
         * showCostPrice : 0.1
         * showSalePrice : 0.01
         * singleSellPrice : 0.1
         * taobaoPrice : 0.1
         */

        private String coverId;
        private double marketPrice;
        private long objectId;
        private double postPrice;
        private String productInfo;
        private String productKey;
        private String productName;
        private int productQuota;
        private String productStatus;
        private String productStatusName;
        private String servicePhoneNo;
        private String shareDescribe;
        private String shareImg;
        private String shareTitle;
        private double showCostPrice;
        private double showSalePrice;
        private double singleSellPrice;
        private double taobaoPrice;
        private List<String> imglist;

        public String getCoverId() {
            return coverId;
        }

        public void setCoverId(String coverId) {
            this.coverId = coverId;
        }

        public double getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(double marketPrice) {
            this.marketPrice = marketPrice;
        }

        public long getObjectId() {
            return objectId;
        }

        public void setObjectId(long objectId) {
            this.objectId = objectId;
        }

        public double getPostPrice() {
            return postPrice;
        }

        public void setPostPrice(double postPrice) {
            this.postPrice = postPrice;
        }

        public String getProductInfo() {
            return productInfo;
        }

        public void setProductInfo(String productInfo) {
            this.productInfo = productInfo;
        }

        public String getProductKey() {
            return productKey;
        }

        public void setProductKey(String productKey) {
            this.productKey = productKey;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getProductQuota() {
            return productQuota;
        }

        public void setProductQuota(int productQuota) {
            this.productQuota = productQuota;
        }

        public String getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(String productStatus) {
            this.productStatus = productStatus;
        }

        public String getProductStatusName() {
            return productStatusName;
        }

        public void setProductStatusName(String productStatusName) {
            this.productStatusName = productStatusName;
        }

        public String getServicePhoneNo() {
            return servicePhoneNo;
        }

        public void setServicePhoneNo(String servicePhoneNo) {
            this.servicePhoneNo = servicePhoneNo;
        }

        public String getShareDescribe() {
            return shareDescribe;
        }

        public void setShareDescribe(String shareDescribe) {
            this.shareDescribe = shareDescribe;
        }

        public String getShareImg() {
            return shareImg;
        }

        public void setShareImg(String shareImg) {
            this.shareImg = shareImg;
        }

        public String getShareTitle() {
            return shareTitle;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }

        public double getShowCostPrice() {
            return showCostPrice;
        }

        public void setShowCostPrice(double showCostPrice) {
            this.showCostPrice = showCostPrice;
        }

        public double getShowSalePrice() {
            return showSalePrice;
        }

        public void setShowSalePrice(double showSalePrice) {
            this.showSalePrice = showSalePrice;
        }

        public double getSingleSellPrice() {
            return singleSellPrice;
        }

        public void setSingleSellPrice(double singleSellPrice) {
            this.singleSellPrice = singleSellPrice;
        }

        public double getTaobaoPrice() {
            return taobaoPrice;
        }

        public void setTaobaoPrice(double taobaoPrice) {
            this.taobaoPrice = taobaoPrice;
        }

        public List<String> getImglist() {
            return imglist;
        }

        public void setImglist(List<String> imglist) {
            this.imglist = imglist;
        }
    }
}
