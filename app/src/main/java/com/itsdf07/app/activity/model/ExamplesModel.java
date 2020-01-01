package com.itsdf07.app.activity.model;

import com.itsdf07.app.R;
import com.itsdf07.app.activity.bean.ExamplesItemBean;
import com.itsdf07.app.activity.contracts.ExamplesContracts;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class ExamplesModel implements ExamplesContracts.IExamplesModel {
    private static final String TAG = "ExamplesModel";

    @Override
    public List<ExamplesItemBean> makeExamplesList() {

        ExamplesItemBean childrenData = new ExamplesItemBean();
        childrenData.setItemContent("Ping");
        childrenData.setItemMark("ping网络是否通畅");

        List<ExamplesItemBean> childDatas = new ArrayList<>();
        childDatas.add(childrenData);
        childDatas.add(childrenData);

        List<ExamplesItemBean> datas = new ArrayList<>();
        ExamplesItemBean groupData = new ExamplesItemBean();
        groupData.setItemContent("网络相关");
        groupData.setChildren(childDatas);
        datas.add(groupData);
        datas.add(groupData);
        return datas;
    }

    private ExamplesItemBean makeItemDate(){
        ExamplesItemBean bean = new ExamplesItemBean();
        bean.setItemContent("网络相关");
        bean.setItemIcon(R.mipmap.ic_launcher);

        List<ExamplesItemBean> lists = new ArrayList<>();
        ExamplesItemBean bean1 = new ExamplesItemBean();
        bean1.setItemContent("网络相关");
        bean1.setItemIcon(R.mipmap.ic_launcher);
        lists.add(bean1);
        lists.add(bean1);
        lists.add(bean1);

        return bean;
    }
}
