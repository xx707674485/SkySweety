package com.xjst.skysweety.test.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xjst.skysweety.R;
import com.xjst.skysweety.test.eventbus.dto.Student;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：zx on 2018/3/19 15:45
 * 描述:
 */
public class ActivityA extends AppCompatActivity {

    @BindView(R.id.text_a)
    TextView textA;
    @BindView(R.id.text_a1)
    TextView textA1;
    @BindView(R.id.btna)
    Button btna;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case 0:
                    Student student = (Student) msg.obj;
                    textA.setText("姓名:" + student.getName() + "   年龄:" + student.getAge() + "   性别:" + student.getSex());
                    break;
                case 1:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ActivityA.this, ActivityB.class);
//                startActivity(intent);
                getData();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Student student) {
        textA.setText("姓名:" + student.getName() + "   年龄:" + student.getAge() + "   性别:" + student.getSex());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent1(String student) {
        textA1.setText("传递的数据是:" + student);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Student student = new Student("小姚", "18", "25");
                Message msg = Message.obtain();
                msg.arg1 = 0;
                msg.obj = student;
                mHandler.sendMessage(msg);
            }
        }).start();
    }




}
