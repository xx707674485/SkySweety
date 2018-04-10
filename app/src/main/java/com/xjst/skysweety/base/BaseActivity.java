package com.xjst.skysweety.base;

import android.databinding.ViewDataBinding;

import com.xjst.skysweety.util.attacher.LayoutNaviProvider;
import com.xjst.skysweety.util.attacher.PresenterNaviProvider;

public abstract class BaseActivity<P extends BasePresenter, V extends ViewDataBinding> extends IBaseActivity implements
        PresenterNaviProvider<P>, LayoutNaviProvider<V> {

    {
        initPresenter();
        initViewDataBinding();
    }
}
