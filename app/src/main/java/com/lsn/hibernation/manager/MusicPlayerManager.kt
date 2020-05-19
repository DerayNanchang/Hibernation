package com.lsn.hibernation.manager

import android.content.Context
import android.media.MediaPlayer
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.db.manager.PlaylistManager

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/5/19 10:09
 * Description
 */
class MusicPlayerManager private constructor() : MediaPlayer.OnCompletionListener {

    companion object JVM {
        var get = MusicPlayerManager()
    }

    var player: MediaPlayer? = null
    var context: Context? = null
    var playMusic: Music? = null
    var isController = false
    private var state = STATE.IDLE
    private var onStartActivity: OnStartActivity? = null

    private enum class STATE {
        // 闲置，播放，暂停
        IDLE,
        PLAY,
        PAUSE
    }

    enum class PLAY_MODE {
        // 顺序，随机，循环
        ORDER,
        RANDOM,
        CIRCULATION
    }

    /**
     * 初始化参数
     */
    fun init(context: Context) {
        this.context = context
        if (player == null) {
            initPlay()
        }
    }

    private fun initPlay() {
        player = MediaPlayer()
        player?.setOnCompletionListener(this)
    }


    fun playPause() {
        val playlist = PlaylistManager.get.getQueuePlaylistById()
        val music = MusicManager.get.getQueueMusicById()
        if (playlist == null || playlist.musics != null) return
        if (playlist.musics.size == 0) return
        if (music == null) return

        if (isIdle()) {
            // 没有播放过
            play(music)
        } else if (isPlay()) {
            if (isController) {
                // 暂停
                pause()
            } else {
                if (isPlayExist()){
                    onStartActivity?.onStartActivity()
                }else{
                    play(music)
                }
            }
        }else{
            if (isController){
                start()
            }else{
                if (isPlayExist()) {
                    //context.startActivity(new Intent(context, PlayActivity.class));
                    onStartActivity?.onStartActivity()
                } else {
                    play(music)
                }
            }
        }

    }

    private fun start() {
        player?.start()
        state = STATE.PLAY
    }

    private fun isPlayExist(): Boolean {
        val newMusic = MusicManager.get.getQueueMusicById()
        return newMusic?.id == playMusic?.id
    }

    private fun pause() {
        player?.pause()
        state = STATE.PAUSE
    }

    /**
     *  播放
     */
    private fun play(music: Music?) {
        if (music == null) return
        player?.apply {
            reset()
            if (music.isNet) {
                if (music.isNet) {
                    setDataSource(music.netId)
                    prepareAsync()
                    setOnPreparedListener {
                        state = STATE.PLAY
                        start()
                        playMusic = music
                        MusicManager.get.setQueueMusic(music)
                    }
                }
            }
        }
    }


    override fun onCompletion(mediaPlayer: MediaPlayer?) {

    }

    private fun isPlay(): Boolean {
        return state == STATE.PLAY
    }

    private fun isPause(): Boolean {
        return state == STATE.PAUSE
    }

    private fun isIdle(): Boolean {
        return state == STATE.IDLE
    }


    interface OnStartActivity {
        fun onStartActivity()
    }

    fun setOnStartActivityListener(onStartActivity: OnStartActivity) {
        this.onStartActivity = onStartActivity
    }

}