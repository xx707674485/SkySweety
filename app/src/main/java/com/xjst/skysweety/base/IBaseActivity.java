package com.xjst.skysweety.base;

import com.trello.navi2.component.support.NaviAppCompatActivity;
import com.xjst.skysweety.util.attacher.ViewInitializationNaviProvider;

public abstract class IBaseActivity extends NaviAppCompatActivity implements BaseActivityView, ViewInitializationNaviProvider {
    {
        initViewInitialization();
    }
}
