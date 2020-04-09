package com.lsn.hibernation.annotation

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2018/12/16
 * Description  在Activity 中获取 toolbar 的高度
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AddProgress(val value: Int)