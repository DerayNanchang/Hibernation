package com.lsn.hibernation.manager

import android.content.Context
import android.media.MediaPlayer

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 15:10
 * Description
 */
class MusicManager private constructor() : MediaPlayer.OnCompletionListener {

    lateinit var context: Context

    private var player: MediaPlayer? = null

    private enum class PlayMode {
        // 顺序，随机，循环
        ORDER,
        RANDOM, CIRCULATION
    }

    private enum class Status {
        // 闲置，播放，暂停
        IDLE,
        PLAY, PAUSE
    }

    companion object JVM {
        val get = MusicManager
    }

    fun init(context: Context) {
        this.context = context
        if (player == null) {
            initPlay()
        }
    }

    private fun initPlay() {
        player = MediaPlayer()
        player?.apply {
            setOnCompletionListener(this@MusicManager)
        }
    }

    // 点击的是其他歌曲  or 点击的是正在唱的歌曲
    /*fun playPause() {
        val position = getQueuePosition()
        val musics = getQueueMusics()
        if (musics == null || musics!!.size <= 0) {
            return
        }
        // 1.还没有播放过音乐
        if (isIdle()) {
            play(position)
        } else if (isPlay()) {
            // 是否是控制器播放
            if (isController) {
                // 控制器 暂停
                pause()
            } else {
                // item 点击
                if (isPlayExist()) {
                    //context.startActivity(new Intent(context, PlayActivity.class));
                    onStartActivity.onStartActivity()
                } else {
                    play(position)
                }
            }
        } else {
            // 暂停
            if (isController) {
                start()
            } else {
                // item 点击
                if (isPlayExist()) {
                    //context.startActivity(new Intent(context, PlayActivity.class));
                    onStartActivity.onStartActivity()
                } else {
                    play(position)
                }
            }
        }
    }*/


    /**
     * 播放完成
     */
    override fun onCompletion(mediaPlayer: MediaPlayer?) {

    }

}