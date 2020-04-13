package com.lsn.hibernation.manager;


import com.lsn.hibernation.base.Constant;
import com.lsn.hibernation.net.Api;
import com.lsn.hibernation.net.config.FastJsonConverterFactory;
import com.lsn.hibernation.net.config.TrustAllCerts;
import com.lsn.hibernation.net.interceptor.AuthorizationInterceptor;
import com.lsn.hibernation.net.interceptor.ResponseInterceptor;

import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by Chris on 2018/4/18.
 */

public class HttpManager {

    private String retrofitUrl = "";
    private final static String AIP = Api.class.getName();
    private final boolean IS_SSL = false;

    public interface Tag {
        String DEBUG = "DEBUG";
        String RELEASE = "RELEASE";
        String NET_EASE = "NET_EASE";
        String QQ = "QQ";
    }

    public interface Url {
        String DEBUG = Constant.Conn.DEBUG_URL;
        String RELEASE = Constant.Conn.RELEASE_URL;
        String NET_EASE = Constant.Conn.NET_EASE_URL;
        String QQ = Constant.Conn.QQ_URL;
    }


    public <T> T get(Class<T> clazz) {
        return get(clazz, false);
    }

    public <T> T get(Class<T> clazz, boolean isToken) {
        return get(clazz, Tag.RELEASE, isToken);
    }

    public <T> T get(Class<T> clazz, String tag) {
        return get(clazz, tag, false);
    }


    public <T> T get(Class<T> clazz, String tag, boolean isAddToken) {
        switch (tag) {
            case Tag.DEBUG:
                retrofitUrl = Url.DEBUG;
                break;
            case Tag.RELEASE:
                retrofitUrl = Url.RELEASE;
                break;
            case Tag.NET_EASE:
                retrofitUrl = Url.NET_EASE;
                break;
            case Tag.QQ:
                retrofitUrl = Url.QQ;
                break;
        }
        if (isAddToken) {
            return getBaseManager(retrofitUrl, true).create(clazz);
        } else {
            return getBaseManager(retrofitUrl, false).create(clazz);
        }
    }


    public <T> T post(Class<T> clazz) {
        return post(clazz, false);
    }

    public <T> T post(Class<T> clazz, boolean isToken) {
        return post(clazz, Tag.RELEASE, isToken);
    }

    public <T> T post(Class<T> clazz, String tag) {
        return post(clazz, tag, false);
    }


    public <T> T post(Class<T> clazz, String tag, boolean isAddToken) {
        System.out.println("tag : " + tag);
        switch (tag) {
            case Tag.DEBUG:
                retrofitUrl = Url.DEBUG;
                break;

            case Tag.RELEASE:
                retrofitUrl = Url.RELEASE;
                break;
            case Tag.NET_EASE:
                retrofitUrl = Url.NET_EASE;
                break;
            case Tag.QQ:
                retrofitUrl = Url.QQ;
                break;
        }
        if (isAddToken) {
            return getBaseManager(retrofitUrl, true).create(clazz);
        } else {
            return getBaseManager(retrofitUrl, false).create(clazz);
        }
    }

    public Retrofit getBaseManager(String baseUrl, boolean isToken) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (isToken) {
            builder.addInterceptor(new AuthorizationInterceptor());     // 添加 token
            builder.addInterceptor(new ResponseInterceptor());          // 检测 token 失效
        }
        if (IS_SSL) {
            builder.sslSocketFactory(TrustAllCerts.createSSLSocketFactory());
            builder.hostnameVerifier(new TrustAllCerts.TrustAllHostnameVerifier());
        }
        builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        OkHttpClient build = builder.build();
        return getBaseManager(baseUrl, build);
    }

    /**
     * 默认添加 token
     *
     * @param baseUrl
     * @return
     */
    private Retrofit getBaseManager(String baseUrl) {
        return getBaseManager(baseUrl, true);
    }


    private Retrofit getBaseManager(String baseUrl, OkHttpClient client) {
        return setBaseUrl(baseUrl)
                .client(client)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    private Retrofit.Builder getBaseRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    private Retrofit.Builder setBaseUrl(String baseUrl) {
        return getBaseRetrofitBuilder().baseUrl(baseUrl);
    }

    private HttpManager() {

    }


    private static class HttpManagerInstance {
        private static HttpManager manager = new HttpManager();
    }

    public static HttpManager request() {
        return HttpManagerInstance.manager;
    }


}
