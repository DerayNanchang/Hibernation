package com.lsn.hibernation.annotation

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.lsn.hibernation.R
import com.lsn.hibernation.modules.music.base.BaseMusicActivity
import com.lsn.hibernation.utils.comm.DensityUtil
import com.lsn.hibernation.utils.comm.StatusBarUtils
import com.lsn.hibernation.utils.comm.UtilsStyle
import com.lsn.hibernation.utils.glide.GlideUtils

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2018/12/9
 * Description    注解逻辑处理类
 */
object YaoAnnotation {

    fun init(context: Context) {
        initView(context)
        initStatusTextColor(context)
        //initStatusColor(context)
    }


    /**
     *  setContentView() 逻辑处理
     */
    private fun initView(context: Context) {
        // 判断是否属于 Music模块 逻辑
        if (context is BaseMusicActivity) {
            // 属于 Music 模块就替换根布局，在根布局中增加一个底部控制器
            // 1. 反射拿到注解数据
            val clazz = context::class.java
            val method = clazz.getMethod("setContentView", View::class.java)
            val layoutResID = clazz.getAnnotation(LayoutResId::class.java)
            layoutResID?.let {
                // 2. 创建一个根布局,并摆放好各自的位置
                val root = RelativeLayout(context)


                // 2.1 控制器View
                val musicController = LayoutInflater.from(context)
                    .inflate(R.layout.include_play_bottom_controller, null, false)
                musicController.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
                val imageView =
                    musicController.findViewById<ImageView>(R.id.ivControllerMusicIcon)
                GlideUtils.defaultCircular(imageView, R.mipmap.ic_music_default)

                // 2.2 确认每个子View布局位置
                val musicControllerParams = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )
                musicControllerParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

                val source = LayoutInflater.from(context).inflate(layoutResID.value, null, false)
                val sourceParams = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
                )
                sourceParams.setMargins(0, 0, 0, DensityUtil.dip2px(context, 55))
                root.addView(source, sourceParams)
                root.addView(musicController, musicControllerParams)

                // 3. 写入布局
                method.invoke(context as Activity, root)
            }
        } else {
            val clazz = context::class.java
            val method = clazz.getMethod("setContentView", Int::class.java)
            val layoutResID = clazz.getAnnotation(LayoutResId::class.java)
            layoutResID?.let {
                method.invoke(context as Activity, layoutResID.value)
            }
        }
    }

    private fun initStatusTextColor(context: Context){
        val activity = context as Activity
        val clazz = activity::class.java
        val annotation = clazz.getAnnotation(StatusBarTextColor::class.java)
        if (annotation != null){
            if (annotation.value){
                UtilsStyle.statusBarLightMode(context)
            }
        }
    }

    private fun initStatusColor(context: Context) {
        val activity = context as Activity
        val clazz = activity::class.java
        val annotation = clazz.getAnnotation(StatusBarColor::class.java)
        if (annotation != null) {
            StatusBarUtils.setStatusBarColor(
                activity,
                activity.resources.getColor(annotation.value)
            )
        } else {
            // 默认设置灰色
            StatusBarUtils.setStatusBarColor(
                activity,
                activity.resources.getColor(R.color.colorAccent)
            )
        }
    }
}