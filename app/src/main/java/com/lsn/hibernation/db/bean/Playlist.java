package com.lsn.hibernation.db.bean;

import com.lsn.hibernation.db.dao.DaoSession;
import com.lsn.hibernation.db.dao.MusicDao;
import com.lsn.hibernation.db.dao.PlaylistDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 16:45
 * Description
 */
@Entity
public class Playlist {
    @Id
    private String id;
    private String netId;
    private String QQId;
    private String name;
    private String url;
    private boolean isCollect;
    private boolean isCache;
    private String owner;
    private String ownerName;
    private String ownerAvatar;
    private String commentId;
    private Long subscribedCount;
    private Long playCount;
    private Long musicCount;
    private Long createTime;
    private Long updateTime;
    @ToMany(referencedJoinProperty = "playlistId")
    private List<Music> musics;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1436610739)
    private transient PlaylistDao myDao;
    @Generated(hash = 1937446164)
    public Playlist(String id, String netId, String QQId, String name, String url, boolean isCollect,
            boolean isCache, String owner, String ownerName, String ownerAvatar, String commentId,
            Long subscribedCount, Long playCount, Long musicCount, Long createTime, Long updateTime) {
        this.id = id;
        this.netId = netId;
        this.QQId = QQId;
        this.name = name;
        this.url = url;
        this.isCollect = isCollect;
        this.isCache = isCache;
        this.owner = owner;
        this.ownerName = ownerName;
        this.ownerAvatar = ownerAvatar;
        this.commentId = commentId;
        this.subscribedCount = subscribedCount;
        this.playCount = playCount;
        this.musicCount = musicCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    @Generated(hash = 1160175056)
    public Playlist() {
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
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean getIsCollect() {
        return this.isCollect;
    }
    public void setIsCollect(boolean isCollect) {
        this.isCollect = isCollect;
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwnerName() {
        return this.ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getOwnerAvatar() {
        return this.ownerAvatar;
    }
    public void setOwnerAvatar(String ownerAvatar) {
        this.ownerAvatar = ownerAvatar;
    }
    public String getCommentId() {
        return this.commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public Long getSubscribedCount() {
        return this.subscribedCount;
    }
    public void setSubscribedCount(Long subscribedCount) {
        this.subscribedCount = subscribedCount;
    }
    public Long getPlayCount() {
        return this.playCount;
    }
    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }
    public Long getMusicCount() {
        return this.musicCount;
    }
    public void setMusicCount(Long musicCount) {
        this.musicCount = musicCount;
    }
    public Long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 704467930)
    public List<Music> getMusics() {
        if (musics == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MusicDao targetDao = daoSession.getMusicDao();
            List<Music> musicsNew = targetDao._queryPlaylist_Musics(id);
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
    @Generated(hash = 226526955)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlaylistDao() : null;
    }
    public boolean getIsCache() {
        return this.isCache;
    }
    public void setIsCache(boolean isCache) {
        this.isCache = isCache;
    }
}
