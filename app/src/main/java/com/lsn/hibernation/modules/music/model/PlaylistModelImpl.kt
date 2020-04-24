package com.lsn.hibernation.modules.music.model

import com.lsn.hibernation.base.BaseModel
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.ModelResponseAdapter
import com.lsn.hibernation.manager.HttpManager
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo
import com.lsn.hibernation.modules.music.contact.PlaylistContact
import com.lsn.hibernation.net.Api
import com.lsn.hibernation.net.config.ThreadHelp
import com.lsn.hibernation.net.config.XObserverAdapter
import io.reactivex.disposables.Disposable

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 11:40
 * Description
 */
class PlaylistModelImpl : BaseModel(), PlaylistContact.PlaylistModel {

    override fun getPlaylistDetail(
        id: String,
        response: ModelResponseAdapter<RawPlaylistInfo.PlaylistBean.TracksBean, RawPlaylistInfo, String>
    ) {

        val parameters = HashMap<String, String>()
        parameters["id"] = id
        val cacheKey =
            getCacheKeyGet(Constant.Music.Api.GET_PLAYLIST_DETAIL, parameters)

        HttpManager.request().get(Api::class.java, HttpManager.Tag.NET_EASE)
            .getPlaylistDetail(id)
            .compose(ThreadHelp.toMain())
            .subscribe(object :
                XObserverAdapter<RawPlaylistInfo.PlaylistBean.TracksBean, RawPlaylistInfo>(cacheKey) {
                override fun onEmptyStatusResponse() {
                    super.onEmptyStatusResponse()
                    response.onEmptyStatusResponse()
                }

                override fun onRequesting(
                    d: Disposable?,
                    cache: MutableList<RawPlaylistInfo.PlaylistBean.TracksBean>
                ) {
                    super.onRequesting(d, cache)
                    response.onRequesting(d, cache)
                }

                override fun onSuccess(key: String, entity: RawPlaylistInfo) {
                    super.onSuccess(key, entity)
                    response.onSuccess(key, entity)
                }

                override fun onFailed(e: Throwable) {
                    super.onFailed(e)
                    println("错误消息 : " + e.message)
                    response.onFailed(e.message)
                }
            })

    }


}