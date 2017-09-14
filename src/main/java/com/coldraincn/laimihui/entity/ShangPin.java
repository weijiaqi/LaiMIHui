package com.coldraincn.laimihui.entity;

/**
 * Created by Administrator on 2017/09/12.
 */

public class ShangPin {
    private  String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private  String name;
    private  String price;
    private  String communityBonus;

    public String getCommunityBonus() {
        return communityBonus;
    }

    public void setCommunityBonus(String communityBonus) {
        this.communityBonus = communityBonus;
    }

    public String getDianjinumber() {
        return dianjinumber;
    }

    public void setDianjinumber(String dianjinumber) {
        this.dianjinumber = dianjinumber;
    }

    private  String dianjinumber;
    private  String objectId;
    private  String communityOid;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCommunityOid() {
        return communityOid;
    }

    public void setCommunityOid(String communityOid) {
        this.communityOid = communityOid;
    }
}
