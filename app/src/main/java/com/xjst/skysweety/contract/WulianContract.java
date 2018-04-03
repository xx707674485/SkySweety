package com.xjst.skysweety.contract;

/**
 * 作者：zx on 2018/3/27 15:31
 * 描述:物联接口连接类
 */
public interface WulianContract {

    /**
     * 获取物联数据
     */
    interface WulianModel {
        void getWulianList();

        void getWulianDetail();

    }

    /**
     * MVP 物联连接接口wulianPresenter
     */
    interface WulianPresenter {
    }

    /**
     * 物联视图逻辑接口
     */
    interface WulianView {

    }


}
