package com.xjst.skysweety.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xjst.skysweety.util.attacher.LayoutNaviProvider;

public abstract class BaseDataBindingFragment<V extends ViewDataBinding> extends IBaseFragment implements
        LayoutNaviProvider<V> {
    {
        initViewDataBinding();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return getRootView();
    }
}
