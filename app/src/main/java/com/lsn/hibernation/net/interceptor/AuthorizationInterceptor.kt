package com.lsn.hibernation.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2018/12/12
 * Description  Http 拦截器，用户拦截增加 请求头
 */
class AuthorizationInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        /*val original = chain.request()
        //println(" token :  "+LiteServiceApp.context.token)
        val builder = original.newBuilder()
                .header("Authorization", LiteServiceApp.context.token)  //Token
                //.header("Authorization", Constant.ToKen.FAILED_TOKEN)  // 测试失效 token，需要测试时，复制一份再添加失效 token
        val request = builder.build()
        //println("token : ${LiteServiceApp.context.token}")
        return chain.proceed(request)*/

        val chainRequest = chain.request()
        return chain.proceed(chainRequest)
    }
}