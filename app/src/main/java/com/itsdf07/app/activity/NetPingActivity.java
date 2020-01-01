package com.itsdf07.app.activity;

import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.itsdf07.app.R;
import com.itsdf07.app.activity.presenter.NetPingPresenter;
import com.itsdf07.app.framework.mvp.BaseMvpActivity;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2019/12/27
 */
public class NetPingActivity extends BaseMvpActivity<NetPingPresenter> {
    private EditText etHost;//域名/IP地址，即要ping的目标主机，如www.baidu.com
    private EditText etPackageCount2Send;//发送数据包的数量，即可理解为返回几次数据
    private EditText etPackageSize2Send;//发送的数据包大小
    private EditText etPackageDelaytime;//延迟发送时间，控制输出显示，避免扎堆
    private EditText etHostGroup;//域名分类，用于从服务器拉取域名时使用
    private TextView tvPingResultInfo;//ping结果信息

    @Override
    public Activity getSelfActivity() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_netping;
    }

    @Override
    public void onBeforeView() {

    }

    @Override
    public void onInitView() {
        etHost = (EditText) findViewById(R.id.et_host);
        etPackageCount2Send = (EditText) findViewById(R.id.et_package_count);
        etPackageSize2Send = (EditText) findViewById(R.id.et_package_size);
        etPackageDelaytime = (EditText) findViewById(R.id.et_package_delaytime);
        etHostGroup = (EditText) findViewById(R.id.et_host_group);
        tvPingResultInfo = (TextView) findViewById(R.id.tv_pingresult);
        tvPingResultInfo.setMovementMethod(ScrollingMovementMethod.getInstance());
        findViewById(R.id.btn_ping).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPingResultInfo.setText("");
                int packageCount = Integer.parseInt(etPackageCount2Send.getText().toString().trim());
                int packageSize = Integer.parseInt(etPackageSize2Send.getText().toString().trim());
                int packageDelaytime = Integer.parseInt(etPackageDelaytime.getText().toString().trim());
                presenter.onPing(etHost.getText().toString().trim(), packageCount, packageSize, packageDelaytime);
            }
        });
        findViewById(R.id.btn_ping_host).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPingResultInfo.setText("");
                int packageCount = Integer.parseInt(etPackageCount2Send.getText().toString().trim());
                int packageSize = Integer.parseInt(etPackageSize2Send.getText().toString().trim());
                int packageDelaytime = Integer.parseInt(etPackageDelaytime.getText().toString().trim());
                presenter.onPingHost(etHostGroup.getText().toString().trim(), packageCount, packageSize, packageDelaytime);
            }
        });
    }

    @Override
    public void onAfterView() {

    }

    @Override
    public NetPingPresenter onInitPresenter() {
        return new NetPingPresenter(this);
    }

    @Override
    public void onAfterPresenter() {

    }
}
