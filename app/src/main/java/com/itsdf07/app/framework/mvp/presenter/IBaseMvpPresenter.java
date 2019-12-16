package com.itsdf07.app.framework.mvp.presenter;

/**
 * @Description:
 * @Author itsdf07
 * @Date 2019/12/16
 */
public interface IBaseMvpPresenter {
    /**
     * Activity生命周期结束时，Presenter也清除IView对象，不在持有
     */
    void detachView();
}
