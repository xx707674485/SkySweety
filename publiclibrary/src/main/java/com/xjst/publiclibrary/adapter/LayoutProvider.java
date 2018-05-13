package com.xjst.publiclibrary.adapter;

import android.support.annotation.LayoutRes;

public interface LayoutProvider<T> {
    @LayoutRes
    int getLayoutId(T data);
}
