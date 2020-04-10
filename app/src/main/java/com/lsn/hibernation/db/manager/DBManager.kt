package com.lsn.hibernation.manager

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/21
 * Description
 */
class DBManager private constructor() {

   /* private lateinit var cacheDao: CacheDao*/

    companion object {
        private const val DB_NAME = "Hibernation"
        val get = DBManager()
    }

/*    fun init(context: Context) {
        val helper = DaoMaster.DevOpenHelper(context, DB_NAME)
        val db = helper.writableDb
        val session = DaoMaster(db).newSession()
        cacheDao = session.cacheDao
    }*/

  /*  fun getCacheDao() = cacheDao*/

}