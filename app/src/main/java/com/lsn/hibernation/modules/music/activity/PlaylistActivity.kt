package com.lsn.hibernation.modules.music.activity

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.WindowManager
import android.widget.Scroller
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.fastjson.JSON
import com.google.android.material.appbar.AppBarLayout
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.InconstantView
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.db.bean.Playlist
import com.lsn.hibernation.db.manager.PlaylistManager
import com.lsn.hibernation.manager.MusicManager
import com.lsn.hibernation.manager.SingerManager
import com.lsn.hibernation.modules.music.adapter.PlaylistAdapter
import com.lsn.hibernation.modules.music.base.BaseMusicActivity
import com.lsn.hibernation.modules.music.bean.PlaylistComm
import com.lsn.hibernation.modules.music.presenter.PlaylistPresenterImpl
import com.lsn.hibernation.ui.adapter.ScrollLinearLayoutManager
import com.lsn.hibernation.utils.comm.StatusBarUtils
import com.lsn.hibernation.utils.comm.Toast
import com.lsn.hibernation.utils.glide.GlideHelp
import com.lsn.hibernation.utils.glide.GlideUtils
import kotlinx.android.synthetic.main.activity_playlist.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.startActivity
import java.lang.Math.max
import java.lang.Math.min
import java.util.*
import kotlin.math.abs


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
    lateinit var recyclerView: RecyclerView
    var playlistComm: PlaylistComm? = null
    var scrollHeight = 0
    lateinit var scroller: Scroller
    override fun init() {
        val playComm = intent.getStringExtra(Constant.Key.PLAYLIST_COMM)
        playlistComm = JSON.parseObject(playComm, PlaylistComm::class.java)
        if (playlistComm == null) {
            Toast.show("歌单不存在")
            onBackPressed()
        }
        mAdapter = PlaylistAdapter()
        scroller = Scroller(this)
        initView()
        initData()
        initEvent()
        //println(" singers : "+JSON.toJSONString(SingerManager.get.getSingers()))
        //SingerManager.get.getSingers()
        llComment.setOnClickListener {
            Toast.show("点击了。。。")
        }

    }

    private fun initEvent() {
        ivBack.setOnClickListener {
            onBackPressed()
        }

        mAdapter.setOnItemClickListener(object : PlaylistAdapter.OnItemClick {
            override fun onClick(data: Music, position: Int) {
                // 保存当前页面的歌单
                PlaylistManager.get.setQueuePlaylistId(data.playlistId)
                MusicManager.get.setQueuePosition(position)
                startActivity<PlayActivity>()
            }
        })

        // 滑动事件
        ablRoot.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset -> // 0 -> -像素
            val y = abs(verticalOffset)
            val ratio = y.coerceAtLeast(0).coerceAtMost(scrollHeight).toFloat() / scrollHeight
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
            llRoot.translationY = verticalOffset.toFloat()
        })

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, xX: Int, xY: Int) {
                super.onScrolled(recyclerView, xX, xY)
                val y = recyclerView.computeVerticalScrollOffset()
            }
        })
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
                val playlist = entity as Playlist
                tvPlaySize.text = "(共" + playlist.musics.size.toString() + "首)"
                mAdapter.updateData(playlist.musics)
                ivPlaylistContent.setBodyTransform(InconstantView.Type.CONTENT)
            }
        }

    }


    private fun initView() {
        // 1.获取头部焦点
        initFocusable()

        // 2. 绘制Toolbar 的高度
        initToolbar()
        initBody(ivPlaylistContent, true)
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
            rlRoot.backgroundColor = colors[colors.size - 1]
        }
    }

    /**
     * 控制appbar的滑动
     * @param isScroll true 允许滑动 false 禁止滑动
     */
    private fun banAppBarScroll(isScroll: Boolean) {
        val mAppBarChildAt = ablRoot.getChildAt(0)
        val mAppBarParams = mAppBarChildAt.layoutParams as AppBarLayout.LayoutParams
        if (isScroll) {
            mAppBarParams.scrollFlags =
                AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
            mAppBarChildAt.layoutParams = mAppBarParams
        } else {
            mAppBarParams.scrollFlags = 0
        }

    }

    private fun initRecyclerView() {
        manager = ScrollLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // 禁止 recycleView 滑动 防止与 ScrollView 冲突
        //manager.setScrollEnabled(false)
        recyclerView = ivPlaylistContent.getContent() as RecyclerView
        recyclerView.layoutManager = manager
        recyclerView.adapter = mAdapter
    }

    private fun initToolbar() {
        // 1. 让 toolbar 顶掉状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // 2 .测量 toolbar 真实高度 及 上半部布局高度，
        llToolbar.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        llRoot.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        vConceal.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        vPlaceholder.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)


        // 3.获取状态栏高度
        val barHeight = StatusBarUtils.getStatusBarHeight(this)

        // 4.添加两者高度 原高度+状态栏高度
        val rootViewParams = llRoot.layoutParams
        rootViewParams.height += barHeight
        val toolbarParams = llToolbar.layoutParams
        toolbarParams.height += barHeight

        val vPlaceholderParams = vPlaceholder.layoutParams
        vPlaceholderParams.height = toolbarParams.height

        val vConcealParams = vConceal.layoutParams
        vConcealParams.height = rootViewParams.height - vPlaceholderParams.height

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