package com.lsn.hibernation.modules.music.model

import com.lsn.hibernation.base.BaseModel
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.ModelResponseAdapter
import com.lsn.hibernation.manager.HttpManager
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist
import com.lsn.hibernation.modules.music.contact.MusicContact
import com.lsn.hibernation.net.Api
import com.lsn.hibernation.net.bean.RespEntity
import com.lsn.hibernation.net.config.ThreadHelp
import com.lsn.hibernation.net.config.XObserver
import io.reactivex.disposables.Disposable

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 11:57
 * Description
 */
class MusicModelImpl : BaseModel(), MusicContact.MusicModel {

    override fun getBanner(
        type: Int,
        response: ModelResponseAdapter<Banner.BannersBean, Banner, String>
    ) {
        val parameters = HashMap<String, String>()
        parameters["type"] = type.toString()
        val cacheKey =
            getCacheKeyGet(Constant.Music.Api.BANNER, parameters)

        HttpManager.request().get(Api::class.java, HttpManager.Tag.NET_EASE)
            .getBanner(type)
            .compose(ThreadHelp.toMain())
            .subscribe(object : XObserver<Banner.BannersBean, Banner>(cacheKey) {
                override fun onEmptyStatusResponse() {
                    response.onEmptyStatusResponse()
                }

                override fun onRequesting(d: Disposable?, cache: MutableList<Banner.BannersBean>) {
                    response.onRequesting(d, cache)
                }

                override fun onSuccess(key: String, entity: Banner) {
                    response.onSuccess(key, entity)
                }

                override fun onFailed(e: Throwable) {
                    response.onFailed(e.message)
                }
            })
    }

    override fun getPlaylist(
        uid: Int,
        response: ModelResponseAdapter<EasePlaylist, RespEntity<List<EasePlaylist>>, String>
    ) {
        val parameters = HashMap<String, String>()
        parameters["uid"] = uid.toString()
        val cacheKey =
            getCacheKeyGet(Constant.Music.Api.PLAYLIST, parameters)


        HttpManager.request().get(Api::class.java, HttpManager.Tag.NET_EASE)
            .getPlaylist(uid)
            .compose(ThreadHelp.toMain())
            .subscribe(object : XObserver<EasePlaylist, RespEntity<List<EasePlaylist>>>(cacheKey) {
                override fun onEmptyStatusResponse() {
                    response.onEmptyStatusResponse()
                }

                override fun onRequesting(d: Disposable?, cache: MutableList<EasePlaylist>) {
                    response.onRequesting(d, cache)
                }

                override fun onSuccess(key: String, entity: RespEntity<List<EasePlaylist>>) {
                    response.onSuccess(key, entity)
                }

                override fun onFailed(e: Throwable) {
                    response.onFailed(e.message)
                }

            })
    }

}