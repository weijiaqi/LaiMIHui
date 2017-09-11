package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by hd on 2017/9/8.
 */

public class SelectTopic {
    /**
     * status : OK
     * data : [{"content":"正宗福建平和琯溪红肉蜜柚红心柚子新鲜农家特产纯天然有机水果","endtime":"2018-05-01 07:59:59","id":443316179900442,"img":"http://dev.wecity.co/upload/20170316/9562500801893896.jpeg","name":"正宗福建平和琯溪红肉蜜柚","productname":"","showSalePrice":0.01,"starttime":"2016-10-18 08:00:00","url":"537580830664190","urlstatus":1}]
     */

    private String status;
    private List<FreshOnLine.DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FreshOnLine.DataBean> getData() {
        return data;
    }

    public void setData(List<FreshOnLine.DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : 正宗福建平和琯溪红肉蜜柚红心柚子新鲜农家特产纯天然有机水果
         * endtime : 2018-05-01 07:59:59
         * id : 443316179900442
         * img : http://dev.wecity.co/upload/20170316/9562500801893896.jpeg
         * name : 正宗福建平和琯溪红肉蜜柚
         * productname :
         * showSalePrice : 0.01
         * starttime : 2016-10-18 08:00:00
         * url : 537580830664190
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
