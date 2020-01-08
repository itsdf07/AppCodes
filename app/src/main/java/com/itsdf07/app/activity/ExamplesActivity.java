package com.itsdf07.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ExpandableListView;

import com.itsdf07.app.R;
import com.itsdf07.app.activity.adapter.ExamplesElvAdapter;
import com.itsdf07.app.activity.contracts.ExamplesContracts;
import com.itsdf07.app.activity.presenter.ExamplesPresenter;
import com.itsdf07.app.framework.mvp.BaseMvpActivity;
import com.itsdf07.lib.alog.ALog;

import java.util.ArrayList;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class ExamplesActivity extends BaseMvpActivity<ExamplesPresenter> implements
        ExamplesContracts.IExamplesView {
    private ExpandableListView elvExamples;
    private ExamplesElvAdapter examplesElvAdapter;

    @Override
    public Activity getSelfActivity() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_examples;
    }

    @Override
    public void onBeforeView() {
    }

    @Override
    public void onInitView() {
        elvExamples = (ExpandableListView) findViewById(R.id.elv_examples);
//        elvChannelGroup.setGroupIndicator(null);//去掉展开箭头
        elvExamples.setSelector(new ColorDrawable(Color.TRANSPARENT));//去除点击后出现的黄色背景
        elvExamples.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                ALog.eTag(TAG, "groupPosition:%s,id:%s", groupPosition, id);
                return false;
            }
        });
        elvExamples.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ALog.eTag(TAG, "groupPosition:%s,childPosition:%s,id:%s", groupPosition, childPosition, id);
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                startActivity(new Intent(ExamplesActivity.this, PingActivity.class));
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                startActivity(new Intent(ExamplesActivity.this, BLEScanActivity.class));
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onAfterView() {

    }

    @Override
    public ExamplesPresenter onInitPresenter() {
        return new ExamplesPresenter(this);
    }

    @Override
    public void onAfterPresenter() {
        examplesElvAdapter = new ExamplesElvAdapter(this, presenter.offerExamplesList());
        elvExamples.setAdapter(examplesElvAdapter);
        elvExamples.expandGroup(0);
    }
}
