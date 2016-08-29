package com.bwf.framwork.http;


import android.content.Context;

import com.bwf.framwork.Constants;
import com.bwf.framwork.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {


    public static void getDetail(Context context,String cityId ,String brandId,String styleId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .tag(context)
                .url(UrlUtils.CAR_DETAIL_URL)
                .addParams("cityId", cityId )
                .addParams("styleId", styleId )
                .addParams("brandId", brandId )
                .build()
                .execute(callBack);

    }

    public static void getCommentList(Context context,String offset,String cityId,String brandId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(UrlUtils.ALL_COMMENT_URL)
                .tag(context)
                .addParams("count", Constants.COUNTT+"")
                .addParams("offset", offset )
                .addParams("cityId", cityId )
                .addParams("brandId", brandId )
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
    public static void getBrandCarSelect(String url,String cityId,HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .addParams("cityId",cityId+"")
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
