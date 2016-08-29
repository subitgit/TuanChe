package com.bwf.tuanche.ui.carselect.bean.option;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:级别
 */
public class BosBean implements Parcelable {
    public String id;

    public String icon;

    public String name;

    public String defIcon;

    public boolean isselected;

    @Override
    public String toString() {
        return "BosBean{" +
                "id='" + id + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", defIcon='" + defIcon + '\'' +
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
        dest.writeString(this.defIcon);
        dest.writeByte(this.isselected ? (byte) 1 : (byte) 0);
    }

    public BosBean() {
    }

    protected BosBean(Parcel in) {
        this.id = in.readString();
        this.icon = in.readString();
        this.name = in.readString();
        this.defIcon = in.readString();
        this.isselected = in.readByte() != 0;
    }

    public static final Parcelable.Creator<BosBean> CREATOR = new Parcelable.Creator<BosBean>() {
        @Override
        public BosBean createFromParcel(Parcel source) {
            return new BosBean(source);
        }

        @Override
        public BosBean[] newArray(int size) {
            return new BosBean[size];
        }
    };
}
