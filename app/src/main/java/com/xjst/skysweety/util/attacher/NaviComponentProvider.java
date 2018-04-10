package com.xjst.skysweety.util.attacher;

import android.support.v4.util.ArrayMap;

import com.trello.navi2.NaviComponent;

import java.util.WeakHashMap;

public interface NaviComponentProvider extends NaviComponent {
    ArrayMap<Class<? extends NaviComponentAttacher>, WeakHashMap<NaviComponentProvider, NaviComponentAttacher>> CLASS_WEAK_HASH_MAP_ARRAY_MAP = new ArrayMap<>();

    static <T extends NaviComponentAttacher> T getAttacher(Class<T> clazz, NaviComponentProvider provider) {
        WeakHashMap<NaviComponentProvider, NaviComponentAttacher> temp = CLASS_WEAK_HASH_MAP_ARRAY_MAP.get(clazz);
        if (temp == null) {
            temp = new WeakHashMap<>();
            CLASS_WEAK_HASH_MAP_ARRAY_MAP.put(clazz, temp);
        }
        NaviComponentAttacher attacher = temp.get(provider);
        if (attacher == null) {
            attacher = NaviComponentAttacher.attach(clazz, provider);
            temp.put(provider, attacher);
        }
        try {
            return (T) attacher;
        } catch (Exception e) {
            return null;
        }

    }
}
