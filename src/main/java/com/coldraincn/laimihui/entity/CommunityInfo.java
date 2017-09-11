package com.coldraincn.laimihui.entity;

/**
 * Created by hd on 2017/9/8.
 */

public class CommunityInfo {

    /**
     * status : OK
     * data : {"accumulateIncome":0,"authEnd":"2017-01-20","communityIntroduce":"","communityName":"测试店","domain":"www.hay.com","headBgimg":"E:workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/upload/20161227/16236119347106.png","objectId":16320885275460,"openid":"oUO0Xs-jb4_COPqLbniFlYHYyNLY","phone":"15313733962","qrCode":"http://localhost:8080/task/qrcode/www.hay.com.png","revenueTarget":0,"shopKeeper":"黄爱莹"}
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
         * accumulateIncome : 0
         * authEnd : 2017-01-20
         * communityIntroduce :
         * communityName : 测试店
         * domain : www.hay.com
         * headBgimg : E:workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/upload/20161227/16236119347106.png
         * objectId : 16320885275460
         * openid : oUO0Xs-jb4_COPqLbniFlYHYyNLY
         * phone : 15313733962
         * qrCode : http://localhost:8080/task/qrcode/www.hay.com.png
         * revenueTarget : 0
         * shopKeeper : 黄爱莹
         */

        private int accumulateIncome;
        private String authEnd;
        private String communityIntroduce;
        private String communityName;
        private String domain;
        private String headBgimg;
        private long objectId;
        private String openid;
        private String phone;
        private String qrCode;
        private int revenueTarget;
        private String shopKeeper;

        public int getAccumulateIncome() {
            return accumulateIncome;
        }

        public void setAccumulateIncome(int accumulateIncome) {
            this.accumulateIncome = accumulateIncome;
        }

        public String getAuthEnd() {
            return authEnd;
        }

        public void setAuthEnd(String authEnd) {
            this.authEnd = authEnd;
        }

        public String getCommunityIntroduce() {
            return communityIntroduce;
        }

        public void setCommunityIntroduce(String communityIntroduce) {
            this.communityIntroduce = communityIntroduce;
        }

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getHeadBgimg() {
            return headBgimg;
        }

        public void setHeadBgimg(String headBgimg) {
            this.headBgimg = headBgimg;
        }

        public long getObjectId() {
            return objectId;
        }

        public void setObjectId(long objectId) {
            this.objectId = objectId;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public int getRevenueTarget() {
            return revenueTarget;
        }

        public void setRevenueTarget(int revenueTarget) {
            this.revenueTarget = revenueTarget;
        }

        public String getShopKeeper() {
            return shopKeeper;
        }

        public void setShopKeeper(String shopKeeper) {
            this.shopKeeper = shopKeeper;
        }
    }
}
