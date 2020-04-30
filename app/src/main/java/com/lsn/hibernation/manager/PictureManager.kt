package com.lsn.hibernation.manager

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.lsn.hibernation.ui.`interface`.PictureAsBitmap

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 13:40
 * Description
 */
class PictureManager private constructor() {
    companion object JVM {
        val get = PictureManager()
    }

    fun netPicture2Bitmap(context: Context, url: String, listener: PictureAsBitmap) {


        Glide.with(context).asBitmap().load(url)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    resource?.let {
                        listener.onSuccess(it)
                    }
                    return false
                }
            })
    }
}