package com.lsn.hibernation.modules.music.fragment

import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.app.HibernationApplication
import com.lsn.hibernation.base.BaseFragment
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.InconstantView
import com.lsn.hibernation.db.bean.Playlist
import com.lsn.hibernation.modules.music.adapter.MusicBannerAdapter
import com.lsn.hibernation.modules.music.adapter.MusicPlaylistPageAdapter
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.bean.easy.EasePlaylist
import com.lsn.hibernation.modules.music.presenter.MusicPresenterImpl
import com.lsn.hibernation.ui.adapter.CVPPageChangeListener
import com.lsn.hibernation.utils.comm.DensityUtil
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_music.*
import kotlinx.android.synthetic.main.view_music_content.*
import org.jetbrains.anko.textColor


/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/10 14:42
 * Description
 */
@LayoutResId(R.layout.fragment_music)
class MusicFragment : BaseFragment() {
    val presenter = MusicPresenterImpl(this)
    lateinit var mAdapter: MusicPlaylistPageAdapter


    override fun init() {

        initView()
        //创建（new banner()）或者布局文件中获取banner
        initData()

        initEvent()
    }

    private fun switchTab(tag: Int) {
        when (tag) {
            0 -> {
                cvpMusicContent.currentItem = 0
                tvSelf.textColor = resources.getColor(R.color.lever1Text)
                tvSelfCount.textColor = resources.getColor(R.color.lever1Text)
                context?.let {
                    tvSelf.textSize = DensityUtil.sp2pxF(it, 5f)
                    tvSelfCount.textSize = DensityUtil.sp2pxF(it, 3f)
                }

                tvCollect.textColor = resources.getColor(R.color.lever2Text)
                tvCollectCount.textColor = resources.getColor(R.color.lever2Text)
                context?.let {
                    tvCollect.textSize = DensityUtil.sp2pxF(it, 4f)
                    tvCollectCount.textSize = DensityUtil.sp2pxF(it, 3f)
                }
            }

            1 -> {
                cvpMusicContent.currentItem = 1

                tvSelf.textColor = resources.getColor(R.color.lever2Text)
                tvSelfCount.textColor = resources.getColor(R.color.lever2Text)
                context?.let {
                    tvSelf.textSize = DensityUtil.sp2pxF(it, 4f)
                    tvSelfCount.textSize = DensityUtil.sp2pxF(it, 3f)
                }


                tvCollect.textColor = resources.getColor(R.color.lever1Text)
                tvCollectCount.textColor = resources.getColor(R.color.lever1Text)
                context?.let {
                    tvCollect.textSize = DensityUtil.sp2pxF(it, 5f)
                    tvCollectCount.textSize = DensityUtil.sp2pxF(it, 3f)
                }
            }
        }
    }

    private fun initEvent() {

        llSelf.setOnClickListener {
            switchTab(0)
        }

        llCollect.setOnClickListener {
            switchTab(1)
        }

        cvpMusicContent.addOnPageChangeListener(object : CVPPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                switchTab(position)
            }
        })

    }

    private fun initView() {
        initBody(ivMusicContent)

        initViewPage()
        tvSelf.text = "创建歌单"
        tvCollect.text = "收藏歌单"
        switchTab(0)
    }


    private fun initViewPage() {
        mAdapter = MusicPlaylistPageAdapter()
        cvpMusicContent.apply {
            adapter = mAdapter
            currentItem = 0
        }


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
            Constant.Music.Api.PLAYLIST -> {
                val easePlaylist = entity as List<Playlist>
                val self = ArrayList<EasePlaylist>()
                val collect = ArrayList<EasePlaylist>()
                easePlaylist.forEach {
                    if (it.creator.nickname == HibernationApplication.get.getNikeName()) {
                        self.add(it)
                    } else {
                        collect.add(it)
                    }
                }
                tvSelfCount.text = self.size.toString()
                tvCollectCount.text = collect.size.toString()
                context?.let {
                    mAdapter.setData(self, collect, it)
                    mAdapter.notifyDataSetChanged()
                }
                ivMusicContent.setBodyTransform(InconstantView.Type.CONTENT)
            }
        }
    }
}