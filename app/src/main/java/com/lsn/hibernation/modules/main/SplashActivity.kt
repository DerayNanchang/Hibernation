package com.lsn.hibernation.modules.main

import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.app.HibernationApplication
import com.lsn.hibernation.base.BaseActivity
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.modules.user.bean.LoginInfoBean
import com.lsn.hibernation.modules.user.presenter.UserPresenterImpl
import org.jetbrains.anko.startActivity

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 10:54
 * Description
 */
@LayoutResId(R.layout.activity_splash)
class SplashActivity : BaseActivity() {

    override fun init() {


        initData()

    }

    override fun onSuccess(tag: String?, isCache: Boolean, entity: Any?) {
        super.onSuccess(tag, isCache, entity)
        val loginInfoBean = entity as LoginInfoBean
        HibernationApplication.get.setLoginInfoBean(loginInfoBean)

        startActivity<MainActivity>()
    }


    private fun initData() {
        val userPresenterImpl = UserPresenterImpl(this)
        userPresenterImpl.loginNetEase(
            Constant.Music.DEFAULT_NET_EASE_USER_NAME,
            Constant.Music.DEFAULT_NET_EASE_PASSWORD
        )
    }
}