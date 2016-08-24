package com.bwf.tuanche.homepage.homejson.bean.marriage;

import java.util.List;

/**
 * Created by BWF on 2016/8/23.
 */
public class MarriageResult {
    public String adpTitle;
    public String adpLogo;
    public String shareUrl;
    public String sharePic;
    public String shareCtx;
    public String shareSlogan;
    public String isShare;
    public String cardTotal;
    public String offset;
    public String count;
    public List<CarSty> carstyleList;

    @Override
    public String toString() {
        return "MarriageResult{" +
                "adpTitle='" + adpTitle + '\'' +
                ", adpLogo='" + adpLogo + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", sharePic='" + sharePic + '\'' +
                ", shareCtx='" + shareCtx + '\'' +
                ", shareSlogan='" + shareSlogan + '\'' +
                ", isShare='" + isShare + '\'' +
                ", cardTotal='" + cardTotal + '\'' +
                ", offset='" + offset + '\'' +
                ", count='" + count + '\'' +
                ", carstyleList=" + carstyleList +
                '}';
    }
}
