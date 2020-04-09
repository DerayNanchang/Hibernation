package com.lsn.hibernation.base

import android.content.Context
import android.util.AttributeSet
import com.lsn.hibernation.R
import com.lsn.hibernation.annotation.LayoutResId
import com.yingjiu.base.HeadOrFootItemView

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/22
 * Description
 */
@LayoutResId(R.layout.view_default_head)
class DefaultFootView : HeadOrFootItemView<String> {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setMsg(size: Int) {
        if (size == 0) {
            tvMsg.text = " 我也是有底线的 "
        } else {
            tvMsg.text = " 正在加载数据 ... "
        }
    }
}