package com.lsn.hibernation.modules.music.fragment

import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.app.HibernationApplication
import com.lsn.hibernation.base.BaseFragment
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.modules.music.adapter.MusicBannerAdapter
import com.lsn.hibernation.modules.music.adapter.MusicPlaylistAdapter
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist
import com.lsn.hibernation.modules.music.presenter.MusicPresenterImpl
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_music.*


/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/10 14:42
 * Description
 */
@LayoutResId(R.layout.fragment_music)
class MusicFragment : BaseFragment() {
    val presenter = MusicPresenterImpl(this)

    override fun init() {
        initView()

        //创建（new banner()）或者布局文件中获取banner
        initData()
    }

    private fun initView() {
        initViewPage()
    }

    private fun initViewPage() {




        val mAdapter = MusicPlaylistAdapter()
        cvpMusicContent


    }

    private fun initData() {

        presenter.getBanner(1)

        presenter.getPlaylist(HibernationApplication.get.getUId())
    }

    override fun onSuccess(tag: String?, isCache: Boolean, entity: Any?) {
        super.onSuccess(tag, isCache, entity)
        when (tag) {
            Constant.Music.Api.BANNER -> {
                val banners = entity as List<Banner.BannersBean>
                //--------------------------简单使用-------------------------------
                //默认直接设置adapter就行了
                context?.let {
                    bnMusicBanner.adapter = MusicBannerAdapter(it, banners)
                    bnMusicBanner.setIndicator(CircleIndicator(it))
                        .start()
                }
            }

            Constant.Music.Api.PLAYLIST ->{
                val easePlaylist = entity as List<EasePlaylist>
                111111111
            }
        }
    }

    override fun onSuccess(tag: String, entity: Any) {
        super.onSuccess(tag, entity)
    }
}