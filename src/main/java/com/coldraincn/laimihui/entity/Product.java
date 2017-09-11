package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by hd on 2017/9/8.
 */

public class Product {

    /**
     * status : OK
     * data : {"datalist":[{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170904/246321195631032.jpg","imglist":[],"marketPrice":0,"objectId":246361921510751,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504510361737090231.jpg\" title=\"1504510361737090231.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831102919.jpg\"/><\/p>","productKey":"海鲜水产","productName":"基地直供！山东青岛现捕梭子蟹 膏肥黄满 现捞现发 顺丰直达","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170904/246544737374855.jpg","imglist":[],"marketPrice":0,"objectId":246582188790980,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504510594872036518.jpg\" title=\"1504510594872036518.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831103044.jpg\"/><\/p>","productKey":"精品粮油","productName":"基地直供！山东威海无花果露酒","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170904/247020781965480.jpg","imglist":[],"marketPrice":0,"objectId":247058893786642,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504511074332050138.jpg\" title=\"1504511074332050138.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831101644.jpg\"/><\/p>","productKey":"休闲食品","productName":"休闲零食","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0,"showSalePrice":0.02,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170731/533628412247057.jpg","imglist":[],"marketPrice":0,"objectId":533671615716821,"postPrice":0,"productInfo":"<p>优惠券测试1<\/p>","productKey":"休闲零食","productName":"优惠券测试1","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":9,"showSalePrice":9,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170731/533740019922592.jpg","imglist":[],"marketPrice":0,"objectId":533765205530399,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504510165379072403.jpg\" title=\"1504510165379072403.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831102919.jpg\"/><\/p>","productKey":"肉禽蛋奶","productName":"优惠券测试2","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":99,"showSalePrice":99,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170731/533821041184991.jpg","imglist":[],"marketPrice":0,"objectId":533840800783484,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509989015007053.jpg\" title=\"1504509989015007053.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831101644.jpg\"/><\/p>","productKey":"新鲜果蔬","productName":"测试收货地址","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":199,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170704/19080749993030166.jpg","imglist":[],"marketPrice":0,"objectId":537580830664190,"postPrice":0,"productInfo":"<p><span style=\"font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;\">此项非常规商品，用于较偏远地区邮费差价。拍前请联系客服，请勿自行购买。<\/span><\/p><p><span style=\"font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;\"><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509793370068373.jpg\" title=\"1504509793370068373.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831103044.jpg\"/><\/span><\/p>","productKey":"其他，此项非常规商品，拍前请联系客服，请勿自行购买。邮费，其他","productName":"补拍邮费","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000082910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0.1,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0}],"pageno":0,"pagesize":200,"totalitems":14,"totalpages":1}
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
         * datalist : [{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170904/246321195631032.jpg","imglist":[],"marketPrice":0,"objectId":246361921510751,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504510361737090231.jpg\" title=\"1504510361737090231.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831102919.jpg\"/><\/p>","productKey":"海鲜水产","productName":"基地直供！山东青岛现捕梭子蟹 膏肥黄满 现捞现发 顺丰直达","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170904/246544737374855.jpg","imglist":[],"marketPrice":0,"objectId":246582188790980,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504510594872036518.jpg\" title=\"1504510594872036518.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831103044.jpg\"/><\/p>","productKey":"精品粮油","productName":"基地直供！山东威海无花果露酒","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170904/247020781965480.jpg","imglist":[],"marketPrice":0,"objectId":247058893786642,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504511074332050138.jpg\" title=\"1504511074332050138.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831101644.jpg\"/><\/p>","productKey":"休闲食品","productName":"休闲零食","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0,"showSalePrice":0.02,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170731/533628412247057.jpg","imglist":[],"marketPrice":0,"objectId":533671615716821,"postPrice":0,"productInfo":"<p>优惠券测试1<\/p>","productKey":"休闲零食","productName":"优惠券测试1","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":9,"showSalePrice":9,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170731/533740019922592.jpg","imglist":[],"marketPrice":0,"objectId":533765205530399,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504510165379072403.jpg\" title=\"1504510165379072403.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831102919.jpg\"/><\/p>","productKey":"肉禽蛋奶","productName":"优惠券测试2","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":99,"showSalePrice":99,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170731/533821041184991.jpg","imglist":[],"marketPrice":0,"objectId":533840800783484,"postPrice":0,"productInfo":"<p><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509989015007053.jpg\" title=\"1504509989015007053.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831101644.jpg\"/><\/p>","productKey":"新鲜果蔬","productName":"测试收货地址","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000088910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":199,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0},{"coverId":"/home/thinker/wwwroot/dev.wecity.co/upload/20170704/19080749993030166.jpg","imglist":[],"marketPrice":0,"objectId":537580830664190,"postPrice":0,"productInfo":"<p><span style=\"font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;\">此项非常规商品，用于较偏远地区邮费差价。拍前请联系客服，请勿自行购买。<\/span><\/p><p><span style=\"font-family: 华文细黑; color: rgb(0, 0, 0); font-size: 20px;\"><img src=\"/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509793370068373.jpg\" title=\"1504509793370068373.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831103044.jpg\"/><\/span><\/p>","productKey":"其他，此项非常规商品，拍前请联系客服，请勿自行购买。邮费，其他","productName":"补拍邮费","productQuota":-1,"productStatus":"1","productStatusName":"已上架","servicePhoneNo":"4000082910","shareDescribe":"","shareImg":"","shareTitle":"","showCostPrice":0.1,"showSalePrice":0.01,"singleSellPrice":0,"taobaoPrice":0}]
         * pageno : 0
         * pagesize : 200
         * totalitems : 14
         * totalpages : 1
         */

        private int pageno;
        private int pagesize;
        private int totalitems;
        private int totalpages;
        private List<DatalistBean> datalist;

        public int getPageno() {
            return pageno;
        }

        public void setPageno(int pageno) {
            this.pageno = pageno;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getTotalitems() {
            return totalitems;
        }

        public void setTotalitems(int totalitems) {
            this.totalitems = totalitems;
        }

        public int getTotalpages() {
            return totalpages;
        }

        public void setTotalpages(int totalpages) {
            this.totalpages = totalpages;
        }

        public List<DatalistBean> getDatalist() {
            return datalist;
        }

        public void setDatalist(List<DatalistBean> datalist) {
            this.datalist = datalist;
        }

        public static class DatalistBean {
            /**
             * coverId : /home/thinker/wwwroot/dev.wecity.co/upload/20170904/246321195631032.jpg
             * imglist : []
             * marketPrice : 0
             * objectId : 246361921510751
             * postPrice : 0
             * productInfo : <p><img src="/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504510361737090231.jpg" title="1504510361737090231.jpg" style="width:100%;" alt="微信图片_20170831102919.jpg"/></p>
             * productKey : 海鲜水产
             * productName : 基地直供！山东青岛现捕梭子蟹 膏肥黄满 现捞现发 顺丰直达
             * productQuota : -1
             * productStatus : 1
             * productStatusName : 已上架
             * servicePhoneNo : 4000088910
             * shareDescribe :
             * shareImg :
             * shareTitle :
             * showCostPrice : 0
             * showSalePrice : 0.01
             * singleSellPrice : 0
             * taobaoPrice : 0
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
            private int singleSellPrice;
            private int taobaoPrice;
            private List<?> imglist;

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

            public int getSingleSellPrice() {
                return singleSellPrice;
            }

            public void setSingleSellPrice(int singleSellPrice) {
                this.singleSellPrice = singleSellPrice;
            }

            public int getTaobaoPrice() {
                return taobaoPrice;
            }

            public void setTaobaoPrice(int taobaoPrice) {
                this.taobaoPrice = taobaoPrice;
            }

            public List<?> getImglist() {
                return imglist;
            }

            public void setImglist(List<?> imglist) {
                this.imglist = imglist;
            }
        }
    }
}
