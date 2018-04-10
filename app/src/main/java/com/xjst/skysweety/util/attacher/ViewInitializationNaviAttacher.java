package com.xjst.skysweety.util.attacher;

import android.app.Activity;
import android.app.Fragment;

import com.trello.navi2.Event;
import com.trello.navi2.NaviComponent;
import com.xjst.skysweety.base.ViewInitializationProvider;

public class ViewInitializationNaviAttacher extends NaviComponentAttacher {
    private ViewInitializationProvider provider;

    public static ViewInitializationNaviAttacher attach(NaviComponent component) {
        return attach(ViewInitializationNaviAttacher.class, component);
    }

    protected ViewInitializationNaviAttacher(NaviComponent target) {
        super(target);
        init();
    }

    private void init() {
        if (target instanceof Fragment || target instanceof android.support.v4.app.Fragment) {
            target.addListener(Event.VIEW_CREATED, viewCreated -> {
                if (target instanceof LayoutNaviProvider) {
                    ((LayoutNaviProvider) target).getLayoutAttacher().forceInitView();
                }
                if (provider != null) provider.initView();
            });
        } else if (target instanceof Activity) {
            target.addListener(Event.CREATE, bundle -> {
                if (target instanceof LayoutNaviProvider) {
                    ((LayoutNaviProvider) target).getLayoutAttacher().forceInitView();
                }
                if (provider != null) provider.initView();
            });
        }
    }

    public void setProvider(ViewInitializationProvider provider) {
        this.provider = provider;
    }

}
