package com.itsdf07.lib.utils.ble.server.core;

import android.util.SparseArray;

public class OKBLEServerOperationFailedDescUtils {

    private static SparseArray<String> descArray=new SparseArray<>();

    static {
        descArray.put(OKBLEServerOperation.BLEServerOperationListener.Operation_FAILED_Invalid_Service_UUID,"Service UUID is invalid");
        descArray.put(OKBLEServerOperation.BLEServerOperationListener.Operation_FAILED_Invalid_Characteristic_UUID,"Characteristic UUID is invalid");
        descArray.put(OKBLEServerOperation.BLEServerOperationListener.Operation_FAILED_BLE_Failed,"BLE_Failed");


    }
    public static String getDesc(int errCode){
        return descArray.get(errCode,"unknown error");
    }
}
