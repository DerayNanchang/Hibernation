package com.lsn.hibernation.modules.user.contact

import com.lsn.hibernation.base.NCacheModelResponseAdapter
import com.lsn.hibernation.manager.HttpManager
import com.lsn.hibernation.modules.user.bean.LoginInfoBean
import com.lsn.hibernation.net.Api
import com.lsn.hibernation.net.config.ThreadHelp
import io.reactivex.disposables.Disposable

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/13 11:18
 * Description
 */
class UserContactImpl : UserContact.userModel {
    override fun loginNetEase(phone: String, password: String, response: NCacheModelResponseAdapter<LoginInfoBean, String>): Disposable {
        return HttpManager.request().get(Api::class.java, HttpManager.Tag.NET_EASE)
            .loginNetEase(phone,password)
            .compose(ThreadHelp.toMain())
            .subscribe ({
                response.onSuccess(it)
            },{
                response.onFailed(it.message)
            })
    }

}