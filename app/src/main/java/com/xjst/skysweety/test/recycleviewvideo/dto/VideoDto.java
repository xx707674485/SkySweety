package com.xjst.skysweety.test.recycleviewvideo.dto;

import com.xjst.publiclibrary.recycleviewadapthelp.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * 作者：zx on 2018/3/22 17:03
 * 描述:
 */
public class VideoDto implements Serializable {
    public String id;
    public String videoName;
    public String localPath;
    public String netUrl;
    public String videoDesc;
    public String imageLocalPath;
    public String imageNetPath;
    public String itemKind;
    public String time;
}
