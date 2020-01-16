package com.itsdf07.lib.utils;

import android.os.Build;

import java.util.Locale;
//android.os.Build.BOARD：获取设备主板名称
//android.os.Build.BOOTLOADER：获取设备引导程序版本号
//android.os.Build.BRAND：获取设备品牌
//android.os.Build.CPU_ABI：获取设备指令集名称（CPU的类型）
//android.os.Build.CPU_ABI2：获取第二个指令集名称
//android.os.Build.DEVICE：获取设备驱动名称
//android.os.Build.DISPLAY：获取设备显示的版本包（在系统设置中显示为版本号）和ID一样
//android.os.Build.FINGERPRINT：设备的唯一标识。由设备的多个信息拼接合成
//android.os.Build.HARDWARE：设备硬件名称，一般和基板名称一样（BOARD）
//android.os.Build.HOST：设备主机地址
//android.os.Build.ID：设备版本号
//android.os.Build.MODEL：获取手机的型号 设备名称。如：SM-N9100（三星Note4）
//android.os.Build.MANUFACTURER：获取设备制造商。如：samsung
//android:os.Build.PRODUCT：产品的名称
//android:os.Build.RADIO：无线电固件版本号，通常是不可用的 显示
//nandroid.os.Build.TAGS：设备标签。如release-keys或测试的test-keys
//android.os.Build.TIME：时间
//android.os.Build.TYPE：设备版本类型主要为”user” 或”eng”
//android.os.Build.USER：设备用户名 基本上都为android-build
//android.os.Build.VERSION.RELEASE：获取系统版本字符串
//android.os.Build.VERSION.CODENAME：设备当前的系统开发代号，一般使用REL代替
//android.os.Build.VERSION.INCREMENTAL：基带版本：系统源代码控制值，一个数字或者git哈希值
//android.os.Build.VERSION.SDK：系统的API级别，推荐使用下面的SDK_INT来查看
//android.os.Build.VERSION.SDK_INT：系统的API级别，int数值类型
//android.os.Build.VERSION_CODES  类：包含所有已公布的Android版本号，全部为int常量

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/1/8
 */
public class EquipmentUtils {
    /**
     * @return 设备主板名称
     */
    public static String getSystemBoard() {
        return Build.BOARD;
    }

    /**
     * @return 设备引导程序版本号
     */
    public static String getSystemBootloader() {
        return Build.BOOTLOADER;
    }

    /**
     * @return 设备品牌
     */
    public static String getSystemBrand() {
        return android.os.Build.BRAND;
    }


    /**
     * 获取设备的CPU架构
     * armeabi	第5代 ARM v5TE，使用软件浮点运算，兼容所有ARM设备，通用性强，速度慢
     * armeabi-v7a	第7代 ARM v7，使用硬件浮点运算，具有高级扩展功能
     * arm64-v8a	第8代，64位，包含AArch32、AArch64两个执行状态对应32、64bit
     * x86	intel 32位，一般用于平板
     * x86_64	intel 64位，一般用于平板
     * mips	少接触
     * mips64	少接触
     *
     * @return
     * @备注 adb指令查看：cat /proc/cpuinfo
     */
    public static String getSystemCPUABI() {
        return Build.CPU_ABI;
    }

    /**
     * 获取设备的CPU架构
     *
     * @return
     */
    public static String getSystemCPUABI2() {
        return Build.CPU_ABI2;
    }

    /**
     * @return 设备驱动名称
     */
    public static String getSystemDevice() {
        return Build.DEVICE;
    }

    /**
     * @return 设备显示的版本包（在系统设置中显示为版本号）和ID一样
     */
    public static String getSystemDisplay() {
        return Build.DISPLAY;
    }


    /**
     * @return 设备的唯一标识。由设备的多个信息拼接合成
     */
    public static String getSystemFingerprint() {
        return Build.FINGERPRINT;
    }


    /**
     * @return 设备硬件名称，一般和基板名称一样（BOARD）
     */
    public static String getSystemHardware() {
        return Build.HARDWARE;
    }


    /**
     * @return 主机地址
     */
    public static String getSystemHost() {
        return Build.HOST;
    }

    /**
     * @return 设备版本号
     */
    public static String getSystemID() {
        return Build.ID;
    }

    /**
     * @return 手机的型号 设备名称。如：SM-N9100（三星Note4）
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * @return 设备制造商。如：samsung
     */
    public static String getSystemManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * @return 产品的名称
     */
    public static String getSystemProduct() {
        return Build.PRODUCT;
    }

    /**
     * @return 无线电固件版本号，通常是不可用的 显示
     */
    public static String getSystemRadio() {
        return Build.RADIO;
    }

    /**
     * @return 设备标签。如release-keys或测试的test-keys
     */
    public static String getSystemTags() {
        return Build.TAGS;
    }


    /**
     * @return 时间
     */
    public static long getSystemTime() {
        return Build.TIME;
    }

    /**
     * @return 设备版本类型主要为”user” 或”eng”
     */
    public static String getSystemType() {
        return Build.TYPE;
    }

    /**
     * @return 设备用户名 基本上都为android-build
     */
    public static String getSystemUser() {
        return Build.USER;
    }

    /**
     * @return 系统版本号
     */
    public static String getSystemRelease() {
        return Build.VERSION.RELEASE;
    }

    /**
     * @return 设备当前的系统开发代号，一般使用REL代替
     */
    public static String getSystemCodename() {
        return Build.VERSION.CODENAME;
    }

    /**
     * @return 基带版本：系统源代码控制值，一个数字或者git哈希值
     */
    public static String getSystemIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    /**
     * @return 系统的API级别，推荐使用下面的SDK_INT来查看
     */
    public static String getSystemSdk() {
        return Build.VERSION.SDK;
    }

    /**
     * @return 系统的API级别
     */
    public static int getSystemSdkInt() {
        return Build.VERSION.SDK_INT;
    }

}
