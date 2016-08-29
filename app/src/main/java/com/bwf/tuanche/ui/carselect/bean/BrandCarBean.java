package com.bwf.tuanche.ui.carselect.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/16.
 * Description:
 */
public class BrandCarBean implements Parcelable {

    public String id;

    public String name;

    public String logo;

    public String baseNum;

    public String modelType;


    public String pinyin;


    public String penname;

    @Override
    public String toString() {
        return "BrandCarBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum='" + baseNum + '\'' +
                ", modelType='" + modelType + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", penname='" + penname + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.logo);
        dest.writeString(this.baseNum);
        dest.writeString(this.modelType);
        dest.writeString(this.pinyin);
        dest.writeString(this.penname);
    }

    public BrandCarBean() {
    }

    protected BrandCarBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.logo = in.readString();
        this.baseNum = in.readString();
        this.modelType = in.readString();
        this.pinyin = in.readString();
        this.penname = in.readString();
    }

    public static final Parcelable.Creator<BrandCarBean> CREATOR = new Parcelable.Creator<BrandCarBean>() {
        @Override
        public BrandCarBean createFromParcel(Parcel source) {
            return new BrandCarBean(source);
        }

        @Override
        public BrandCarBean[] newArray(int size) {
            return new BrandCarBean[size];
        }
    };
}
