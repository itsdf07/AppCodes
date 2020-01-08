package com.itsdf07.app.activity;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.itsdf07.app.R;
import com.itsdf07.app.activity.contracts.BLEContracts;
import com.itsdf07.app.activity.presenter.BLEPresenter;
import com.itsdf07.app.framework.mvp.BaseMvpActivity;
import com.itsdf07.lib.alog.ALog;
import com.itsdf07.lib.utils.ble.bean.BLEChannelSetting;
import com.itsdf07.lib.utils.ble.bean.BLEPublicSetting;
import com.itsdf07.lib.utils.ble.client.scan.BLEScanResult;


/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class BLEActivity extends BaseMvpActivity<BLEPresenter> implements BLEContracts.IBLEView, AdapterView.OnItemSelectedListener, View.OnClickListener {
    TextView tvConnectStatus;
    TextView tvBleInfo;
    Spinner spGps;
    Spinner spBluetoothStatus;
    Spinner spSquelch1;
    Spinner spVoiceLevel;
    Spinner spVoiceDelay;
    Spinner spScanType;
    Spinner spDisplayModel;
    Spinner spBeep;
    Spinner spVoice2send;
    Spinner spTotTimeout;
    Spinner spDisplayTime;
    Spinner spPowerModel;
    Spinner spXdxz;
    TextView txMinus;
    TextView txPlus;
    EditText etFreq;
    Spinner spCtcss;
    Spinner spScan;
    Spinner spBandwidth;
    Spinner spTransmitpower;
    Spinner spTsxl;
    Button btnReadHz;
    Button btnWriteHz;
    private BLEScanResult bleScanResult;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDisConnectedBLE();
            presenter.detachView();
        }
    }

    @Override
    public BLEPresenter onInitPresenter() {
        return new BLEPresenter(this);
    }

    @Override
    public void onAfterPresenter() {
        updatePublic(presenter.getBLEPublicSetting());
        presenter.setBLEScanResult(bleScanResult);
        presenter.onConnectedBLE();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ble_channel;
    }

    @Override
    public void onBeforeView() {
        bleScanResult = getIntent().getParcelableExtra(BLEPresenter.EXTRA_BLEDEVICE);
        if (null == bleScanResult) {
            ALog.dTag(TAG, "蓝牙设备信息获取失败");
            this.finish();
        }
        ALog.dTag(TAG, "BLE名称:%s,Mac:%s", bleScanResult.getBluetoothDevice().getName(), bleScanResult.getBluetoothDevice().getAddress());
    }

    @Override
    public void onInitView() {
        tvConnectStatus = (TextView) findViewById(R.id.tv_connect_status);
        tvBleInfo = (TextView) findViewById(R.id.tv_ble_info);
        spGps = (Spinner) findViewById(R.id.sp_gps);
        spBluetoothStatus = (Spinner) findViewById(R.id.sp_bluetooth_status);
        spSquelch1 = (Spinner) findViewById(R.id.sp_squelch1);
        spVoiceLevel = (Spinner) findViewById(R.id.sp_voice_level);
        spVoiceDelay = (Spinner) findViewById(R.id.sp_voice_delay);
        spScanType = (Spinner) findViewById(R.id.sp_scan_type);
        spDisplayModel = (Spinner) findViewById(R.id.sp_display_model);
        spBeep = (Spinner) findViewById(R.id.sp_beep);
        spVoice2send = (Spinner) findViewById(R.id.sp_voice2send);
        spTotTimeout = (Spinner) findViewById(R.id.sp_tot_timeout);
        spDisplayTime = (Spinner) findViewById(R.id.sp_display_time);
        spPowerModel = (Spinner) findViewById(R.id.sp_power_model);
        spXdxz = (Spinner) findViewById(R.id.sp_xdxz);
        txMinus = (TextView) findViewById(R.id.tx_minus);
        txPlus = (TextView) findViewById(R.id.tx_plus);
        etFreq = (EditText) findViewById(R.id.et_freq);
        spCtcss = (Spinner) findViewById(R.id.sp_ctcss);
        spScan = (Spinner) findViewById(R.id.sp_scan);
        spBandwidth = (Spinner) findViewById(R.id.sp_bandwidth);
        spTransmitpower = (Spinner) findViewById(R.id.sp_transmitpower);
        spTsxl = (Spinner) findViewById(R.id.sp_tsxl);
        btnReadHz = (Button) findViewById(R.id.btn_readHz);
        btnWriteHz = (Button) findViewById(R.id.btn_writeHz);

        btnReadHz.setOnClickListener(this);
        btnWriteHz.setOnClickListener(this);


        spGps.setOnItemSelectedListener(this);
        spBluetoothStatus.setOnItemSelectedListener(this);
        spSquelch1.setOnItemSelectedListener(this);
        spVoiceLevel.setOnItemSelectedListener(this);
        spVoiceDelay.setOnItemSelectedListener(this);
        spScanType.setOnItemSelectedListener(this);
        spDisplayModel.setOnItemSelectedListener(this);
        spBeep.setOnItemSelectedListener(this);
        spVoice2send.setOnItemSelectedListener(this);
        spTotTimeout.setOnItemSelectedListener(this);
        spDisplayTime.setOnItemSelectedListener(this);
        spPowerModel.setOnItemSelectedListener(this);
        spXdxz.setOnItemSelectedListener(this);
        spCtcss.setOnItemSelectedListener(this);
        spScan.setOnItemSelectedListener(this);
        spBandwidth.setOnItemSelectedListener(this);
        spTransmitpower.setOnItemSelectedListener(this);
    }

    @Override
    public void onAfterView() {
        tvBleInfo.setText(getString(R.string.string_public_information) + "　" +
                bleScanResult.getBluetoothDevice().getName() + "->" + bleScanResult.getBluetoothDevice().getAddress());
        updateBLEConnectStatus(BLEPresenter.BLE_STATUS_DISCONNECTED);
        etFreq.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.getBLEChannelSetting(spXdxz.getSelectedItemPosition() + 1).setTxFreq(s.toString());
            }
        });
    }

    @Override
    public Activity getSelfActivity() {
        return this;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ALog.vTag(TAG, "position:%s,id:%s", position, id);
        if (null == presenter.getBLEPublicSetting()) {
            Log.w(TAG, "blePublicSetting is null");
            return;
        }
        switch (parent.getId()) {
            case R.id.sp_gps:
                presenter.getBLEPublicSetting().setGps(spGps.getSelectedItemPosition());
                break;
            case R.id.sp_bluetooth_status:
                presenter.getBLEPublicSetting().setBluetoothStatus(spBluetoothStatus.getSelectedItemPosition());
                break;
            case R.id.sp_squelch1:
                presenter.getBLEPublicSetting().setSquelch1(spSquelch1.getSelectedItemPosition());
                break;
            case R.id.sp_voice_level:
                presenter.getBLEPublicSetting().setVoiceLevel(spVoiceLevel.getSelectedItemPosition());
                break;
            case R.id.sp_voice_delay:
                presenter.getBLEPublicSetting().setVoiceDelay((spVoiceDelay.getSelectedItemPosition()));
                break;
            case R.id.sp_scan_type:
                presenter.getBLEPublicSetting().setScanType(spScanType.getSelectedItemPosition());
                break;
            case R.id.sp_display_model:
                presenter.getBLEPublicSetting().setDisplayModel(spDisplayModel.getSelectedItemPosition());
                break;
            case R.id.sp_beep:
                presenter.getBLEPublicSetting().setBeep(spBeep.getSelectedItemPosition());
                break;
            case R.id.sp_voice2send:
                presenter.getBLEPublicSetting().setVoice2Send(spVoice2send.getSelectedItemPosition());
                break;
            case R.id.sp_tot_timeout:
                presenter.getBLEPublicSetting().setTotTimeOut(spTotTimeout.getSelectedItemPosition());
                break;
            case R.id.sp_display_time:
                presenter.getBLEPublicSetting().setDisplayTime(spDisplayTime.getSelectedItemPosition());
                break;
            case R.id.sp_power_model:
                presenter.getBLEPublicSetting().setPowerMode(spPowerModel.getSelectedItemPosition());
                break;
            case R.id.sp_xdxz:
                updateChannel(presenter.getBLEChannelSetting(position + 1));
                break;
            case R.id.sp_ctcss:
                presenter.getBLEChannelSetting(spXdxz.getSelectedItemPosition() + 1).setCtcss(spCtcss.getSelectedItem().toString());
                break;
            case R.id.sp_scan:
                presenter.getBLEChannelSetting(spXdxz.getSelectedItemPosition() + 1).setScan(position);
                break;
            case R.id.sp_bandwidth:
                presenter.getBLEChannelSetting(spXdxz.getSelectedItemPosition() + 1).setBandwidth(position);
                break;
            case R.id.sp_transmitpower:
                presenter.getBLEChannelSetting(spXdxz.getSelectedItemPosition() + 1).setTransmitPower(position);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void updateChannel(BLEChannelSetting bleChannelSetting) {
        etFreq.setText(bleChannelSetting.getTxFreq());
        spTransmitpower.setSelection(bleChannelSetting.getTransmitPower(), true);
        spBandwidth.setSelection(bleChannelSetting.getBandwidth(), true);
        spScan.setSelection(bleChannelSetting.getScan(), true);
        spCtcss.setSelection(getIndex(bleChannelSetting.getCtcss()), true);
    }

    private void updatePublic(BLEPublicSetting blePublicSetting) {
        spGps.setSelection(blePublicSetting.getGps(), true);
        spBluetoothStatus.setSelection(blePublicSetting.getBluetoothStatus(), true);
        spSquelch1.setSelection(blePublicSetting.getSquelch1(), true);
        spVoiceLevel.setSelection(blePublicSetting.getVoiceLevel(), true);
        spVoiceDelay.setSelection(blePublicSetting.getVoiceDelay(), true);
        spScanType.setSelection(blePublicSetting.getScanType(), true);
        spDisplayModel.setSelection(blePublicSetting.getDisplayModel(), true);
        spBeep.setSelection(blePublicSetting.getBeep(), true);
        spVoice2send.setSelection(blePublicSetting.getVoice2Send(), true);
        spVoiceDelay.setSelection(blePublicSetting.getVoiceDelay(), true);
        spDisplayTime.setSelection(blePublicSetting.getDisplayTime(), true);
        spPowerModel.setSelection(blePublicSetting.getPowerMode(), true);
    }

    private int getIndex(String value) {
        String[] arrays = getResources().getStringArray(R.array.array_hz_ctcdcs);
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(value)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void updateBLEConnectStatus(int status) {
        switch (status) {
            case BLEPresenter.BLE_STATUS_CONNECTED:
                tvConnectStatus.setText("已连接");
                break;
            case BLEPresenter.BLE_STATUS_CONNECTING:
                tvConnectStatus.setText("连接中...");
                break;
            case BLEPresenter.BLE_STATUS_DISCONNECTED:
            default:
                tvConnectStatus.setText("未连接");
                break;
        }

    }

    @Override
    public void updateBLEOperateBtn(boolean operating) {
        btnReadHz.setEnabled(!operating);
        btnWriteHz.setEnabled(!operating);
        updatePublic(presenter.getBLEPublicSetting());
        updateChannel(presenter.getBLEChannelSetting(spXdxz.getSelectedItemPosition() + 1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_readHz:
                presenter.readData();
                break;
            case R.id.btn_writeHz:
                presenter.writeData();
                break;
        }
    }
}
