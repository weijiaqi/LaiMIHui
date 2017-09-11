package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by hd on 2017/9/10.
 */

public class ProductDetail {

    /**
     * status : OK
     * data : {"coverId":"http://api.17yun.com.cn/upload/20170731/533821041184991.jpg","imglist":["http://dev.wecity.co/upload/20170731/533823460732199.jpg","http://dev.wecity.co/upload/20170904/245930890258055.jpg","http://dev.wecity.co/upload/20170904/245933679275300.jpg"],"marketPrice":199,"objectId":533840800783484,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509989015007053.jpg\" title=\"1504509989015007053.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831101644.jpg\"/><\/p>","productKey":"新鲜果蔬","productName":"测试收货地址","productQuota":-1,"productStatus":"3","productStatusName":"进行中","servicePhoneNo":"4000088910","shareDescribe":"优惠券测试3","shareImg":"http://dev.wecity.co/upload/20170731/533834843070655.jpg","shareTitle":"优惠券测试3","showCostPrice":199,"showSalePrice":0.01,"singleSellPrice":0.02,"taobaoPrice":199}
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
         * coverId : http://api.17yun.com.cn/upload/20170731/533821041184991.jpg
         * imglist : ["http://dev.wecity.co/upload/20170731/533823460732199.jpg","http://dev.wecity.co/upload/20170904/245930890258055.jpg","http://dev.wecity.co/upload/20170904/245933679275300.jpg"]
         * marketPrice : 199
         * objectId : 533840800783484
         * postPrice : 0
         * productInfo : <p><img src="/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509989015007053.jpg" title="1504509989015007053.jpg" style="width:100%;" alt="微信图片_20170831101644.jpg"/></p>
         * productKey : 新鲜果蔬
         * productName : 测试收货地址
         * productQuota : -1
         * productStatus : 3
         * productStatusName : 进行中
         * servicePhoneNo : 4000088910
         * shareDescribe : 优惠券测试3
         * shareImg : http://dev.wecity.co/upload/20170731/533834843070655.jpg
         * shareTitle : 优惠券测试3
         * showCostPrice : 199
         * showSalePrice : 0.01
         * singleSellPrice : 0.02
         * taobaoPrice : 199
         */

        private String coverId;
        private int marketPrice;
        private long objectId;
        private int postPrice;
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
        private int showCostPrice;
        private double showSalePrice;
        private double singleSellPrice;
        private int taobaoPrice;
        private List<String> imglist;

        public String getCoverId() {
            return coverId;
        }

        public void setCoverId(String coverId) {
            this.coverId = coverId;
        }

        public int getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(int marketPrice) {
            this.marketPrice = marketPrice;
        }

        public long getObjectId() {
            return objectId;
        }

        public void setObjectId(long objectId) {
            this.objectId = objectId;
        }

        public int getPostPrice() {
            return postPrice;
        }

        public void setPostPrice(int postPrice) {
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

        public int getShowCostPrice() {
            return showCostPrice;
        }

        public void setShowCostPrice(int showCostPrice) {
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

        public int getTaobaoPrice() {
            return taobaoPrice;
        }

        public void setTaobaoPrice(int taobaoPrice) {
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
