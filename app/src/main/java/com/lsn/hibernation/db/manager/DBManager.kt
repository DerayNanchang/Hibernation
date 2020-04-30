package com.lsn.hibernation.manager

import android.content.Context
import com.lsn.hibernation.db.dao.*

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/21
 * Description
 */
class DBManager private constructor() {

    private lateinit var cacheDao: CacheDao
    private lateinit var session : DaoSession

    companion object {
        private const val DB_NAME = "Hibernation"
        val get = DBManager()
    }

    fun init(context: Context) {
        val helper = DaoMaster.DevOpenHelper(context, DB_NAME)
        val db = helper.writableDb
        session = DaoMaster(db).newSession()
        cacheDao = session.cacheDao
    }

    fun getCacheDao() :CacheDao {
       return  session.cacheDao
    }

    fun getPlaylistDao():PlaylistDao{
        return session.playlistDao
    }

    fun getMusicDao():MusicDao{
        return session.musicDao
    }

    fun getSingerDao():SingerDao{
        return session.singerDao
    }

    fun getAlbumDao():AlbumDao{
        return session.albumDao
    }

    fun getMusicWithSingerDao():MusicWithSingerDao{
        return session.musicWithSingerDao
    }

}