package com.bwf.framwork;

import com.bwf.framwork.base.BaseBean;

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
    //品牌选车列表
    public static final String BRANDCAR_SELECT = "bwf_TuanChe_XuanbrandmapServlet";
    public static final String BRANDCAR_SELECT_IN_URL = TUANCHE_SERVER + BRANDCAR_SELECT;
    //选车热门品牌
    public static final String BRANDCAR_HOTSTYLE = "bwf_TuanChe_SelectTopBrand";
    public static final String BRANDCAR_SELECT_HOT_URL = TUANCHE_SERVER + BRANDCAR_HOTSTYLE;
    //条件选车
    public static final String OPTION_SELECT = "bwf_TuanChe_SelectCarInfosServlet";
    public static final String OPTION_SELECT_URL = TUANCHE_SERVER + OPTION_SELECT;
    //pupwin选车
    public static final String OPTION_POPWIN_SELECT = "bwf_TuanChe_BrandCarStyleServlet";
    public static final String OPTION_POPWIN_SELECT_URL = TUANCHE_SERVER + OPTION_POPWIN_SELECT;



}
