package com.lsn.hibernation.modules.music.adapter

import android.view.ViewGroup
import com.lsn.hibernation.base.BaseItemView
import com.lsn.hibernation.base.BaseViewHolder
import com.lsn.hibernation.base.SimpleAdapter
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.ui.item.ItemPlaylistView

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 13:43
 * Description
 */
class PlaylistAdapter : SimpleAdapter<Music>() {
    lateinit var adapter: PlaylistAdapter
    override fun onCreateBodyViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): BaseViewHolder<*, out BaseItemView<*>> {
        val playlistView = ItemPlaylistView(parent?.context)
        playlistView.adapter = this

        return PlayListViewHolder(playlistView)
    }

    class PlayListViewHolder(view: ItemPlaylistView) : BaseViewHolder<Music, ItemPlaylistView>(view)

    var onItemClick: OnItemClick? = null

    interface OnItemClick {
        fun onClick(data: Music, position: Int)
    }

    fun setOnItemClickListener(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }
}