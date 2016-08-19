package com.bwf.tuanche.homepage.ui;
import android.app.Fragment;
import android.view.View;
import android.view.WindowManager;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.fragment.FragmentBanner;
import com.bwf.tuanche.homepage.fragment.FragmentHotCar;
import com.bwf.tuanche.homepage.fragment.FragmentHotLog;
import com.bwf.tuanche.homepage.fragment.FragmentTopBrand;
import com.bwf.tuanche.homepage.homejson.bean.banner.BannerResultBean;
import com.bwf.tuanche.homepage.homejson.bean.hotcar.HotCarBean;
import com.bwf.tuanche.homepage.homejson.bean.hotlogo.HotLogoResultBean;
import com.bwf.tuanche.homepage.homejson.bean.topbrand.ResultBean;
import java.util.List;

/**
 * Created by BWF on 2016/8/16.
 */
public class HomePageActivity extends BaseActivity {
    private FragmentTopBrand fragmentTopBrand;
    private FragmentHotLog fragmentHotLog;
    private FragmentBanner fragmentBanner;
    private FragmentHotCar fragmentHotCar;

    @Override
    public int getContentViewId() {
        return R.layout.home_activity;
    }

    @Override
    public void beforeInitView() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    @Override
    public void initView() {
        fragmentTopBrand = (FragmentTopBrand) getSupportFragmentManager().findFragmentById(R.id.fragment_top);
        fragmentHotLog = (FragmentHotLog) getSupportFragmentManager().findFragmentById(R.id.fragment_log);
        fragmentBanner = (FragmentBanner) getSupportFragmentManager().findFragmentById(R.id.fragment_banner);
        fragmentHotCar = (FragmentHotCar) getSupportFragmentManager().findFragmentById(R.id.fragment_hotcar);
    }

    @Override
    public void initData() {
        HttpHelper.getTopBrandDetail("156", new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean result) {
                if (result != null) {
                    if (result != null) {
                        fragmentTopBrand.setNc(result.nc);
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
            }
        });


        HttpHelper.getHotLog("156", new HttpCallBack<HotLogoResultBean>() {
            @Override
            public void onSuccess(HotLogoResultBean result) {
                if (result != null) {
                    if (result != null) {
                        fragmentHotLog.setList(result.list);
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

        HttpHelper.getBanner("156", new HttpCallBack<BannerResultBean>() {
            @Override
            public void onSuccess(BannerResultBean result) {
                if (result != null) {
                    fragmentTopBrand.setHeader_banner(result.header_banner);
                    fragmentBanner.setBannerResultBean(result);
                }
            }

            @Override
            public void onFail(String errMsg) {
            }
        });

        HttpHelper.getHotCar("156", new HttpArrayCallBack<HotCarBean>() {
            @Override
            public void onSuccess(List result) {
                fragmentHotCar.setList(result);
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
