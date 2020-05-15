package com.lsn.hibernation.modules.music.presenter

import com.lsn.hibernation.app.HibernationApplication
import com.lsn.hibernation.base.BasePresenter
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.IBaseView
import com.lsn.hibernation.base.ModelResponseAdapter
import com.lsn.hibernation.db.bean.Playlist
import com.lsn.hibernation.db.manager.PlaylistManager
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.contact.MusicContact
import com.lsn.hibernation.modules.music.model.MusicModelImpl
import com.lsn.hibernation.net.bean.EaseEntity
import io.reactivex.disposables.Disposable

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 11:55
 * Description
 */
class MusicPresenterImpl(view: IBaseView) :
    BasePresenter<IBaseView>(view), MusicContact.MusicPresenter {



    val mode = MusicModelImpl()
    override fun getBanner(type: Int) {
        mode.getBanner(type, object : ModelResponseAdapter<Banner.BannersBean, Banner, String>() {
            override fun onEmptyStatusResponse() {
                super.onEmptyStatusResponse()
                view?.onEmptyStatusResponse()
            }

            override fun onRequesting(
                disposable: Disposable?,
                cache: MutableList<Banner.BannersBean>
            ) {
                super.onRequesting(disposable, cache)
                view?.onSuccess(Constant.Music.Api.BANNER, true, cache)
            }

            override fun onSuccess(key: String?, result: Banner) {
                super.onSuccess(key, result)
                //view?.getBannerSuccess(result.banners, false)
                if (result.code == Constant.Music.NET_EASE_SUCCESS_CODE) {
                    if (result.banners.size > 0) {
                        view?.onSuccess(Constant.Music.Api.BANNER, false, result.banners)
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

    override fun getPlaylist(uid: Long) {
        mode.getPlaylist(uid,object :ModelResponseAdapter<Playlist,EaseEntity,String>(){
            override fun onEmptyStatusResponse() {
                super.onEmptyStatusResponse()
                view?.onEmptyStatusResponse()
            }
            override fun onRequesting(disposable: Disposable?, cache: MutableList<Playlist>) {
                super.onRequesting(disposable, cache)
                view?.onSuccess(Constant.Music.Api.PLAYLIST,true,cache)
            }
            override fun onSuccess(key: String?, result: EaseEntity) {
                super.onSuccess(key, result)
                if (result.code == Constant.Conn.EASE_CODE){
                    if (result.playlist.isNotEmpty()){
                        val list = ArrayList<Playlist>()
                        result.playlist.forEach {
                            val playlist = Playlist()
                            playlist.apply {
                                id = PlaylistManager.get.setPlaylistId(it.id)
                                netId = it.id
                                name = it.name
                                url = it.coverImgUrl
                                isCollect = it.userId != HibernationApplication.get.getUId()
                                owner = it.userId.toString()
                                ownerAvatar = it.creator.avatarUrl
                                ownerName = it.creator.nickname
                                commentId = it.commentThreadId
                                subscribedCount = it.subscribedCount
                                playCount = it.playCount
                                createTime = it.createTime
                                updateTime = it.updateTime
                            }
                            list.add(playlist)
                        }

                        view?.onSuccess(Constant.Music.Api.PLAYLIST,false,list)
                    }else{
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