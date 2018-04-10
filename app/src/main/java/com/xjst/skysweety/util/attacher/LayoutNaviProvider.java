package com.xjst.skysweety.util.attacher;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.xjst.skysweety.base.LayoutProvider;

public interface LayoutNaviProvider<V extends ViewDataBinding> extends NaviComponentProvider, LayoutProvider {
    @SuppressWarnings("unchecked")
    default LayoutNaviAttacher<V> getLayoutAttacher() {
        return NaviComponentProvider.getAttacher(LayoutNaviAttacher.class, this);
    }

    default void initViewDataBinding() {
        getLayoutAttacher().setLayoutProvider(this);
    }

    default V getDataBinding() {
        return getLayoutAttacher().getDataBinding();
    }

    default View getRootView() {
        return getLayoutAttacher().getRootView();
    }

    @LayoutRes
    @Override
    int getLayout();
}
