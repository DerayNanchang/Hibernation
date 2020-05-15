package com.lsn.hibernation.base;


public interface Constant {
    interface Conn {
        String DEBUG_URL = "https://bank.shanxinsx.cn";
        String RELEASE_URL = "https://bank.shanxinsx.cn";

        String NET_EASE_URL = "http://musicapi.leanapp.cn";
        String QQ_URL = "http://musicapi.leanapp.cn";

        int EASE_CODE = 200;

        int EASE = 0;
        int QQ = 1;


        String APP_NAME_EN = "JT";
        String APP_IMG = "img";
        String APK = "apk";
        String MUSIC = "music";
        String APP_NAME_CN_ZH = "闪信";
        String APP_NAME_CN_TW = "闪信";
        String NOTIFICATION_O_ID = "app";   //android 8.0 通知栏(APP 下载) 通道ID
        String NOTIFICATION_O_NAME = "APP 下载";   //android 8.0 通知栏(APP 下载) 通道 名称
        String NOTIFICATION_O_MESSAGE = "message";   //android 8.0 通知栏(APP 下载) 通道ID
        String NOTIFICATION_O_NEW_MESSAGE = "首页消息通知";   //android 8.0 通知栏(APP 下载) 通道 名称
        String DOWNLOAD_NAME = "闪信.apk";
        boolean IS_DEBUG = true;
        String HT_LOG = "HT_LOG";


    }


    interface Key{
        String PLAYLIST_COMM = "PLAYLIST_COMM";

        /*String PLAYLIST_ID = "PLAYLIST_ID";
        String ICON = "ICON";
        String U_AVATAR = "U_AVATAR";*/
    }


    interface Music {

        int NET_EASE_SUCCESS_CODE = 200;
        String DEFAULT_NET_EASE_USER_NAME = "13361634880";
        String DEFAULT_NET_EASE_PASSWORD = "123456";
        String DEFAULT_QQ_USER_NAME = "761048783";
        String DEFAULT_QQ_PASSWORD = "b4q4s2z2lzq.";

        interface Api{

            String CALL_PHONE = "/login/cellphone";
            String BANNER = "/banner";
            String PLAYLIST = "/user/playlist";
            String GET_PLAYLIST_DETAIL = "/playlist/detail";

        }
    }
}