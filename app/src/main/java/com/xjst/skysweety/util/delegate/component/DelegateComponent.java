package com.xjst.skysweety.util.delegate.component;

public interface DelegateComponent {
    <P> void addListener(Event<P> event, Listener<P> listener);

    <P> void removeListener(Listener<P> listener);
}
