package com.xjst.skysweety.test.recycleviewvideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.xjst.publiclibrary.nicevideoplayer.NiceVideoPlayer;
import com.xjst.publiclibrary.nicevideoplayer.NiceVideoPlayerManager;
import com.xjst.publiclibrary.nicevideoplayer.TxVideoPlayerController;
import com.xjst.publiclibrary.recycleviewadapthelp.BaseQuickAdapter;
import com.xjst.publiclibrary.recycleviewadapthelp.BaseViewHolder;
import com.xjst.skysweety.R;
import com.xjst.skysweety.test.eventbus.dto.Student;
import com.xjst.skysweety.test.recycleviewvideo.dto.CameraActivity;
import com.xjst.skysweety.test.recycleviewvideo.dto.VideoDto;
import com.xjst.skysweety.ui.MainActivity;
import com.xjst.skysweety.util.StringUtils;
import com.xjst.skysweety.util.ToastUtils;
import com.xjst.skysweety.view.MyPopDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;

/**
 * 作者：zx on 2018/3/22 17:48
 * 描述:
 */
public class VideoItemActivity extends AppCompatActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    private VideoItemAdapt videoItemAdapt;
    private List<VideoDto> mDatas = new ArrayList<>();
    private NiceVideoPlayer mNiceVideoPlayer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        videoItemAdapt = new VideoItemAdapt();
        recyclerview.setAdapter(videoItemAdapt);
        videoItemAdapt.setmOnitemClickListeren(new OnItemClickListeren() {
            @Override
            public void onImgClick(VideoDto item) {
                if (item.itemKind.equals("0")) {//视频
                    MyPopDialog myPopDialog = new MyPopDialog(VideoItemActivity.this, R.layout.dialog_video_win);
                    myPopDialog.show();

                    mNiceVideoPlayer = (NiceVideoPlayer) myPopDialog.findViewById(R.id.nice_video_player);
                    mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // IjkPlayer or MediaPlayer
                    String videoUrl = item.localPath;
                    mNiceVideoPlayer.setUp(videoUrl, null);
                    TxVideoPlayerController controller = new TxVideoPlayerController(VideoItemActivity.this);
                    controller.setTitle(item.videoName);
                    Glide.with(VideoItemActivity.this)
                            .load(item.imageLocalPath)
                            .placeholder(R.drawable.img_default)
                            .crossFade()
                            .into(controller.imageView());
                    mNiceVideoPlayer.setController(controller);
                    mNiceVideoPlayer.start();
                    if (mNiceVideoPlayer == NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer()) {
                        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
                    }
                } else {//图片
                    ToastUtils.showShort("点击了图片");
                }
            }
        });
//设置 Header 为 BezierRadar 样式
        refreshLayout.setRefreshHeader(new BezierRadarHeader(this).setEnableHorizontalDrag(true));
//设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoItemActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(VideoDto video) {
        if (null != video) {
            videoItemAdapt.addData(0, video);
            videoItemAdapt.notifyDataSetChanged();
        }
    }

    public void enterTinyWindow(View view) {
        if (mNiceVideoPlayer.isIdle()) {
            Toast.makeText(this, "要点击播放后才能进入小窗口", Toast.LENGTH_SHORT).show();
        } else {
            mNiceVideoPlayer.enterTinyWindow();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventmsg(String message) {
        ToastUtils.showShort(message);
    }

    class VideoItemAdapt extends BaseQuickAdapter<VideoDto, BaseViewHolder> {
        private OnItemClickListeren mOnitemClickListeren;

        public void setmOnitemClickListeren(OnItemClickListeren mOnitemClickListeren) {
            this.mOnitemClickListeren = mOnitemClickListeren;
        }

        public VideoItemAdapt() {
            super(R.layout.item_video);
        }

        @Override
        protected void convert(BaseViewHolder helper, VideoDto item) {
            helper.setText(R.id.tv_video_name, item.videoName);
            helper.setText(R.id.tv_video_des, item.videoDesc);
            helper.setText(R.id.tv_video_time, item.time);
            RelativeLayout relativeLayout = (RelativeLayout) helper.getView(R.id.rl_thumbnail);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (StringUtils.isEmpty(item.itemKind))
                        return;
                    mOnitemClickListeren.onImgClick(item);
                }
            });
            ImageView ivphoto = (ImageView) helper.getView(R.id.iv_thumbnail);
            ImageView ivVideo = (ImageView) helper.getView(R.id.iv_enable_play);
            /**
             * 视频
             */
            if (item.itemKind.equals("0")) {
                ivVideo.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(item.localPath).centerCrop().placeholder(R.drawable.img_default).into(ivphoto);
            }
            /**
             * 图片
             */
            else if (item.itemKind.equals("1")) {
                ivVideo.setVisibility(View.GONE);
                Glide.with(mContext).load(item.imageLocalPath).centerCrop().placeholder(R.drawable.img_default).into(ivphoto);
            } else {
                ivVideo.setVisibility(View.GONE);
                ivphoto.setImageDrawable(getResources().getDrawable(R.drawable.ic_error));
            }

        }

    }

    public interface OnItemClickListeren {
        void onImgClick(VideoDto item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
}
