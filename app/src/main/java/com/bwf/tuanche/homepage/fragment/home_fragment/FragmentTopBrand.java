package com.bwf.tuanche.homepage.fragment.home_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.homejson.bean.banner.HeaderBannerBean;
import com.bwf.tuanche.homepage.homejson.bean.topbrand.NcBean;
import com.bwf.tuanche.homepage.ui.WebSiteViewActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BWF on 2016/8/16.
 */
public class FragmentTopBrand extends BaseFragment {
     private    List<NcBean> nc;
    private List<HeaderBannerBean> header_banner;
    private   SimpleDraweeView topBrand_adImage ;
    private  SimpleDraweeView[] simpleDraweeViews = new  SimpleDraweeView[4];
    private TextView[] textViews = new TextView[4];
    private LinearLayout topBrand_carSafe,topBrand_carSale,topBrand_carProtec,topBrand_lowPrice;


    public void setNc(List<NcBean> nc) {
        this.nc = nc;
        initData();
    }

    public void setHeader_banner(List<HeaderBannerBean> header_banner) {
        this.header_banner = header_banner;
        if (topBrand_adImage!=null){
            topBrand_adImage.setImageURI(header_banner.get(0).adImgUrl);
        }
    }

    @Override
    protected int getResource() {
        return R.layout.topbrand_fragment;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        topBrand_adImage = findViewByIdNoCast(R.id.topBrand_adImage);
        topBrand_adImage.setOnClickListener(this);
        simpleDraweeViews[0] = findViewByIdNoCast(R.id.topBrand_lowPrice_image);
        simpleDraweeViews[1] = findViewByIdNoCast(R.id.topBrand_carProtect_image);
        simpleDraweeViews[2] = findViewByIdNoCast(R.id.topBrand_carSale_image);
        simpleDraweeViews[3] = findViewByIdNoCast(R.id.topBrand_carSafe_image);
        textViews[0] = findViewByIdNoCast(R.id.topBrand_lowPrice_tv);
        textViews[1] = findViewByIdNoCast(R.id.topBrand_carProtect_tv);
        textViews[2] = findViewByIdNoCast(R.id.topBrand_carSale_tv);
        textViews[3] = findViewByIdNoCast(R.id.topBrand_carSafe_tv);

        topBrand_carSafe = findViewByIdNoCast(R.id.topBrand_carSafe);
        topBrand_carSale = findViewByIdNoCast(R.id.topBrand_carSale);
        topBrand_carProtec = findViewByIdNoCast(R.id.topBrand_carProtec);
        topBrand_lowPrice = findViewByIdNoCast(R.id.topBrand_lowPrice);

        topBrand_carSafe.setOnClickListener(this);
        topBrand_carSale.setOnClickListener(this);
        topBrand_carProtec.setOnClickListener(this);
        topBrand_lowPrice.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        if (nc!=null&&nc.size()!=0){
            LogUtils.e(nc.toString());
            for (int i = 0;i<simpleDraweeViews.length;i++){
                simpleDraweeViews[i].setImageURI(nc.get(i).pic);
                textViews[i].setText(nc.get(i).name);
            }
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.topBrand_lowPrice:
            break;
            case R.id.topBrand_carProtec:
                Bundle bundle = new Bundle();
                if (nc!=null&&nc.size()!=0){
                    if (nc.get(1).name!=null){
                        bundle.putString("title",nc.get(1).name);
                    }
                    if (nc.get(1).url!=null){
                        bundle.putString("url",nc.get(1).url);
                    }
                }
            Intent intent = new Intent(getParentFragment().getActivity(), WebSiteViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            break;
            case R.id.topBrand_carSale:
            break;
            case R.id.topBrand_carSafe:
                Bundle sbundle = new Bundle();
                if (nc!=null&&nc.size()!=0){
                    if (nc.get(3).name!=null){
                        sbundle.putString("title",nc.get(3).name);
                    }
                    if (nc.get(3).url!=null){
                        sbundle.putString("url",nc.get(3).url);
                    }
                }
                Intent sintent = new Intent(getParentFragment().getActivity(), WebSiteViewActivity.class);
                sintent.putExtras(sbundle);
                startActivity(sintent);
            break;
            case R.id.topBrand_adImage:

            break;
        }

    }
}
