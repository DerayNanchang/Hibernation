package com.lsn.hibernation.base

import android.content.Context
import android.util.AttributeSet
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import kotlinx.android.synthetic.main.view_default_head.view.*

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/22
 * Description
 */
@LayoutResId(R.layout.view_default_head)
class DefaultHeadView : HeadOrFootItemView<String> {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setMsg(size: Int) {
        if (size == 0) {
            tvMsg.text = " 我也是有顶线的 "
        } else {
            tvMsg.text = " 正在加载数据 ... "
        }
    }
}