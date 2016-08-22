package com.bwf.tuanche.homepage.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by BWF on 2016/8/22.
 */
public class WebSiteViewActivity extends BaseActivity {
    private TextView webView_title;
    private ImageView webView_back;
    private WebView webView;
    private String title;
    private String url;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public int getContentViewId() {
        return R.layout.homepager_web;
    }

    @Override
    public void beforeInitView() {
        title = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");
    }

    @Override
    public void initView() {
        webView_title = findViewByIdNoCast(R.id.webView_title);
        webView_back = findViewByIdNoCast(R.id.webView_back);
        webView_back.setOnClickListener(this);
        webView = findViewByIdNoCast(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLoadsImagesAutomatically(true);
    }

    @Override
    public void initData() {
        webView_title.setText(title);
        webView.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.webView_back:
                Intent intent = new Intent(WebSiteViewActivity.this,HomeActivity.class);
                startActivity(intent);
            break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
            return super.onKeyDown(keyCode, event);
    }
}
