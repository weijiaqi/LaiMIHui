package com.coldraincn.laimihui.entity;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 17:08
 */

public class Address {
    private String receiverName;//	string	//Y	收货人姓名
    private String receiverPhoneNo;//	String	//Y	收货人手机号
    private String receiverAddress;//	string	//Y	详细地址
    private int isDefault;//	Int	//Y	是否是默认地址
    private String postCode;//String;	//Y	邮编
    private int provinceCode;//	Int	//Y	省代码
    private int cityCode;//	Int	//Y	城市代码
    private int areaCode;//	Int	//Y	县区
    private String province;//	Int	//Y	省
    private String city;//	Int	//Y	城市
    private String area;//	Int	//Y	县区
    private long objectId;//	Int	//Y	县区代码

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getObjectId() {
        return objectId;
    }
    public void setObjectId(long objectId) {
        this.objectId = objectId;
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

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
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

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }
}
