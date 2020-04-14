package com.lsn.hibernation.ui.adapter

import com.lsn.hibernation.modules.music.bean.Banner
import com.lsn.hibernation.modules.music.contact.MusicContact

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 16:51
 * Description
 */
open class MusicViewImpl : MusicContact.MusicView {
    override fun getBannerSuccess(banner: List<Banner.BannersBean>, isCache: Boolean) {

    }

    override fun msg(msg: Int): String {
        return ""
    }

    override fun onEmptyStatusResponse() {

    }

    override fun onEmptyStatusResponse(msg: String) {
    }

}