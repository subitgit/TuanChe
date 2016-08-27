package com.bwf.czg.entity.version;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by caozhiguo on 2016/8/18.
 * Description:
 */
public class VersionResultBean extends BaseBean implements Parcelable {
    public String versionCode;
    public String versionName;
    public String url;
    public String md5file;
    public String description;//更新详细
    public String upgradeIntervalWarn;
    public String isFourceUpGrade;
    public String isPromtUpGrade;
    public String titleText;
    public String giveUpText;
    public String upgradeText;
    public String textPic;
    public String isForce;
    public String specificEdition;
    public String minVersion;

    @Override
    public String toString() {
        return "VersionResultBean{" +
                "versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", url='" + url + '\'' +
                ", md5file='" + md5file + '\'' +
                ", description='" + description + '\'' +
                ", upgradeIntervalWarn='" + upgradeIntervalWarn + '\'' +
                ", isFourceUpGrade='" + isFourceUpGrade + '\'' +
                ", isPromtUpGrade='" + isPromtUpGrade + '\'' +
                ", titleText='" + titleText + '\'' +
                ", giveUpText='" + giveUpText + '\'' +
                ", upgradeText='" + upgradeText + '\'' +
                ", textPic='" + textPic + '\'' +
                ", isForce='" + isForce + '\'' +
                ", specificEdition='" + specificEdition + '\'' +
                ", minVersion='" + minVersion + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.versionCode);
        dest.writeString(this.versionName);
        dest.writeString(this.url);
        dest.writeString(this.md5file);
        dest.writeString(this.description);
        dest.writeString(this.upgradeIntervalWarn);
        dest.writeString(this.isFourceUpGrade);
        dest.writeString(this.isPromtUpGrade);
        dest.writeString(this.titleText);
        dest.writeString(this.giveUpText);
        dest.writeString(this.upgradeText);
        dest.writeString(this.textPic);
        dest.writeString(this.isForce);
        dest.writeString(this.specificEdition);
        dest.writeString(this.minVersion);
    }

    public VersionResultBean() {
    }

    protected VersionResultBean(Parcel in) {
        this.versionCode = in.readString();
        this.versionName = in.readString();
        this.url = in.readString();
        this.md5file = in.readString();
        this.description = in.readString();
        this.upgradeIntervalWarn = in.readString();
        this.isFourceUpGrade = in.readString();
        this.isPromtUpGrade = in.readString();
        this.titleText = in.readString();
        this.giveUpText = in.readString();
        this.upgradeText = in.readString();
        this.textPic = in.readString();
        this.isForce = in.readString();
        this.specificEdition = in.readString();
        this.minVersion = in.readString();
    }

    public static final Parcelable.Creator<VersionResultBean> CREATOR = new Parcelable.Creator<VersionResultBean>() {
        @Override
        public VersionResultBean createFromParcel(Parcel source) {
            return new VersionResultBean(source);
        }

        @Override
        public VersionResultBean[] newArray(int size) {
            return new VersionResultBean[size];
        }
    };
}
