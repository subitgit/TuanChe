package com.bwf.tuanche.homepage.homejson.bean.hotcar;

/**
 * Created by BWF on 2016/8/17.
 */
public class HotCarBean {
    public int id;

    public int brandId;

    public String logo;

    public String styleName;

    public String factoryPrice;

    public String content;

    public int isBuy;

    public int manNum;

    public int isNew;

    public String prefix;

    public String suffix;

    public String levelStr;

    public String brandName;

    public String carModelPrices;

    public int firmBrandId;

    public int identify;

    public String basePrice;

    public String pricePrefix;

    public String price;

    public String priceSuffix;

    public String adInfo;

    public String ecLable;


    @Override
    public String toString() {
        return "HotCarBean{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", logo='" + logo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", factoryPrice='" + factoryPrice + '\'' +
                ", content='" + content + '\'' +
                ", isBuy=" + isBuy +
                ", manNum=" + manNum +
                ", isNew=" + isNew +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", levelStr='" + levelStr + '\'' +
                ", brandName='" + brandName + '\'' +
                ", carModelPrices='" + carModelPrices + '\'' +
                ", firmBrandId=" + firmBrandId +
                ", identify=" + identify +
                ", basePrice='" + basePrice + '\'' +
                ", pricePrefix='" + pricePrefix + '\'' +
                ", price='" + price + '\'' +
                ", priceSuffix='" + priceSuffix + '\'' +
                ", adInfo='" + adInfo + '\'' +
                ", ecLable='" + ecLable + '\'' +
                '}';
    }
}
