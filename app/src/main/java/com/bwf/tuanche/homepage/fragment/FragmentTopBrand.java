package com.bwf.tuanche.homepage.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.homejson.bean.banner.HeaderBannerBean;
import com.bwf.tuanche.homepage.homejson.bean.topbrand.NcBean;
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
    private ImageLoader imageLoader;

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
            break;
            case R.id.topBrand_carSale:
            break;
            case R.id.topBrand_carSafe:
            break;
        }

    }
}
