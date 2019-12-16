package com.itsdf07.app.activity.contracts;

import android.app.Activity;

import com.itsdf07.app.activity.bean.ExamplesItemBean;
import com.itsdf07.app.framework.mvp.model.IBaseMvpModel;
import com.itsdf07.app.framework.mvp.presenter.IBaseMvpPresenter;
import com.itsdf07.app.framework.mvp.view.IBaseMvpView;

import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public interface ExamplesContracts {
    interface IExamplesView extends IBaseMvpView<Activity> {
    }

    interface IExamplesPresenter extends IBaseMvpPresenter {
        /**
         * 提供Examples列表数据
         *
         * @return
         */
        List<ExamplesItemBean> offerExamplesList();
    }

    interface IExamplesModel extends IBaseMvpModel {
        /**
         * 生成Examples列表数据
         *
         * @return
         */
        List<ExamplesItemBean> makeExamplesList();
    }
}
