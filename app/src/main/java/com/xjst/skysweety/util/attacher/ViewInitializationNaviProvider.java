package com.xjst.skysweety.util.attacher;

import com.xjst.skysweety.base.ViewInitializationProvider;

public interface ViewInitializationNaviProvider extends NaviComponentProvider, ViewInitializationProvider {
    default ViewInitializationNaviAttacher getViewInitializationAttacher() {
        return NaviComponentProvider.getAttacher(ViewInitializationNaviAttacher.class, this);
    }

    default void initViewInitialization() {
        getViewInitializationAttacher().setProvider(this);
    }
}
