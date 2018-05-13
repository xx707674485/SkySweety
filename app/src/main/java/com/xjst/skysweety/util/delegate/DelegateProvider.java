package com.xjst.skysweety.util.delegate;


import android.support.v4.util.ArrayMap;

public interface DelegateProvider<T extends Delegate> {
    ArrayMap<DelegateProvider, Delegate> ACTIVITY_DELEGATE_ARRAY_MAP = new ArrayMap<>();

    default T getComponentDelegate() {
        return (T) ACTIVITY_DELEGATE_ARRAY_MAP.get(this);
    }

//    default void initActivityDelegateProvider(T delegate) {
//        seComponentDelegate(delegate);
//    }

    default void seComponentDelegate(T delegate) {
        ACTIVITY_DELEGATE_ARRAY_MAP.put(this, delegate);
    }

    default void destroy() {
        ACTIVITY_DELEGATE_ARRAY_MAP.remove(this);
    }
}
