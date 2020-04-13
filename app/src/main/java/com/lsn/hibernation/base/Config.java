package com.lsn.hibernation.base;

import android.os.Environment;

import java.io.File;

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2018/12/3
 * Description
 */
public class Config {

    public boolean isDebug = true;

    private Config() {
    }

    private static class Instance{
       private static Config config = new Config();
    }

    public static Config get(){
        return Instance.config;
    }


    public File createFile(File file){
        if (!file.exists()){
            file.mkdir();
        }
        return file;
    }

    public File initLiteServiceDir(){
        return createFile(new File(Environment.getExternalStorageDirectory(),Constant.Conn.APP_NAME_EN));
    }


    public File initApkDir(){
        return createFile(new File(initLiteServiceDir(),Constant.Conn.APK));
    }

    public File initImgDir(){
        return createFile(new File(initLiteServiceDir(),Constant.Conn.APP_IMG));
    }

    public File initMusicDir(){
        return createFile(new File(initLiteServiceDir(),Constant.Conn.APP_IMG));
    }



    /*public String getProcessImageURL(String rawImageUrl){
        if (isDebug){
            return Constant.Conn.DEBUG_URL + rawImageUrl;
        }else {
            return Constant.Conn.RELEASE_URL + rawImageUrl;
        }
    }*/
}
