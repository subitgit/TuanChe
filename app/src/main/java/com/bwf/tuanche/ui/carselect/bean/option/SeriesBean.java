package com.bwf.tuanche.ui.carselect.bean.option;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:国别
 */
public class SeriesBean implements Parcelable {
    public String id;

    public String icon;

    public String name;

    public boolean isselected;

    @Override
    public String toString() {
        return "SeriesBean{" +
                "id='" + id + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", isselected=" + isselected +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.icon);
        dest.writeString(this.name);
        dest.writeByte(this.isselected ? (byte) 1 : (byte) 0);
    }

    public SeriesBean() {
    }

    protected SeriesBean(Parcel in) {
        this.id = in.readString();
        this.icon = in.readString();
        this.name = in.readString();
        this.isselected = in.readByte() != 0;
    }

    public static final Parcelable.Creator<SeriesBean> CREATOR = new Parcelable.Creator<SeriesBean>() {
        @Override
        public SeriesBean createFromParcel(Parcel source) {
            return new SeriesBean(source);
        }

        @Override
        public SeriesBean[] newArray(int size) {
            return new SeriesBean[size];
        }
    };
}
