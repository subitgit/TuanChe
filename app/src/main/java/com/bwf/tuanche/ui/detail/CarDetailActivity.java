package com.bwf.tuanche.ui.detail;

import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CarDetailResponseBean;
import com.bwf.tuanche.ui.detail.fragment.CarDetailFragment1;
import com.bwf.tuanche.ui.detail.fragment.CarDetailFragment2;

public class CarDetailActivity extends BaseActivity {


    private CarDetailFragment1 fragment1;
    private CarDetailFragment2 fragment2;

    @Override
    public int getContentViewId() {
        return R.layout.activity_car_detail;
    }

    private String cityId, brandId, styleId;

    @Override
    public void beforeInitView() {

        cityId = getIntent().getStringExtra("cityId");
        brandId = getIntent().getStringExtra("brandId");
        styleId = getIntent().getStringExtra("styleId");
    }

    @Override
    public void initView() {
        fragment1 = (CarDetailFragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment2 = (CarDetailFragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);

    }

    @Override
    public void initData() {

        getDatas();

    }

    private void getDatas() {

        HttpHelper.getDetail("156", "31", "166", new HttpCallBack<CarDetailResponseBean>() {
            @Override
            public void onSuccess(CarDetailResponseBean result) {

                fragment1.setDatas(result);
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View v) {


    }
}
