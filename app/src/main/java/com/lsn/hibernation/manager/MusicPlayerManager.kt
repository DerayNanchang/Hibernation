package com.lsn.hibernation.manager

import android.content.Context
import android.media.MediaPlayer
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.db.manager.PlaylistManager
import java.util.*

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
    private var playMode = Constant.Music.AUDIO_PLAY_MANAGER_ORDER
    var isController = false
    private var state = STATE.IDLE
    private val NEXT = -10
    private val PRE = -12
    private var position = 0
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
        if (playlist == null || playlist.musics != null) return

        if (isIdle()) {
            // 没有播放过
            play()
        } else if (isPlay()) {
            if (isController) {
                // 暂停
                pause()
            } else {
                if (isPlayExist()) {
                    onStartActivity?.onStartActivity()
                } else {
                    play()
                }
            }
        } else {
            if (isController) {
                start()
            } else {
                if (isPlayExist()) {
                    onStartActivity?.onStartActivity()
                } else {
                    play()
                }
            }
        }

    }

    private fun start() {
        player?.start()
        state = STATE.PLAY
    }

    private fun isPlayExist(): Boolean {
        val newMusic = MusicManager.get.getQueueMusic()
        return newMusic?.id == playMusic?.id
    }

    private fun pause() {
        player?.pause()
        state = STATE.PAUSE
    }

    /**
     *  播放
     */
    private fun play() {
        val music = MusicManager.get.getQueueMusic()
        music?.let {
            player?.apply {
                reset()
                if (it.isNet) {
                    if (it.isNet) {
                        setDataSource(it.netId)
                        prepareAsync()
                        setOnPreparedListener { media ->
                            state = STATE.PLAY
                            start()
                            playMusic = it

                            /*if (PlayActivity. != null) {
                                addTimer()
                            }*/


                        }
                    }
                }
            }
        }
    }


    override fun onCompletion(mediaPlayer: MediaPlayer?) {

    }

    fun isPlay(): Boolean {
        return state == STATE.PLAY
    }

    fun isPause(): Boolean {
        return state == STATE.PAUSE
    }

    fun isIdle(): Boolean {
        return state == STATE.IDLE
    }


    interface OnStartActivity {
        fun onStartActivity()
    }

    fun setOnStartActivityListener(onStartActivity: OnStartActivity) {
        this.onStartActivity = onStartActivity
    }

    fun setPlayMode(playMode: String) {
        this.playMode = playMode
    }

    fun getPlayMode(): String {
        return playMode
    }

    fun setSeekTo(progress: Int) {
        player?.seekTo(progress)
    }

    fun updatePlayMode() {
        val playMode = getPlayMode()
        when (playMode) {
            Constant.Music.AUDIO_PLAY_MANAGER_ORDER -> this.playMode =
                Constant.Music.AUDIO_PLAY_MANAGER_RANDOM
            Constant.Music.AUDIO_PLAY_MANAGER_RANDOM -> this.playMode =
                Constant.Music.AUDIO_PLAY_MANAGER_CIRCULATION
            Constant.Music.AUDIO_PLAY_MANAGER_CIRCULATION -> this.playMode =
                Constant.Music.AUDIO_PLAY_MANAGER_ORDER
        }
        MusicManager.get.setPlayMode(this.playMode)
    }

    fun pre() {
        val playlist = PlaylistManager.get.getQueuePlaylistById() ?: return
        if (playlist.musics == null || playlist.musics.size == 0) return

        when (playMode) {
            Constant.Music.AUDIO_PLAY_MANAGER_ORDER -> {
                position = order(PRE)
            }
            Constant.Music.AUDIO_PLAY_MANAGER_RANDOM -> {
                position = random()
            }
            Constant.Music.AUDIO_PLAY_MANAGER_CIRCULATION -> {
                position = circulation(PRE)
            }
        }
    }

    operator fun next() {
        val playlist = PlaylistManager.get.getQueuePlaylistById() ?: return
        if (playlist.musics == null || playlist.musics.size == 0) return
        when (playMode) {
            Constant.Music.AUDIO_PLAY_MANAGER_ORDER -> position = order(NEXT)
            Constant.Music.AUDIO_PLAY_MANAGER_RANDOM -> position = random()
            Constant.Music.AUDIO_PLAY_MANAGER_CIRCULATION -> position = circulation(NEXT)
        }
        play()
    }

    private fun order(tag: Int): Int {
        val playlist = PlaylistManager.get.getQueuePlaylistById()
        if (playlist != null) {
            if (playlist.musics != null && playlist.musics.size > 0) {
                var position = MusicManager.get.getQueuePosition()
                return if (tag == NEXT) {
                    if (position == playlist.musics.size - 1) {
                        position = 0
                    } else {
                        position += 1
                    }
                    position
                } else {
                    if (position == 0) {
                        position = playlist.musics.size - 1
                    } else {
                        position -= 1
                    }
                    position
                }
            } else {
                return -1
            }
        } else {
            return -1
        }
    }

    private fun random(): Int {
        val playlist = PlaylistManager.get.getQueuePlaylistById()
        return if (playlist != null) {
            if (playlist.musics != null && playlist.musics.size > 0) {
                val random = Random()
                random.nextInt(playlist.musics.size)
            } else {
                0
            }
        } else {
            0
        }
    }

    private fun circulation(tag: Int): Int {
        val position = MusicManager.get.getQueuePosition()
        return if (isController) {
            order(tag)
        } else {
            position
        }
    }


}