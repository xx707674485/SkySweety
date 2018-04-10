package com.xjst.skysweety.base;

import com.xjst.skysweety.util.ToastUtils;

public interface UIProvider {
    default void showToast(CharSequence msg) {
        ToastUtils.showShort(msg);
    }

    void showProgress(CharSequence msg);

    void dismissProgress();
}
