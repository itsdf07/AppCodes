package com.itsdf07.app.activity.model;

import android.content.Context;

import com.itsdf07.app.activity.contracts.MainContracts;
import com.itsdf07.lib.utils.EquipmentUtils;
import com.itsdf07.lib.utils.Tools2DeviceInfo;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class MainModel implements MainContracts.IMainModel {
    private static final String TAG = "MainModel";

    @Override
    public String equipmentInfo(Context context) {
        int[] screenPixels = Tools2DeviceInfo.getInstance().getScreenPixels(context);
        return "设备分辨率(宽*高:密度)：" + screenPixels[0] + "*" + screenPixels[1] + ":" + Tools2DeviceInfo.getInstance().getDensity(context) + ":" + Tools2DeviceInfo.getInstance().getDensityDpi(context) + "\n" +
                "设备品牌：" + EquipmentUtils.getSystemBrand() + "\n" +
                "设备制造商：" + EquipmentUtils.getSystemManufacturer() + "\n" +
                "设备产品：" + EquipmentUtils.getSystemProduct() + "\n" +
                "设备型号：" + EquipmentUtils.getSystemModel() + "\n" +
                "设备标签：" + EquipmentUtils.getSystemTags() + "\n" +
                "设备IMEI：" + Tools2DeviceInfo.getInstance().getIMEI(context) + "/" + Tools2DeviceInfo.getInstance().getIMEI_2(context) + "\n" +
                "设备主板号：" + EquipmentUtils.getSystemBoard() + "\n" +
                "设备版本号：" + EquipmentUtils.getSystemID() + "\n" +
                "设备硬件：" + EquipmentUtils.getSystemHardware() + "\n" +
                "设备驱动：" + EquipmentUtils.getSystemDevice() + "\n" +
                "设备CPU架构：" + EquipmentUtils.getSystemCPUABI() + "\n" +
                "设备CPU架构2：" + EquipmentUtils.getSystemCPUABI2() + "\n" +
                "设备版本包：" + EquipmentUtils.getSystemDisplay() + "\n" +
                "设备的唯一标识：" + EquipmentUtils.getSystemFingerprint() + "\n" +
                "系统SDK API：" + EquipmentUtils.getSystemSdkInt() + "\n" +
                "系统SDK 版本：" + EquipmentUtils.getSystemRelease() + "\n" +
                "用户名：" + EquipmentUtils.getSystemUser() + "\n" +
                "无线电固件版本号：" + EquipmentUtils.getSystemRadio() + "\n" +
                "时间：" + EquipmentUtils.getSystemTime() + "\n" +
                "设备版本类型：" + EquipmentUtils.getSystemType() + "\n" +
                "系统开发代号：" + EquipmentUtils.getSystemCodename() + "\n" +
                "基带版本：" + EquipmentUtils.getSystemIncremental();
    }
}
