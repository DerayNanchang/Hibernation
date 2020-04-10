package com.audio.administrator.ganhuo.db.manager

import android.content.Context
import com.lsn.hibernation.db.dao.CacheDao
import com.lsn.hibernation.db.dao.DaoMaster

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/21
 * Description
 */
class DBManager private constructor() {

    private lateinit var cacheDao: CacheDao

    companion object {
        private const val DB_NAME = "Hibernation"
        val get = DBManager()
    }

    fun init(context: Context) {
        val helper = DaoMaster.DevOpenHelper(context, DB_NAME)
        val db = helper.writableDb
        val session = DaoMaster(db).newSession()
        cacheDao = session.cacheDao
    }

    fun getCacheDao() = cacheDao

}