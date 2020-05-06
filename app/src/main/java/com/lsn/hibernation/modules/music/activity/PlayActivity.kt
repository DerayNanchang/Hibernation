package com.lsn.hibernation.modules.music.activity

import android.media.MediaPlayer
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.modules.music.base.BaseMusicActivity
import com.lsn.hibernation.utils.comm.Toast


/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 11:51
 * Description
 */
@LayoutResId(R.layout.activity_play)
class PlayActivity : BaseMusicActivity(), MediaPlayer.OnCompletionListener {
    override fun onCompletion(p0: MediaPlayer?) {

    }

    override fun init() {
        val url = "https://music.163.com/song/media/outer/url?id=33894312.mp3"
        // 播放歌曲
        val player = MediaPlayer()
        player.setOnCompletionListener(this)

        try {
            player.reset()
            player.setDataSource(url)
            player.prepareAsync()
            player.setOnPreparedListener {
                //player.duration
                player.start()
                // 加载一个计时器 显示最新的进度
            }

        } catch (e: Exception) {
            e.printStackTrace()
            println("异常 ： " + e.message)
            Toast.show("当前歌曲无法播放")
        }


        /* val url = "https://music.163.com/song/media/outer/url?id=33894312.mp3";
        val gsyVideoOption = GSYVideoOptionBuilder()
        gsyVideoOption
            .setIsTouchWiget(true)
            .setRotateViewAuto(false)
            .setLockLand(false)
            .setAutoFullWithSize(false)
            .setShowFullAnimation(false)
            .setNeedLockFull(true)
            .setUrl(url)
            .setCacheWithPlay(false)
            .setVideoAllCallBack(object : GSYSampleCallBack() {
                override fun onPrepared(url: String?, vararg objects: Any) {
                    Debuger.printfError("***** onPrepared **** " + objects[0])
                    Debuger.printfError("***** onPrepared **** " + objects[1])
                    super.onPrepared(url, *objects)
                    //开始播放了才能旋转和全屏
                    //orientationUtils.setEnable(true)
                    //isPlay = true

                    //设置 seek 的临近帧。
                    *//*if (detailPlayer.getGSYVideoManager().getPlayer() is Exo2PlayerManager) {
                        (detailPlayer.getGSYVideoManager().getPlayer() as Exo2PlayerManager).setSeekParameter(
                            SeekParameters.NEXT_SYNC
                        )
                        Debuger.printfError("***** setSeekParameter **** ")
                    }*//*
                }

                override fun onEnterFullscreen(url: String?, vararg objects: Any) {
                    super.onEnterFullscreen(url, *objects)
                    Debuger.printfError("***** onEnterFullscreen **** " + objects[0])//title
                    Debuger.printfError("***** onEnterFullscreen **** " + objects[1])//当前全屏player
                }

                override fun onAutoComplete(url: String?, vararg objects: Any) {
                    super.onAutoComplete(url, *objects)
                }

                override fun onClickStartError(url: String?, vararg objects: Any) {
                    super.onClickStartError(url, *objects)
                }

                override fun onQuitFullscreen(url: String?, vararg objects: Any) {
                    super.onQuitFullscreen(url, *objects)
                    Debuger.printfError("***** onQuitFullscreen **** " + objects[0])//title
                    Debuger.printfError("***** onQuitFullscreen **** " + objects[1])//当前非全屏player
                    *//*if (orientationUtils != null) {
                        orientationUtils.backToProtVideo()
                    }*//*
                }
            })
            .setLockClickListener(object : LockClickListener {
                fun onClick(view: View, lock: Boolean) {
                    if (orientationUtils != null) {
                        //配合下方的onConfigurationChanged
                        orientationUtils.setEnable(!lock)
                    }
                }
            })
            .setGSYVideoProgressListener { progress, secProgress, currentPosition, duration ->
                Debuger.printfLog(
                    " progress $progress secProgress $secProgress currentPosition $currentPosition duration $duration"
                )
            }
            .build(detailPlayer)*/


        /*val blur = EasyBlur.with(this)
            .bitmap()
            .scale(4)
            .radius(10)
            .blur()*/

    }

}