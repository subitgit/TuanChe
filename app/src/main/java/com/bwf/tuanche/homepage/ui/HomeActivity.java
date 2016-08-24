package com.bwf.tuanche.homepage.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.fragment.HomePageFragment;
import com.bwf.tuanche.homepage.view.ButtonBar;

/**
 * Created by Administrator on 2016/8/21.
 */
public class HomeActivity extends BaseActivity implements ButtonBar.Select {
    private HomePageFragment homePage;
    private Fragment[] fragments = new Fragment[1];
    private FragmentTransaction transaction;
    private ButtonBar buttonBar;
    private String cityId;
    @Override
    public int getContentViewId() {
        return R.layout.home_activity;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        homePage = (HomePageFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_homePager);
        fragments[0] = homePage;
        buttonBar = findViewByIdNoCast(R.id.buttonBar);
        buttonBar.setSelect(this);
    }

    @Override
    public void initData() {
      /*  hideAll();
        showFragment(0);*/
    }

    public void hideAll(){
        transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0;i<fragments.length;i++){
            transaction.hide(fragments[i]);
        }
        transaction.commit();
    }

    public void showFragment(int i){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(fragments[i]);
        transaction.commit();
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void selected(int i) {
        switch (i){
            case 0:
                ToastUtil.showToast("点击了首页");
               /* hideAll();
                showFragment(0);*/
            break;
            case 1:
                ToastUtil.showToast("点击了订单");
                break;
            case 2:
                ToastUtil.showToast("点击了客服");
                break;
            case 3:
                ToastUtil.showToast("点击了自己");
                break;
            case 4:

                break;
        }
    }
}
