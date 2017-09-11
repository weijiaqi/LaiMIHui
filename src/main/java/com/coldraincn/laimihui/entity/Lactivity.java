package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * Created by hd on 2017/9/8.
 */

public class Lactivity {

    /**
     * status : OK
     * data : [{"content":"<p>444佛挡杀佛<\/p>","createTime":null,"img":"http://dev.wecity.co/upload/20170724/20794312545572058.png","objectId":282120234373639,"state":1,"title":"充值500元，1元购鸡蛋活动","url":"http://dev.wecity.co/task/mall/community/rechange500.do"},{"content":"<p>测试。。<\/p>","createTime":null,"img":"http://dev.wecity.co/upload/20170721/20551051115887672.png","objectId":66666666,"state":1,"title":"测试1","url":"http://dev.wecity.co/task/mall/community/rechange500.do?userOid="}]
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
         * content : <p>444佛挡杀佛</p>
         * createTime : null
         * img : http://dev.wecity.co/upload/20170724/20794312545572058.png
         * objectId : 282120234373639
         * state : 1
         * title : 充值500元，1元购鸡蛋活动
         * url : http://dev.wecity.co/task/mall/community/rechange500.do
         */

        private String content;
        private Object createTime;
        private String img;
        private long objectId;
        private int state;
        private String title;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public long getObjectId() {
            return objectId;
        }

        public void setObjectId(long objectId) {
            this.objectId = objectId;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
