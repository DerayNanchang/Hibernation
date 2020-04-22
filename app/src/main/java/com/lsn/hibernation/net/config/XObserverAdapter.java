package com.lsn.hibernation.net.config;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/22 15:58
 * Description
 */
public class XObserverAdapter<CACHE, ENTITY> extends XObserver<CACHE,ENTITY> {

    public XObserverAdapter(String key) {
        super(key);
    }

    @Override
    protected void onEmptyStatusResponse() {

    }

    @Override
    protected void onRequesting(Disposable d, List<CACHE> cache) {

    }

    @Override
    protected void onRequesting(Disposable d, CACHE cache) {

    }

    @Override
    protected void onSuccess(String key, ENTITY entity) {

    }

    @Override
    protected void onFailed(Throwable e) {

    }
}
