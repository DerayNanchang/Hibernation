package com.lsn.hibernation.modules.music.adapter

import android.view.ViewGroup
import com.lsn.hibernation.base.BaseItemView
import com.lsn.hibernation.base.BaseViewHolder
import com.lsn.hibernation.base.SimpleAdapter
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist
import com.lsn.hibernation.ui.item.ItemMusicPlaylistView

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/21 17:40
 * Description
 */
class MusicPlaylistAdapter : SimpleAdapter<EasePlaylist>(){
    override fun onCreateBodyViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): BaseViewHolder<*, out BaseItemView<*>> {
        val playlistView = ItemMusicPlaylistView(parent?.context)
        playlistView.adapter = this

        return MusicPlayListViewHolder(playlistView)
    }

    class MusicPlayListViewHolder(view: ItemMusicPlaylistView) : BaseViewHolder<EasePlaylist, ItemMusicPlaylistView>(view)

     var onItemClickListener: OnItemClickListener? =  null


    fun setMOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }


    interface OnItemClickListener {
        fun onClick(position: Int, entity: EasePlaylist)
    }


}