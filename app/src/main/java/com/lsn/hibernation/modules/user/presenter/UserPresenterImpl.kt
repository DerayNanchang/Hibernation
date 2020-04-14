package com.lsn.hibernation.modules.user.presenter

import com.alibaba.fastjson.JSON
import com.lsn.hibernation.base.BasePresenter
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.NCacheModelResponseAdapter
import com.lsn.hibernation.modules.user.bean.LoginInfoBean
import com.lsn.hibernation.modules.user.contact.UserContact
import com.lsn.hibernation.modules.user.model.UserModelImpl
import com.lsn.hibernation.utils.comm.ELog
import com.lsn.hibernation.utils.comm.Toast

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 10:06
 * Description
 */
class UserPresenterImpl(view: UserContact.UserView) : BasePresenter<UserContact.UserView>(view),
    UserContact.UserPresenter {

    private val mode = UserModelImpl()

    override fun loginNetEase(phone: String, password: String) {
        mode.loginNetEase(
            phone,
            password,
            object : NCacheModelResponseAdapter<LoginInfoBean, String>() {
                override fun onSuccess(result: LoginInfoBean?) {
                    super.onSuccess(result)
                    ELog.i(JSON.toJSONString(result))
                    if (result?.code == Constant.Music.NET_EASE_SUCCESS_CODE) {
                        ELog.i(JSON.toJSONString(result.code))
                        view?.loginNetEaseSuccess(result)
                    } else {
                        Toast.show("登录异常")
                    }
                }

                override fun onFailed(exception: String?) {
                    super.onFailed(exception)
                    ELog.e(exception)
                    Toast.show("登录异常")
                }
            })
    }
}