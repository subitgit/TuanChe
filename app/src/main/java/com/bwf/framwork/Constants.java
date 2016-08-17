package com.bwf.framwork;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description: 常量类
 */
public class Constants {

    public static final String DB_NAME = "tuanche_db";//数据库名称

    public static final int DB_VERSION = 1;//数据库版本

    //数据库所有的表
    public static String[] TABLES = new String[]{};

    public static final String TUANCHE_SERVER = "http://123.56.145.151:8080/TuanCheNetWork/";

   public static final String BRANDCAR_SELECT= "bwf_TuanChe_SelectTopBrand";
   public static final String BRANDCAR_SELECT_IN=TUANCHE_SERVER +BRANDCAR_SELECT;

}
