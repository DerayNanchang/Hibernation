package com.lsn.hibernation.manager

import android.text.TextUtils
import com.alibaba.fastjson.JSON
import com.lsn.hibernation.db.bean.Cache
import com.lsn.hibernation.db.dao.CacheDao

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/21
 * Description
 */
class CacheManager private constructor() {

    companion object {
        val get = CacheManager()
        private const val DAY_MILLISCOND = 24 * 60 * 60 * 1000
        private const val FOR_EVER = -1L                        // 永久
        private const val THREE_DAYS = 3 * DAY_MILLISCOND       // 3 天
        private const val Seven_Days = 7 * DAY_MILLISCOND       // 7 天
        private const val THIRTY_DAYS = 30 * DAY_MILLISCOND      // 30 天
        private const val M_180_DAYS = 180 * DAY_MILLISCOND     // 180 天
    }

    private fun getDayMilliscond() = 24 * 60 * 60 * 1000

    fun forEver(): Long {
        return FOR_EVER
    }

    fun <ENTITY> setCache(key: String, entity: ENTITY): Boolean {
        println("储存的数据的类型 : " + (entity is List<*>))


        val cache = Cache(
            key,
            JSON.toJSONString(entity),
            (entity is List<*>),
            System.currentTimeMillis(),
            FOR_EVER
        )
        val cacheJSON = getCacheStr(key)
        // 返回是否插入了，前台凭这个判断是否需要更新数据
        return if (!TextUtils.isEmpty(cacheJSON)) {
            if (cacheJSON == cache.jsonEntity) {
                //如果两次的数据一致，说明没有数据更新，就不插入了，也不刷新页面了
                false
            } else {
                // 数据不一致,就更新插入数据
                DBManager.get.getCacheDao().insertOrReplace(cache)
                true
            }
        } else {
            // 第一次插入
            DBManager.get.getCacheDao().insertOrReplace(cache)
            true
        }
    }

    private fun getCache(key: String): Cache? {


        return DBManager.get.getCacheDao().queryBuilder().where(CacheDao.Properties.Key.eq(key))
            .build().unique()

    }

    fun getCacheStr(key: String): String {
        val cache = getCache(key)
        return if (cache != null) {
            // 有缓存
            cache.jsonEntity
        } else {
            // 无缓存
            ""
        }
        return ""
    }

    fun isList(key: String): Boolean {
        val cache = getCache(key)
        if (cache != null) {
            return cache.isList
        } else {
            return false
        }
    }
}