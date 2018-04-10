package com.xjst.skysweety.base;

import com.xjst.skysweety.util.attacher.PresenterNaviProvider;

public abstract class BasePresenterActivity<P extends BasePresenter> extends IBaseActivity implements PresenterNaviProvider<P> {
}
