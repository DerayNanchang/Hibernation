package com.lsn.hibernation.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.lsn.hibernation.db.bean.Album;
import com.lsn.hibernation.db.bean.Cache;
import com.lsn.hibernation.db.bean.Music;
import com.lsn.hibernation.db.bean.Playlist;
import com.lsn.hibernation.db.bean.Singer;

import com.lsn.hibernation.db.dao.AlbumDao;
import com.lsn.hibernation.db.dao.CacheDao;
import com.lsn.hibernation.db.dao.MusicDao;
import com.lsn.hibernation.db.dao.PlaylistDao;
import com.lsn.hibernation.db.dao.SingerDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig albumDaoConfig;
    private final DaoConfig cacheDaoConfig;
    private final DaoConfig musicDaoConfig;
    private final DaoConfig playlistDaoConfig;
    private final DaoConfig singerDaoConfig;

    private final AlbumDao albumDao;
    private final CacheDao cacheDao;
    private final MusicDao musicDao;
    private final PlaylistDao playlistDao;
    private final SingerDao singerDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        albumDaoConfig = daoConfigMap.get(AlbumDao.class).clone();
        albumDaoConfig.initIdentityScope(type);

        cacheDaoConfig = daoConfigMap.get(CacheDao.class).clone();
        cacheDaoConfig.initIdentityScope(type);

        musicDaoConfig = daoConfigMap.get(MusicDao.class).clone();
        musicDaoConfig.initIdentityScope(type);

        playlistDaoConfig = daoConfigMap.get(PlaylistDao.class).clone();
        playlistDaoConfig.initIdentityScope(type);

        singerDaoConfig = daoConfigMap.get(SingerDao.class).clone();
        singerDaoConfig.initIdentityScope(type);

        albumDao = new AlbumDao(albumDaoConfig, this);
        cacheDao = new CacheDao(cacheDaoConfig, this);
        musicDao = new MusicDao(musicDaoConfig, this);
        playlistDao = new PlaylistDao(playlistDaoConfig, this);
        singerDao = new SingerDao(singerDaoConfig, this);

        registerDao(Album.class, albumDao);
        registerDao(Cache.class, cacheDao);
        registerDao(Music.class, musicDao);
        registerDao(Playlist.class, playlistDao);
        registerDao(Singer.class, singerDao);
    }
    
    public void clear() {
        albumDaoConfig.clearIdentityScope();
        cacheDaoConfig.clearIdentityScope();
        musicDaoConfig.clearIdentityScope();
        playlistDaoConfig.clearIdentityScope();
        singerDaoConfig.clearIdentityScope();
    }

    public AlbumDao getAlbumDao() {
        return albumDao;
    }

    public CacheDao getCacheDao() {
        return cacheDao;
    }

    public MusicDao getMusicDao() {
        return musicDao;
    }

    public PlaylistDao getPlaylistDao() {
        return playlistDao;
    }

    public SingerDao getSingerDao() {
        return singerDao;
    }

}
