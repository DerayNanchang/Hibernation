package com.lsn.hibernation.modules.user.contact

import com.lsn.hibernation.base.NCacheModelResponseAdapter
import com.lsn.hibernation.modules.user.bean.LoginInfoBean
import io.reactivex.disposables.Disposable

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/13 11:05
 * Description
 */
interface UserContact {

    interface UserPresenter {
        fun loginNetEase(phone: String, password: String)
    }

    interface UserModel{
        fun loginNetEase(phone: String,password: String , response : NCacheModelResponseAdapter<LoginInfoBean,String>) : Disposable
    }

}