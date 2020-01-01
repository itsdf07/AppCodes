package com.itsdf07.app.activity.model;

import com.itsdf07.app.activity.bean.RespPingHostBean;
import com.itsdf07.app.activity.contracts.NetPingContracts;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/27
 */
public class NetPingModel implements NetPingContracts.INetPingModel {
    private static final String TAG = "PingModel";
    private static final String ICCID_1 = "";//移动
    private static final String ICCID_2 = "8986061910003732056H";//联通
    private static final String ICCID_3 = "";//电信
    private static final String IMEI_1 = "";//移动
    private static final String IMEI_2 = "866747000649326";//联通
    private static final String IMEI_3 = "";//电信
    private static final String OSVERSION_1 = "";//移动
    private static final String OSVERSION_2 = "5.1.1-XinSJ";//联通
    private static final String OSVERSION_3 = "";//电信

    @Override
    public void getHostsFromService(String group, IHostsRequCallback callback) {
        final String url = UrlGlobal.URL_PING_HOST + ":" + UrlGlobal.PORT_PING_HOST + "/ping/hosts";
        JSONObject root = new JSONObject();
        try {
            root.put("group", group);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttp3Utils.getInstance().postAsyn2Data(url, root.toString(), new OkHttp3CallbackImpl() {
            @Override
            public void onStart(RequestInfo requestInfo) {
                ALog.dTag(TAG, "url:%s,body:%s", requestInfo.getUrl(), requestInfo.getBody());
            }

            @Override
            public void onSuccess(OkBaseBean okBaseBean) {
                ALog.dTag(TAG, "hostResult:%s", okBaseBean.getEncrptyResult());
                RespPingHostBean pingHostBean = new Gson().fromJson(okBaseBean.getEncrptyResult(), RespPingHostBean.class);
                ALog.dTag(TAG, okBaseBean.getEncrptyResult());
                if (null != callback) {
                    callback.hostsResultCallback(pingHostBean.getDatas());
                }
            }

            @Override
            public void onFailed(OkBaseBean bean) {
                ALog.dTag(TAG, "bean:%s", bean.getEncrptyResult());
            }

            @Override
            public void onFinish() {
                ALog.dTag(TAG, "url:%s", url);
            }
        }, true);
    }

    @Override
    public void doPing(String host, int packageCount, int packageSize, int delayTime, IPingResultCallback callback) {

    }

    @Override
    public void addPingResults(HashMap<String, HashMap<String, String>> hostMaps) {

    }

    /**
     * 从服务端请求到需要执行ping的目标主机集合
     */
    public interface IHostsRequCallback {
        void hostsResultCallback(List<RespPingHostBean.DatasBean> datas);
    }

    /**
     * ping结果数据回调到UI
     */
    public interface IPingResultCallback {
        /**
         * ping结果
         *
         * @param pingResult
         */
        void pingResultCallback(String pingResult);

        /**
         * ping出现了错误
         *
         * @param errResult
         */
        void pingResultErr(String errResult);

        /**
         * ping介绍回调
         *
         * @param host 目标主机
         */
        void pingOver(String host);
    }

}
