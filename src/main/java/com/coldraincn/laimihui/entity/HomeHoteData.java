package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13 0013.
 */

public class HomeHoteData {

    /**
     * status : OK
     * data : {"excellentFreshOnLineList":[{"content":"正宗福建平和琯溪红肉蜜柚红心柚子新鲜农家特产纯天然有机水果","endtime":"2018-05-01 07:59:59","endtimestr":"","id":443316179900442,"img":"http://api.17yun.com.cn/upload/20170316/9562500801893896.jpeg","name":"正宗福建平和琯溪红肉蜜柚","productname":"","showSalePrice":0.01,"showstatus":1,"starttime":"2016-10-18 08:00:00","starttimestr":"","status":1,"type":2,"url":"537580830664190","urlstatus":1}],"seasonSellList":[{"content":"1111","endtime":"2017-12-01 07:59:59","endtimestr":"","id":9410824571483055,"img":"http://api.17yun.com.cn/upload/20170314/9410823660924608.jpg","name":"1111","productname":"","showSalePrice":0.01,"showstatus":1,"starttime":"2017-03-14 08:00:00","starttimestr":"","status":1,"type":3,"url":"537580830664190","urlstatus":1}],"selectTopicList":[{"content":"","endtime":"2017-10-01 07:59:59","endtimestr":"","id":339998186311295,"img":"http://api.17yun.com.cn/upload/20170905/339996930305219.jpg","name":"长岛海鲜","productname":"","showSalePrice":0,"showstatus":1,"starttime":"2017-09-05 08:00:00","starttimestr":"","status":1,"type":4,"url":"http://dev.wecity.co/task/mall/article/viewTopicDetail.do?articleOid=24488906905227","urlstatus":2}],"todayExplosionList":[{"content":"22222","endtime":"2017-10-01 07:59:59","endtimestr":"","id":66554603422594,"img":"http://api.17yun.com.cn/upload/20170910/783018402006946.jpg","name":"测试APP用户","productname":"","showSalePrice":0.01,"showstatus":1,"starttime":"2017-08-21 08:00:00","starttimestr":"","status":1,"type":0,"url":"533840800783484","urlstatus":1},{"content":"天凉啦，来碗山药粥尝尝","endtime":"2017-12-01 07:59:59","endtimestr":"","id":541362812273407,"img":"http://api.17yun.com.cn/upload/20170316/9562205486887786.jpeg","name":"铁棍山药5斤量贩装仅售35.6元","productname":"","showSalePrice":0.01,"showstatus":1,"starttime":"2016-10-12 08:00:00","starttimestr":"","status":1,"type":0,"url":"45775087505334451","urlstatus":1}],"vipProductList":[{"content":"驱蚊器无123","endtime":"2017-12-01 07:59:59","endtimestr":"","id":9562705690402743,"img":"http://api.17yun.com.cn/upload/20170316/9562680701805017.jpeg","name":"美宝世家","productname":"","showSalePrice":0.01,"showstatus":1,"starttime":"2017-03-15 08:00:00","starttimestr":"","status":1,"type":1,"url":"533840800783484","urlstatus":1}]}
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
        private List<ExcellentFreshOnLineListBean> excellentFreshOnLineList;
        private List<SeasonSellListBean> seasonSellList;
        private List<SelectTopicListBean> selectTopicList;
        private List<TodayExplosionListBean> todayExplosionList;
        private List<VipProductListBean> vipProductList;

        public List<ExcellentFreshOnLineListBean> getExcellentFreshOnLineList() {
            return excellentFreshOnLineList;
        }

        public void setExcellentFreshOnLineList(List<ExcellentFreshOnLineListBean> excellentFreshOnLineList) {
            this.excellentFreshOnLineList = excellentFreshOnLineList;
        }

        public List<SeasonSellListBean> getSeasonSellList() {
            return seasonSellList;
        }

        public void setSeasonSellList(List<SeasonSellListBean> seasonSellList) {
            this.seasonSellList = seasonSellList;
        }

        public List<SelectTopicListBean> getSelectTopicList() {
            return selectTopicList;
        }

        public void setSelectTopicList(List<SelectTopicListBean> selectTopicList) {
            this.selectTopicList = selectTopicList;
        }

        public List<TodayExplosionListBean> getTodayExplosionList() {
            return todayExplosionList;
        }

        public void setTodayExplosionList(List<TodayExplosionListBean> todayExplosionList) {
            this.todayExplosionList = todayExplosionList;
        }

        public List<VipProductListBean> getVipProductList() {
            return vipProductList;
        }

        public void setVipProductList(List<VipProductListBean> vipProductList) {
            this.vipProductList = vipProductList;
        }

        public static class ExcellentFreshOnLineListBean {
            /**
             * content : 正宗福建平和琯溪红肉蜜柚红心柚子新鲜农家特产纯天然有机水果
             * endtime : 2018-05-01 07:59:59
             * endtimestr :
             * id : 443316179900442
             * img : http://api.17yun.com.cn/upload/20170316/9562500801893896.jpeg
             * name : 正宗福建平和琯溪红肉蜜柚
             * productname :
             * showSalePrice : 0.01
             * showstatus : 1
             * starttime : 2016-10-18 08:00:00
             * starttimestr :
             * status : 1
             * type : 2
             * url : 537580830664190
             * urlstatus : 1
             */

            private String content;
            private String endtime;
            private String endtimestr;
            private long id;
            private String img;
            private String name;
            private String productname;
            private double showSalePrice;
            private int showstatus;
            private String starttime;
            private String starttimestr;
            private int status;
            private int type;
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

            public String getEndtimestr() {
                return endtimestr;
            }

            public void setEndtimestr(String endtimestr) {
                this.endtimestr = endtimestr;
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

            public int getShowstatus() {
                return showstatus;
            }

            public void setShowstatus(int showstatus) {
                this.showstatus = showstatus;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getStarttimestr() {
                return starttimestr;
            }

            public void setStarttimestr(String starttimestr) {
                this.starttimestr = starttimestr;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

        public static class SeasonSellListBean {
            /**
             * content : 1111
             * endtime : 2017-12-01 07:59:59
             * endtimestr :
             * id : 9410824571483055
             * img : http://api.17yun.com.cn/upload/20170314/9410823660924608.jpg
             * name : 1111
             * productname :
             * showSalePrice : 0.01
             * showstatus : 1
             * starttime : 2017-03-14 08:00:00
             * starttimestr :
             * status : 1
             * type : 3
             * url : 537580830664190
             * urlstatus : 1
             */

            private String content;
            private String endtime;
            private String endtimestr;
            private long id;
            private String img;
            private String name;
            private String productname;
            private double showSalePrice;
            private int showstatus;
            private String starttime;
            private String starttimestr;
            private int status;
            private int type;
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

            public String getEndtimestr() {
                return endtimestr;
            }

            public void setEndtimestr(String endtimestr) {
                this.endtimestr = endtimestr;
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

            public int getShowstatus() {
                return showstatus;
            }

            public void setShowstatus(int showstatus) {
                this.showstatus = showstatus;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getStarttimestr() {
                return starttimestr;
            }

            public void setStarttimestr(String starttimestr) {
                this.starttimestr = starttimestr;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

        public static class SelectTopicListBean {
            /**
             * content :
             * endtime : 2017-10-01 07:59:59
             * endtimestr :
             * id : 339998186311295
             * img : http://api.17yun.com.cn/upload/20170905/339996930305219.jpg
             * name : 长岛海鲜
             * productname :
             * showSalePrice : 0
             * showstatus : 1
             * starttime : 2017-09-05 08:00:00
             * starttimestr :
             * status : 1
             * type : 4
             * url : http://dev.wecity.co/task/mall/article/viewTopicDetail.do?articleOid=24488906905227
             * urlstatus : 2
             */

            private String content;
            private String endtime;
            private String endtimestr;
            private long id;
            private String img;
            private String name;
            private String productname;
            private int showSalePrice;
            private int showstatus;
            private String starttime;
            private String starttimestr;
            private int status;
            private int type;
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

            public String getEndtimestr() {
                return endtimestr;
            }

            public void setEndtimestr(String endtimestr) {
                this.endtimestr = endtimestr;
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

            public int getShowSalePrice() {
                return showSalePrice;
            }

            public void setShowSalePrice(int showSalePrice) {
                this.showSalePrice = showSalePrice;
            }

            public int getShowstatus() {
                return showstatus;
            }

            public void setShowstatus(int showstatus) {
                this.showstatus = showstatus;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getStarttimestr() {
                return starttimestr;
            }

            public void setStarttimestr(String starttimestr) {
                this.starttimestr = starttimestr;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

        public static class TodayExplosionListBean {
            /**
             * content : 22222
             * endtime : 2017-10-01 07:59:59
             * endtimestr :
             * id : 66554603422594
             * img : http://api.17yun.com.cn/upload/20170910/783018402006946.jpg
             * name : 测试APP用户
             * productname :
             * showSalePrice : 0.01
             * showstatus : 1
             * starttime : 2017-08-21 08:00:00
             * starttimestr :
             * status : 1
             * type : 0
             * url : 533840800783484
             * urlstatus : 1
             */

            private String content;
            private String endtime;
            private String endtimestr;
            private long id;
            private String img;
            private String name;
            private String productname;
            private double showSalePrice;
            private int showstatus;
            private String starttime;
            private String starttimestr;
            private int status;
            private int type;
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

            public String getEndtimestr() {
                return endtimestr;
            }

            public void setEndtimestr(String endtimestr) {
                this.endtimestr = endtimestr;
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

            public int getShowstatus() {
                return showstatus;
            }

            public void setShowstatus(int showstatus) {
                this.showstatus = showstatus;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getStarttimestr() {
                return starttimestr;
            }

            public void setStarttimestr(String starttimestr) {
                this.starttimestr = starttimestr;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

        public static class VipProductListBean {
            /**
             * content : 驱蚊器无123
             * endtime : 2017-12-01 07:59:59
             * endtimestr :
             * id : 9562705690402743
             * img : http://api.17yun.com.cn/upload/20170316/9562680701805017.jpeg
             * name : 美宝世家
             * productname :
             * showSalePrice : 0.01
             * showstatus : 1
             * starttime : 2017-03-15 08:00:00
             * starttimestr :
             * status : 1
             * type : 1
             * url : 533840800783484
             * urlstatus : 1
             */

            private String content;
            private String endtime;
            private String endtimestr;
            private long id;
            private String img;
            private String name;
            private String productname;
            private double showSalePrice;
            private int showstatus;
            private String starttime;
            private String starttimestr;
            private int status;
            private int type;
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

            public String getEndtimestr() {
                return endtimestr;
            }

            public void setEndtimestr(String endtimestr) {
                this.endtimestr = endtimestr;
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

            public int getShowstatus() {
                return showstatus;
            }

            public void setShowstatus(int showstatus) {
                this.showstatus = showstatus;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getStarttimestr() {
                return starttimestr;
            }

            public void setStarttimestr(String starttimestr) {
                this.starttimestr = starttimestr;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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
}
