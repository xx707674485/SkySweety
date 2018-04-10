package com.xjst.skysweety.util.attacher;

import android.app.Activity;
import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;

import com.trello.navi2.Event;
import com.trello.navi2.NaviComponent;
import com.xjst.skysweety.base.LayoutProvider;

public class LayoutNaviAttacher<V extends ViewDataBinding> extends NaviComponentAttacher {
    private V dataBinding;
    private LayoutProvider layoutProvider;

    public static LayoutNaviAttacher attach(NaviComponent component) {
        return attach(LayoutNaviAttacher.class, component);
    }

    protected LayoutNaviAttacher(NaviComponent target) {
        super(target);
        init();
    }

    private void init() {
        if (target instanceof Fragment || target instanceof android.support.v4.app.Fragment) {
            initFragment();
        } else if (target instanceof Activity) {
            initInActivity((Activity) target);
        }
    }

    private void initInActivity(Activity activity) {
        if (target == null) return;
        target.addListener(Event.CREATE, bundle -> initDataBinding());

    }

    private void initFragment() {
        if (target == null) return;
        target.addListener(Event.CREATE_VIEW, bundle -> initDataBinding());
    }

    private void initDataBinding() {
        if (dataBinding != null) return;
        if (target instanceof Activity) {
            dataBinding = DataBindingUtil.setContentView((Activity) target, layoutProvider.getLayout());
        } else if (target instanceof Fragment || target instanceof android.support.v4.app.Fragment) {
            dataBinding = DataBindingUtil.inflate(LayoutInflater.from(ActicityStackManagerAttacher.getCurrentActivity()), layoutProvider.getLayout(), null, false);

        }
    }

    public void forceInitView() {
        initDataBinding();
    }

    public View getRootView() {
        if (dataBinding != null) return dataBinding.getRoot();
        return null;
    }

    public V getDataBinding() {
        return dataBinding;
    }

    public void setLayoutProvider(LayoutProvider provider) {
        layoutProvider = provider;
    }


}
