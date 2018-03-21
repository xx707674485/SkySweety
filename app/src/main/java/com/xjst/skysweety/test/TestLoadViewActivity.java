package com.xjst.skysweety.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xjst.publiclibrary.avloadingview.AVLoadingIndicatorView;
import com.xjst.skysweety.R;


/**
 */

public class TestLoadViewActivity extends AppCompatActivity {

    private AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_loadview_activity);

        String indicator = INDICATORS[0];
        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator(indicator);
    }

    public void hideClick(View view) {
        avi.smoothToHide();
    }

    public void showClick(View view) {
        avi.smoothToShow();
    }


    private static final String[] INDICATORS = new String[]{
            "BallPulseIndicator",
            "BallGridPulseIndicator",
            "BallClipRotateIndicator",
            "BallClipRotatePulseIndicator",
            "SquareSpinIndicator",
            "BallClipRotateMultipleIndicator",
            "BallPulseRiseIndicator",
            "BallRotateIndicator",
            "CubeTransitionIndicator",
            "BallZigZagIndicator",
            "BallZigZagDeflectIndicator",
            "BallTrianglePathIndicator",
            "BallScaleIndicator",
            "LineScaleIndicator",
            "LineScalePartyIndicator",
            "BallScaleMultipleIndicator",
            "BallPulseSyncIndicator",
            "BallBeatIndicator",
            "LineScalePulseOutIndicator",
            "LineScalePulseOutRapidIndicator",
            "BallScaleRippleIndicator",
            "BallScaleRippleMultipleIndicator",
            "BallSpinFadeLoaderIndicator",
            "LineSpinFadeLoaderIndicator",
            "TriangleSkewSpinIndicator",
            "PacmanIndicator",
            "BallGridBeatIndicator",
            "SemiCircleSpinIndicator",
            "com.wang.avi.sample.MyCustomIndicator"
    };
}
