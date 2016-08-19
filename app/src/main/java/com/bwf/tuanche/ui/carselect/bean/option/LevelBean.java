package com.bwf.tuanche.ui.carselect.bean.option;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:排量
 */
public class LevelBean implements Parcelable {
    public String id;

    public String name;

    public boolean isselected;

    @Override
    public String toString() {
        return "LevelBean{" +
                "id='" + id + '\'' +
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
        dest.writeString(this.name);
        dest.writeByte(this.isselected ? (byte) 1 : (byte) 0);
    }

    public LevelBean() {
    }

    protected LevelBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.isselected = in.readByte() != 0;
    }

    public static final Parcelable.Creator<LevelBean> CREATOR = new Parcelable.Creator<LevelBean>() {
        @Override
        public LevelBean createFromParcel(Parcel source) {
            return new LevelBean(source);
        }

        @Override
        public LevelBean[] newArray(int size) {
            return new LevelBean[size];
        }
    };
}
