package com.lsn.hibernation.utils.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.lsn.hibernation.R;

/**
 * Created by Chris on 2018/3/29.
 */

public class GlideUtils {

    public static void defaultBanner(ImageView imageView, String url) {
        baseLoadImg2(imageView, R.mipmap.ic_default_banner, url);
    }

    public static void defaultRounded(ImageView imageView, String url) {
        baseLoadImg(imageView, R.mipmap.ic_music_default, url);
    }

    public static void defaultRounded4(ImageView imageView, String url) {
        baseLoadImg(imageView, R.mipmap.ic_music_default, url);
    }

    private static void baseLoadImg(ImageView imageView, int defaultImg, String url) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(imageView.getDrawable())
                .skipMemoryCache(false)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .dontAnimate()
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.transform(new CenterCrop(), new RoundedCorners(7)))
                .into(imageView);
    }

    private static void baseLoadImg2(ImageView imageView, int defaultImg, String url) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView.getContext())
                .load(url)
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.transform(new CenterCrop(), new RoundedCorners(10)))
                .into(imageView);
    }

    public static void defaultCircular(ImageView imageView, String url) {
        circular(imageView, url, R.mipmap.ic_music_default);
    }

    public static void defaultCircular(ImageView imageView, int url) {
        circular(imageView, url, R.mipmap.ic_music_default);
    }


    public static void circular(ImageView imageView, String url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .apply(requestOptions.dontAnimate().centerCrop())
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.skipMemoryCache(false))
                .circleCrop()
//                .apply(requestOptions.transform(new GlideCircleTransform()))
                .into(imageView);
    }

    public static void circular(ImageView imageView, int url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .apply(requestOptions.dontAnimate().centerCrop())
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.skipMemoryCache(false))
                .circleCrop()
//                .apply(requestOptions.transform(new GlideCircleTransform()))
                .into(imageView);
    }


    public static void clear(final Context context) {
        Glide.get(context).clearMemory();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(context).clearDiskCache();
            }
        }).start();

    }
}
