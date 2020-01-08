package com.itsdf07.app.activity.contracts;

import android.app.Activity;


import com.itsdf07.app.framework.mvp.model.IBaseMvpModel;
import com.itsdf07.app.framework.mvp.presenter.IBaseMvpPresenter;
import com.itsdf07.app.framework.mvp.view.IBaseMvpView;
import com.itsdf07.lib.utils.ble.bean.BLEChannelSetting;
import com.itsdf07.lib.utils.ble.bean.BLEPublicSetting;
import com.itsdf07.lib.utils.ble.client.scan.BLEScanResult;

import java.util.ArrayList;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public interface BLEContracts<T> {
    interface IBLEView extends IBaseMvpView<Activity> {
        /**
         * 更新蓝牙连接状态
         *
         * @param status
         */
        void updateBLEConnectStatus(int status);

        void updateBLEOperateBtn(boolean operating);
    }

    interface IBLEPresenter extends IBaseMvpPresenter {
        void setBLEScanResult(BLEScanResult bleScanResult);

        BLEScanResult getBLEScanResult();

        void onConnectedBLE();

        void onDisConnectedBLE();

        void writeData();

        void readData();

        BLEPublicSetting getBLEPublicSetting();

        BLEChannelSetting getBLEChannelSetting(int position);
    }

    interface IBLEModel extends IBaseMvpModel {
        BLEPublicSetting getBLEPublicSetting();

        BLEChannelSetting getBLEChannelSetting(int position);


        /**
         * 设备握手协议头
         *
         * @return
         */
        ArrayList<byte[][]> handshakeProtocol();


        /**
         * 获取公共协议写入数据包
         *
         * @param blePublicSetting
         * @return
         */
        byte[] getBLEPublicDataPackage(BLEPublicSetting blePublicSetting);

        /**
         * 获取频道协议写入数据包
         *
         * @param bleChannelSetting
         * @return
         */
        byte[] getChannelDataPackage(BLEChannelSetting bleChannelSetting);

        String demical2Hex(int demical);
    }
}
