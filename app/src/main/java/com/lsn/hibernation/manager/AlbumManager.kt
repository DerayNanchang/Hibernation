package com.lsn.hibernation.manager

import com.lsn.hibernation.db.bean.Album

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/5/14 14:14
 * Description
 */
class AlbumManager private constructor() {

    companion object JVM {
        val get = AlbumManager()
    }

    fun setAlbumId(ease: String): String {
        return setAlbumId(ease, "0")
    }

    fun setAlbumId(ease: String, qq: String): String {
        return ease + "_" + qq
    }


    fun insert(album: Album) {
        DBManager.get.getAlbumDao().insertOrReplace(album)
    }

    fun insert(album: List<Album>) {
        album.forEach {
            DBManager.get.getAlbumDao().insertOrReplace(it)
        }
    }
}