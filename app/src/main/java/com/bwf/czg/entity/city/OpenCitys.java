package com.bwf.czg.entity.city;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by caozhiguo on 2016/8/18.
 * Description:
 */
public class OpenCitys implements Parcelable {

    public String id;
    public String name;
    public String province;
    public String pinyin;
    public String citycode;
    public String pname;
    public String py;
    public String openStatus;
    public String manNum;

    @Override
    public String toString() {
        return "OpenCitys{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", citycode='" + citycode + '\'' +
                ", pname='" + pname + '\'' +
                ", py='" + py + '\'' +
                ", openStatus='" + openStatus + '\'' +
                ", manNum='" + manNum + '\'' +
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
        dest.writeString(this.citycode);
        dest.writeString(this.pname);
        dest.writeString(this.py);
        dest.writeString(this.openStatus);
        dest.writeString(this.manNum);
    }

    public OpenCitys() {
    }

    protected OpenCitys(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.province = in.readString();
        this.pinyin = in.readString();
        this.citycode = in.readString();
        this.pname = in.readString();
        this.py = in.readString();
        this.openStatus = in.readString();
        this.manNum = in.readString();
    }

    public static final Parcelable.Creator<OpenCitys> CREATOR = new Parcelable.Creator<OpenCitys>() {
        @Override
        public OpenCitys createFromParcel(Parcel source) {
            return new OpenCitys(source);
        }

        @Override
        public OpenCitys[] newArray(int size) {
            return new OpenCitys[size];
        }
    };
}
