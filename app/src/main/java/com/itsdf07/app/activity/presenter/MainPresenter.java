package com.itsdf07.app.activity.presenter;

import com.itsdf07.app.activity.contracts.MainContracts;
import com.itsdf07.app.activity.model.MainModel;
import com.itsdf07.app.framework.mvp.presenter.BaseMvpPresenter;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class MainPresenter extends BaseMvpPresenter<MainContracts.IMainView> implements MainContracts.IMainPresenter {
    MainContracts.IMainModel iMainModel;

    public MainPresenter(MainContracts.IMainView view) {
        super(view);
        iMainModel = new MainModel();
    }


    @Override
    public void detachView() {
        super.detachView();
    }


}
