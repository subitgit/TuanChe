package com.bwf.tuanche.ui.carselect;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.fragment.BrandCarFragment;
import com.bwf.tuanche.ui.carselect.fragment.OptionCarFragment;
import com.bwf.tuanche.ui.carselect.pubwincallback.BrandId;
import com.bwf.tuanche.ui.carselect.view.SidePopupWindow;

public class CarSelectMainActivity extends BaseActivity implements BrandId {
    private BrandCarFragment brandCarFragment;
    private OptionCarFragment optionCarFragment;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private ImageView img_round_left, img_round_right;
    private TextView tv_round_left, tv_round_right;
    private SidePopupWindow sidePopupWindow;
    private String cityId ="156";
    @Override
    public int getContentViewId() {
        return R.layout.activity_car_select_main;
    }

    @Override
    public void beforeInitView() {
       // cityId = getIntent().getStringExtra("cityId");
    }

    @Override
    public void initView() {
        sidePopupWindow = new SidePopupWindow(this);

        manager = getSupportFragmentManager();

        img_round_left = findViewByIdNoCast(R.id.img_round_left);
        img_round_right = findViewByIdNoCast(R.id.img_round_right);
        tv_round_left = findViewByIdNoCast(R.id.tv_round_left);
        tv_round_right = findViewByIdNoCast(R.id.tv_round_right);
        brandCarFragment = (BrandCarFragment) manager.findFragmentById(R.id.fm_brandcarcra);
        optionCarFragment = (OptionCarFragment) manager.findFragmentById(R.id.fm_optioncar);
        //brandCarFragment = new BrandCarFragment();
        //transaction.add(R.id.fm_brandcarcra,brandCarFragment);

        transaction = manager.beginTransaction();
        transaction.hide(optionCarFragment);
        transaction.commit();

    }

    @Override
    public void initData() {
       // brandCarFragment.setCityId(cityId);
        setOnClick(R.id.img_round_left, R.id.img_round_right);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_round_left:
                manager.beginTransaction()
                        .hide(optionCarFragment)
                        .commit();
                manager.beginTransaction()
                        .show(brandCarFragment)
                        .commit();
                tv_round_left.setTextColor(getResources().getColor(R.color.white));
                img_round_left.setImageResource(R.mipmap.round_red_left);
                tv_round_right.setTextColor(getResources().getColor(R.color.black));
                img_round_right.setImageResource(R.mipmap.round_white_right);
                break;
            case R.id.img_round_right:
                manager.beginTransaction()
                        .hide(brandCarFragment)
                        .commit();
                manager.beginTransaction()
                        .show(optionCarFragment)
                        .commit();
                tv_round_left.setTextColor(getResources().getColor(R.color.black));
                img_round_left.setImageResource(R.mipmap.round_white_left);
                tv_round_right.setTextColor(getResources().getColor(R.color.white));
                img_round_right.setImageResource(R.mipmap.round_red_right);
                break;
        }
    }

    @Override
    public void setOnBrandId(String id) {
            sidePopupWindow.setRequestParams(cityId,id);
            sidePopupWindow.showSidepop(tv_round_right);
    }

    @Override
    public void setOnNullBrandId() {

    }
}
