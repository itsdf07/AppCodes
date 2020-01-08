package com.itsdf07.app.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itsdf07.app.R;
import com.itsdf07.app.activity.adapter.BLEAdapter;
import com.itsdf07.app.activity.contracts.BLEScanContracts;
import com.itsdf07.app.activity.presenter.BLEPresenter;
import com.itsdf07.app.activity.presenter.BLEScanPresenter;
import com.itsdf07.app.framework.mvp.BaseMvpActivity;


/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/16
 */
public class BLEScanActivity extends BaseMvpActivity<BLEScanPresenter> implements BLEScanContracts.IBLEScanView, View.OnClickListener {
    Button btnStartScanBle;
    Button btnStopScanBle;
    ListView lvBles;

    public BLEAdapter bleAdapter;

    @Override
    public BLEScanPresenter onInitPresenter() {
        return new BLEScanPresenter(this);
    }

    @Override
    public void onAfterPresenter() {
        bleAdapter.updateBles(presenter.getBLEs());
        lvBles.setAdapter(bleAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ble_scan;
    }

    @Override
    public void onBeforeView() {
    }

    @Override
    public void onInitView() {
        btnStartScanBle = (Button) findViewById(R.id.btn_start_scan_ble);
        btnStartScanBle.setOnClickListener(this);
        btnStopScanBle = (Button) findViewById(R.id.btn_stop_scan_ble);
        btnStopScanBle.setOnClickListener(this);
        lvBles = (ListView) findViewById(R.id.lv_bles);
        lvBles.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BLEScanActivity.this, BLEActivity.class);
                intent.putExtra(BLEPresenter.EXTRA_BLEDEVICE, presenter.getBLEs().get(position));
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    public void onAfterView() {
        bleAdapter = new BLEAdapter(this);
    }

    @Override
    public BLEScanActivity getSelfActivity() {
        return this;
    }


    @Override
    public void notifyUpdata2Adapter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bleAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void notifyUpdata2Item(final int index) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updatePosition(index);
            }
        });
    }

    public void updatePosition(int posi) {
        int visibleFirstPosi = lvBles.getFirstVisiblePosition();
        int visibleLastPosi = lvBles.getLastVisiblePosition();
        if (posi >= visibleFirstPosi && posi <= visibleLastPosi) {
            View view = lvBles.getChildAt(posi - visibleFirstPosi);
            BLEAdapter.ViewHolder holder = (BLEAdapter.ViewHolder) view.getTag();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_scan_ble:
                presenter.startScan();
                break;
            case R.id.btn_stop_scan_ble:
                presenter.stopScan();
                break;
        }
    }
}
