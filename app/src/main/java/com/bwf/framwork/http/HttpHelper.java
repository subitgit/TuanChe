package com.bwf.framwork.http;


import com.zhy.http.okhttp.OkHttpUtils;

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
    public static void getBrandCarSelect(String url,int cityId,HttpCallBack callBack){
        OkHttpUtils
                .post()
              //  .addParams("cityId",cityId+"")
                .url("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_SelectTopBrand?cityId=156")
                .build()
                .execute(callBack);
    }

}
