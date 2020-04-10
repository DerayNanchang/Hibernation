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
import com.lsn.hibernation.modules.music.MusicFragment
import com.lsn.hibernation.modules.video.VideoFragment
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

@LayoutResId(R.layout.activity_main)
class MainActivity : BaseActivity() {

    private val fragments = listOf(MusicFragment(), VideoFragment(), InformationFragment())
    private val titles = listOf("音乐", "视频", "信息咨询")
    private lateinit var mPermission: Disposable
    override fun init() {
        initDir()
        initView()
    }

    private fun initView() {
        initTabLayout()
        initViewPage()
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
        cTLMainTabLayout.setTabData(tabs)

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
