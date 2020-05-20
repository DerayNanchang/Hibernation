package com.lsn.hibernation.manager

import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.db.dao.MusicDao
import com.lsn.hibernation.db.manager.PlaylistManager
import com.lsn.hibernation.utils.comm.StrUtil

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 15:10
 * Description
 */
class MusicManager private constructor() {

    companion object JVM {
        val get = MusicManager()
    }


    fun setMusicId(ease: String): String {
        return setMusicId(ease, "0")
    }

    fun setMusicId(ease: String, qq: String): String {
        return ease + "_" + qq
    }

    fun insert(music: Music) {
        getMusicDao().insertOrReplace(music)
    }

    fun insert(music: List<Music>) {
        music.forEach {
            getMusicDao().insertOrReplace(it)
        }
    }

    fun getEaseNetUrl(easeId: String): String {
        return Constant.Music.DEFAULT_NET_PLAYER + easeId + ".mp3"
    }

    fun getMusicById(id: String): Music {
        return getMusicDao().queryBuilder().where(MusicDao.Properties.Id.eq(id)).build()
            .unique()
    }

    private fun getMusicDao(): MusicDao {
        return DBManager.get.getMusicDao()
    }


    fun setPlayMode(mode: String) {
        SPManager.sp.setPlayMode(mode)
    }

    fun getPlayMode(): String {
        return SPManager.sp.getPlayMode()
    }

    fun getDurationStr(duration: Long): String {
        return StrUtil.formatTime("mm:ss", duration)
    }


    fun getQueuePosition(): Int {
        return SPManager.sp.getQueuePosition()
    }

    fun setQueuePosition(position: Int) {
        return SPManager.sp.setQueuePosition(position)
    }

    fun getQueueMusic(): Music? {
        val playlist = PlaylistManager.get.getQueuePlaylistById()
        val position = getQueuePosition()
        if (playlist != null) {
            if (playlist.musics != null && playlist.musics.size > 0) {
                return playlist.musics[position]
            }else{
                return null
            }
        } else {
            return null
        }
    }

}