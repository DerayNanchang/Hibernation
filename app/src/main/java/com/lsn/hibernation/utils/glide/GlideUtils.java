package com.lsn.hibernation.utils.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.lsn.hibernation.R;

import java.io.File;

/**
 * Created by Chris on 2018/3/29.
 */

public class GlideUtils {


    public static void local(ImageView imageView, int url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(requestOptions.placeholder(defaultImg))
                .apply(requestOptions.error(defaultImg))
                .into(imageView);
    }


    public static void local(ImageView imageView, int url) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

    public static void local(ImageView imageView, String url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.override(300, 230))
                //.apply(requestOptions.centerCrop())
                .apply(requestOptions.transform(new GlideRoundTransform(6)))
                .into(imageView);
    }


    public static void baseMusicState2(ImageView imageView, String url, int def) {
        imageView.setTag("");
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView.getContext())
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(requestOptions.error(def))
                .apply(requestOptions.transform(new GlideRoundTransform(6)))
                .into(imageView);
    }


    public static void noDefault(ImageView imageView, String url) {
        Glide.with(imageView)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .into(imageView);
    }


    public static void baseMusicState(Context context, ImageView imageView, String url, int def) {
        imageView.setTag("");
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(context)
                .load(url)
                .apply(requestOptions.error(def))
                .apply(requestOptions.skipMemoryCache(false))
                .apply(requestOptions.transform(new GlideRoundTransform(6)))
                .apply(requestOptions.dontAnimate())
                .into(imageView);
    }

    public static void baseMusicState(ImageView imageView, String url, int def) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView.getContext())
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(requestOptions.error(def))
                .apply(requestOptions.transform(new GlideRoundTransform(6)))
                .into(imageView);
    }

 /*   public static void baseMusicState(ImageView imageView, String url) {
        baseLoadImg(imageView, url);
    }*/


    public static void defaultBanner(ImageView imageView, String url) {
        baseLoadImg(imageView,R.mipmap.ic_default_banner, url);
    }

    private static void baseLoadImg(ImageView imageView,int defaultImg, String url) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(imageView.getDrawable())
                .skipMemoryCache(false)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .dontAnimate()
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.transform(new GlideRoundTransform(7)))
                .into(imageView);
    }


    public static void baseMusicState(ImageView imageView, int url) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(imageView.getDrawable())
                .skipMemoryCache(false)
                .dontAnimate()
                .apply(requestOptions.transform(new GlideRoundTransform(7)))
                .into(imageView)
        ;
    }


    public static void simple(ImageView imageView, String url, int defaultImg) {

        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(requestOptions.placeholder(defaultImg))
                .apply(requestOptions.error(defaultImg))
                .into(imageView);
    }


    public static void setImage(ImageView imageView, int resource) {
        Glide.with(imageView)
                .load(resource)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .into(imageView);
    }

    public static void simple(ImageView imageView, File url, int defaultImg) {

        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(requestOptions.placeholder(defaultImg))
                .apply(requestOptions.error(defaultImg))
                .into(imageView);
    }

    public static void imIcon(ImageView imageView, String url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(requestOptions.placeholder(defaultImg))
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.override(96, 96))
                .into(imageView);

    }

    // 圆图
    public static void circular(ImageView imageView, String url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.placeholder(defaultImg))
                .apply(requestOptions.transform(new GlideCircleTransform()))
                .into(imageView);
    }

    // 圆图
    public static void customCircular(ImageView imageView, String url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .placeholder(imageView.getDrawable())
                .skipMemoryCache(false)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .dontAnimate()
                .apply(requestOptions.dontAnimate().centerCrop())
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.skipMemoryCache(false))
                .apply(requestOptions.transform(new GlideCircleTransform()))
                .into(imageView);
    }

    // 圆图
    public static void circular(ImageView imageView, File url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .apply(requestOptions.dontAnimate().centerCrop())
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.skipMemoryCache(false))
                .apply(requestOptions.transform(new GlideCircleTransform()))
                .into(imageView);
    }


    // 圆图
    public static void circular(ImageView imageView, int url, int defaultImg) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .apply(requestOptions.dontAnimate().centerCrop())
                .apply(requestOptions.error(defaultImg))
                .apply(requestOptions.skipMemoryCache(false))
                .apply(requestOptions.transform(new GlideCircleTransform()))
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
