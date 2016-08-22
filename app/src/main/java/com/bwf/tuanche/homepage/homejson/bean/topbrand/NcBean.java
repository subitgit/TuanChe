package com.bwf.tuanche.homepage.homejson.bean.topbrand;

/**
 * Created by BWF on 2016/8/16.
 */
public class NcBean {
    public String weight;

    public String name;

    public String pic;

    public String show;

    public String type;

    public String modules;

    public String is_ng;

    public String is_login;

    public String url;


    @Override
    public String toString() {
        return "NcBean{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", show=" + show +
                ", type=" + type +
                ", modules=" + modules +
                ", is_ng=" + is_ng +
                ", is_login=" + is_login +
                '}';
    }
}
