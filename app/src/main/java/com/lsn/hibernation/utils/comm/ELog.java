package com.lsn.hibernation.utils.comm;

import android.util.Log;

import com.lsn.hibernation.base.Constant;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 10:21
 * Description
 */
public class ELog {
    private static final boolean isLog = Constant.Conn.IS_DEBUG;

    public static void e(String text) {
        if (isLog){
            Log.e(Constant.Conn.HT_LOG, text);
        }
    }

    public static void i(String text) {
        if (isLog){
            Log.i(Constant.Conn.HT_LOG, text);
        }
    }
}
