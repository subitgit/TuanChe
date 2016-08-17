package com.bwf.tuanche.entity.detail;

/**
 * Created by Sandal on 2016/8/17.
 * Description:
 */
public class CarDetailResponseBean {

    public double commentTotal;

    public String regular4sShop;

    public String isFree;

    public String isLowest;

    public String isPriorityBy4S;

    public String isAllFree;

    public CommentBean comment;

    public String groupbuyDate;

    public String groupbuyWeek;

    public int salerId;

    public int id;

    public String logo;//汽车大图片

    public String styleName;

    public String factoryPrice;

    public String content;

    public int isBuy;

    public int manNum;

    public int state;

    public String isCompensate;

    public String addUp;

    public String brandLogo;

    public String flowUrl;

    public String questionUrl;

    public BuyWaysBean buyWays;

    public String manNumDesc;

    public String brandName;

    public String brandPic;

    public SsgTzBean ssgTz;

    public String passNum;

    public int brandGroupStyleNum;

    public int brandGroupStyleManNum;

    public String shareBrandTitle;

    public String shareStyleTitle;

    public String shareDesc;

    public String shareBrandUrl;

    public String shareStyleUrl;

    public String tcbzDesc;

    public int brandId;

    public int styleId;

    public String saveUpString;//累计为团友额外

    public String saveUpMoney;//节省32.0万

    public boolean special;


    @Override
    public String toString() {
        return "CarDetailResponseBean{" +
                "commentTotal=" + commentTotal +
                ", regular4sShop='" + regular4sShop + '\'' +
                ", isFree='" + isFree + '\'' +
                ", isLowest='" + isLowest + '\'' +
                ", isPriorityBy4S='" + isPriorityBy4S + '\'' +
                ", isAllFree='" + isAllFree + '\'' +
                ", comment=" + comment +
                ", groupbuyDate='" + groupbuyDate + '\'' +
                ", groupbuyWeek='" + groupbuyWeek + '\'' +
                ", salerId=" + salerId +
                ", id=" + id +
                ", logo='" + logo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", factoryPrice='" + factoryPrice + '\'' +
                ", content='" + content + '\'' +
                ", isBuy=" + isBuy +
                ", manNum=" + manNum +
                ", state=" + state +
                ", isCompensate='" + isCompensate + '\'' +
                ", addUp='" + addUp + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", flowUrl='" + flowUrl + '\'' +
                ", questionUrl='" + questionUrl + '\'' +
                ", buyWays=" + buyWays +
                ", manNumDesc='" + manNumDesc + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", ssgTz=" + ssgTz +
                ", passNum='" + passNum + '\'' +
                ", brandGroupStyleNum=" + brandGroupStyleNum +
                ", brandGroupStyleManNum=" + brandGroupStyleManNum +
                ", shareBrandTitle='" + shareBrandTitle + '\'' +
                ", shareStyleTitle='" + shareStyleTitle + '\'' +
                ", shareDesc='" + shareDesc + '\'' +
                ", shareBrandUrl='" + shareBrandUrl + '\'' +
                ", shareStyleUrl='" + shareStyleUrl + '\'' +
                ", tcbzDesc='" + tcbzDesc + '\'' +
                ", brandId=" + brandId +
                ", styleId=" + styleId +
                ", saveUpString='" + saveUpString + '\'' +
                ", saveUpMoney='" + saveUpMoney + '\'' +
                ", special=" + special +
                '}';
    }
}
