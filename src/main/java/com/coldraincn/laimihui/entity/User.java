package com.coldraincn.laimihui.entity;

/**
 * Created by hd on 2017/9/7.
 */

public class User {


    /**
     * status : OK
     * data : {"comUserHeadImg":"http://wx.qlogo.cn/mmopen/H87yGagbryVZibE3qBp1iahW0twusJHZNoTSia1wn2hm0I7Dt4ntHAQibmOKticVjmtGjjSNuT0iaqhwjSpwuI2MdkerlJib7ZIic6n9/0","comUserName":"贺yufeng","communityOid":16320885275460,"phone":"18661772011","token":"f88e934ecd15496da2440bcda88b09d1","userRole":2,"userSex":"1","userWxCity":"","userWxCountry":"海地","userWxHeadimgurl":"http://wx.qlogo.cn/mmopen/H87yGagbryVZibE3qBp1iahW0twusJHZNoTSia1wn2hm0I7Dt4ntHAQibmOKticVjmtGjjSNuT0iaqhwjSpwuI2MdkerlJib7ZIic6n9/0","userWxNickname":"贺yufeng","userWxProvince":""}
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
         * comUserHeadImg : http://wx.qlogo.cn/mmopen/H87yGagbryVZibE3qBp1iahW0twusJHZNoTSia1wn2hm0I7Dt4ntHAQibmOKticVjmtGjjSNuT0iaqhwjSpwuI2MdkerlJib7ZIic6n9/0
         * comUserName : 贺yufeng
         * communityOid : 16320885275460
         * phone : 18661772011
         * token : f88e934ecd15496da2440bcda88b09d1
         * userRole : 2
         * userSex : 1
         * userWxCity :
         * userWxCountry : 海地
         * userWxHeadimgurl : http://wx.qlogo.cn/mmopen/H87yGagbryVZibE3qBp1iahW0twusJHZNoTSia1wn2hm0I7Dt4ntHAQibmOKticVjmtGjjSNuT0iaqhwjSpwuI2MdkerlJib7ZIic6n9/0
         * userWxNickname : 贺yufeng
         * userWxProvince :
         */

        private String comUserHeadImg;
        private String comUserName;
        private long communityOid;
        private String phone;
        private String token;
        private int userRole;
        private String userSex;
        private String userWxCity;
        private String userWxCountry;
        private String userWxHeadimgurl;
        private String userWxNickname;
        private String userWxProvince;

        public String getComUserHeadImg() {
            return comUserHeadImg;
        }

        public void setComUserHeadImg(String comUserHeadImg) {
            this.comUserHeadImg = comUserHeadImg;
        }

        public String getComUserName() {
            return comUserName;
        }

        public void setComUserName(String comUserName) {
            this.comUserName = comUserName;
        }

        public long getCommunityOid() {
            return communityOid;
        }

        public void setCommunityOid(long communityOid) {
            this.communityOid = communityOid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUserRole() {
            return userRole;
        }

        public void setUserRole(int userRole) {
            this.userRole = userRole;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }

        public String getUserWxCity() {
            return userWxCity;
        }

        public void setUserWxCity(String userWxCity) {
            this.userWxCity = userWxCity;
        }

        public String getUserWxCountry() {
            return userWxCountry;
        }

        public void setUserWxCountry(String userWxCountry) {
            this.userWxCountry = userWxCountry;
        }

        public String getUserWxHeadimgurl() {
            return userWxHeadimgurl;
        }

        public void setUserWxHeadimgurl(String userWxHeadimgurl) {
            this.userWxHeadimgurl = userWxHeadimgurl;
        }

        public String getUserWxNickname() {
            return userWxNickname;
        }

        public void setUserWxNickname(String userWxNickname) {
            this.userWxNickname = userWxNickname;
        }

        public String getUserWxProvince() {
            return userWxProvince;
        }

        public void setUserWxProvince(String userWxProvince) {
            this.userWxProvince = userWxProvince;
        }
    }
}
