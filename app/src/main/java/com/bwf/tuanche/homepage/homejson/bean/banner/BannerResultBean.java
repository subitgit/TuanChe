package com.bwf.tuanche.homepage.homejson.bean.banner;

import java.util.List;

/**
 * Created by BWF on 2016/8/17.
 */
public class BannerResultBean {
    public List<HeaderBannerBean> header_banner ;
    public List<CenterBannerBean> center_banner ;
    public List<PositionBannerBean> position_banner ;

    @Override
    public String toString() {
        return "BannerResultBean{" +
                "header_banner=" + header_banner +
                ", center_banner=" + center_banner +
                ", position_banner=" + position_banner +
                '}';
    }
}
