package com.itsdf07.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 获取设备信息的工具，使用静态内部类的方式实现单例模式
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/01/08
 */
public class Tools2DeviceInfo {
    public static Tools2DeviceInfo getInstance() {
        return Tools2DeviceInfoHolder.instance;
    }

    private static class Tools2DeviceInfoHolder {
        private static final Tools2DeviceInfo instance = new Tools2DeviceInfo();
    }


    /**
     * @param context
     * @return DisplayMetrics{density=3.0, width=1080, height=1920, scaledDensity=3.0, xdpi=403.411, ydpi=403.041}
     */
    public DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    /**
     * 获取设备的分辨率:px<br/>
     * 其中扣掉了导航栏(返回键+Home键+Menu键)的高度(默认是126px)
     *
     * @param context
     * @return 设备的分辨率:px<br/> [widthPixels, heightPixels],如 [1080,1794]
     */
    public int[] getScreenPixels(Context context) {
        int[] pixels = new int[2];
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        pixels[0] = displayMetrics.widthPixels;
        pixels[1] = displayMetrics.heightPixels;
        return pixels;
    }

    /**
     * 屏幕的逻辑密度，是密度无关像素（dip）的缩放因子，
     * 160dpi是系统屏幕显示的基线，1dip = 1px，
     * 所以，在160dpi的屏幕上，density = 1， 而在一个120dpi屏幕上 density = 0.75
     *
     * @param context
     * @return 密度
     */
    public float getDensity(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.density;
    }

    /**
     * 每英寸的像素点数，屏幕密度的另一种表示。densityDpi = density * 160.
     *
     * @param context
     * @return
     */
    public int getDensityDpi(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.densityDpi;
    }

    /**
     * 屏幕上字体显示的缩放因子，一般与density值相同，除非在程序运行中，用户根据喜好调整了显示字体的大小时，会有微小的增加。
     * 单位 sp 的 换算值: 一般用在设定字体大小中。
     * <p/>
     * 伸缩密度，图片、字体在不同分辨率上面运行，分辨率不一样导致设置的大小也就不一样。
     * <p/>
     * 一般字体大小设置为：
     * <p/>
     * DisplayMetrics dm= new DisplayMetrics();
     * getWindowManager().getDefaultDisplay().getMetrics(dm);
     * <p/>
     * pixelSize = (int)scaledPixelSize * dm.scaledDensity;
     * <p/>
     * 这样可以适配在多个分辨率上面
     *
     * @return 伸缩密度:单位 sp 的 换算值
     */
    public float getScaledDensity(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.scaledDensity;
    }

    /**
     * 获取设备IMEI， 需要 “android.permission.READ_PHONE_STATE”权限
     *
     * @param context
     * @return 设备IMEI
     */
    public String getIMEI(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null) {
            return "UnKnown";
        } else {
            return deviceId;
        }
    }

    /**
     * @param context
     * @return 设备IMEI 2号
     */
    public String getIMEI_2(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        Class clazz = tm.getClass();
        try {
            Method getImei = clazz.getDeclaredMethod("getImei", int.class);
            return getImei.invoke(tm, 1).toString();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }
}
