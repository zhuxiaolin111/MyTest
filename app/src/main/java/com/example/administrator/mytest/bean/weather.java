package com.example.administrator.mytest.bean;

import java.util.List;

public class weather {

    /**
     * errNum : 0
     * errMsg : success
     * retData : [{"province_cn":"北京","district_cn":"北京","name_cn":"朝阳","name_en":"chaoyang","area_id":"101010300"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"朝阳","name_en":"chaoyang","area_id":"101071201"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"凌源","name_en":"lingyuan","area_id":"101071203"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"喀左","name_en":"kazuo","area_id":"101071204"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"北票","name_en":"beipiao","area_id":"101071205"},{"province_cn":"辽宁","district_cn":"朝阳","name_cn":"建平县","name_en":"jianpingxian","area_id":"101071207"}]
     */

    private int errNum;
    private String errMsg;
    /**
     * province_cn : 北京
     * district_cn : 北京
     * name_cn : 朝阳
     * name_en : chaoyang
     * area_id : 101010300
     */

    private List<RetDataBean> retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<RetDataBean> getRetData() {
        return retData;
    }

    public void setRetData(List<RetDataBean> retData) {
        this.retData = retData;
    }

    public static class RetDataBean {
        private String province_cn;
        private String district_cn;
        private String name_cn;
        private String name_en;
        private String area_id;

        public String getProvince_cn() {
            return province_cn;
        }

        public void setProvince_cn(String province_cn) {
            this.province_cn = province_cn;
        }

        public String getDistrict_cn() {
            return district_cn;
        }

        public void setDistrict_cn(String district_cn) {
            this.district_cn = district_cn;
        }

        public String getName_cn() {
            return name_cn;
        }

        public void setName_cn(String name_cn) {
            this.name_cn = name_cn;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }
    }
}
