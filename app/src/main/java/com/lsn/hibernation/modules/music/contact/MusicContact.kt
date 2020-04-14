package com.lsn.hibernation.modules.music.contact

import com.lsn.hibernation.base.ModelResponseAdapter
import com.lsn.hibernation.modules.music.bean.Banner

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/14 11:48
 * Description
 */
interface MusicContact {

    interface MusicPresenter {
        fun getBanner(type: Int)
    }

    interface MusicModel {
        fun getBanner(type: Int, response: ModelResponseAdapter<Banner.BannersBean, Banner, String>)
    }
}