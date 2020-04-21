package com.lsn.hibernation.modules.music.presenter

import com.lsn.hibernation.base.BasePresenter
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.IBaseView
import com.lsn.hibernation.base.ModelResponseAdapter
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist
import com.lsn.hibernation.modules.music.contact.MusicContact
import com.lsn.hibernation.modules.music.model.MusicModelImpl
import com.lsn.hibernation.net.bean.RespEntity
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

    override fun getPlaylist(uid: Int) {
        mode.getPlaylist(uid,object :ModelResponseAdapter<EasePlaylist,RespEntity<List<EasePlaylist>>,String>(){
            override fun onEmptyStatusResponse() {
                super.onEmptyStatusResponse()
                view?.onEmptyStatusResponse()
            }
            override fun onRequesting(disposable: Disposable?, cache: MutableList<EasePlaylist>) {
                super.onRequesting(disposable, cache)
                view?.onSuccess(Constant.Music.Api.PLAYLIST,true,cache)
            }
            override fun onSuccess(key: String?, result: RespEntity<List<EasePlaylist>>) {
                super.onSuccess(key, result)
                if (result.code == Constant.Conn.EASE_CODE){
                    if (result.payload.isNotEmpty()){
                        view?.onSuccess(Constant.Music.Api.PLAYLIST,false,result.payload)
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