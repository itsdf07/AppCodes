package com.itsdf07.app.activity.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;

import com.itsdf07.app.activity.model.NetPingModel;
import com.itsdf07.app.framework.mvp.presenter.BaseMvpPresenter;
import com.itsdf07.app.activity.contracts.NetPingContracts;
import com.itsdf07.app.framework.mvp.view.IBaseMvpView;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/27
 */
public class NetPingPresenter extends BaseMvpPresenter implements NetPingContracts.INetPingPresenter {
    NetPingContracts.INetPingModel iNetPingModel;
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            String pingResult = (String) msg.obj;
            getView().updateInfo(pingResult);
        }
    };

    public NetPingPresenter(IBaseMvpView view) {
        super(view);
        iNetPingModel = new NetPingModel();
    }

    @Override
    public void onPingFromInput(final String host, final int packageCount, final int packageSize, final int delayTime) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                iNetPingModel.ping(host, packageCount, packageSize, delayTime, new iNetPingModel.IPingResultCallback() {
                    @Override
                    public void pingResultCallback(final String pingResult) {
                        Message msg = mMainHandler.obtainMessage();
                        msg.obj = pingResult;
                        msg.sendToTarget();
                    }

                    @Override
                    public void pingResultErr(final String errResult) {
                        Message msg = mMainHandler.obtainMessage();
                        msg.obj = errResult;
                        msg.sendToTarget();
                    }

                    @Override
                    public void pingOver(String host) {

                    }
                });
            }
        }).start();
    }

    @Override
    public void onPingFromService(String group, int packageCount, int packageSize, int delayTime) {

    }
}
