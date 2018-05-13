package com.xjst.skysweety.util.delegate.component;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public final class Event<P> {
 public static final Event<Bundle> ON_CREATE=new Event<>();
 public static final Event<Integer> SET_THEME=new Event<>();
 public static final Event<Bundle> ON_POST_CREATE=new Event<>();
 public static final Event<Void> GET_SUPPORT_ACTION_BAR=new Event<>();
 public static final Event<Toolbar> SET_SUPPORT_ACTION_BAR=new Event<>();
 public static final Event<Void> GET_MENU_INFLATER=new Event<>();
 public static final Event<Integer> SET_CONTENT_VIEW_ID=new Event<>();
}
