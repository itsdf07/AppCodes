package com.itsdf07.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.itsdf07.lib.alog.ALog;

/**
 * @Description: 打印Activity相关的生命周期内容
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/1/16
 */
public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ALog.dTag("ActivityLifeCycle", "表示Activity正在被创建，常用来初始化工作，比如调用setContentView加载界面布局资源，初始化Activity所需数据等；");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ALog.dTag("ActivityLifeCycle", "表示Activity正在重新启动，一般情况下，当前Acitivty从不可见重新变为可见时，OnRestart就会被调用；");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ALog.dTag("ActivityLifeCycle", "表示Activity正在被启动，此时Activity可见但不在前台，还处于后台，无法与用户交互；");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ALog.dTag("ActivityLifeCycle", "表示Activity获得焦点，此时Activity可见且在前台并开始活动，这是与onStart的区别所在；");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ALog.dTag("ActivityLifeCycle", "表示Activity正在停止，此时可做一些存储数据、停止动画等工作，但是不能太耗时，因为这会影响到新Activity的显示，onPause必须先执行完，新Activity的onResume才会执行；");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ALog.dTag("ActivityLifeCycle", "表示Activity即将停止，可以做一些稍微重量级的回收工作，比如注销广播接收器、关闭网络连接等，同样不能太耗时；");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ALog.dTag("ActivityLifeCycle", "表示Activity即将被销毁，这是Activity生命周期中的最后一个回调，常做回收工作、资源释放；");
    }
}
