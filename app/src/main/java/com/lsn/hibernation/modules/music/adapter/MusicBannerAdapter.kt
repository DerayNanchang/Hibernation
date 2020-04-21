package com.lsn.hibernation.modules.music.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lsn.hibernation.R
import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.ui.widget.CustomSmartDotView
import com.lsn.hibernation.utils.glide.GlideUtils
import com.youth.banner.adapter.BannerAdapter
import org.jetbrains.anko.find

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/16 10:41
 * Description
 */
class MusicBannerAdapter(var context: Context, var banners: List<Banner.BannersBean>) :
    BannerAdapter<Banner.BannersBean, MusicBannerAdapter.BannerViewHolder>(banners) {
    class BannerViewHolder : RecyclerView.ViewHolder {
        var ivBannerImg: ImageView;
        var csDotView: CustomSmartDotView;

        constructor(itemView: View) : super(itemView) {
            ivBannerImg = itemView.find(R.id.ivBannerImg)
            csDotView = itemView.find(R.id.csDotView)

        }
    }


    override fun onCreateHolder(
        parent: ViewGroup?,
        viewType: Int
    ): MusicBannerAdapter.BannerViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.layout_music_banner, parent,false)
        return BannerViewHolder(view)
    }

    override fun onBindView(
        holder: MusicBannerAdapter.BannerViewHolder?,
        data: Banner.BannersBean?,
        position: Int,
        size: Int
    ) {
        GlideUtils.defaultBanner(holder?.ivBannerImg, data?.picUrl)
        holder?.csDotView?.setDrawDotNumber(banners.size)
    }

}