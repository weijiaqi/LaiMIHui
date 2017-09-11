package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by hd on 2017/9/9.
 */

public class ListMessage {


    /**
     * status : OK
     * data : {"datalist":[{"content":"基地直供！广西北海红树林海鸭蛋上线啦！<br/>\r\n顿顿吃海鲜，偶尔下个蛋。<br/>\r\n醇香冒油，蛋香浓郁，<br/>\r\n营养丰富，富含卵磷脂，<br/>\r\n恒温烤制，真空包装，<br/>\r\n心动不如行动，快来抢购吧！<br/>","createtimestrmess":"2017-09-04 15:21:20","imglist":["http://api.17yun.com.cn/upload/20170904/245592605053021.jpg"],"objectId":245607627793822,"productList":[{"coverId":"http://api.17yun.com.cn/upload/20170731/533740019922592.jpg","productName":"优惠券测试2","salePersent":"533765205530399"}],"title":"测试单图动态！","unionList":[]},{"content":"基地直供！广西北海红树林海鸭蛋上线啦！<br/>\r\n顿顿吃海鲜，偶尔下个蛋。<br/>\r\n醇香冒油，蛋香浓郁，<br/>\r\n营养丰富，富含卵磷脂，<br/>\r\n恒温烤制，真空包装，<br/>\r\n心动不如行动，快来抢购吧！<br/>","createtimestrmess":"2017-09-04 15:20:34","imglist":["http://api.17yun.com.cn/upload/20170904/245446512373957.jpg","http://api.17yun.com.cn/upload/20170904/245455005015334.jpg","http://api.17yun.com.cn/upload/20170904/245459457785977.jpg","http://api.17yun.com.cn/upload/20170904/245470653117310.jpg","http://api.17yun.com.cn/upload/20170904/245475204023811.jpg","http://api.17yun.com.cn/upload/20170904/245495263488284.jpg","http://api.17yun.com.cn/upload/20170904/245502643835413.jpg"],"objectId":245561985957167,"productList":[{"coverId":"http://api.17yun.com.cn/upload/20170731/533628412247057.jpg","productName":"优惠券测试1","salePersent":"533671615716821"},{"coverId":"http://api.17yun.com.cn/upload/20170731/533740019922592.jpg","productName":"优惠券测试2","salePersent":"533765205530399"}],"title":"多个商品上线啦！","unionList":[]},{"content":"","createtimestrmess":"2017-08-29 09:38:23","imglist":[],"objectId":503627370886830,"productList":[],"title":"关联外部链接","unionList":[{"linkImage":"/home/thinker/wwwroot/dev.wecity.co/upload/20170829/503625419991405.jpg","linkTitle":"测试","linkUrl":"http://www.baidu.com"}]},{"content":"测试","createtimestrmess":"2017-08-24 12:56:02","imglist":[],"objectId":83488837486798,"productList":[],"title":"测试","unionList":[]},{"content":"基地直供！有机白牦牛棒骨块上线啦！<br/>\r\n来自海拔3000米雪域高原的滋补佳品，<br/>\r\n自古以来就有白牦牛:\u201c骨髓可壮筋骨,延年益寿\u201d的记载。<br/>\r\n白牦牛骨棒粗壮，骨髓饱满，滑爽香嫩，汤鲜味美，<br/>\r\n骨髓营养丰富，易吸收，特别适合老人小孩补钙。<br/>\r\n快来抢购吧！<br/>","createtimestrmess":"2017-08-08 10:00:59","imglist":["http://api.17yun.com.cn/upload/20170808/87756168087676.jpg","http://api.17yun.com.cn/upload/20170808/87760766049469.jpg","http://api.17yun.com.cn/upload/20170808/87764917963969.jpg","http://api.17yun.com.cn/upload/20170808/87768155809836.jpg","http://api.17yun.com.cn/upload/20170808/87772727578477.jpg","http://api.17yun.com.cn/upload/20170808/87785075315345.jpg"],"objectId":87900346029925,"productList":[{"coverId":"http://api.17yun.com.cn/upload/20170731/533821041184991.jpg","productName":"测试收货地址","salePersent":"533840800783484"}],"title":"基地直供！有机白牦牛棒骨块 汤鲜味美 骨髓饱满 滋补佳品","unionList":[]}],"pageno":1,"pagesize":5,"totalitems":11,"totalpages":3}
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
         * datalist : [{"content":"基地直供！广西北海红树林海鸭蛋上线啦！<br/>\r\n顿顿吃海鲜，偶尔下个蛋。<br/>\r\n醇香冒油，蛋香浓郁，<br/>\r\n营养丰富，富含卵磷脂，<br/>\r\n恒温烤制，真空包装，<br/>\r\n心动不如行动，快来抢购吧！<br/>","createtimestrmess":"2017-09-04 15:21:20","imglist":["http://api.17yun.com.cn/upload/20170904/245592605053021.jpg"],"objectId":245607627793822,"productList":[{"coverId":"http://api.17yun.com.cn/upload/20170731/533740019922592.jpg","productName":"优惠券测试2","salePersent":"533765205530399"}],"title":"测试单图动态！","unionList":[]},{"content":"基地直供！广西北海红树林海鸭蛋上线啦！<br/>\r\n顿顿吃海鲜，偶尔下个蛋。<br/>\r\n醇香冒油，蛋香浓郁，<br/>\r\n营养丰富，富含卵磷脂，<br/>\r\n恒温烤制，真空包装，<br/>\r\n心动不如行动，快来抢购吧！<br/>","createtimestrmess":"2017-09-04 15:20:34","imglist":["http://api.17yun.com.cn/upload/20170904/245446512373957.jpg","http://api.17yun.com.cn/upload/20170904/245455005015334.jpg","http://api.17yun.com.cn/upload/20170904/245459457785977.jpg","http://api.17yun.com.cn/upload/20170904/245470653117310.jpg","http://api.17yun.com.cn/upload/20170904/245475204023811.jpg","http://api.17yun.com.cn/upload/20170904/245495263488284.jpg","http://api.17yun.com.cn/upload/20170904/245502643835413.jpg"],"objectId":245561985957167,"productList":[{"coverId":"http://api.17yun.com.cn/upload/20170731/533628412247057.jpg","productName":"优惠券测试1","salePersent":"533671615716821"},{"coverId":"http://api.17yun.com.cn/upload/20170731/533740019922592.jpg","productName":"优惠券测试2","salePersent":"533765205530399"}],"title":"多个商品上线啦！","unionList":[]},{"content":"","createtimestrmess":"2017-08-29 09:38:23","imglist":[],"objectId":503627370886830,"productList":[],"title":"关联外部链接","unionList":[{"linkImage":"/home/thinker/wwwroot/dev.wecity.co/upload/20170829/503625419991405.jpg","linkTitle":"测试","linkUrl":"http://www.baidu.com"}]},{"content":"测试","createtimestrmess":"2017-08-24 12:56:02","imglist":[],"objectId":83488837486798,"productList":[],"title":"测试","unionList":[]},{"content":"基地直供！有机白牦牛棒骨块上线啦！<br/>\r\n来自海拔3000米雪域高原的滋补佳品，<br/>\r\n自古以来就有白牦牛:\u201c骨髓可壮筋骨,延年益寿\u201d的记载。<br/>\r\n白牦牛骨棒粗壮，骨髓饱满，滑爽香嫩，汤鲜味美，<br/>\r\n骨髓营养丰富，易吸收，特别适合老人小孩补钙。<br/>\r\n快来抢购吧！<br/>","createtimestrmess":"2017-08-08 10:00:59","imglist":["http://api.17yun.com.cn/upload/20170808/87756168087676.jpg","http://api.17yun.com.cn/upload/20170808/87760766049469.jpg","http://api.17yun.com.cn/upload/20170808/87764917963969.jpg","http://api.17yun.com.cn/upload/20170808/87768155809836.jpg","http://api.17yun.com.cn/upload/20170808/87772727578477.jpg","http://api.17yun.com.cn/upload/20170808/87785075315345.jpg"],"objectId":87900346029925,"productList":[{"coverId":"http://api.17yun.com.cn/upload/20170731/533821041184991.jpg","productName":"测试收货地址","salePersent":"533840800783484"}],"title":"基地直供！有机白牦牛棒骨块 汤鲜味美 骨髓饱满 滋补佳品","unionList":[]}]
         * pageno : 1
         * pagesize : 5
         * totalitems : 11
         * totalpages : 3
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
             * content : 基地直供！广西北海红树林海鸭蛋上线啦！<br/>
             顿顿吃海鲜，偶尔下个蛋。<br/>
             醇香冒油，蛋香浓郁，<br/>
             营养丰富，富含卵磷脂，<br/>
             恒温烤制，真空包装，<br/>
             心动不如行动，快来抢购吧！<br/>
             * createtimestrmess : 2017-09-04 15:21:20
             * imglist : ["http://api.17yun.com.cn/upload/20170904/245592605053021.jpg"]
             * objectId : 245607627793822
             * productList : [{"coverId":"http://api.17yun.com.cn/upload/20170731/533740019922592.jpg","productName":"优惠券测试2","salePersent":"533765205530399"}]
             * title : 测试单图动态！
             * unionList : []
             */

            private String content;
            private String createtimestrmess;
            private long objectId;
            private String title;
            private List<String> imglist;
            private List<ProductListBean> productList;
            private List<?> unionList;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreatetimestrmess() {
                return createtimestrmess;
            }

            public void setCreatetimestrmess(String createtimestrmess) {
                this.createtimestrmess = createtimestrmess;
            }

            public long getObjectId() {
                return objectId;
            }

            public void setObjectId(long objectId) {
                this.objectId = objectId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<String> getImglist() {
                return imglist;
            }

            public void setImglist(List<String> imglist) {
                this.imglist = imglist;
            }

            public List<ProductListBean> getProductList() {
                return productList;
            }

            public void setProductList(List<ProductListBean> productList) {
                this.productList = productList;
            }

            public List<?> getUnionList() {
                return unionList;
            }

            public void setUnionList(List<?> unionList) {
                this.unionList = unionList;
            }

            public static class ProductListBean {
                /**
                 * coverId : http://api.17yun.com.cn/upload/20170731/533740019922592.jpg
                 * productName : 优惠券测试2
                 * salePersent : 533765205530399
                 */

                private String coverId;
                private String productName;
                private String salePersent;

                public String getCoverId() {
                    return coverId;
                }

                public void setCoverId(String coverId) {
                    this.coverId = coverId;
                }

                public String getProductName() {
                    return productName;
                }

                public void setProductName(String productName) {
                    this.productName = productName;
                }

                public String getSalePersent() {
                    return salePersent;
                }

                public void setSalePersent(String salePersent) {
                    this.salePersent = salePersent;
                }
            }
        }
    }
}
