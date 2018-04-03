package com.xjst.skysweety.test.recycleviewvideo.dto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import com.xjst.publiclibrary.camra.JCameraView;
import com.xjst.publiclibrary.camra.listener.ClickListener;
import com.xjst.publiclibrary.camra.listener.ErrorListener;
import com.xjst.publiclibrary.camra.listener.JCameraListener;
import com.xjst.publiclibrary.camra.util.DeviceUtil;
import com.xjst.publiclibrary.camra.util.FileUtil;
import com.xjst.skysweety.R;
import com.xjst.skysweety.test.eventbus.dto.Student;
import com.xjst.skysweety.test.recycleviewvideo.VideoItemActivity;
import com.xjst.skysweety.util.TimeUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {
    private JCameraView jCameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_camera);
        jCameraView = (JCameraView) findViewById(R.id.jcameraview);
        //设置视频保存路径
        jCameraView.setSaveVideoPath(Environment.getExternalStorageDirectory().getPath() + File.separator + "JCamera");
        jCameraView.setFeatures(JCameraView.BUTTON_STATE_BOTH);
        jCameraView.setTip("轻按拍照/长按录制视频");
        jCameraView.setMediaQuality(JCameraView.MEDIA_QUALITY_HIGH);
        jCameraView.setErrorLisenter(new ErrorListener() {
            @Override
            public void onError() {
                //错误监听
                Log.i("CJT", "camera error");
//                Intent intent = new Intent();
//                setResult(103, intent);
                EventBus.getDefault().post("添加数据错误");
                finish();
            }

            @Override
            public void AudioPermissionError() {
                Toast.makeText(CameraActivity.this, "给点录音权限可以?", Toast.LENGTH_SHORT).show();
            }
        });
        //JCameraView监听
        jCameraView.setJCameraLisenter(new JCameraListener() {
            @Override
            public void captureSuccess(Bitmap bitmap) {
                //获取图片bitmap
//                Log.i("JCameraView", "bitmap = " + bitmap.getWidth());
                String path = FileUtil.saveBitmap("JCamera", bitmap);
//                Intent intent = new Intent();
//                intent.putExtra("path", path);
//                setResult(101, intent);
                VideoDto temp = new VideoDto();
                temp.itemKind = "1";
                temp.imageLocalPath = path;
                temp.time = TimeUtils.date2String(new Date(), TimeUtils.ChINESE_FORMAT);
                temp.videoName = "图片" + temp.time;
                temp.videoDesc = "拍照生成的图片";
                EventBus.getDefault().post(temp);
                finish();
            }

            @Override
            public void recordSuccess(String url, Bitmap firstFrame) {
                //获取视频路径
                String path = FileUtil.saveBitmap("JCamera", firstFrame);
                Log.i("CJT", "url = " + url + ", Bitmap = " + path);
//                Intent intent = new Intent();
//                intent.putExtra("path", path);
//                intent.putExtra("videourl", url);
//                setResult(102, intent);
                VideoDto temp = new VideoDto();
                temp.itemKind = "0";
                temp.imageLocalPath = path;
                temp.localPath = url;
                temp.time = TimeUtils.date2String(new Date(), TimeUtils.ChINESE_FORMAT);
                temp.videoName = "视频" + temp.time;
                temp.videoDesc = "录像产生的视频";
                EventBus.getDefault().post(temp);
                finish();
            }

            @Override
            public void quit() {

            }
        });

        jCameraView.setLeftClickListener(new ClickListener() {
            @Override
            public void onClick() {
                CameraActivity.this.finish();
            }
        });
        jCameraView.setRightClickListener(new ClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(CameraActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
        });

        Log.i("CJT", DeviceUtil.getDeviceModel());
    }

    @Override
    protected void onStart() {
        super.onStart();
        //全屏显示
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        jCameraView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        jCameraView.onPause();
    }
}
