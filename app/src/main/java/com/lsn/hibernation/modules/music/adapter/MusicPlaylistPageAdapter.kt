package com.lsn.hibernation.modules.music.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.alibaba.fastjson.JSON
import com.lsn.hibernation.R
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.db.bean.Playlist
import com.lsn.hibernation.modules.music.activity.PlaylistActivity
import com.lsn.hibernation.modules.music.bean.PlaylistComm

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/21 17:18
 * Description
 */
class MusicPlaylistPageAdapter() : PagerAdapter() {
    var self: List<Playlist>? = null
    var collect: List<Playlist>? = null
    var context: Context? = null


    fun setData(self: List<Playlist>, collect: List<Playlist>, context: Context) {
        this.self = self
        this.collect = collect
        this.context = context
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(container.context)
                .inflate(R.layout.item_music_playlist, null, false)
        val mAdapter = MusicPlaylistAdapter(self,collect)
        val rvMusicPlaylist = view.findViewById<RecyclerView>(R.id.rvMusicPlaylist)
        mAdapter.setMOnItemClickListener(object : MusicPlaylistAdapter.OnItemClickListener {
            override fun onClick(position: Int, entity: Playlist) {
                context?.let {
                    val intent = Intent(context, PlaylistActivity::class.java)
                    val playlistComm = PlaylistComm(
                        entity.url,
                        entity.ownerAvatar,
                        entity.name,
                        entity.ownerName,
                        entity.netId
                    )
                    intent.putExtra(Constant.Key.PLAYLIST_COMM, JSON.toJSONString(playlistComm))
                    (it as Activity).startActivity(intent)
                }
            }
        })
        rvMusicPlaylist.apply {
            this.adapter = mAdapter
            this.layoutManager = GridLayoutManager(context, 2)
            when (position) {
                0 -> {
                    if (self != null) {
                        mAdapter.updateData(self)
                    }
                    container.addView(view)
                    return view
                }
                1 -> {
                    if (collect != null) {
                        mAdapter.updateData(collect)
                    }
                    container.addView(view)
                    return view
                }
            }

            return view
        }
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`//官方固定写法
    }

    override fun getCount(): Int {
        return 2
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)
        container.removeView(`object` as View);

    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

}