package com.bwf.tuanche.entity.detail;

/**
 * Created by Sandal on 2016/8/18.
 * Description:
 */
public class LocationInfoBean {
    public String id;

    public String name;

    public String pinyin;

    public String py;

    public String openStatus;

    @Override
    public String toString() {
        return "LocationInfoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", py='" + py + '\'' +
                ", openStatus=" + openStatus +
                '}';
    }
}
