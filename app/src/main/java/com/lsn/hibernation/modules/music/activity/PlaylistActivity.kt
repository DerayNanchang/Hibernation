package com.lsn.hibernation.modules.music.activity

import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.fastjson.JSON
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.InconstantView
import com.lsn.hibernation.modules.music.adapter.PlaylistAdapter
import com.lsn.hibernation.modules.music.base.BaseMusicActivity
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo
import com.lsn.hibernation.modules.music.presenter.PlaylistPresenterImpl
import com.lsn.hibernation.ui.adapter.ScrollLinearLayoutManager
import com.lsn.hibernation.utils.comm.StatusBarUtils
import kotlinx.android.synthetic.main.activity_playlist.*

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 9:46
 * Description
 */
@LayoutResId(R.layout.activity_playlist)
class PlaylistActivity : BaseMusicActivity() {
    val presenter = PlaylistPresenterImpl(this)
    lateinit var manager : ScrollLinearLayoutManager
    lateinit var mAdapter: PlaylistAdapter
    override fun init() {

        val id = intent.getStringExtra(Constant.Key.PLAYLIST_ID)
        mAdapter = PlaylistAdapter()
        println("呈现数据:1 " + id)
        initView()
        initData(id)

    }

    private fun initData(id:String) {

        presenter.getPlaylistDetail(id)
    }

    override fun onSuccess(tag: String?, isCache: Boolean, entity: Any?) {
        super.onSuccess(tag, isCache, entity)
        when(tag){
            Constant.Music.Api.GET_PLAYLIST_DETAIL ->{
                val tracksBean = entity as List<RawPlaylistInfo.PlaylistBean.TracksBean>
                println("呈现数据:" + JSON.toJSONString(tracksBean))
                mAdapter.updateData(tracksBean)
                ivPlaylistContent.setBodyTransform(InconstantView.Type.CONTENT)
            }
        }

    }


    private fun initView() {
        // 1.获取头部焦点
        initFocusable()

        // 2. 绘制Toolbar 的高度
        initToolbar()
        initBody(ivPlaylistContent)
        initRecyclerView()
        initPalette()

    }

    private fun initPalette() {
    }

    private fun initRecyclerView() {
       manager = ScrollLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // 禁止 recycleView 滑动 防止与 ScrollView 冲突
        manager.setScrollEnabled(false)
        val recyclerView = ivPlaylistContent.getContent() as RecyclerView
        recyclerView.layoutManager = manager
        recyclerView.adapter = mAdapter
    }

    private fun initToolbar() {
        // 1. 让 toolbar 顶掉状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // 2 .测量 toolbar 真实高度 及 上半部布局高度，
        tbBar.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        rlRoot.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)

        // 3.获取状态栏高度
        val barHeight = StatusBarUtils.getStatusBarHeight(this)

        // 4.添加两者高度 原高度+状态栏高度
        val rootViewParams = rlRoot.layoutParams
        rootViewParams.height += barHeight
        val toolbarParams = tbBar.layoutParams
        toolbarParams.height += barHeight

        // 5. 设置 两者 padding 高度(创建假状态栏)
        tbBar.setPadding(
            tbBar.paddingLeft,
            tbBar.paddingTop + barHeight,
            tbBar.paddingRight,
            tbBar.paddingBottom
        )

        rlRoot.setPadding(
            rlRoot.paddingLeft,
            rlRoot.paddingTop + barHeight,
            rlRoot.paddingRight,
            rlRoot.paddingBottom
        )

        // 6. 获取滑动高度  = 父布局高度 - Toolbar 高度
        var scrollHeight = rootViewParams.height - toolbarParams.height

    }

    private fun initFocusable() {
        rlRoot.isFocusableInTouchMode = true
        rlRoot.requestFocus()
    }

}