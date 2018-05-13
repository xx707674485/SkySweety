package com.xjst.skysweety.test;

import android.support.annotation.LayoutRes;
import android.util.Log;

import com.xjst.skysweety.base.BaseActivity;
import com.xjst.skysweety.base.BasePresenter;

public class TestActivity extends BaseActivity {

    private static final String TAG = "TestActivity";

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public void initView() {

    }

    private void onTest() {
        getDataBinding();
        getPresenter();
    }
}
