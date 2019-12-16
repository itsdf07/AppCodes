package com.itsdf07.app.framework.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public abstract class BaseActivity extends AppCompatActivity {
    public String TAG = this.getClass().getSimpleName();
    /**
     * 是否打印框架Log:true-打印;false-不打印
     */
    public boolean isBaseActivityLog = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LibMvpConfig.isShowLibMvpLog) {
            Log.v(TAG, "onCreate->...");
        }
        int resLayoutId = this.getLayoutId();
        if (resLayoutId > 0) {
            setContentView(resLayoutId);
        } else {
            if (LibMvpConfig.isShowLibMvpLog) {
                Log.w(TAG, "onCreate->请在getLayoutId中设置您的UI布局");
            }
        }
        onBeforeView();
        onInitView();
        onAfterView();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 用来处理UI控件初始化之前要做的事情
     */
    public abstract void onBeforeView();


    /**
     * 初始化UI控件
     */
    public abstract void onInitView();


    /**
     * 初始化UI控件之后要做且与Presenter无关的事情，切记，与Presenter无关，因为此时Presenter尚未初始化
     */
    public abstract void onAfterView();

}
