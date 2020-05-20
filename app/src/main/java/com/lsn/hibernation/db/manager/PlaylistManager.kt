package com.lsn.hibernation.db.manager

import com.lsn.hibernation.db.bean.Playlist
import com.lsn.hibernation.db.dao.PlaylistDao
import com.lsn.hibernation.manager.DBManager
import com.lsn.hibernation.manager.SPManager

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

    fun setPlaylistId(ease: String): String {
        return setPlaylistId(ease, "0")
    }

    fun setPlaylistId(ease: String, qq: String): String {
        return ease + "_" + qq
    }

    fun insertPlaylist(playlist: Playlist) {
        getPlaylistDao().insertOrReplace(playlist)
    }

    fun insertPlaylist(playlist: List<Playlist>) {
        playlist.forEach {
            getPlaylistDao().insertOrReplace(it)
        }
    }





    fun getQueuePlaylistById(): Playlist? {
        val musicCacheId = SPManager.sp.getPlaylistQueueId()
        return getPlaylistById(musicCacheId)
    }

    fun setQueuePlaylistId(id:String){
        SPManager.sp.setPlaylistQueueId(id)
    }

    private fun setQueuePlaylistStatus(playlist: Playlist) {
        return getPlaylistDao().update(playlist)
    }

    fun setQueuePlaylistTrue(playlist: Playlist) {
        playlist.isCache = true
        setQueuePlaylistStatus(playlist)
    }

    fun setQueuePlaylistFalse(playlist: Playlist) {
        playlist.isCache = false
        setQueuePlaylistStatus(playlist)
    }


    fun getPlaylistById(id: String): Playlist? {
        return getPlaylistDao().queryBuilder().where(PlaylistDao.Properties.Id.eq(id)).build()
            .unique()
    }


    fun getPlaylistByEaseId(id: Long): Playlist? {
        return getPlaylistDao().queryBuilder().where(PlaylistDao.Properties.NetId.eq(id)).build()
            .unique()
    }

    fun getPlaylistAll(): List<Playlist>? {
        return getPlaylistDao().queryBuilder().list()
    }
}