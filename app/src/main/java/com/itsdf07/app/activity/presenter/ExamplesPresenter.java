package com.itsdf07.app.activity.presenter;

import com.itsdf07.app.activity.bean.ExamplesItemBean;
import com.itsdf07.app.activity.contracts.ExamplesContracts;
import com.itsdf07.app.activity.contracts.MainContracts;
import com.itsdf07.app.activity.model.ExamplesModel;
import com.itsdf07.app.activity.model.MainModel;
import com.itsdf07.app.framework.mvp.presenter.BaseMvpPresenter;

import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class ExamplesPresenter extends BaseMvpPresenter<ExamplesContracts.IExamplesView> implements ExamplesContracts.IExamplesPresenter {
    ExamplesContracts.IExamplesModel iExamplesModel;

    public ExamplesPresenter(ExamplesContracts.IExamplesView view) {
        super(view);
        iExamplesModel = new ExamplesModel();
    }


    @Override
    public void detachView() {
        super.detachView();
    }


    @Override
    public List<ExamplesItemBean> offerExamplesList() {
        return iExamplesModel.makeExamplesList();
    }
}
