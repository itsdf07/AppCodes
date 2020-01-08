package com.itsdf07.app.activity;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.itsdf07.app.R;
import com.itsdf07.app.activity.contracts.PingContracts;
import com.itsdf07.app.activity.presenter.PingPresenter;
import com.itsdf07.app.framework.mvp.BaseMvpActivity;
import com.itsdf07.lib.alog.ALog;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/01/08
 */
public class PingActivity extends BaseMvpActivity<PingPresenter> implements PingContracts.IPingView {
    private EditText etHost;
    private EditText etPackageCount;
    private EditText etPackageSize;
    private EditText etPackageDelaytime;
    private EditText etHostGroup;
    private TextView tvPingResultInfo;

    @Override
    public PingPresenter onInitPresenter() {
        return new PingPresenter(this);
    }

    @Override
    public void onAfterPresenter() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ping;
    }

    @Override
    public void onBeforeView() {

    }

    @Override
    public void onInitView() {
        etHost = (EditText) findViewById(R.id.et_host);
        etPackageCount = (EditText) findViewById(R.id.et_package_count);
        etPackageSize = (EditText) findViewById(R.id.et_package_size);
        etPackageDelaytime = (EditText) findViewById(R.id.et_package_delaytime);
        etHostGroup = (EditText) findViewById(R.id.et_host_group);
        tvPingResultInfo = (TextView) findViewById(R.id.tv_pingresult);
        tvPingResultInfo.setMovementMethod(ScrollingMovementMethod.getInstance());
        findViewById(R.id.btn_ping).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPingResultInfo.setText("");
                int packageCount = Integer.parseInt(etPackageCount.getText().toString().trim());
                int packageSize = Integer.parseInt(etPackageSize.getText().toString().trim());
                int packageDelaytime = Integer.parseInt(etPackageDelaytime.getText().toString().trim());
                presenter.onPing(etHost.getText().toString().trim(), packageCount, packageSize, packageDelaytime);
            }
        });
        findViewById(R.id.btn_ping_host).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPingResultInfo.setText("");
                int packageCount = Integer.parseInt(etPackageCount.getText().toString().trim());
                int packageSize = Integer.parseInt(etPackageSize.getText().toString().trim());
                int packageDelaytime = Integer.parseInt(etPackageDelaytime.getText().toString().trim());
                presenter.onPingHost(etHostGroup.getText().toString().trim(), packageCount, packageSize, packageDelaytime);
            }
        });
    }

    @Override
    public void onAfterView() {

    }

    @Override
    public PingActivity getSelfActivity() {
        return this;
    }

    @Override
    public void updateInfo(String pingResult) {
        ALog.dTag(TAG, "pingResult:%s", pingResult);
        tvPingResultInfo.append("\n" + pingResult);

    }
}
