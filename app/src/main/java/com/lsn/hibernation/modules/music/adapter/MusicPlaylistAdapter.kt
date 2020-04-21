package com.lsn.hibernation.modules.music.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.lsn.hibernation.R
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/21 17:18
 * Description
 */
class MusicPlaylistAdapter : PagerAdapter {
    lateinit var easePlaylist: List<EasePlaylist>

    constructor() : super()

    constructor(easePlaylist: List<EasePlaylist>) : super() {
        this.easePlaylist = easePlaylist
    }

    fun setView(easePlaylist: List<EasePlaylist>) {
        this.easePlaylist = easePlaylist
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //val view = easePlaylist[position]
        val mAdapter = PlaylistAdapter()
        val view =
            LayoutInflater.from(container.context).inflate(R.layout.item_music_playlist, null, false)
        val rvMusicPlaylist = view.findViewById<RecyclerView>(R.id.rvMusicPlaylist)
        rvMusicPlaylist.apply {
            this.adapter = mAdapter
            layoutManager = LinearLayoutManager(container.context)
        }
        mAdapter.updateData(easePlaylist)
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`//官方固定写法
    }

    override fun getCount(): Int {
        return 2
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        //container.removeView(views[position]);

    }

}