package com.lsn.hibernation.base;

import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.lsn.hibernation.R;
import com.lsn.hibernation.annotation.YaoAnnotation;
import com.lsn.hibernation.manager.ActivityManager;
import com.lsn.hibernation.receiver.NetConnectReceiver;
import com.lsn.hibernation.utils.comm.MVPConfig;

import org.jetbrains.annotations.NotNull;


/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2018/12/3
 * Description
 */
abstract public class BaseActivity extends AppCompatActivity implements IBaseView {

    private ProgressDialog dialog;
    private NetConnectReceiver receiver;
    private View statusBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityManager.get().addActivity(this);
        initWindow();
        super.onCreate(savedInstanceState);
        /*if (isSetSatatusBar()){
            UtilsStyle.statusBarLightMode(this);
        }*/
        registerNetReceiver();
        YaoAnnotation.INSTANCE.init(this);
        init();
    }

    private void initStatusBar() {
        if (statusBarView == null) {
            int identifier = getResources().getIdentifier("statusBarBackground", "id", "android");
            statusBarView = getWindow().findViewById(identifier);
        }
        if (statusBarView != null) {
            statusBarView.setBackgroundDrawable(null);//在设置前将背景设置为null;
            statusBarView.setBackgroundResource(MVPConfig.statusDrawable);
        }
    }

    @NotNull
    @Override
    public String msg(int msg) {
        return "";
    }

    @Override
    public void onEmptyStatusResponse() {

    }

    protected void initBody(InconstantView inconstantView) {
        // 添加空状态与无网络
        if (inconstantView != null) {
            inconstantView.addContent(R.layout.view_default_content);
            inconstantView.addEmptyState(R.layout.view_default_empty_state);
            inconstantView.addNoConnect(R.layout.view_default_no_connect);
            //inconstantView.addLoading(R.layout.view_custom_wrap_progress);
            inconstantView.addLoading(R.layout.view_comm_progress);
            inconstantView.setBodyTransform(InconstantView.Type.LOADING);
        }
    }

    protected void initBody(InconstantView inconstantView, boolean isCoordinatorLayout) {
        // 添加空状态与无网络
        if (inconstantView != null) {
            inconstantView.addContent(R.layout.view_default_content);
            inconstantView.addEmptyState(R.layout.view_default_empty_state);
            inconstantView.addNoConnect(R.layout.view_default_no_connect);
            //inconstantView.addLoading(R.layout.view_custom_wrap_progress);
            inconstantView.addLoading(R.layout.view_comm_progress, isCoordinatorLayout);
            inconstantView.setBodyTransform(InconstantView.Type.LOADING);
        }
    }


    @Override
    public void onEmptyStatusResponse(@NotNull String tag, @NotNull String msg) {

    }

    @Override
    public void onSuccess(@NotNull String tag, @NotNull Object entity) {
    }

    @Override
    public void onSuccess(String tag, boolean isCache, Object entity) {
    }

    @Override
    public void onFailed() {

    }

    protected void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 过渡动画
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
    }


    private void registerNetReceiver() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //实例化IntentFilter对象
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            receiver = new NetConnectReceiver();
            //注册广播接收
            registerReceiver(receiver, filter);
        }
    }


    protected abstract void init();


    protected void showDialog(String msg) {
        dialog = ProgressDialog.show(this, "", msg);
        dialog.show();
    }

    protected void showDialog() {
        String message = "正在加载数据";
        dialog = ProgressDialog.show(this, "", message);
        dialog.show();
    }


    protected void dismissDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
        if (receiver != null) unregisterReceiver(receiver);
        ActivityManager.get().removeActivity(this);
    }
}
