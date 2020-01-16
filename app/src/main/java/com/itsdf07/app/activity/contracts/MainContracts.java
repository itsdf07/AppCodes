package com.itsdf07.app.activity.contracts;

import android.app.Activity;
import android.content.Context;

import com.itsdf07.app.framework.mvp.model.IBaseMvpModel;
import com.itsdf07.app.framework.mvp.presenter.IBaseMvpPresenter;
import com.itsdf07.app.framework.mvp.view.IBaseMvpView;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public interface MainContracts {
    interface IMainView extends IBaseMvpView<Activity> {
    }

    interface IMainPresenter extends IBaseMvpPresenter {
        /**
         * 获取设备的相关信息
         *
         * @return
         */
        String getEquipmentInfo();
    }

    interface IMainModel extends IBaseMvpModel {

        String equipmentInfo(Context context);

    }
}
