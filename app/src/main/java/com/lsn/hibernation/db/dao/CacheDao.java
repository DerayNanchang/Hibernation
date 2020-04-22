package com.lsn.hibernation.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.lsn.hibernation.db.bean.Cache;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CACHE".
*/
public class CacheDao extends AbstractDao<Cache, String> {

    public static final String TABLENAME = "CACHE";

    /**
     * Properties of entity Cache.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Key = new Property(0, String.class, "key", true, "KEY");
        public final static Property JsonEntity = new Property(1, String.class, "jsonEntity", false, "JSON_ENTITY");
        public final static Property IsList = new Property(2, Boolean.class, "isList", false, "IS_LIST");
        public final static Property LastTime = new Property(3, Long.class, "lastTime", false, "LAST_TIME");
        public final static Property StorageTime = new Property(4, Long.class, "storageTime", false, "STORAGE_TIME");
    }


    public CacheDao(DaoConfig config) {
        super(config);
    }
    
    public CacheDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CACHE\" (" + //
                "\"KEY\" TEXT PRIMARY KEY NOT NULL ," + // 0: key
                "\"JSON_ENTITY\" TEXT," + // 1: jsonEntity
                "\"IS_LIST\" INTEGER," + // 2: isList
                "\"LAST_TIME\" INTEGER," + // 3: lastTime
                "\"STORAGE_TIME\" INTEGER);"); // 4: storageTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CACHE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Cache entity) {
        stmt.clearBindings();
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(1, key);
        }
 
        String jsonEntity = entity.getJsonEntity();
        if (jsonEntity != null) {
            stmt.bindString(2, jsonEntity);
        }
 
        Boolean isList = entity.getIsList();
        if (isList != null) {
            stmt.bindLong(3, isList ? 1L: 0L);
        }
 
        Long lastTime = entity.getLastTime();
        if (lastTime != null) {
            stmt.bindLong(4, lastTime);
        }
 
        Long storageTime = entity.getStorageTime();
        if (storageTime != null) {
            stmt.bindLong(5, storageTime);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Cache entity) {
        stmt.clearBindings();
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(1, key);
        }
 
        String jsonEntity = entity.getJsonEntity();
        if (jsonEntity != null) {
            stmt.bindString(2, jsonEntity);
        }
 
        Boolean isList = entity.getIsList();
        if (isList != null) {
            stmt.bindLong(3, isList ? 1L: 0L);
        }
 
        Long lastTime = entity.getLastTime();
        if (lastTime != null) {
            stmt.bindLong(4, lastTime);
        }
 
        Long storageTime = entity.getStorageTime();
        if (storageTime != null) {
            stmt.bindLong(5, storageTime);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public Cache readEntity(Cursor cursor, int offset) {
        Cache entity = new Cache( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // key
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // jsonEntity
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // isList
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // lastTime
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // storageTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Cache entity, int offset) {
        entity.setKey(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setJsonEntity(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIsList(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setLastTime(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setStorageTime(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
     }
    
    @Override
    protected final String updateKeyAfterInsert(Cache entity, long rowId) {
        return entity.getKey();
    }
    
    @Override
    public String getKey(Cache entity) {
        if(entity != null) {
            return entity.getKey();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Cache entity) {
        return entity.getKey() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
