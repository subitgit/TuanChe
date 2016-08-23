package com.bwf.tuanche.ui.detail.fragment;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;

/**
 * Created by Sandal on 2016/8/22.
 * Description:
 */
public class CarDetailFragment4 extends BaseFragment {

    private WebView webView;
    @Override
    protected int getResource() {
        return R.layout.car_detail_fragment4;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        webView = findViewByIdNoCast(R.id.webView);
    }

    @Override
    protected void initData() {
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.loadUrl(UrlUtils.CAR_DETAIL_QUSTION_URL);
    }

    @Override
    public void onClick(View v) {

    }

}
