package com.bwf.tuanche.homepage.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.homejson.bean.banner.BannerResultBean;
import com.bwf.tuanche.homepage.homejson.bean.banner.CenterBannerBean;
import com.bwf.tuanche.homepage.homejson.bean.banner.PositionBannerBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BWF on 2016/8/17.
 */
public class FragmentBanner extends BaseFragment {
    private BannerResultBean bannerResultBean;
    private TextView[] names = new TextView[6];
    private TextView[] discs = new TextView[6];
    private SimpleDraweeView[] imags = new SimpleDraweeView[8];

    public void setBannerResultBean(BannerResultBean bannerResultBean) {
        this.bannerResultBean = bannerResultBean;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_banner;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {

        names[0] = findViewByIdNoCast(R.id.fragment_center1_name);
        names[1] = findViewByIdNoCast(R.id.fragment_center2_name);
        names[2] = findViewByIdNoCast(R.id.fragment_center3_name);
        names[3] = findViewByIdNoCast(R.id.fragment_position1_name);
        names[4] = findViewByIdNoCast(R.id.fragment_position2_name);
        names[5] = findViewByIdNoCast(R.id.fragment_position3_name);

        discs[0] = findViewByIdNoCast(R.id.fragment_center1_ds);
        discs[1] = findViewByIdNoCast(R.id.fragment_center2_ds);
        discs[2] = findViewByIdNoCast(R.id.fragment_center3_ds);
        discs[3] = findViewByIdNoCast(R.id.fragment_position1_ds);
        discs[4] = findViewByIdNoCast(R.id.fragment_position2_ds);
        discs[5] = findViewByIdNoCast(R.id.fragment_position3_ds);


        imags[0] = findViewByIdNoCast(R.id.fragment_header1_image);
        imags[1] = findViewByIdNoCast(R.id.fragment_header2_image);
        imags[2] = findViewByIdNoCast(R.id.fragment_center1_image);
        imags[3] = findViewByIdNoCast(R.id.fragment_center2_image);
        imags[4] = findViewByIdNoCast(R.id.fragment_center3_image);
        imags[5] = findViewByIdNoCast(R.id.fragment_position1_image);
        imags[6] = findViewByIdNoCast(R.id.fragment_position2_image);
        imags[7] = findViewByIdNoCast(R.id.fragment_position3_image);




    }

    @Override
    protected void initData() {
        if (bannerResultBean!=null){
            List<CenterBannerBean> list = bannerResultBean.center_banner;
            for (int i = 0;i<list.size();i++){
               imags[i].setImageURI(list.get(i).adImgUrl);
            }
            List<PositionBannerBean> position_banner = bannerResultBean.position_banner;
            for (int i = 0;i<position_banner.size();i++){
                names[i].setText(position_banner.get(i).bigTitle);
                discs[i].setText(position_banner.get(i).subTitle);
                imags[i+2].setImageURI(position_banner.get(i).iconUrl);
            }
        }
    }

    @Override
    public void onClick(View v) {

    }
}
