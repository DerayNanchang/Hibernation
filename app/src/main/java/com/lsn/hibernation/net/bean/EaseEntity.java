package com.lsn.hibernation.net.bean;

import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist;

import java.util.List;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/22 9:53
 * Description
 */
public class EaseEntity extends BaseEaseEntity {
    private List<EasePlaylist> playlist;

    public List<EasePlaylist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<EasePlaylist> playlist) {
        this.playlist = playlist;
    }
}
