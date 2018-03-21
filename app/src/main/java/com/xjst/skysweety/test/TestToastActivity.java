package com.xjst.skysweety.test;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xjst.publiclibrary.loadtoast.LoadToast;
import com.xjst.skysweety.R;
//import com.xjst.skysweety.databinding.ActivityMainBinding;
import com.xjst.skysweety.util.TimeUtils;

import java.util.Date;

/**
 * 作者：zx on 2018/3/14 18:00
 * 描述:
 */
public class TestToastActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final String text = "加载失败。。。";
        final LoadToast lt = new LoadToast(this)
                .setText(text)
                .setTranslationY(1000)
                .setBorderColor(Color.LTGRAY)
                .setBorderWidthPx(1)
                .setProgressColor(Color.WHITE)
                .show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    lt.hide();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

       String time= TimeUtils.date2String(new Date(),TimeUtils.ChINESE_FORMAT);
    }


}
