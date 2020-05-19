package com.lsn.hibernation.modules.music.activity

import android.media.MediaPlayer
import android.view.View
import android.view.WindowManager
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseActivity
import com.lsn.hibernation.utils.comm.StatusBarUtils
import kotlinx.android.synthetic.main.activity_play.*


/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 11:51
 * Description
 */
@LayoutResId(R.layout.activity_play)
class PlayActivity : BaseActivity(), MediaPlayer.OnCompletionListener {
    override fun onCompletion(p0: MediaPlayer?) {

    }

    override fun init() {
        initToolbar()
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

        /*llToolbar.layoutParams
        val params = llToolbar.layoutParams
        println(llToolbar.measuredHeight)
        params.height = llToolbar.measuredHeight + barHeight
        llToolbar.layoutParams = params
        llToolbar.setPadding(
            llToolbar.paddingLeft,
            llToolbar.paddingTop + barHeight,
            llToolbar.paddingRight,
            llToolbar.paddingBottom
        )*/


    }


}