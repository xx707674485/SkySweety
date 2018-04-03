package com.xjst.skysweety.test.eventbus;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 作者：zx on 2018/3/20 15:08
 * 描述:消息传递
 */
public class TestBoradcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.equals("com.xjst.skysweety.testreceive")) {
        }
    }
}
