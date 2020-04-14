package com.lsn.hibernation.modules.music.fragment

import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.lsn.hibernation.base.BaseFragment
import com.lsn.hibernation.modules.music.presenter.MusicPresenterImpl

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/10 14:42
 * Description
 */
@LayoutResId(R.layout.fragment_music)
class MusicFragment : BaseFragment() {

    val presenter = MusicPresenterImpl(this)


    override fun init() {

    }

    override fun onSuccess(tag: String, entity: MutableList<Any>) {
        super.onSuccess(tag,entity)
        when (tag) {
            "1" -> {
            }
            "2" -> {
            }
        }
    }
}