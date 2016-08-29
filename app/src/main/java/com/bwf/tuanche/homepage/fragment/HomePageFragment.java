package com.bwf.tuanche.homepage.fragment;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.fragment.home_fragment.FragmentBanner;
import com.bwf.tuanche.homepage.fragment.home_fragment.FragmentHotCar;
import com.bwf.tuanche.homepage.fragment.home_fragment.FragmentHotLog;
import com.bwf.tuanche.homepage.fragment.home_fragment.FragmentTopBrand;
import com.bwf.tuanche.homepage.homejson.bean.banner.BannerResultBean;
import com.bwf.tuanche.homepage.homejson.bean.hotcar.HotCarBean;
import com.bwf.tuanche.homepage.homejson.bean.hotlogo.HotLogoResultBean;
import com.bwf.tuanche.homepage.homejson.bean.topbrand.ResultBean;
import com.bwf.tuanche.search.ui.SearchActivity;

import java.util.List;

/**
 * Created by BWF on 2016/8/16.
 */
public class HomePageFragment extends BaseFragment {
    private String cityId;
    private ImageView topbrand_erWeima;
    private FragmentTopBrand fragmentTopBrand;
    private FragmentHotLog fragmentHotLog;
    private FragmentBanner fragmentBanner;
    private FragmentHotCar fragmentHotCar;
    private EditText topbrand_search;
    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected int getResource() {
        return  R.layout.home_fragment;
    }

    @Override
    public void beforeInitView() {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    @Override
    protected void initView(View rootView) {
        fragmentTopBrand = (FragmentTopBrand)getChildFragmentManager().findFragmentById(R.id.fragment_top);
        fragmentHotLog = (FragmentHotLog) getChildFragmentManager().findFragmentById(R.id.fragment_log);
        fragmentBanner = (FragmentBanner) getChildFragmentManager().findFragmentById(R.id.fragment_banner);
        fragmentHotCar = (FragmentHotCar) getChildFragmentManager().findFragmentById(R.id.fragment_hotcar);
        topbrand_search = findViewByIdNoCast(R.id.topbrand_search);
        topbrand_search.setOnClickListener(this);
        topbrand_erWeima = findViewByIdNoCast(R.id.topbrand_erWeima);
        topbrand_erWeima.setOnClickListener(this);
    }



    @Override
    public void initData() {
        //if (cityId!=null&&cityId.equals("")){
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
        //  }

   }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.topbrand_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            break;
            case R.id.topbrand_erWeima:

            break;
        }
    }


}
