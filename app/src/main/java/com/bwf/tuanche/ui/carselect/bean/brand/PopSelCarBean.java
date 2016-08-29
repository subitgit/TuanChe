package com.bwf.tuanche.ui.carselect.bean.brand;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.utils.PinYinUtil;
import com.bwf.tuanche.ui.carselect.bean.BrandCarBean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/18.
 * Description:
 */
public class PopSelCarBean implements Parcelable {

    public String id;

    public String brandId;

    public String logo;

    public String styleName;

    public String factoryPrice;

    public String content;

    public String isBuy;

    public String manNum;

    public String isNew;

    public String prefix;

    public String suffix;

    public String levelStr;

    public String brandName;

    public String carModelPrices;

    public String firmBrandId;

    public String identify;

    public String basePrice;

    public String pricePrefix;

    public String price;

    public String priceSuffix;

    public String adInfo;

    public String ecLable;

    public static void orderByName(List<PopSelCarBean> beans){
            Collections.sort(beans, new Comparator<PopSelCarBean>() {
                @Override
                public int compare(PopSelCarBean lhs, PopSelCarBean rhs) {
                    String l = PinYinUtil.getFirstTag(lhs.brandName);
                    String r = PinYinUtil.getFirstTag(rhs.brandName);
                    int i= l.compareTo(r);
                    return i;
                }
            });
    }

    @Override
    public String toString() {
        return "PopSelCarBean{" +
                "id='" + id + '\'' +
                ", brandId='" + brandId + '\'' +
                ", logo='" + logo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", factoryPrice='" + factoryPrice + '\'' +
                ", content='" + content + '\'' +
                ", isBuy='" + isBuy + '\'' +
                ", manNum='" + manNum + '\'' +
                ", isNew='" + isNew + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", levelStr='" + levelStr + '\'' +
                ", brandName='" + brandName + '\'' +
                ", carModelPrices='" + carModelPrices + '\'' +
                ", firmBrandId='" + firmBrandId + '\'' +
                ", identify='" + identify + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", pricePrefix='" + pricePrefix + '\'' +
                ", price='" + price + '\'' +
                ", priceSuffix='" + priceSuffix + '\'' +
                ", adInfo='" + adInfo + '\'' +
                ", ecLable='" + ecLable + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.brandId);
        dest.writeString(this.logo);
        dest.writeString(this.styleName);
        dest.writeString(this.factoryPrice);
        dest.writeString(this.content);
        dest.writeString(this.isBuy);
        dest.writeString(this.manNum);
        dest.writeString(this.isNew);
        dest.writeString(this.prefix);
        dest.writeString(this.suffix);
        dest.writeString(this.levelStr);
        dest.writeString(this.brandName);
        dest.writeString(this.carModelPrices);
        dest.writeString(this.firmBrandId);
        dest.writeString(this.identify);
        dest.writeString(this.basePrice);
        dest.writeString(this.pricePrefix);
        dest.writeString(this.price);
        dest.writeString(this.priceSuffix);
        dest.writeString(this.adInfo);
        dest.writeString(this.ecLable);
    }

    public PopSelCarBean() {
    }

    protected PopSelCarBean(Parcel in) {
        this.id = in.readString();
        this.brandId = in.readString();
        this.logo = in.readString();
        this.styleName = in.readString();
        this.factoryPrice = in.readString();
        this.content = in.readString();
        this.isBuy = in.readString();
        this.manNum = in.readString();
        this.isNew = in.readString();
        this.prefix = in.readString();
        this.suffix = in.readString();
        this.levelStr = in.readString();
        this.brandName = in.readString();
        this.carModelPrices = in.readString();
        this.firmBrandId = in.readString();
        this.identify = in.readString();
        this.basePrice = in.readString();
        this.pricePrefix = in.readString();
        this.price = in.readString();
        this.priceSuffix = in.readString();
        this.adInfo = in.readString();
        this.ecLable = in.readString();
    }

    public static final Parcelable.Creator<PopSelCarBean> CREATOR = new Parcelable.Creator<PopSelCarBean>() {
        @Override
        public PopSelCarBean createFromParcel(Parcel source) {
            return new PopSelCarBean(source);
        }

        @Override
        public PopSelCarBean[] newArray(int size) {
            return new PopSelCarBean[size];
        }
    };
}
