package com.lsn.hibernation.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.lsn.hibernation.utils.comm.NetUtil;
import com.lsn.hibernation.utils.comm.Toast;

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2018/12/28
 * Description
 */
public class NetConnectReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String desc = NetUtil.getSimpleNetDesc(context);
        if (!TextUtils.isEmpty(desc)){
            Toast.show(desc);
        }
    }
}
