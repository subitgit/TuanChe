package com.bwf.tuanche.ui.carselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.fragment.BrandCarFragment;

public class CarSelectMainActivity extends BaseActivity {
    private BrandCarFragment brandCarFragment;
    @Override
    public int getContentViewId() {
        return R.layout.activity_car_select_main;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        brandCarFragment = (BrandCarFragment) getSupportFragmentManager().findFragmentById(R.id.fm_brandcarcra);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
