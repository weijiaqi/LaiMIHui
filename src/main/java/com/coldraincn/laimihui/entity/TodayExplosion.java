package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by hd on 2017/9/8.
 */

public class TodayExplosion {

    /**
     * status : OK
     * data : [{"content":"1111","endtime":"2017-10-01 07:59:59","id":66554603422594,"img":"http://dev.wecity.co/upload/20170822/66551221241151.jpg","name":"测试APP用户","productname":"","showSalePrice":0.01,"starttime":"2017-08-21 08:00:00","url":"533840800783484","urlstatus":1}]
     */

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
        /**
         * content : 1111
         * endtime : 2017-10-01 07:59:59
         * id : 66554603422594
         * img : http://dev.wecity.co/upload/20170822/66551221241151.jpg
         * name : 测试APP用户
         * productname :
         * showSalePrice : 0.01
         * starttime : 2017-08-21 08:00:00
         * url : 533840800783484
         * urlstatus : 1
         */

        private String content;
        private String endtime;
        private long id;
        private String img;
        private String name;
        private String productname;
        private double showSalePrice;
        private String starttime;
        private String url;
        private int urlstatus;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProductname() {
            return productname;
        }

        public void setProductname(String productname) {
            this.productname = productname;
        }

        public double getShowSalePrice() {
            return showSalePrice;
        }

        public void setShowSalePrice(double showSalePrice) {
            this.showSalePrice = showSalePrice;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUrlstatus() {
            return urlstatus;
        }

        public void setUrlstatus(int urlstatus) {
            this.urlstatus = urlstatus;
        }
    }
}
