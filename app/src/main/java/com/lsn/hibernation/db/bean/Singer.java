package com.lsn.hibernation.db.bean;

import com.lsn.hibernation.db.dao.DaoSession;
import com.lsn.hibernation.db.dao.MusicDao;
import com.lsn.hibernation.db.dao.SingerDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 15:46
 * Description
 */
@Entity
public class Singer {
    @Id
    private String id;
    private String netId;
    private String QQId;
    private String name;
    private String musicId;
    @Generated(hash = 817266405)
    public Singer(String id, String netId, String QQId, String name,
            String musicId) {
        this.id = id;
        this.netId = netId;
        this.QQId = QQId;
        this.name = name;
        this.musicId = musicId;
    }
    @Generated(hash = 242898301)
    public Singer() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNetId() {
        return this.netId;
    }
    public void setNetId(String netId) {
        this.netId = netId;
    }
    public String getQQId() {
        return this.QQId;
    }
    public void setQQId(String QQId) {
        this.QQId = QQId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMusicId() {
        return this.musicId;
    }
    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
}
