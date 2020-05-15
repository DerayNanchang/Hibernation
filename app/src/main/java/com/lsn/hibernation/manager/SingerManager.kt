package com.lsn.hibernation.manager

import com.lsn.hibernation.db.bean.Singer

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/5/7 15:57
 * Description
 */
class SingerManager private constructor() {
    companion object JVM {
        val get = SingerManager()
    }

    fun setSingerId(ease: String): String {
        return setSingerId(ease, "0")
    }

    fun setSingerId(ease: String, qq: String): String {
        return ease.toString() + "_" + qq.toString()
    }

    fun insert(singer: Singer) {
        DBManager.get.getSingerDao().insertOrReplace(singer)
    }

    fun insert(singers: List<Singer>) {
        singers.forEach {
            DBManager.get.getSingerDao().insertOrReplace(it)
        }
    }
}