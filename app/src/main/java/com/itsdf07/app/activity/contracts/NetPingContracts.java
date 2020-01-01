package com.itsdf07.app.activity.contracts;

import android.app.Activity;

import com.itsdf07.app.activity.bean.ExamplesItemBean;
import com.itsdf07.app.activity.model.NetPingModel;
import com.itsdf07.app.framework.mvp.model.IBaseMvpModel;
import com.itsdf07.app.framework.mvp.presenter.IBaseMvpPresenter;
import com.itsdf07.app.framework.mvp.view.IBaseMvpView;

import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public interface NetPingContracts {
    interface INetPingView extends IBaseMvpView<Activity> {
    }

    interface INetPingPresenter extends IBaseMvpPresenter {
        /**
         * ping目标主机
         *
         * @param host         主机，如域名、IP
         * @param packageCount 发送数据包的数目
         * @param packageSize  发送数据包的大小(byte)
         * @param delayTime    发送数据包的间隔时间(s)
         */
        void onPingFromInput(String host, int packageCount, int packageSize, int delayTime);

        /**
         * ping功能,ping服务器登记过的全部域名
         *
         * @param group        目标主机分组，如TTS、LOC
         * @param packageCount 发送数据包的数目
         * @param packageSize  发送数据包的大小(byte)
         * @param delayTime    发送数据包的间隔时间(s)
         */
        void onPingFromService(String group, int packageCount, int packageSize, int delayTime);
    }

    interface INetPingModel extends IBaseMvpModel {
        /**
         * 从服务器拉取目标主机集合
         *
         * @param group    域名分类，null或者""，即为拉取全部
         * @param callback
         */
        void getHostsFromService(String group, NetPingModel.IHostsRequCallback callback);

        /**
         * ping功能，ping指定域名
         *
         * @param host         主机，如域名、IP
         * @param packageCount 发送数据包的数目
         * @param packageSize  发送数据包的大小(byte)
         * @param delayTime    发送数据包的间隔时间(s)
         * @param callback
         */
        void doPing(String host, int packageCount, int packageSize, int delayTime, NetPingModel.IPingResultCallback callback);

        /**
         * 保存ping出来的新结果数据
         *
         * @param hostMaps
         */
        void addPingResults(HashMap<String, HashMap<String, String>> hostMaps);
    }
}
