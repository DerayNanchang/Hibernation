package com.lsn.hibernation.modules.music.bean;

import java.util.List;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 11:52
 * Description
 */
public class Banner {

    /**
     * code : 200
     * banners : [{"picUrl":"http://p1.music.126.net/jdx3RNbljbP_R4VRMLuRBg==/109951164900957905.jpg","url":"https://music.163.com/m/at/2020Q1","targetId":"0","backgroundUrl":"","targetType":"3000","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/2xfwYJFN8Ot9Sb_vLHsd3Q==/109951164901094816.jpg","url":"/playlist?id=3205374001","targetId":"3205374001","backgroundUrl":"","targetType":"1000","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/2hhQnG9YIIr6bIhuLJSg6Q==/109951164902040499.jpg","url":"/album?id=87928146","targetId":"87928146","backgroundUrl":"","targetType":"10","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/EzsawqAXJ92C7NjCf0niyg==/109951164901110604.jpg","url":"/album?id=87929838","targetId":"87929838","backgroundUrl":"","targetType":"10","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/aWo-6kEnUr0uak--8k63_Q==/109951164901113225.jpg","url":"/album?id=87927433","targetId":"87927433","backgroundUrl":"","targetType":"10","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/y9YMR49Ul134F5vyJbErtQ==/109951164901122514.jpg","url":"https://music.163.com/m/at/5e870223a5f7ff08ff218b93","targetId":"0","backgroundUrl":"","targetType":"3000","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/YjupkD2bBRTNAUE_kFahYQ==/109951164901129027.jpg","url":"/album?id=87860548","targetId":"87860548","backgroundUrl":"","targetType":"10","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/NZ9jiG2_b5xbDFmZQVUd1Q==/109951164901132280.jpg","url":"/song?id=1440104622","targetId":"1440104622","backgroundUrl":"","targetType":"1","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""},{"picUrl":"http://p1.music.126.net/DH-Ohm7V0eljz5LFlq_43Q==/109951164901979254.jpg","url":"/album?id=87853748","targetId":"87853748","backgroundUrl":"","targetType":"10","monitorType":"","monitorImpress":"","monitorClick":"","backgroundColor":""}]
     */

    private int code;
    private List<BannersBean> banners;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public static class BannersBean {
        /**
         * picUrl : http://p1.music.126.net/jdx3RNbljbP_R4VRMLuRBg==/109951164900957905.jpg
         * url : https://music.163.com/m/at/2020Q1
         * targetId : 0
         * backgroundUrl :
         * targetType : 3000
         * monitorType :
         * monitorImpress :
         * monitorClick :
         * backgroundColor :
         */

        private String picUrl;
        private String url;
        private String targetId;
        private String backgroundUrl;
        private String targetType;
        private String monitorType;
        private String monitorImpress;
        private String monitorClick;
        private String backgroundColor;

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTargetId() {
            return targetId;
        }

        public void setTargetId(String targetId) {
            this.targetId = targetId;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public String getTargetType() {
            return targetType;
        }

        public void setTargetType(String targetType) {
            this.targetType = targetType;
        }

        public String getMonitorType() {
            return monitorType;
        }

        public void setMonitorType(String monitorType) {
            this.monitorType = monitorType;
        }

        public String getMonitorImpress() {
            return monitorImpress;
        }

        public void setMonitorImpress(String monitorImpress) {
            this.monitorImpress = monitorImpress;
        }

        public String getMonitorClick() {
            return monitorClick;
        }

        public void setMonitorClick(String monitorClick) {
            this.monitorClick = monitorClick;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }
}
