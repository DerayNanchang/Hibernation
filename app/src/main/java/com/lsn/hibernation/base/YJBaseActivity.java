package com.lsn.hibernation.base;

import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.qd.kit.R;
import com.qd.kit.activity.QDBaseActivity;
import com.yingjiu.annotation.NetFailed;
import com.yingjiu.annotation.YaoAnnotation;
import com.yingjiu.manager.ActivityManager;
import com.yingjiu.module.comm.bean.QDUser;
import com.yingjiu.receiver.NetConnectReceiver;
import com.yingjiu.ui.InconstantView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import kotlin.Unit;

public abstract class YJBaseActivity extends QDBaseActivity {


    private ProgressDialog dialog;
    private WindowManager manager;
    private View view;
    private NetConnectReceiver receiver;
    @NotNull

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // QD 的逻辑不动,在此基础上添加YJ的基础逻辑
        ActivityManager.get().addActivity(this);
        registerNetReceiver();
        YaoAnnotation.INSTANCE.init(this);
        //initAnnotationNet();
        //RxBusManager.Jvm.getRx().tokenFailedSubscribe(this);

        if (getBaseToolbarBack() != null) {
            getBaseToolbarBack().setOnClickListener(view -> onBackPressed());
        }

        if (getBaseToolbarTitle() != null && getBaseToolbarTitle().size() > 0) {
            TextView textView = (TextView) getBaseToolbarTitle().get(0);
            String title = (String) getBaseToolbarTitle().get(1);
            textView.setText(title);
        }
        getBaseToolbarBack();
        init();
    }


    protected void initBody(InconstantView inconstantView) {
        // 添加空状态与无网络
        if (inconstantView != null) {
            inconstantView.addContent(R.layout.view_default_content);
            inconstantView.addEmptyState(R.layout.view_default_empty_state);
            inconstantView.addNoConnect(R.layout.view_default_no_connect);
            inconstantView.addLoading(R.layout.view_custom_wrap_progress);
            inconstantView.setBodyTransform(InconstantView.Type.LOADING);
        }
    }

    protected View getBaseToolbarBack() {
        return null;
    }

    protected List<Object> getBaseToolbarTitle() {
        return null;
    }


    protected void initWindow() {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
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


    private void addCustomNetFailedView(boolean isDefault, NetFailed annotation) {
        /*manager = getWindowManager();
        if (isDefault){
            view = LayoutInflater.from(this).inflate(R.layout.view_default_no_connect, null, false);
        }else {
            view = LayoutInflater.from(this).inflate(annotation.value(), null, false);
        }
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        int statusBarHeight = DensityUtil.getStatusBarHeight(this);
        int toolbarHeight = DensityUtil.dip2px(56);
        params.height = DensityUtil.getScreenMetrics(this).y - statusBarHeight - toolbarHeight;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.format = PixelFormat.RGBA_8888;
        params.gravity = Gravity.BOTTOM;
        manager.addView(view, params);*/
    }

    private void initAnnotationNet() {
        /*Class clazz = getClass();
        NetFailed annotation = (NetFailed) clazz.getAnnotation(NetFailed.class);
        if (annotation != null){
            if (!NetUtil.isNetworkConnected(this)){
                if (annotation.value() == 0){
                    addCustomNetFailedView(true,null);
                }else {
                    addCustomNetFailedView(false,annotation);
                }
            }
        }*/
    }

    private void dismissCustomNetView() {
        if (manager != null && view != null) {
            manager.removeView(view);
        }
    }


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
        dismissCustomNetView();
        ActivityManager.get().removeActivity(this);
    }
}
