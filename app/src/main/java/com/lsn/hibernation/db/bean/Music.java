package com.lsn.hibernation.db.bean;

import com.lsn.hibernation.db.dao.AlbumDao;
import com.lsn.hibernation.db.dao.DaoSession;
import com.lsn.hibernation.db.dao.MusicDao;
import com.lsn.hibernation.db.dao.SingerDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/30 15:41
 * Description
 */
@Entity
public class Music {

    @Id
    private String id;
    private String name;
    private String netId;
    private String QQId;
    @ToMany()
    @JoinEntity(entity = MusicWithSinger.class, sourceProperty = "mId", targetProperty = "sId")
    private List<Singer> singers;
    private Long duration;
    private boolean isNet;
    private boolean isCache;
    private int type; // 网易云/QQ
    private String albumId;
    @ToOne(joinProperty = "albumId")
    private Album album;
    private String playlistId;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1255683360)
    private transient MusicDao myDao;

    @Generated(hash = 115357949)
    public Music(String id, String name, String netId, String QQId, Long duration, boolean isNet,
            boolean isCache, int type, String albumId, String playlistId) {
        this.id = id;
        this.name = name;
        this.netId = netId;
        this.QQId = QQId;
        this.duration = duration;
        this.isNet = isNet;
        this.isCache = isCache;
        this.type = type;
        this.albumId = albumId;
        this.playlistId = playlistId;
    }

    @Generated(hash = 1263212761)
    public Music() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public boolean getIsNet() {
        return this.isNet;
    }

    public void setIsNet(boolean isNet) {
        this.isNet = isNet;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPlaylistId() {
        return this.playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    @Generated(hash = 1470384725)
    private transient String album__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 494291042)
    public Album getAlbum() {
        String __key = this.albumId;
        if (album__resolvedKey == null || album__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AlbumDao targetDao = daoSession.getAlbumDao();
            Album albumNew = targetDao.load(__key);
            synchronized (this) {
                album = albumNew;
                album__resolvedKey = __key;
            }
        }
        return album;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1320471351)
    public void setAlbum(Album album) {
        synchronized (this) {
            this.album = album;
            albumId = album == null ? null : album.getId();
            album__resolvedKey = albumId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 768544581)
    public List<Singer> getSingers() {
        if (singers == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SingerDao targetDao = daoSession.getSingerDao();
            List<Singer> singersNew = targetDao._queryMusic_Singers(id);
            synchronized (this) {
                if (singers == null) {
                    singers = singersNew;
                }
            }
        }
        return singers;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1001462671)
    public synchronized void resetSingers() {
        singers = null;
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

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1218270154)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMusicDao() : null;
    }

    public boolean getIsCache() {
        return this.isCache;
    }

    public void setIsCache(boolean isCache) {
        this.isCache = isCache;
    }

}
