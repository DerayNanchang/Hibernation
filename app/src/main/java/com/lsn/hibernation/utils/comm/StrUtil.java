package com.lsn.hibernation.utils.comm;

import android.text.format.DateUtils;

import java.util.Locale;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/5/20 10:15
 * Description
 */
public class StrUtil {

    public static String formatTime(String pattern, long milli) {
        int m = (int) (milli / DateUtils.MINUTE_IN_MILLIS);
        int s = (int) ((milli / DateUtils.SECOND_IN_MILLIS) % 60);
        String mm = String.format(Locale.getDefault(), "%02d", m);
        String ss = String.format(Locale.getDefault(), "%02d", s);
        String replace = pattern.replace("mm", mm).replace("ss", ss);
        if (replace.contains("-")) {
            return "00:00";
        } else {

            return replace;
        }
    }
}
