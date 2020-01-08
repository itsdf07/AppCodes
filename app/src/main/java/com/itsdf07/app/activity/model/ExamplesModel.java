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

        ExamplesItemBean childrenDataPing = new ExamplesItemBean();
        childrenDataPing.setItemContent("Ping");
        childrenDataPing.setItemMark("ping网络是否通畅");

        List<ExamplesItemBean> childDatasNet = new ArrayList<>();
        childDatasNet.add(childrenDataPing);

        ExamplesItemBean groupDataNet = new ExamplesItemBean();
        groupDataNet.setItemContent("网络相关");
        groupDataNet.setChildren(childDatasNet);
        //---------------------------------------------------

        ExamplesItemBean childrenDataBle = new ExamplesItemBean();
        childrenDataBle.setItemContent("BLE");
        childrenDataBle.setItemMark("某蓝牙BLE设备读写数据");

        List<ExamplesItemBean> childDatasDevice = new ArrayList<>();
        childDatasDevice.add(childrenDataBle);

        ExamplesItemBean groupDataDevice = new ExamplesItemBean();
        groupDataDevice.setItemContent("设备相关");
        groupDataDevice.setChildren(childDatasDevice);

        //---------------------------------------------------

        List<ExamplesItemBean> datas = new ArrayList<>();

        datas.add(groupDataNet);
        datas.add(groupDataDevice);
        return datas;
    }
}
