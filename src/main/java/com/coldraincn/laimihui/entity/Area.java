package com.coldraincn.laimihui.entity;

import java.util.List;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 15:49
 */

public class Area {
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

    public class DataBean{

        /**
         * status : OK
         * data : [{"area":"北京市","areaid":110000},{"area":"天津市","areaid":120000},{"area":"河北省","areaid":130000},{"area":"山西省","areaid":140000}]
         */

        private String status;
        private String area;
        private int areaid;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getAreaid() {
            return areaid;
        }

        public void setAreaid(int areaid) {
            this.areaid = areaid;
        }
    }
}
