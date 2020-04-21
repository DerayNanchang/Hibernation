package com.lsn.hibernation.base;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 17:11
 * Description
 */
public interface IBaseView {

    String msg(int msg);

    void onEmptyStatusResponse();

    void onEmptyStatusResponse(String tag,String msg);

    void onSuccess(String tag,Object entity);

    void onSuccess(String tag,boolean isCache,Object entity);

    void onFailed();

}
