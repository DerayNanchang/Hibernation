package com.lsn.hibernation.utils.comm

import android.content.Context
import android.graphics.Point
import android.view.View
import android.view.ViewGroup

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2018/11/20
 * Description  View 相关
 */
object DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun dip2pxF(context: Context, dpValue: Float): Float {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f)
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context, dpValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun dip2pxF(context: Context, dpValue: Int): Float {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f)
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun px2dipF(context: Context, pxValue: Float): Float {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f)
    }


    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity;
        return (pxValue / fontScale + 0.5f).toInt();
    }

    fun px2spF(context: Context, pxValue: Float): Float {
        val fontScale = context.resources.displayMetrics.scaledDensity;
        return (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    fun sp2px(context: Context, spValue: Float): Int {
        var fontScale = context.resources.displayMetrics.scaledDensity;
        return (spValue * fontScale + 0.5f).toInt();
    }

    fun sp2pxF(context: Context, spValue: Float): Float {
        var fontScale = context.resources.displayMetrics.scaledDensity;
        return (spValue * fontScale + 0.5f)
    }

    /**
     * 设置某个View的margin
     *
     * @param view   需要设置的view
     * @param isDp   需要设置的数值是否为DP
     * @param left   左边距
     * @param right  右边距
     * @param top    上边距
     * @param bottom 下边距
     * @return
     */
    fun setViewMargin(
        view: View?,
        isDp: Boolean,
        left: Int,
        right: Int,
        top: Int,
        bottom: Int
    ): ViewGroup.LayoutParams? {
        if (view == null) {
            return null
        }

        var leftPx = left
        var rightPx = right
        var topPx = top
        var bottomPx = bottom
        val params = view.layoutParams
        val marginParams: ViewGroup.MarginLayoutParams
        //获取view的margin设置参数
        if (params is ViewGroup.MarginLayoutParams) {
            marginParams = params
        } else {
            //不存在时创建一个新的参数
            marginParams = ViewGroup.MarginLayoutParams(params)
        }

        //根据DP与PX转换计算值
        if (isDp) {
            leftPx = dip2px(view.context, left.toFloat())
            rightPx = dip2px(view.context, right.toFloat())
            topPx = dip2px(view.context, top.toFloat())
            bottomPx = dip2px(view.context, bottom.toFloat())
        }
        //设置margin
        marginParams.setMargins(leftPx, topPx, rightPx, bottomPx)
        view.layoutParams = marginParams
        view.requestLayout()
        return marginParams
    }


    fun getStatusBarHeight(context: Context): Int {
        val resources = context.resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }


    /**
     * 获取屏幕宽高，单位px
     *
     * @param context
     * @return
     */
    fun getScreenMetrics(context: Context): Point {
        val dm = context.resources.displayMetrics
        val screenWidth = dm.widthPixels
        val screenHeight = dm.heightPixels
        return Point(screenWidth, screenHeight)
    }
}