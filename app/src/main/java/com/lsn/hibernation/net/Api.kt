package com.lsn.hibernation.net

import com.lsn.hibernation.modules.user.bean.LoginInfoBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/13 10:25
 * Description
 */
interface Api {

    @GET("/login/cellphone")
    abstract fun loginNetEase(@Query("phone") phone: String, @Path("password") password: String): Observable<LoginInfoBean>
}