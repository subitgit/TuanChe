package com.bwf.tuanche.homepage.homejson.bean.hotlogo;

/**
 * Created by BWF on 2016/8/17.
 */
public class HotLogListBean {
    public  int id;

    public String name;

    public String logo;

    public int baseNum;

    public int modelType;


    @Override
    public String toString() {
        return "HotLogListBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum=" + baseNum +
                ", modelType=" + modelType +
                '}';
    }
}
