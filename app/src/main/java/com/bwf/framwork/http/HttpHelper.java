package com.bwf.framwork.http;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {


    public static void getDetail(String url,String pageNo,String pageSize,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageNo", pageNo)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }


    /**
     * 首页TopBrand请求数据
     * @param cityId
     * @param callBack
     */
    public static void getTopBrandDetail(String  cityId ,HttpCallBack callBack){
        OkHttpUtils
                .get()
                .url("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_HomeServlet")
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    /**
     * 首页热门品牌请求数据
     * @param cityId
     * @param callBack
     */
    public static void getHotLog(String  cityId ,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_TopBrand")
                .addParams("isBuy", "2")
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    /**
     * 请求首页Banner
     * @param cityId
     * @param callBack
     */

    public static void getBanner(String  cityId ,HttpCallBack callBack){
        OkHttpUtils
                .get()
                .url("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_BannerServlet")
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    /**
     * 首页热门车型请求数据
     * @param cityId
     * @param callBack
     */

    public static void getHotCar(String  cityId ,HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .url("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_Hotstyle")
                .addParams("count", "10")
                .addParams("offset", "0")
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    /**
     * 搜索页 热门搜索
     * @param cityId
     * @param callBack
     */

    public static void getHotSearch(String  cityId ,HttpArrayCallBack callBack){
        OkHttpUtils
                .get()
                .url("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_SearchhotServlet")
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }



}
