package com.lsn.hibernation.ui.item

import android.content.Context
import android.util.AttributeSet
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseItemView
import com.lsn.hibernation.modules.music.adapter.PlaylistAdapter
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo
import kotlinx.android.synthetic.main.item_playlist_view.view.*

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 13:45
 * Description
 */
@LayoutResId(R.layout.item_playlist_view)
class ItemPlaylistView : BaseItemView<RawPlaylistInfo.PlaylistBean.TracksBean> {

    lateinit var adapter: PlaylistAdapter

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun bindData(data: RawPlaylistInfo.PlaylistBean.TracksBean, position: Int) {
        tvSongName.text = data.name
        //tvSinger.text = data.ar.
        tvPosition.text = (position + 1).toString()
        if (data.ar != null && data.ar.size > 0) {
            //tvSinger.text = data.
            data.ar.forEach {
                tvSinger.text = it.name + tvSinger.text + "/"
            }
        }
    }

}