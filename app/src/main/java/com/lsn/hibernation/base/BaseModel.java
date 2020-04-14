package com.lsn.hibernation.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 13:33
 * Description
 */
public abstract class BaseModel {
    private StringBuffer parametersStr = new StringBuffer();

    protected enum Type {
        POST, GET;
    }


    // key 格式  基础路径 + 请求路径 + [参数=值][请求类型]
    private String getCacheKey(Type type, String baseUrl, String path, HashMap<String, String> parameters) {
        parametersStr.append(baseUrl);
        parametersStr.append(path);
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            parametersStr.append("[");
            parametersStr.append(parameter.getKey());
            parametersStr.append("=");
            parametersStr.append(parameter.getValue());
            parametersStr.append("]");
        }
        parametersStr.append("[");
        parametersStr.append(type);
        parametersStr.append("]");
        return parametersStr.toString();
    }

    protected String getCacheKey(Type type, String path, HashMap<String, String> parameters) {
        return getCacheKey(type,Constant.Conn.NET_EASE_URL,path,parameters);
    }

    protected String getCacheKeyGet(String path, HashMap<String, String> parameters) {
        return getCacheKey(Type.GET,path,parameters);
    }

    protected String getCacheKeyPost(String path, HashMap<String, String> parameters) {
        return getCacheKey(Type.POST,path,parameters);
    }
}
