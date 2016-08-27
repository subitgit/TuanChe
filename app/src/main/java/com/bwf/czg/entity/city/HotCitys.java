package com.bwf.czg.entity.city;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by caozhiguo on 2016/8/18.
 * Description:
 */
public class HotCitys implements Parcelable {

    public  String id;

    public  String name;

    public  String province;

    public  String pinyin;

    public  String pname;

    public  String py;

    public  String openStatus;

    @Override
    public String toString() {
        return "HotCitys{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", pname='" + pname + '\'' +
                ", py='" + py + '\'' +
                ", openStatus='" + openStatus + '\'' +
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
        dest.writeString(this.province);
        dest.writeString(this.pinyin);
        dest.writeString(this.pname);
        dest.writeString(this.py);
        dest.writeString(this.openStatus);
    }

    public HotCitys() {
    }

    protected HotCitys(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.province = in.readString();
        this.pinyin = in.readString();
        this.pname = in.readString();
        this.py = in.readString();
        this.openStatus = in.readString();
    }

    public static final Creator<HotCitys> CREATOR = new Creator<HotCitys>() {
        @Override
        public HotCitys createFromParcel(Parcel source) {
            return new HotCitys(source);
        }

        @Override
        public HotCitys[] newArray(int size) {
            return new HotCitys[size];
        }
    };
}
