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
    private Long netId;
    private Long QQId;
    private String name;
    @ToMany
    @JoinEntity(entity = MusicWithSinger.class, sourceProperty = "sId", targetProperty = "mId")
    private List<Music> musics;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 183933131)
    private transient SingerDao myDao;
    @Generated(hash = 1303122251)
    public Singer(String id, Long netId, Long QQId, String name) {
        this.id = id;
        this.netId = netId;
        this.QQId = QQId;
        this.name = name;
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
    public Long getNetId() {
        return this.netId;
    }
    public void setNetId(Long netId) {
        this.netId = netId;
    }
    public Long getQQId() {
        return this.QQId;
    }
    public void setQQId(Long QQId) {
        this.QQId = QQId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 961119388)
    public List<Music> getMusics() {
        if (musics == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MusicDao targetDao = daoSession.getMusicDao();
            List<Music> musicsNew = targetDao._querySinger_Musics(id);
            synchronized (this) {
                if (musics == null) {
                    musics = musicsNew;
                }
            }
        }
        return musics;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1369131536)
    public synchronized void resetMusics() {
        musics = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 938712516)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSingerDao() : null;
    }
}
