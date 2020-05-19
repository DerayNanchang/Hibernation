package com.lsn.hibernation.manager

import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.db.dao.MusicDao

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

    fun getQueueMusicById(): Music? {
        val musicCacheId = SPManager.sp.getMusicQueueId()
        return getMusicById(musicCacheId)
    }

    fun getMusicById(id: String): Music {
        return getMusicDao().queryBuilder().where(MusicDao.Properties.Id.eq(id)).build()
            .unique()
    }

    private fun getMusicDao(): MusicDao {
        return DBManager.get.getMusicDao()
    }

    fun setQueueMusic(music: Music) {
        SPManager.sp.setMusicQueueId(music.id)
    }

}