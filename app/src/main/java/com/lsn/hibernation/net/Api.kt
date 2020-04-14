package com.lsn.hibernation.net

import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.user.bean.LoginInfoBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/13 10:25
 * Description
 */
interface Api {

    @GET(Constant.Music.Api.CALL_PHONE)
    fun loginNetEase(@Query("phone") phone: String, @Query("password") password: String): Observable<LoginInfoBean>


    /**
     *  获取音乐Banner
     *      0: pc
     *      1: android
     *      2: iphone
     *      3: ipad
     */
    @GET(Constant.Music.Api.BANNER)
    fun getBanner(@Query("type") type: Int): Observable<Banner>
}