package com.lsn.hibernation.modules.music.adapter

import android.view.ViewGroup
import com.lsn.hibernation.base.BaseItemView
import com.lsn.hibernation.base.BaseViewHolder
import com.lsn.hibernation.base.SimpleAdapter
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist
import com.lsn.hibernation.ui.item.ItemPlaylistView

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/21 17:40
 * Description
 */
class PlaylistAdapter : SimpleAdapter<EasePlaylist>(){
    override fun onCreateBodyViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): BaseViewHolder<*, out BaseItemView<*>> {
        val playlistView = ItemPlaylistView(parent?.context)
        playlistView.adapter = this

        return PlayListViewHolder(playlistView)
    }

    class PlayListViewHolder(view: ItemPlaylistView) : BaseViewHolder<EasePlaylist, ItemPlaylistView>(view)

}