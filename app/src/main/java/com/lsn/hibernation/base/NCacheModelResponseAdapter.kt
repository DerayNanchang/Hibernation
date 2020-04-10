package com.lsn.hibernation.base

import com.lsn.hibernation.base.NCacheModelResponse


/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/18
 * Description
 */

abstract  class NCacheModelResponseAdapter<RESULT, EXCEPTION> :
    NCacheModelResponse<RESULT, EXCEPTION> {
    override fun onSuccess(result: RESULT?) {

    }

    override fun onFailed(exception: EXCEPTION?) {
       // Toast.show("网络异常 ... ")
    }
}