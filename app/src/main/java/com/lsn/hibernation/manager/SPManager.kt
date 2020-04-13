package com.lsn.hibernation.manager

import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.utils.comm.SP

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/13 10:40
 * Description
 */
class SPManager private constructor(){

    companion object Jvm{
        val sp = SPManager()

        const val NET_EASE_MUSIC_USER_NAME = "NET_EASE_MUSIC_USER_NAME";
        const val NET_EASE_MUSIC_PASSWORD = "NET_EASE_MUSIC_PASSWORD";
        const val QQ_MUSIC_USER_NAME = "QQ_MUSIC_USER_NAME";
        const val QQ_MUSIC_PASSWORD = "QQ_MUSIC_PASSWORD";
    }

    fun setNetEaseMusicUserName(userName : String){
        SP.get().putString(NET_EASE_MUSIC_USER_NAME,userName)
    }
    fun setNetEaseMusicPassword(password : String){
        SP.get().putString(NET_EASE_MUSIC_PASSWORD,password)
    }
    fun setQQMusicUserName(userName : String){
        SP.get().putString(QQ_MUSIC_USER_NAME,userName)
    }
    fun setQQMusicPassword(password : String){
        SP.get().putString(QQ_MUSIC_PASSWORD,password)
    }


    fun getNetEaseMusicUserName(){
        SP.get().getString(NET_EASE_MUSIC_USER_NAME,Constant.Music.DEFAULT_NET_EASE_USER_NAME)
    }
    fun getNetEaseMusicPassword(){
        SP.get().getString(NET_EASE_MUSIC_PASSWORD,Constant.Music.DEFAULT_NET_EASE_PASSWORD)
    }
    fun getQQMusicUserName(){
        SP.get().getString(QQ_MUSIC_USER_NAME,Constant.Music.DEFAULT_QQ_USER_NAME)
    }
    fun getQQMusicPassword(){
        SP.get().getString(QQ_MUSIC_PASSWORD,Constant.Music.DEFAULT_QQ_PASSWORD)
    }

}