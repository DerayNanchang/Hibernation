package com.lsn.hibernation.utils.glide;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by Administrator on 2018/9/20.
 */

public class GlideHelp {


    public interface OnAsBitmap {
        void asBitmap(Bitmap bitmap);
    }

    public void asBitMap(final ImageView imageView, final String url, final OnAsBitmap onAsBitmap) {
        Glide.with(imageView.getContext())
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        onAsBitmap.asBitmap(resource);
                    }
                });
        /*Glide.with(imageView.getContext())
                .asBitmap()
                .load(url)
                .into(new Target<Bitmap>() {
                    @Override
                    public void onLoadStarted(@Nullable Drawable placeholder) {
                        *//*BitmapDrawable drawable = (BitmapDrawable) placeholder;
                        if (drawable != null){
                            if (drawable.getBitmap() != null){
                                onAsBitmap.asBitmap(drawable.getBitmap());
                            }
                        }*//*
                    }

                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        Bitmap bitmap = BitmapFactory.decodeResource(imageView.getResources(), R.mipmap.icon_default);
                        onAsBitmap.asBitmap(bitmap);
                    }

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        onAsBitmap.asBitmap(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        System.out.println("onLoadCleared");
                    }

                    @Override
                    public void getSize(@NonNull SizeReadyCallback cb) {
                    }

                    @Override
                    public void removeCallback(@NonNull SizeReadyCallback cb) {
                    }

                    @Override
                    public void setRequest(@Nullable Request request) {
                    }

                    @Nullable
                    @Override
                    public Request getRequest() {
                        return null;
                    }

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onStop() {
                    }

                    @Override
                    public void onDestroy() {
                    }
                });*/
    }
}
