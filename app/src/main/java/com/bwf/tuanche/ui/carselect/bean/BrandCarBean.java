package com.bwf.tuanche.ui.carselect.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/16.
 * Description:
 */
public class BrandCarBean implements Parcelable {

    private int id;

    private String name;

    private String logo;

    private int baseNum;

    private int modelType;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public String getLogo(){
        return this.logo;
    }
    public void setBaseNum(int baseNum){
        this.baseNum = baseNum;
    }
    public int getBaseNum(){
        return this.baseNum;
    }
    public void setModelType(int modelType){
        this.modelType = modelType;
    }
    public int getModelType(){
        return this.modelType;
    }

    @Override
    public String toString() {
        return "BrandCarBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum=" + baseNum +
                ", modelType=" + modelType +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.logo);
        dest.writeInt(this.baseNum);
        dest.writeInt(this.modelType);
    }

    public BrandCarBean() {
    }

    protected BrandCarBean(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.logo = in.readString();
        this.baseNum = in.readInt();
        this.modelType = in.readInt();
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
