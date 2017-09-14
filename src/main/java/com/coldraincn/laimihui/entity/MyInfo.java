package com.coldraincn.laimihui.entity;

/**
 * Created by Administrator on 2017/09/13.
 */

public class MyInfo {


    /**
     * status : OK
     * data : {"accumulateIncome":0,"authEnd":"2017-08-07","communityIntroduce":"","communityName":"翠成店","domain":"damin","headBgimg":"/home/thinker/wwwroot/dev.wecity.co/upload/20161204/752417570183717.jpg","idNumber":"1101011911111111","objectId":8125665711450378,"openid":"oUO0Xsy445ggnLgAd6LSQoNJqY0Y","phone":"13522890823","qrCode":"http://dev.wecity.co:80/task/qrcode/damin.jpg","revenueTarget":0,"shopKeeper":"赵宝"}
     */

    private String status;
    private DataBean data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        /**
         * accumulateIncome : 0
         * authEnd : 2017-08-07
         * communityIntroduce :
         * communityName : 翠成店
         * domain : damin
         * headBgimg : /home/thinker/wwwroot/dev.wecity.co/upload/20161204/752417570183717.jpg
         * idNumber : 1101011911111111
         * objectId : 8125665711450378
         * openid : oUO0Xsy445ggnLgAd6LSQoNJqY0Y
         * phone : 13522890823
         * qrCode : http://dev.wecity.co:80/task/qrcode/damin.jpg
         * revenueTarget : 0
         * shopKeeper : 赵宝
         */

        private int accumulateIncome;
        private String authEnd;
        private String communityIntroduce;
        private String communityName;
        private String domain;
        private String headBgimg;
        private String idNumber;
        private long objectId;
        private String openid;
        private String phone;
        private String qrCode;
        private int revenueTarget;
        private String shopKeeper;

        public void setAccumulateIncome(int accumulateIncome) {
            this.accumulateIncome = accumulateIncome;
        }

        public void setAuthEnd(String authEnd) {
            this.authEnd = authEnd;
        }

        public void setCommunityIntroduce(String communityIntroduce) {
            this.communityIntroduce = communityIntroduce;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public void setHeadBgimg(String headBgimg) {
            this.headBgimg = headBgimg;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public void setObjectId(long objectId) {
            this.objectId = objectId;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public void setRevenueTarget(int revenueTarget) {
            this.revenueTarget = revenueTarget;
        }

        public void setShopKeeper(String shopKeeper) {
            this.shopKeeper = shopKeeper;
        }

        public int getAccumulateIncome() {
            return accumulateIncome;
        }

        public String getAuthEnd() {
            return authEnd;
        }

        public String getCommunityIntroduce() {
            return communityIntroduce;
        }

        public String getCommunityName() {
            return communityName;
        }

        public String getDomain() {
            return domain;
        }

        public String getHeadBgimg() {
            return headBgimg;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public long getObjectId() {
            return objectId;
        }

        public String getOpenid() {
            return openid;
        }

        public String getPhone() {
            return phone;
        }

        public String getQrCode() {
            return qrCode;
        }

        public int getRevenueTarget() {
            return revenueTarget;
        }

        public String getShopKeeper() {
            return shopKeeper;
        }
    }
}
