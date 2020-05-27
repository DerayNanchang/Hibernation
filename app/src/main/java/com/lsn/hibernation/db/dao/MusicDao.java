package com.lsn.hibernation.db.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.lsn.hibernation.db.bean.Album;

import com.lsn.hibernation.db.bean.Music;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MUSIC".
*/
public class MusicDao extends AbstractDao<Music, String> {

    public static final String TABLENAME = "MUSIC";

    /**
     * Properties of entity Music.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property NetId = new Property(2, String.class, "netId", false, "NET_ID");
        public final static Property QQId = new Property(3, String.class, "QQId", false, "QQID");
        public final static Property Duration = new Property(4, Long.class, "duration", false, "DURATION");
        public final static Property IsNet = new Property(5, boolean.class, "isNet", false, "IS_NET");
        public final static Property IsCache = new Property(6, boolean.class, "isCache", false, "IS_CACHE");
        public final static Property Type = new Property(7, int.class, "type", false, "TYPE");
        public final static Property AlbumId = new Property(8, String.class, "albumId", false, "ALBUM_ID");
        public final static Property PlaylistId = new Property(9, String.class, "playlistId", false, "PLAYLIST_ID");
    }

    private DaoSession daoSession;

    private Query<Music> album_MusicsQuery;
    private Query<Music> playlist_MusicsQuery;

    public MusicDao(DaoConfig config) {
        super(config);
    }
    
    public MusicDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MUSIC\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"NET_ID\" TEXT," + // 2: netId
                "\"QQID\" TEXT," + // 3: QQId
                "\"DURATION\" INTEGER," + // 4: duration
                "\"IS_NET\" INTEGER NOT NULL ," + // 5: isNet
                "\"IS_CACHE\" INTEGER NOT NULL ," + // 6: isCache
                "\"TYPE\" INTEGER NOT NULL ," + // 7: type
                "\"ALBUM_ID\" TEXT," + // 8: albumId
                "\"PLAYLIST_ID\" TEXT);"); // 9: playlistId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MUSIC\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Music entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String netId = entity.getNetId();
        if (netId != null) {
            stmt.bindString(3, netId);
        }
 
        String QQId = entity.getQQId();
        if (QQId != null) {
            stmt.bindString(4, QQId);
        }
 
        Long duration = entity.getDuration();
        if (duration != null) {
            stmt.bindLong(5, duration);
        }
        stmt.bindLong(6, entity.getIsNet() ? 1L: 0L);
        stmt.bindLong(7, entity.getIsCache() ? 1L: 0L);
        stmt.bindLong(8, entity.getType());
 
        String albumId = entity.getAlbumId();
        if (albumId != null) {
            stmt.bindString(9, albumId);
        }
 
        String playlistId = entity.getPlaylistId();
        if (playlistId != null) {
            stmt.bindString(10, playlistId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Music entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String netId = entity.getNetId();
        if (netId != null) {
            stmt.bindString(3, netId);
        }
 
        String QQId = entity.getQQId();
        if (QQId != null) {
            stmt.bindString(4, QQId);
        }
 
        Long duration = entity.getDuration();
        if (duration != null) {
            stmt.bindLong(5, duration);
        }
        stmt.bindLong(6, entity.getIsNet() ? 1L: 0L);
        stmt.bindLong(7, entity.getIsCache() ? 1L: 0L);
        stmt.bindLong(8, entity.getType());
 
        String albumId = entity.getAlbumId();
        if (albumId != null) {
            stmt.bindString(9, albumId);
        }
 
        String playlistId = entity.getPlaylistId();
        if (playlistId != null) {
            stmt.bindString(10, playlistId);
        }
    }

    @Override
    protected final void attachEntity(Music entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public Music readEntity(Cursor cursor, int offset) {
        Music entity = new Music( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // netId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // QQId
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // duration
            cursor.getShort(offset + 5) != 0, // isNet
            cursor.getShort(offset + 6) != 0, // isCache
            cursor.getInt(offset + 7), // type
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // albumId
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // playlistId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Music entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNetId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setQQId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDuration(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setIsNet(cursor.getShort(offset + 5) != 0);
        entity.setIsCache(cursor.getShort(offset + 6) != 0);
        entity.setType(cursor.getInt(offset + 7));
        entity.setAlbumId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPlaylistId(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final String updateKeyAfterInsert(Music entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(Music entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Music entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "musics" to-many relationship of Album. */
    public List<Music> _queryAlbum_Musics(String albumId) {
        synchronized (this) {
            if (album_MusicsQuery == null) {
                QueryBuilder<Music> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.AlbumId.eq(null));
                album_MusicsQuery = queryBuilder.build();
            }
        }
        Query<Music> query = album_MusicsQuery.forCurrentThread();
        query.setParameter(0, albumId);
        return query.list();
    }

    /** Internal query to resolve the "musics" to-many relationship of Playlist. */
    public List<Music> _queryPlaylist_Musics(String playlistId) {
        synchronized (this) {
            if (playlist_MusicsQuery == null) {
                QueryBuilder<Music> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.PlaylistId.eq(null));
                playlist_MusicsQuery = queryBuilder.build();
            }
        }
        Query<Music> query = playlist_MusicsQuery.forCurrentThread();
        query.setParameter(0, playlistId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getAlbumDao().getAllColumns());
            builder.append(" FROM MUSIC T");
            builder.append(" LEFT JOIN ALBUM T0 ON T.\"ALBUM_ID\"=T0.\"ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Music loadCurrentDeep(Cursor cursor, boolean lock) {
        Music entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Album album = loadCurrentOther(daoSession.getAlbumDao(), cursor, offset);
        entity.setAlbum(album);

        return entity;    
    }

    public Music loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Music> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Music> list = new ArrayList<Music>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Music> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Music> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
