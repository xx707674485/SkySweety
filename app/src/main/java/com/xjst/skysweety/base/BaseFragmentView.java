package com.xjst.skysweety.base;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.navi.NaviLifecycle;

import java.util.WeakHashMap;

import io.reactivex.Observable;

public interface BaseFragmentView extends BaseView, LifecycleProvider<FragmentEvent> {
    WeakHashMap<BaseView, LifecycleProvider<FragmentEvent>> CACHE_MAP = new WeakHashMap<>();

    static LifecycleProvider<FragmentEvent> getDelegate(BaseView provider) {
        LifecycleProvider<FragmentEvent> delegate = CACHE_MAP.get(provider);
        if (delegate == null) {
            delegate = NaviLifecycle.createFragmentLifecycleProvider(provider);
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
   default  <T> LifecycleTransformer<T> bindUntilEvent(@NonNull FragmentEvent event){
        return getDelegate(this).bindUntilEvent(event);
    }

    @NonNull
    @Override
    default Observable<FragmentEvent> lifecycle(){
        return getDelegate(this).lifecycle();
    }
}
