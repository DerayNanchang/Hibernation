package com.lsn.hibernation.modules.main

import android.Manifest
import com.flyco.tablayout.listener.CustomTabEntity
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseActivity
import com.lsn.hibernation.base.Config
import com.lsn.hibernation.modules.information.InformationFragment
import com.lsn.hibernation.modules.main.adapter.MainAdapter
import com.lsn.hibernation.modules.main.entity.MainTabEntity
import com.lsn.hibernation.modules.music.fragment.MusicFragment
import com.lsn.hibernation.modules.video.VideoFragment
import com.lsn.hibernation.ui.adapter.CVPPageChangeListener
import com.lsn.hibernation.utils.comm.DensityUtil
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_main_navigation.view.*


@LayoutResId(R.layout.activity_main)
class MainActivity : BaseActivity() {

    private val fragments = listOf(MusicFragment(), VideoFragment(), InformationFragment())
    private val titles = listOf("音乐", "视频", "咨询")
    private lateinit var mPermission: Disposable
    private var selectPosition = 0;
    override fun init() {
        initDir()
        initView()
        initEvent()
    }

    private fun initEvent() {
        // 音乐，视频，信息咨询

        initTabLayoutEvent()
        cVPContent.addOnPageChangeListener(object : CVPPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                selectPosition = position
                selectTab(selectPosition)
            }
        })

    }

    private fun initTabLayoutEvent() {
        viewNavigation.tvMusic.setOnClickListener {
            selectTab(0)
        }

        viewNavigation.tvVideo.setOnClickListener {
            selectTab(1)
        }

        viewNavigation.tvInformation.setOnClickListener {
            selectTab(2)
        }
    }


    fun spToPx(size:Float) : Float{
        return DensityUtil.px2spF(this, size)
    }

    fun selectTab(position: Int) {
        when (position) {
            0 -> {
                // 改变字体颜色
                selectPosition = 0
                viewNavigation.tvMusic.textSize = spToPx(36f)
                viewNavigation.tvVideo.textSize = spToPx(30f)
                viewNavigation.tvInformation.textSize = spToPx(30f)
                viewNavigation.tvMusic.setTextColor(resources.getColor(R.color.selectColor))
                viewNavigation.tvVideo.setTextColor(resources.getColor(R.color.unSelectColor))
                viewNavigation.tvInformation.setTextColor(resources.getColor(R.color.unSelectColor))
                cVPContent.currentItem = selectPosition
            }
            1 -> {
                selectPosition = 1
                viewNavigation.tvMusic.textSize = spToPx(30f)
                viewNavigation.tvVideo.textSize = spToPx(36f)
                viewNavigation.tvInformation.textSize = spToPx(30f)
                viewNavigation.tvMusic.setTextColor(resources.getColor(R.color.unSelectColor))
                viewNavigation.tvVideo.setTextColor(resources.getColor(R.color.selectColor))
                viewNavigation.tvInformation.setTextColor(resources.getColor(R.color.unSelectColor))
                cVPContent.currentItem = selectPosition
            }
            2 -> {
                selectPosition = 2
                viewNavigation.tvMusic.textSize = spToPx(30f)
                viewNavigation.tvVideo.textSize = spToPx(30f)
                viewNavigation.tvInformation.textSize = spToPx(36f)
                viewNavigation.tvMusic.setTextColor(resources.getColor(R.color.unSelectColor))
                viewNavigation.tvVideo.setTextColor(resources.getColor(R.color.unSelectColor))
                viewNavigation.tvInformation.setTextColor(resources.getColor(R.color.selectColor))
                cVPContent.currentItem = selectPosition
            }
        }

    }

    private fun initView() {
        initViewPage()
        initTabLayout()
    }

    private fun initDir() {
        val rx = RxPermissions(this)
        //  初始化文件夹
        mPermission = rx.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe { aBoolean ->
                if (aBoolean!!) {
                    //  初始化文件夹
                    Config.get().initMusicDir()
                    Config.get().initApkDir()
                    Config.get().initImgDir()
                }
            }
    }

    private fun initTabLayout() {
        val tabs = ArrayList<CustomTabEntity>()
        titles.forEach {
            tabs.add(MainTabEntity(it))
        }
        //viewNavigation.tlTitle.setupWithViewPager(cVPContent)

    }

    private fun initViewPage() {
        val mAdapter = MainAdapter(supportFragmentManager, fragments, titles)
        cVPContent.apply {
            adapter = mAdapter
            offscreenPageLimit = 3
            currentItem = 0
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!mPermission.isDisposed) mPermission.dispose()
    }
}
