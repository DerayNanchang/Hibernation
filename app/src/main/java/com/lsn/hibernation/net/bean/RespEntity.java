package com.lsn.hibernation.net.bean;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/21 16:07
 * Description
 */
public class RespEntity<T> extends BaseEntity {
    private T payload;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "RespEntity{" +
                "payload=" + payload +
                '}';
    }
}
