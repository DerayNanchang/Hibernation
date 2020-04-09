package com.lsn.hibernation.base;


import org.greenrobot.greendao.annotation.Id;
import org.jetbrains.annotations.NotNull;

public interface Constant {
    interface Conn {
        String DEBUG_URL = "https://bank.shanxinsx.cn";
        String RELEASE_URL = "https://bank.shanxinsx.cn";

        String APP_NAME_EN = "ShanXin";
        String APP_IMG = "img";
        String APP_NAME_CN_ZH = "闪信";
        String APP_NAME_CN_TW = "闪信";
        String NOTIFICATION_O_ID = "app";   //android 8.0 通知栏(APP 下载) 通道ID
        String NOTIFICATION_O_NAME = "APP 下载";   //android 8.0 通知栏(APP 下载) 通道 名称
        String NOTIFICATION_O_MESSAGE = "message";   //android 8.0 通知栏(APP 下载) 通道ID
        String NOTIFICATION_O_NEW_MESSAGE = "首页消息通知";   //android 8.0 通知栏(APP 下载) 通道 名称
        String APK = "apk";
        String DOWNLOAD_NAME = "闪信.apk";


    }
}