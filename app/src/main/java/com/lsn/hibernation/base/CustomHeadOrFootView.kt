package com.lsn.hibernation.base

import android.content.Context
import android.util.AttributeSet
import com.yingjiu.base.HeadOrFootItemView

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/22
 * Description
 */
abstract class CustomHeadOrFootView : HeadOrFootItemView<String> {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}