package com.lsn.hibernation.manager

import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.utils.comm.SP

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/13 10:40
 * Description
 */
class SPManager private constructor() {

    companion object Jvm {
        val sp = SPManager()

        const val NET_EASE_MUSIC_USER_NAME = "NET_EASE_MUSIC_USER_NAME";
        const val NET_EASE_MUSIC_PASSWORD = "NET_EASE_MUSIC_PASSWORD";
        const val QQ_MUSIC_USER_NAME = "QQ_MUSIC_USER_NAME";
        const val QQ_MUSIC_PASSWORD = "QQ_MUSIC_PASSWORD";

        const val PLAYLIST_CACHE_ID = "PLAYLIST_CACHE_ID"
        const val MUSIC_CACHE_ID = "MUSIC_CACHE_ID"
        const val MUSIC_PLAY_MODE = "MUSIC_PLAY_MODE"

        const val QUEUE_POSITION = "QUEUE_POSITION"
    }

    fun setPlaylistQueueId(id: String) {
        SP.get().putString(PLAYLIST_CACHE_ID, id)
    }

    fun getPlaylistQueueId(): String {
        return SP.get().getString(PLAYLIST_CACHE_ID, "_")
    }

    fun setNetEaseMusicUserName(userName: String) {
        SP.get().putString(NET_EASE_MUSIC_USER_NAME, userName)
    }

    fun setNetEaseMusicPassword(password: String) {
        SP.get().putString(NET_EASE_MUSIC_PASSWORD, password)
    }

    fun setQQMusicUserName(userName: String) {
        SP.get().putString(QQ_MUSIC_USER_NAME, userName)
    }

    fun setQQMusicPassword(password: String) {
        SP.get().putString(QQ_MUSIC_PASSWORD, password)
    }


    fun getNetEaseMusicUserName() {
        SP.get().getString(NET_EASE_MUSIC_USER_NAME, Constant.Music.DEFAULT_NET_EASE_USER_NAME)
    }

    fun getNetEaseMusicPassword() {
        SP.get().getString(NET_EASE_MUSIC_PASSWORD, Constant.Music.DEFAULT_NET_EASE_PASSWORD)
    }

    fun getQQMusicUserName() {
        SP.get().getString(QQ_MUSIC_USER_NAME, Constant.Music.DEFAULT_QQ_USER_NAME)
    }

    fun getQQMusicPassword() {
        SP.get().getString(QQ_MUSIC_PASSWORD, Constant.Music.DEFAULT_QQ_PASSWORD)
    }

    fun setPlayMode(mode: String) {
        SP.get().putString(MUSIC_PLAY_MODE, mode)
    }

    fun getPlayMode(): String {
        return SP.get().getString(MUSIC_PLAY_MODE, Constant.Music.AUDIO_PLAY_MANAGER_ORDER)
    }

    fun setQueuePosition(position: Int) {
        SP.get().putInt(QUEUE_POSITION, position)
    }

    fun getQueuePosition() : Int{
        return SP.get().getInt(QUEUE_POSITION,0)
    }

}