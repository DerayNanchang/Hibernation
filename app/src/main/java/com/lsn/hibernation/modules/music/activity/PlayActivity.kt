package com.lsn.hibernation.modules.music.activity

import android.graphics.Bitmap
import android.media.MediaPlayer
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.widget.SeekBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseActivity
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.db.manager.PlaylistManager
import com.lsn.hibernation.manager.MusicManager
import com.lsn.hibernation.manager.MusicPlayerManager
import com.lsn.hibernation.ui.adapter.SeekBarListener
import com.lsn.hibernation.ui.anima.AnimaUtils
import com.lsn.hibernation.utils.comm.StatusBarUtils
import com.lsn.hibernation.utils.comm.StrUtil
import com.zhouwei.blurlibrary.EasyBlur
import kotlinx.android.synthetic.main.activity_play.*


/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 11:51
 * Description
 */
@LayoutResId(R.layout.activity_play)
open class PlayActivity : BaseActivity(), MediaPlayer.OnCompletionListener {

    var position = 0

    /*object var handler = Handler(object :Handler.Callback{
        override fun handleMessage(msg: Message): Boolean {
            if (seekBar != null){
                val bundle = msg.data
                val progress = bundle.getInt(Constant.Music.PLAY_ACTIVITY_KEY_MUSIC_PROGRESS)
                val duration = bundle.getInt(Constant.Music.PLAY_ACTIVITY_KEY_MUSIC_DURATION)
                seekBar.max = duration
                seekBar.progress = progress
                return true
            }else{
                return false
            }
        }
    })*/



    /*open var handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            // 获取实时进度

        }
    }*/

    override fun init() {
        initView()
        initData()
        initEvent()
    }

    private fun initEvent() {

        seekBar.setOnSeekBarChangeListener(object : SeekBarListener() {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                super.onProgressChanged(seekBar, progress, fromUser)
                tvPlayProgress.text = StrUtil.formatTime("mm:ss", progress.toLong())
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                super.onStopTrackingTouch(seekBar)
                seekBar?.let {
                    MusicPlayerManager.get.setSeekTo(it.progress)
                }
            }
        })

        ivPlayMode.setOnClickListener {
            val manager = MusicPlayerManager.get
            manager.updatePlayMode()
            when (manager.getPlayMode()) {
                Constant.Music.AUDIO_PLAY_MANAGER_ORDER -> ivPlayMode.setImageResource(com.lsn.hibernation.R.drawable.svg_order)
                Constant.Music.AUDIO_PLAY_MANAGER_RANDOM -> ivPlayMode.setImageResource(com.lsn.hibernation.R.drawable.svg_random)
                Constant.Music.AUDIO_PLAY_MANAGER_CIRCULATION -> ivPlayMode.setImageResource(
                    R.drawable.svg_circulation
                )
            }
        }

        ivPre.setOnClickListener {
            pre(true)
        }

        ivNext.setOnClickListener {
            next(true)
        }

        ivPlay.setOnClickListener {
            val manager = MusicPlayerManager.get
            if (manager.isPlay()) {
                ivPlay.setImageResource(R.drawable.svg_pause_3)
            } else {
                ivPlay.setImageResource(R.drawable.svg_play_3)
            }
            manager.isController = true
            manager.playPause()
        }
    }

    private fun pre(controller: Boolean) {
        val manager = MusicPlayerManager.get
        manager.isController = controller
        manager.pre()
        setBGP()
    }

    private fun next(controller: Boolean) {
        val manager = MusicPlayerManager.get
        manager.isController = controller
        manager.next()
        setBGP()
    }


    private fun setBGP() {
        val playlist = PlaylistManager.get.getQueuePlaylistById()
        val queuePosition = MusicManager.get.getQueuePosition()
        val musics = playlist?.musics
        val music = musics?.get(queuePosition)

        Glide.with(this)
            .asBitmap()
            .load(music?.album?.url)
            .centerCrop()
            .override(150, 150)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    val blur = EasyBlur.with(this@PlayActivity)
                        .bitmap(resource)
                        .scale(4)
                        .radius(10)
                        .blur()
                    ivBGP.setImageBitmap(blur)
                    val animation = AlphaAnimation(0.0f, 1.0f)
                    animation.duration = 3000    //深浅动画持续时间
                    animation.fillAfter = true   //动画结束时保持结束的画面
                    ivBGP.animation = AnimaUtils.alpha(0.0f, 1.0f)
                }
            })
    }


    private fun initData() {
        val musicManager = MusicManager.get
        val playMode = musicManager.getPlayMode()
        val music = musicManager.getQueueMusic()
        position = getMPosition()
        MusicPlayerManager.get.setPlayMode(playMode)
        if (music != null) {
            tvMusicName.text = music.name
            if (music.singers != null && music.singers.size > 0) {
                tvSinger.text = music.singers[0].name
            }
            tvPlayDuration.text = musicManager.getDurationStr(music.duration)
            seekBar.max = music.duration.toInt()
            if (MusicPlayerManager.get.isPlay()) {
                ivPlay.setImageResource(R.drawable.svg_play_3)
            } else {
                ivPlay.setImageResource(R.drawable.svg_pause_3)
            }
        }

        when (playMode) {
            Constant.Music.AUDIO_PLAY_MANAGER_ORDER -> {
                ivPlayMode.setImageResource(R.drawable.svg_order)
            }
            Constant.Music.AUDIO_PLAY_MANAGER_RANDOM -> {
                ivPlayMode.setImageResource(R.drawable.svg_random)
            }
            Constant.Music.AUDIO_PLAY_MANAGER_CIRCULATION -> {
                ivPlayMode.setImageResource(R.drawable.svg_circulation)
            }
        }


    }

    private fun initView() {
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        initToolbar()
    }

    override fun onCompletion(media: MediaPlayer?) {

    }

    fun getMPosition(): Int {
        position = MusicManager.get.getQueuePosition()
        position += 1
        return position
    }


    private fun initToolbar() {
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        val barHeight = StatusBarUtils.getStatusBarHeight(this)
        llToolbar.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val toolbarParams = llToolbar.layoutParams
        toolbarParams.height += barHeight
        llToolbar.setPadding(
            llToolbar.paddingLeft,
            llToolbar.paddingTop + barHeight,
            llToolbar.paddingRight,
            llToolbar.paddingBottom
        )
    }


}