package com.coldraincn.laimihui.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <Pre>
 *     商品列表
 * </Pre>
 *
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 13:41
 */

public class AddressList implements Serializable{
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

    public class DataBean implements Serializable{
        /**
         * areaCode : 110108
         * cityCode : 110100
         * isDefault : 1
         * objectId : 754539076389498
         * postCode : 100081
         * provinceCode : 110000
         * receiverAddress : 北京市海淀区中关村南大街
         * receiverName : 苏文君
         * receiverPhoneNo : 13810153494
         */

        private int areaCode;
        private int cityCode;
        private String isDefault;
        private long objectId;
        private String postCode;
        private int provinceCode;
        private String receiverAddress;
        private String receiverName;
        private String receiverPhoneNo;

        public int getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(int areaCode) {
            this.areaCode = areaCode;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public String getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(String isDefault) {
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
