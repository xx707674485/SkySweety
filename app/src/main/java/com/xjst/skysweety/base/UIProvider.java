package com.xjst.skysweety.base;

import com.xjst.skysweety.util.ToastUtils;

public interface UIProvider {
    default void showToast(CharSequence msg) {
        ToastUtils.showShort(msg);
    }

    default void showProgress(CharSequence msg) {

    }

    default void dismissProgress() {
    }
}
