package com.coldraincn.laimihui.entity;

/**
 * Created by hd on 2017/9/14.
 */

public class DefaltAddress {
    /**
     * status : OK
     * data : {"area":"","areaCode":110101,"city":"","cityCode":110100,"isDefault":"1","objectId":608353049428800,"postCode":"1000091","province":"","provinceCode":110000,"receiverAddress":"北京市海淀区中关村南大街","receiverName":"赵宝","receiverPhoneNo":"13522890823"}
     */

    private String status;
    private DefaltAddress.DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DefaltAddress.DataBean getData() {
        return data;
    }

    public void setData(DefaltAddress.DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * area :
         * areaCode : 110101
         * city :
         * cityCode : 110100
         * isDefault : 1
         * objectId : 608353049428800
         * postCode : 1000091
         * province :
         * provinceCode : 110000
         * receiverAddress : 北京市海淀区中关村南大街
         * receiverName : 赵宝
         * receiverPhoneNo : 13522890823
         */

        private String area;
        private int areaCode;
        private String city;
        private int cityCode;
        private int isDefault;
        private long objectId;
        private String postCode;
        private String province;
        private int provinceCode;
        private String receiverAddress;
        private String receiverName;
        private String receiverPhoneNo;



        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(int areaCode) {
            this.areaCode = areaCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public int getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
        }

        public long getObjectId() {
            return objectId;
        }

        public void setObjectId(long objectId) {
            this.objectId = objectId;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public int getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(int provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getReceiverAddress() {
            return receiverAddress;
        }

        public void setReceiverAddress(String receiverAddress) {
            this.receiverAddress = receiverAddress;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getReceiverPhoneNo() {
            return receiverPhoneNo;
        }

        public void setReceiverPhoneNo(String receiverPhoneNo) {
            this.receiverPhoneNo = receiverPhoneNo;
        }
    }
}
