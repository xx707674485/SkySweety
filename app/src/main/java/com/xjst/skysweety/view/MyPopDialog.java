package com.xjst.skysweety.view;


import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager.LayoutParams;

import com.xjst.skysweety.R;


/**
 * 弹出框 dialog
 *
 * @author zcwl888
 */
public class MyPopDialog extends Dialog {

    public MyPopDialog(Context context, int resouceId) {
        super(context, R.style.ThemeTransparent);
        setContentView(resouceId);//R.layout.mycar_location_onoff
        // 单击dialog之外的地方，可以dismiss掉dialog。
        setCanceledOnTouchOutside(true);
        //
        LayoutParams a = getWindow().getAttributes();
        getWindow().addFlags(LayoutParams.FLAG_DIM_BEHIND);//控制后面的activity是否有阴影
//        a.width = getWindow().getWindowManager().getDefaultDisplay().getWidth() / 16 * 9;
        a.width = LayoutParams.MATCH_PARENT;
        a.height = LayoutParams.WRAP_CONTENT;
        a.dimAmount = 0.6f; // 背景遮盖，0.0f表示无阴影
        getWindow().setGravity(Gravity.CENTER);//getWindow()代表整个窗体
        getWindow().setAttributes(a);

    }

}
