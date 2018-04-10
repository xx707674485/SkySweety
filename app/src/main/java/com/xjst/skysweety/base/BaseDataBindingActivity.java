package com.xjst.skysweety.base;

import android.databinding.ViewDataBinding;

import com.xjst.skysweety.util.attacher.LayoutNaviProvider;

public abstract class BaseDataBindingActivity<V extends ViewDataBinding> extends IBaseActivity implements
        LayoutNaviProvider<V> {
    {
        initViewDataBinding();
    }
}
