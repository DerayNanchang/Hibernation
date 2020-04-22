package com.lsn.hibernation.net.bean;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/22 9:52
 * Description
 */
public abstract class BaseEaseEntity extends BaseEntity {
    private boolean more;

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }
}
