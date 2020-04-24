package com.lsn.hibernation.net

import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo
import com.lsn.hibernation.modules.user.bean.LoginInfoBean
import com.lsn.hibernation.net.bean.EaseEntity
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


    // 获取用户歌单
    @GET(Constant.Music.Api.PLAYLIST)
    fun getPlaylist(@Query("uid") uid: Int): Observable<EaseEntity>


    // 获取歌单详情 歌单ID
    @GET(Constant.Music.Api.GET_PLAYLIST_DETAIL)
    fun getPlaylistDetail(@Query("id") id: String): Observable<RawPlaylistInfo>
}