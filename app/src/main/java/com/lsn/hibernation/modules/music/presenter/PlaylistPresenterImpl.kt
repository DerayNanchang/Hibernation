package com.lsn.hibernation.modules.music.presenter

import com.alibaba.fastjson.JSON
import com.lsn.hibernation.base.BasePresenter
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.IBaseView
import com.lsn.hibernation.base.ModelResponseAdapter
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo
import com.lsn.hibernation.modules.music.contact.PlaylistContact
import com.lsn.hibernation.modules.music.model.PlaylistModelImpl
import io.reactivex.disposables.Disposable

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 11:37
 * Description
 */
class PlaylistPresenterImpl(view: IBaseView) : BasePresenter<IBaseView>(view),
    PlaylistContact.PlaylistPresenter {

    private val mode = PlaylistModelImpl()

    override fun getPlaylistDetail(id: String) {
        mode.getPlaylistDetail(
            id,
            object :
                ModelResponseAdapter<RawPlaylistInfo.PlaylistBean.TracksBean, RawPlaylistInfo, String>() {
                override fun onEmptyStatusResponse() {
                    super.onEmptyStatusResponse()
                    view?.onEmptyStatusResponse()
                }

                override fun onRequesting(
                    disposable: Disposable?,
                    cache: MutableList<RawPlaylistInfo.PlaylistBean.TracksBean>
                ) {
                    super.onRequesting(disposable, cache)
                    view?.onSuccess(Constant.Music.Api.GET_PLAYLIST_DETAIL, true, cache)
                }

                override fun onSuccess(key: String?, result: RawPlaylistInfo) {
                    super.onSuccess(key, result)
                    println("数据: " + JSON.toJSONString(result))
                    if (result.code == Constant.Music.NET_EASE_SUCCESS_CODE) {
                        if (result.playlist.tracks.size > 0) {
                            view?.onSuccess(
                                Constant.Music.Api.GET_PLAYLIST_DETAIL,
                                false,
                                result.playlist.tracks
                            )
                        } else {
                            view?.onEmptyStatusResponse()
                        }
                    }
                }

                override fun onFailed(exception: String?) {
                    super.onFailed(exception)
                    view?.onEmptyStatusResponse()
                }
            })
    }

}