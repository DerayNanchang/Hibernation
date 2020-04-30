package com.lsn.hibernation.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 16:15
 * Description
 */
@Entity
public class MusicWithSinger {
    @Id(autoincrement = true)
    private Long id;
    private String StrId;
    private String sId;
    private String mId;
    @Generated(hash = 539715303)
    public MusicWithSinger(Long id, String StrId, String sId, String mId) {
        this.id = id;
        this.StrId = StrId;
        this.sId = sId;
        this.mId = mId;
    }
    @Generated(hash = 1654978453)
    public MusicWithSinger() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStrId() {
        return this.StrId;
    }
    public void setStrId(String StrId) {
        this.StrId = StrId;
    }
    public String getSId() {
        return this.sId;
    }
    public void setSId(String sId) {
        this.sId = sId;
    }
    public String getMId() {
        return this.mId;
    }
    public void setMId(String mId) {
        this.mId = mId;
    }

}
