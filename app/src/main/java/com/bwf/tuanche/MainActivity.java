package com.bwf.tuanche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.IntentUtils;
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
        findViewByIdNoCast(R.id.text).setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text) {
            IntentUtils.openActivity(this, CarDetailActivity.class);
        }
    }
}
