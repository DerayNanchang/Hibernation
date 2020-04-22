package com.lsn.hibernation.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Cache {
    @Id
    private String key;
    private String jsonEntity;
    private Boolean isList;
    private Long lastTime;
    private Long storageTime;
    @Generated(hash = 806364974)
    public Cache(String key, String jsonEntity, Boolean isList, Long lastTime,
            Long storageTime) {
        this.key = key;
        this.jsonEntity = jsonEntity;
        this.isList = isList;
        this.lastTime = lastTime;
        this.storageTime = storageTime;
    }
    @Generated(hash = 1305017356)
    public Cache() {
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getJsonEntity() {
        return this.jsonEntity;
    }
    public void setJsonEntity(String jsonEntity) {
        this.jsonEntity = jsonEntity;
    }
    public Boolean getIsList() {
        return this.isList;
    }
    public void setIsList(Boolean isList) {
        this.isList = isList;
    }
    public Long getLastTime() {
        return this.lastTime;
    }
    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }
    public Long getStorageTime() {
        return this.storageTime;
    }
    public void setStorageTime(Long storageTime) {
        this.storageTime = storageTime;
    }
    public void setIsList(boolean isList) {
        this.isList = isList;
    }

    
}
