package com.bwf.czg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;

public class WelcomeActivity extends BaseActivity implements Handler.Callback{
    private Handler handler;

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        handler = new Handler(this);
        handler.sendEmptyMessageDelayed(1,1000);
    }



    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case 1:
                if(SharePrefreceHelper.getInstence(WelcomeActivity.this).isFirst())
                    IntentUtils.openActivity(this,GuideActivity.class);
                else
                    IntentUtils.openActivity(this,SelectCityActivity.class);
        }
        return false;
    }
}
