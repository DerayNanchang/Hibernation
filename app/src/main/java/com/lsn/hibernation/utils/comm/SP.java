package com.lsn.hibernation.utils.comm;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deray on 2018/1/5.
 */

public class SP {

    private static final String CONFIG = "config";

    private Context context;

    private SP() {
    }

    private static class getInstance {
        private static SP sp = new SP();
    }

    public static SP get() {
        return getInstance.sp;
    }

    public  void init(Context context) {
        this.context = context;
    }


    private SharedPreferences getSharedPreference(Context context, String fileName) {
        return context.getSharedPreferences(fileName, 0);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference(context, CONFIG).edit();
        editor.putString(key, value).apply();
    }

    public String getString(String key, String defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context, CONFIG);
        return sharedPreference.getString(key, defValue);
    }

    public void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = getSharedPreference(context, CONFIG).edit();
        editor.putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, Boolean defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context, CONFIG);
        return sharedPreference.getBoolean(key, defValue);
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = getSharedPreference(context, CONFIG).edit();
        editor.putInt(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context, CONFIG);
        return sharedPreference.getInt(key, defValue);
    }

    public void putFloat(String fileName, String key, float value) {
        SharedPreferences.Editor editor = getSharedPreference(context, fileName).edit();
        editor.putFloat(key, value).apply();
    }

    public float getFloat(String key, Float defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context, CONFIG);
        return sharedPreference.getFloat(key, defValue);
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor editor = getSharedPreference(context, CONFIG).edit();
        editor.putLong(key, value).apply();
    }

    public long getLong(String key, long defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context, CONFIG);
        return sharedPreference.getLong(key, defValue);
    }

    public List<String> getStrListValue(String key) {
        ArrayList strList = new ArrayList();
        int size = getInt(key + "size", 0);

        for (int i = 0; i < size; ++i) {
            strList.add(getString(key + i, null));
        }
        return strList;
    }


    public void putStrListValue(String key, List<String> strList) {
        if (null != strList) {
            removeStrList(key);
            int size = strList.size();
            putInt(key + "size", size);

            for (int i = 0; i < size; ++i) {
                putString(key + i, strList.get(i));
            }

        }
    }

    public void removeStrList(String key) {
        int size = getInt(key + "size", 0);
        if (0 != size) {
            remove(key + "size");

            for (int i = 0; i < size; ++i) {
                remove(key + i);
            }

        }
    }

    public void remove(String key) {
        SharedPreferences.Editor editor = getSharedPreference(context, CONFIG).edit();
        editor.remove(key).apply();
    }

}
