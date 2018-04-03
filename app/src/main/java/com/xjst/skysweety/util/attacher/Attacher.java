package com.xjst.skysweety.util.attacher;

import android.util.Log;

public class Attacher {
    private static final String TAG = "Attacher";
    CharSequence args1, args2;
    int args3 = -10;

    public Attacher(CharSequence args1, CharSequence args2) {
        this.args1 = args1;
        this.args2 = args2;
        init();
    }
    public Attacher(CharSequence args1, int args3, CharSequence args2){
        this.args1 = args1;
        this.args2 = args2;
        this.args3 = args3;
        init();
    }

    public Attacher(CharSequence args1) {
        this.args1 = args1;
        init();
    }

    private void init() {
        Log.d(TAG, "init: args1=" + args1);
        Log.d(TAG, "init: args2=" + args2);
        Log.d(TAG, "init: args3=" + args3);
    }
}
