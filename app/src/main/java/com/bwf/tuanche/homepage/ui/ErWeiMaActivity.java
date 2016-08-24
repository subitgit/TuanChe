package com.bwf.tuanche.homepage.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.R;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by BWF on 2016/8/24.
 */
public class ErWeiMaActivity extends BaseActivity {
    private Button second_button1;
    @Override
    public int getContentViewId() {
        return R.layout.erweima;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        second_button1 = findViewByIdNoCast(R.id.second_button1);
        second_button1.setOnClickListener(this);
        CaptureFragment captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);
        captureFragment.setAnalyzeCallback(new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
                bundle.putString(CodeUtils.RESULT_STRING, result);
                resultIntent.putExtras(bundle);
                ErWeiMaActivity.this.setResult(RESULT_OK, resultIntent);
                ErWeiMaActivity.this.finish();
            }

            @Override
            public void onAnalyzeFailed() {
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
                bundle.putString(CodeUtils.RESULT_STRING, "");
                resultIntent.putExtras(bundle);
                ErWeiMaActivity.this.setResult(RESULT_OK, resultIntent);
                ErWeiMaActivity.this.finish();
            }
        });
        /**
         * 替换我们的扫描控件
         */ getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.second_button1:
                Intent intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
            break;
        }

    }
}
