package com.itsdf07.app.activity.contracts;

import android.app.Activity;

import com.itsdf07.app.framework.mvp.model.IBaseMvpModel;
import com.itsdf07.app.framework.mvp.presenter.IBaseMvpPresenter;
import com.itsdf07.app.framework.mvp.view.IBaseMvpView;
import com.itsdf07.lib.utils.ble.LinkedHashMap;
import com.itsdf07.lib.utils.ble.client.scan.BLEScanResult;


/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public interface BLEScanContracts {
    interface IBLEScanView extends IBaseMvpView<Activity> {
        /**
         * 刷新整个适配器内容
         */
        void notifyUpdata2Adapter();

        /**
         * 针对列表的某一项进行刷新
         *
         * @param index
         */
        void notifyUpdata2Item(int index);
    }

    interface IBLEScanPresenter extends IBaseMvpPresenter {
        LinkedHashMap<String, BLEScanResult> getBLEs();

        void startScan();

        void stopScan();
    }

    interface IBLEScanModel extends IBaseMvpModel {
    }
}
