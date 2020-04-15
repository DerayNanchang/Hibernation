package com.lsn.hibernation.modules.music.presenter

import com.lsn.hibernation.base.BasePresenter
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.IBaseView
import com.lsn.hibernation.base.ModelResponseAdapter
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.contact.MusicContact
import com.lsn.hibernation.modules.music.model.MusicModelImpl
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
                        view?.onSuccess(Constant.Music.Api.BANNER, true, result.banners)
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