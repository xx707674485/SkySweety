package com.xjst.skysweety.test;

import android.support.annotation.LayoutRes;
import android.util.Log;

import com.xjst.skysweety.base.BaseActivity;
import com.xjst.skysweety.base.BasePresenter;

public class TestActivity extends BaseActivity {

    private static final String TAG = "TestActivity";

    @Override
    public void showProgress(CharSequence msg) {
    }

    @Override
    public void dismissProgress() {
    }

    @Override
    public BasePresenter createPresenter() {
        Log.d(TAG, "createPresenter: enter this line");
        return null;
    }
    @Override
    public int getLayout() {
        return -1;
    }

    @Override
    public void initView() {

    }
}
