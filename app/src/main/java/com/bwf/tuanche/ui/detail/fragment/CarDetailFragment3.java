package com.bwf.tuanche.ui.detail.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CarDetailResponseBean;
import com.bwf.tuanche.entity.detail.GuaranteeBean;
import com.bwf.tuanche.ui.detail.adapter.DetailRecycleViewAdapter;

import java.util.List;

/**
 * Created by Sandal on 2016/8/19.
 * Description:
 */
public class CarDetailFragment3 extends BaseFragment{


    private RecyclerView recyclerView;
    private DetailRecycleViewAdapter mAdapter;
    private WebView webView;
    @Override
    protected int getResource() {
        return R.layout.car_detail_fragment3;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {

        recyclerView = findViewByIdNoCast(R.id.recycleView);
        webView = findViewByIdNoCast(R.id.webView);

    }

    @Override
    protected void initData() {

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.loadUrl(UrlUtils.CAR_DETAIL_FLOW_URL);

    }

    @Override
    public void onClick(View v) {

    }

    public void setDatas(CarDetailResponseBean result) {
        String desc = result.tcbzDesc;
        if (!TextUtils.isEmpty(desc)) {
            desc = desc.replace("\\", "");
            List<GuaranteeBean> list = JSON.parseArray(desc, GuaranteeBean.class);
            mAdapter = new DetailRecycleViewAdapter(list, getContext());
            recyclerView.setAdapter(mAdapter);
        }

    }

}
