package com.lsn.hibernation.modules.music.contact

import com.lsn.hibernation.base.ModelResponseAdapter2
import com.lsn.hibernation.db.bean.Playlist
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 11:32
 * Description
 */
interface PlaylistContact {
    interface PlaylistPresenter {
        fun getPlaylistDetail(id: String)
    }

    interface PlaylistModel {

        fun getPlaylistDetail(
            id: String,
            response: ModelResponseAdapter2<Playlist, RawPlaylistInfo, String>
        )
    }
}