package com.lsn.hibernation.modules.main

import com.flyco.tablayout.listener.CustomTabEntity
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseActivity
import com.lsn.hibernation.modules.information.InformationFragment
import com.lsn.hibernation.modules.main.adapter.MainAdapter
import com.lsn.hibernation.modules.main.entity.MainTabEntity
import com.lsn.hibernation.modules.music.MusicFragment
import com.lsn.hibernation.modules.video.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*

@LayoutResId(R.layout.activity_main)
class MainActivity : BaseActivity() {

    val fragments = listOf(MusicFragment(), VideoFragment(), InformationFragment())
    val titles = listOf("音乐", "视频", "信息咨询")

    override fun init() {
        initView()
    }

    private fun initView() {
        initTabLayout()
        initViewPage()
    }

    private fun initTabLayout() {
        val tabs = ArrayList<CustomTabEntity>()
        titles.forEach {
            tabs.add(MainTabEntity(it))
        }
        cTLMainTabLayout.setTabData(tabs)

    }

    private fun initViewPage() {
        val adapter = MainAdapter(supportFragmentManager, fragments, titles)

    }

}
