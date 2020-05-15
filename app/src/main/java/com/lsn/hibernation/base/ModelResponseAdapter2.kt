package com.lsn.hibernation.base
import io.reactivex.disposables.Disposable

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/22
 * Description  这里可以做很多关于网络请求的事情
 */
open class ModelResponseAdapter2<CACHE, RESULT, EXCEPTION> :
    ModelResponse2<CACHE, RESULT, EXCEPTION> {
    override fun onEmptyStatusResponse() {

    }

    override fun onRequesting(disposable: Disposable?, cache: CACHE) {

    }

    override fun onSuccess(key: String?, result: RESULT) {
    }

    override fun onFailed(exception: EXCEPTION?) {
    }

}