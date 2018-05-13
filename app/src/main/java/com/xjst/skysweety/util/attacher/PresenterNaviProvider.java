package com.xjst.skysweety.util.attacher;

import com.xjst.skysweety.base.BasePresenter;

public interface PresenterNaviProvider<P extends BasePresenter> extends NaviComponentProvider,
        PresenterNaviAttacher.PresenterCreator<P> {
    @SuppressWarnings("unchecked")
    default PresenterNaviAttacher<P> getPresenterAttacher() {
        return NaviComponentProvider.getAttacher(PresenterNaviAttacher.class, this);
    }

    default void initPresenter() {
        getPresenterAttacher().setCreator(this);
    }

    default P getPresenter() {
        return getPresenterAttacher().getPresenter();
    }

}
