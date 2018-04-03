package com.xjst.skysweety.util.attacher;

import com.trello.navi2.NaviComponent;

public class NaviComponentAttacher extends Attacher<NaviComponent> {

    protected NaviComponentAttacher(NaviComponent target) {
        super(target);
    }


    public static <T extends NaviComponentAttacher> T attach(Class<T> clazz, NaviComponent component) {
        return Attacher.attach(clazz, component);
    }
}
