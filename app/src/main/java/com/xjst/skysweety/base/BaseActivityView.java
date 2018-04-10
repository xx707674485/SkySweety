package com.xjst.skysweety.base;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.navi.NaviLifecycle;

import java.util.WeakHashMap;

import io.reactivex.Observable;

public interface BaseActivityView extends BaseView, LifecycleProvider<ActivityEvent> {
    WeakHashMap<BaseView, LifecycleProvider<ActivityEvent>> CACHE_MAP = new WeakHashMap<>();

    static LifecycleProvider<ActivityEvent> getDelegate(BaseView provider) {
        LifecycleProvider<ActivityEvent> delegate = CACHE_MAP.get(provider);
        if (delegate == null) {
            delegate = NaviLifecycle.createActivityLifecycleProvider(provider);
            CACHE_MAP.put(provider, delegate);
        }
        return delegate;
    }

    @NonNull
    @Override
    default <T> LifecycleTransformer<T> bindToLifecycle() {
       return getDelegate(this).bindToLifecycle();
    }

    @NonNull
    @Override
   default  <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event){
        return getDelegate(this).bindUntilEvent(event);
    }

    @NonNull
    @Override
    default Observable<ActivityEvent> lifecycle(){
        return getDelegate(this).lifecycle();
    }
}
