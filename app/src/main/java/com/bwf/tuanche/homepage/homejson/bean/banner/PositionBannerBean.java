package com.bwf.tuanche.homepage.homejson.bean.banner;

/**
 * Created by BWF on 2016/8/17.
 */
public class PositionBannerBean {
    public String subTitle;

    public String bigTitle;

    public String adpInfoUrl;

    public String positionId;

    public String iconUrl;

    public String positionType;

    public String adType;

    @Override
    public String toString() {
        return "PositionBannerBean{" +
                "subTitle='" + subTitle + '\'' +
                ", bigTitle='" + bigTitle + '\'' +
                ", adpInfoUrl='" + adpInfoUrl + '\'' +
                ", positionId=" + positionId +
                ", iconUrl='" + iconUrl + '\'' +
                ", positionType=" + positionType +
                ", adType='" + adType + '\'' +
                '}';
    }
}
