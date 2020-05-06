package com.lsn.hibernation.db.manager

import com.lsn.hibernation.db.dao.PlaylistDao
import com.lsn.hibernation.manager.DBManager

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 17:33
 * Description
 */
class PlaylistManager private constructor() {

    companion object JVM {
        val get = PlaylistManager()
    }

    private fun getPlaylistDao(): PlaylistDao {
        return DBManager.get.getPlaylistDao()
    }

    fun setPlaylistId(ease: Long): String {
        return ease.toString()
    }

    fun setPlaylistId(ease: String, qq: String): String {
        return ease + "_" + qq
    }


    /*fun getPlaylistById(id:String){
        getPlaylistDao().queryBuilder().where(PlaylistDao.Properties.Id.eq(id)).build().unique()
    }*/


}