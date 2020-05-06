package com.lsn.hibernation.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 15:08
 * Description
 */
class MusicService : Service(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //MusicManager.get.init()
        return START_REDELIVER_INTENT
    }



    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}