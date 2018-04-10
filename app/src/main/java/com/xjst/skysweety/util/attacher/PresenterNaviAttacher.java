package com.xjst.skysweety.util.attacher;

import com.trello.navi2.Event;
import com.trello.navi2.NaviComponent;
import com.xjst.skysweety.base.BasePresenter;

public class PresenterNaviAttacher<P extends BasePresenter> extends NaviComponentAttacher {
    private PresenterCreator<P> creator;

    private P presenter;

    public static PresenterNaviAttacher attach(NaviComponent component) {
        return attach(PresenterNaviAttacher.class, component);
    }

    protected PresenterNaviAttacher(NaviComponent target) {
        super(target);
        init();
    }

    private void init() {
        if (target == null) return;
        target.addListener(Event.CREATE, bundle -> setCreator());

    }

    private void setCreator() {
        if (creator != null) presenter = creator.createPresenter();
    }

    public void setCreator(PresenterCreator<P> creator) {
        this.creator = creator;
    }

    public P getPresenter() {
        return presenter;
    }

    public interface PresenterCreator<P extends BasePresenter> {
        P createPresenter();
    }
}
