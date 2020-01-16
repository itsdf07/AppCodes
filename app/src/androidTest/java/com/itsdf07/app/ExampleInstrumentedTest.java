package com.itsdf07.app;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.itsdf07.lib.utils.EquipmentUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.itsdf07.app", appContext.getPackageName());
    }

    @Test
    public void getEquipmentInfo() throws Exception {
        Log.e("aso","单元测试日志输出");
        assertEquals("result:",  EquipmentUtils.getSystemHardware() + "\n" + EquipmentUtils.getSystemBoard());
    }
}
