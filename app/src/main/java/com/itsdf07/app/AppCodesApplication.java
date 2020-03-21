package com.itsdf07.app;

import android.app.Application;
import android.util.Log;

import com.itsdf07.app.config.AppConfig;
import com.itsdf07.lib.alog.ALog;
import com.itsdf07.lib.alog.ALogLevel;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/3/20
 */
public class AppCodesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(AppConfig.DTag, "AppCodesApplication:onCreate->isLog=" + AppConfig.isLog + ",DTag=" + AppConfig.DTag + ",isLog2File=" + AppConfig.isLog2File);
        ALog.init()
                .setLogLevel(AppConfig.isLog ? ALogLevel.FULL : ALogLevel.NONE) //是否打印log
                .setTag(AppConfig.DTag) //自定义tag
                .setLog2Local(AppConfig.isLog2File ? true : false); //设置是否本地存储log记录
    }
}
