package com.lsn.hibernation.ui.item

import android.content.Context
import android.util.AttributeSet
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseItemView
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.modules.music.adapter.PlaylistAdapter
import kotlinx.android.synthetic.main.item_playlist_view.view.*

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 13:45
 * Description
 */
@LayoutResId(R.layout.item_playlist_view)
class ItemPlaylistView : BaseItemView<Music> {

    lateinit var adapter: PlaylistAdapter

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun bindData(data: Music, position: Int) {
        tvSongName.text = data.name
        tvPosition.text = (position + 1).toString()
        if (data.singers != null && data.singers.size > 0) {
            tvSinger.text = data.singers[0].name
        }
    }

}