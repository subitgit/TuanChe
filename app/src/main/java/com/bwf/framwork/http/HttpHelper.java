package com.bwf.framwork.http;


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


    public static void getDetail(String cityId ,String brandId,String styleId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(UrlUtils.CAR_DETAIL_URL)
                .addParams("cityId", cityId )
                .addParams("styleId", styleId )
                .addParams("brandId", brandId )
                .build()
                .execute(callBack);

    }

}
