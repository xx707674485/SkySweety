package com.xjst.skysweety.base;

import android.app.Fragment;
import android.content.Context;

public interface ContextProvider {
    default Context getContext() {
        if (this instanceof Context) return (Context) this;
        if (this instanceof Fragment) return ((Fragment) this).getActivity();
        if (this instanceof android.support.v4.app.Fragment)
            return ((android.support.v4.app.Fragment) this).getActivity();
        return null;
    }

}
