package com.lsn.hibernation.modules.music.activity

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.WindowManager
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.fastjson.JSON
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.InconstantView
import com.lsn.hibernation.modules.music.adapter.PlaylistAdapter
import com.lsn.hibernation.modules.music.base.BaseMusicActivity
import com.lsn.hibernation.modules.music.bean.PlaylistComm
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo
import com.lsn.hibernation.modules.music.presenter.PlaylistPresenterImpl
import com.lsn.hibernation.ui.adapter.ScrollLinearLayoutManager
import com.lsn.hibernation.utils.comm.StatusBarUtils
import com.lsn.hibernation.utils.comm.Toast
import com.lsn.hibernation.utils.glide.GlideHelp
import com.lsn.hibernation.utils.glide.GlideUtils
import kotlinx.android.synthetic.main.activity_playlist.*
import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 9:46
 * Description
 */
@LayoutResId(R.layout.activity_playlist)
class PlaylistActivity : BaseMusicActivity() {
    val presenter = PlaylistPresenterImpl(this)
    lateinit var manager: ScrollLinearLayoutManager
    lateinit var mAdapter: PlaylistAdapter
    var playlistComm: PlaylistComm? = null
    var scrollHeight = 0
    override fun init() {
        val playComm = intent.getStringExtra(Constant.Key.PLAYLIST_COMM)
        playlistComm = JSON.parseObject(playComm, PlaylistComm::class.java)
        if (playlistComm == null) {
            Toast.show("歌单不存在")
            onBackPressed()
        }
        mAdapter = PlaylistAdapter()
        initView()
        initData()
        initEvent()

    }

    private fun initEvent() {
        // 滑动事件
        sslView.setOnScrollChangedListener { _, y, _, _ ->
            // 滑动间距  所占的高度比例
            val ratio = min(max(y, 0), scrollHeight).toFloat() / scrollHeight
            // 设置 alpha 滑动数据
            // 滑动比例 0-1 而 alpha 要从 隐藏到显示 0 - 255
            val alpha = ratio * 255
            val argb = Color.argb(alpha.toInt(), newRed, newGreen, newBlue)
            llToolbar.setBackgroundColor(argb)
            // 当滑动 滑动高度的三分之一的时候 就改变 title
            if (y > scrollHeight / 3) {
                tvPlaylistName.text = playlistComm?.albumName
            } else {
                tvPlaylistName.text = "歌单"
            }
        }
    }

    private fun initData() {
        tvName.text = playlistComm?.albumName
        tvUserName.text = playlistComm?.ownerName
        GlideUtils.defaultRounded(ivIcon, playlistComm?.albumIcon)
        GlideUtils.defaultCircular(ivAvatar, playlistComm?.ownerIcon)
        playlistComm?.let {
            presenter.getPlaylistDetail(it.id)
        }
    }

    override fun onSuccess(tag: String?, isCache: Boolean, entity: Any?) {
        super.onSuccess(tag, isCache, entity)
        when (tag) {
            Constant.Music.Api.GET_PLAYLIST_DETAIL -> {
                val tracksBean = entity as List<RawPlaylistInfo.PlaylistBean.TracksBean>
                tvPlaySize.text = "(共" + tracksBean.size.toString() + "首)"
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

    private var newRed: Int = 0
    private var newGreen: Int = 0
    private var newBlue: Int = 0
    private val colors = ArrayList<Int>()

    private fun initPalette() {
        val help = GlideHelp();

        help.asBitMap(ivIcon, playlistComm?.albumIcon) { bitmap ->
            bitmap?.let {
                Palette.from(it).generate { palette ->
                    palette?.let {
                        val vibrant = palette.vibrantSwatch//有活力的
                        val vibrantDark = palette.darkVibrantSwatch//有活力的，暗色
                        val vibrantLight = palette.lightVibrantSwatch//有活力的，亮色
                        val muted = palette.mutedSwatch//柔和的
                        val mutedDark = palette.darkMutedSwatch//柔和的，暗色
                        val mutedLight = palette.lightMutedSwatch//柔和的,亮色
                        // 渐变颜色 从 vibrantLight（活力亮色） red（增幅 50 ） green（增幅 50 ） blue
                        var baseColor = 0
                        if (mutedDark != null) {
                            baseColor = mutedDark.rgb
                        } else if (mutedLight != null) {
                            baseColor = mutedLight.rgb
                        }

                        /*if (vibrantLight != null) {
                            baseColor = vibrantLight.rgb
                        } else if (vibrant != null) {
                            baseColor = vibrant.rgb
                        } else if (mutedLight != null) {
                            baseColor = mutedLight.rgb
                        } else if (muted != null) {
                            baseColor = muted.rgb
                        }*/
                        val red = baseColor and 0xff0000 shr 16
                        val green = baseColor and 0x00ff00 shr 8
                        val blue = baseColor and 0x0000ff
                        // BaseColor
                        newRed = if (red > 200) 200 else red
                        newGreen = if (green > 200) 200 else green
                        newBlue = if (blue > 200) 200 else blue


                        val increaseRed = if (red + 80 > 200) 200 else red + 80
                        val increaseGreen = if (green + 80 > 200) 200 else green + 80
                        val increaseBlue = if (blue + 80 > 200) 200 else blue + 80

                        baseColor = Color.rgb(newRed, newGreen, newBlue)

                        val increaseColor = Color.rgb(increaseRed, increaseGreen, increaseBlue)
                        //int increaseColor = muted.getRgb();
                        colors.clear()
                        colors.add(increaseColor)
                        colors.add(baseColor)
                        assemblyColor()
                    }
                }
            }
        }
    }

    private fun assemblyColor() {

        if (colors.size > 0) {
            val color = intArrayOf(colors[0], colors[colors.size - 1])
            /*Drawable drawable = ScrimUtil.makeCubicGradientScrimDrawable(color[0], 8, Gravity.TOP);
            view.rlRoot.setBackground(drawable);*/
            val bg = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, color)
            val sdk = android.os.Build.VERSION.SDK_INT
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                llRoot.setBackgroundDrawable(bg)
            } else {
                llRoot.background = bg
            }
        }
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
        llToolbar.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        llRoot.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)

        // 3.获取状态栏高度
        val barHeight = StatusBarUtils.getStatusBarHeight(this)

        // 4.添加两者高度 原高度+状态栏高度
        val rootViewParams = llRoot.layoutParams
        rootViewParams.height += barHeight
        val toolbarParams = llToolbar.layoutParams
        toolbarParams.height += barHeight

        // 5. 设置 两者 padding 高度(创建假状态栏)
        llToolbar.setPadding(
            llToolbar.paddingLeft,
            llToolbar.paddingTop + barHeight,
            llToolbar.paddingRight,
            llToolbar.paddingBottom
        )

        llRoot.setPadding(
            llRoot.paddingLeft,
            llRoot.paddingTop + barHeight,
            llRoot.paddingRight,
            llRoot.paddingBottom
        )

        // 6. 获取滑动高度  = 父布局高度 - Toolbar 高度
        scrollHeight = rootViewParams.height - toolbarParams.height

    }

    private fun initFocusable() {
        llRoot.isFocusableInTouchMode = true
        llRoot.requestFocus()
    }

}