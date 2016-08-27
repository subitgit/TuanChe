package com.bwf.czg.entity.dingwei;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by caozhiguo on 2016/8/18.
 * Description:
 */
public class DingWeiResultBean extends BaseBean implements Parcelable {

    public String id;
    public String name;
    public String pinyin;
    public String py;
    public String openStatus;

    @Override
    public String toString() {
        return "DingWeiResultBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
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
        dest.writeString(this.pinyin);
        dest.writeString(this.py);
        dest.writeString(this.openStatus);
    }

    public DingWeiResultBean() {
    }

    protected DingWeiResultBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.pinyin = in.readString();
        this.py = in.readString();
        this.openStatus = in.readString();
    }

    public static final Parcelable.Creator<DingWeiResultBean> CREATOR = new Parcelable.Creator<DingWeiResultBean>() {
        @Override
        public DingWeiResultBean createFromParcel(Parcel source) {
            return new DingWeiResultBean(source);
        }

        @Override
        public DingWeiResultBean[] newArray(int size) {
            return new DingWeiResultBean[size];
        }
    };
}
