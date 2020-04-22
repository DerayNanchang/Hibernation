package com.lsn.hibernation.utils.comm;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.DrawableRes;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/22 17:24
 * Description
 */
public class MVPConfig {
    public static int statusDrawable;
    public static int toolbarBackgroundColor;
    public static int toolbarBackgroundDrawable;
    public static int backDrawable;
    public static boolean isStatusBarLight;

    public static void setStatusbarDrawable(@DrawableRes int statusDraw) {
        statusDrawable = statusDraw;
    }

    public static boolean isStatusBar() {
        return statusDrawable > 0;
    }

    public static void setToolbarDrawable(int toolbarBackgroundDrawable) {
        MVPConfig.toolbarBackgroundDrawable = toolbarBackgroundDrawable;
    }

    public static void setBackDrawable(int backDrawable) {
        MVPConfig.backDrawable = backDrawable;
    }

    public static void setIsStatusBarLight(boolean isStatusBarLight) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
            MVPConfig.statusDrawable = Color.parseColor("#33ffffff");
        }
        MVPConfig.isStatusBarLight = isStatusBarLight;
    }

}
