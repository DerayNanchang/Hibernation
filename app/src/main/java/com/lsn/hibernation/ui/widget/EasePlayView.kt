package com.lsn.hibernation.ui.widget

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import com.lsn.hibernation.R
import com.lsn.hibernation.utils.glide.GlideUtils

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/5/19 15:14
 * Description
 */
class EasePlayView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var animSet: AnimatorSet? = AnimatorSet()
    private var interpolator = LinearInterpolator()

    init {
        initEasePlay()
    }

    private fun initEasePlay() {
        val inflate = LayoutInflater.from(context).inflate(R.layout.view_ease_play, null, false)
        val ivAlbumIcon = inflate.findViewById<ImageView>(R.id.ivAlbumIcon)
        GlideUtils.defaultCircular(ivAlbumIcon, R.mipmap.ic_music_default)
        var rotate = ObjectAnimator.ofFloat(ivAlbumIcon, "rotation", 0f, 360f)
        rotate.repeatMode = ValueAnimator.RESTART
        rotate.repeatCount = -1
        animSet?.interpolator = interpolator
        animSet?.play(rotate)
        animSet?.duration = 25000
        animSet?.start()
        inflate.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        val params = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        params.addRule(CENTER_IN_PARENT)
        addView(inflate, params)
    }


}