package com.bwf.framwork.http;


import com.bwf.czg.entity.city.ResultBean;
import com.bwf.czg.entity.dingwei.DingWeiResultBean;
import com.bwf.czg.entity.version.VersionResultBean;
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

    public static void getNowCity(String url,String longitude,String latitude,HttpCallBack<DingWeiResultBean> callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("longitude", longitude)
                .addParams("latitude", latitude)
                .build()
                .execute(callBack);
    }

    public static void getCitys(String url,HttpCallBack<ResultBean> callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageSize", "4")
                .build()
                .execute(callBack);
    }

    public static void getVersionMsg(String url,HttpCallBack<VersionResultBean> callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }

    public static void getBrandCarSelect(String url,String cityId,HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .addParams("cityId",cityId+"")
                .url(url)
                .build()
                .execute(callBack);
    }
    public static void getBrandCarSelectHot(String url,String cityId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .addParams("cityId",cityId)
                .addParams("isBuy","2")
                .url(url)
                .build()
                .execute(callBack);
    }
    public static void getOptionSelect(String url,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }
    public static void getPopWinCarList(String url,String cityId,String brandId,int type,HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .addParams("cityId",cityId+"")
                .addParams("type",type+"")
                .addParams("brandId",brandId)
                .url(url)
                .build()
                .execute(callBack);
    }

}
