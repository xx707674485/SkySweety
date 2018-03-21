package com.xjst.skysweety.test.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xjst.skysweety.R;
import com.xjst.skysweety.test.eventbus.dto.Student;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityB extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Student("小花", "18", "女"));
                EventBus.getDefault().post("大帅哥");
                onBackPressed();
            }
        });
    }


//    public void back() {
//        EventBus.getDefault().post(new Student("小花", "18", "女"));
////        EventBus.getDefault().post("大帅哥");
////        onBackPressed();
//    }
}
