package com.lsn.hibernation.ui.item

import android.content.Context
import android.util.AttributeSet
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseItemView
import com.lsn.hibernation.modules.music.adapter.MusicPlaylistAdapter
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist
import com.lsn.hibernation.utils.glide.GlideUtils
import kotlinx.android.synthetic.main.item_music_playlist_view.view.*

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/21 17:44
 * Description
 */
@LayoutResId(R.layout.item_music_playlist_view)
class ItemMusicPlaylistView : BaseItemView<EasePlaylist> {
    lateinit var adapter: MusicPlaylistAdapter


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun bindData(data: EasePlaylist, position: Int) {
        GlideUtils.defaultBanner(ivPlaylistEd, data.coverImgUrl)
        tvName.text = data.name
        tvSize.text = data.trackCount.toString() + "首"

        llItemRoot.setOnClickListener {
            println("点击事件:" + adapter.onItemClickListener)
            adapter.onItemClickListener?.onClick(position,data)
        }
    }

}