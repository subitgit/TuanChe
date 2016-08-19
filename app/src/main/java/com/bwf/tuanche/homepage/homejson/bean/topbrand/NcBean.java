package com.bwf.tuanche.homepage.homejson.bean.topbrand;

/**
 * Created by BWF on 2016/8/16.
 */
public class NcBean {
    public int weight;

    public String name;

    public String pic;

    public boolean show;

    public int type;

    public int modules;

    public int is_ng;

    public int is_login;


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
