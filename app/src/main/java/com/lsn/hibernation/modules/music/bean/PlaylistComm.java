package com.lsn.hibernation.modules.music.bean;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/27 15:07
 * Description
 */
public class PlaylistComm {
    private String albumIcon;
    private String ownerIcon;
    private String albumName;
    private String ownerName;
    private String id;

    public PlaylistComm() {
    }

    public PlaylistComm(String albumIcon, String ownerIcon, String albumName, String ownerName, String id) {
        this.albumIcon = albumIcon;
        this.ownerIcon = ownerIcon;
        this.albumName = albumName;
        this.ownerName = ownerName;
        this.id = id;
    }

    public String getAlbumIcon() {
        return albumIcon;
    }

    public void setAlbumIcon(String albumIcon) {
        this.albumIcon = albumIcon;
    }

    public String getOwnerIcon() {
        return ownerIcon;
    }

    public void setOwnerIcon(String ownerIcon) {
        this.ownerIcon = ownerIcon;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
