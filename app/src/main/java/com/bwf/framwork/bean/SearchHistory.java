package com.bwf.framwork.bean;


import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by BWF on 2016/8/18.
 */
public class SearchHistory implements Parcelable{
    public String history;
    public String date;


    public SearchHistory(String history, String date) {
        this.history = history;
        this.date = date;
    }



    @Override
    public String toString() {
        return "SearchHistory{" +
                "history='" + history + '\'' +
                ", date=" + date +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.history);
        dest.writeString(this.date);
    }

    public SearchHistory() {

    }

    protected SearchHistory(Parcel in) {
        this.history = in.readString();
        this.date = in.readString();
    }

    public static final Parcelable.Creator<SearchHistory> CREATOR = new Parcelable.Creator<SearchHistory>() {
        @Override
        public SearchHistory createFromParcel(Parcel source) {
            return new SearchHistory(source);
        }

        @Override
        public SearchHistory[] newArray(int size) {
            return new SearchHistory[size];
        }
    };


}
