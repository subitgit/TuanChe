package com.bwf.tuanche;

import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.ui.carselect.CarSelectMainActivity;
import com.bwf.tuanche.ui.detail.CarDetailActivity;


public class MainActivity extends BaseActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        setOnClick(R.id.btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                IntentUtils.openActivity(this, CarSelectMainActivity.class);
                break;
        }
    }
}
