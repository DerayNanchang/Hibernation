package com.lsn.hibernation.modules.music.model

import com.lsn.hibernation.base.BaseModel
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.ModelResponseAdapter2
import com.lsn.hibernation.db.bean.Playlist
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
        response: ModelResponseAdapter2<Playlist, RawPlaylistInfo, String>
    ) {

        val parameters = HashMap<String, String>()
        parameters["id"] = id
        val cacheKey =
            getCacheKeyGet(Constant.Music.Api.GET_PLAYLIST_DETAIL, parameters)

        HttpManager.request().get(Api::class.java, HttpManager.Tag.NET_EASE)
            .getPlaylistDetail(id)
            .compose(ThreadHelp.toMain())
            .subscribe(object :
                XObserverAdapter<Playlist, RawPlaylistInfo>(cacheKey) {
                override fun onEmptyStatusResponse() {
                    super.onEmptyStatusResponse()
                    response.onEmptyStatusResponse()
                }

                override fun onRequesting(
                    d: Disposable?,
                    cache: Playlist
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
                    response.onFailed(e.message)
                }
            })

    }


}