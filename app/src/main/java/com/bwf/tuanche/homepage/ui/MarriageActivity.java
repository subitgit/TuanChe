package com.bwf.tuanche.homepage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;

import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.adapter.MarriageAdapte;
import com.bwf.tuanche.homepage.homejson.bean.marriage.CarSty;
import com.bwf.tuanche.homepage.homejson.bean.marriage.MarriageResult;
import com.bwf.tuanche.homepage.view.ListViewPlus;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by BWF on 2016/8/23.
 */
public class MarriageActivity extends BaseActivity implements ListViewPlus.ListViewPlusListener {
    private SimpleDraweeView marriage_title;
    private ListViewPlus marriage_lv;
    private ImageView marriage_back;
    private  List<CarSty> carstyleList;
    private MarriageAdapte adapte;
    private String time;


    @Override
    public int getContentViewId() {
        return R.layout.marriage;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        marriage_back = findViewByIdNoCast(R.id.marriage_back);
        marriage_back.setOnClickListener(this);
        marriage_lv = findViewByIdNoCast(R.id.marriage_lv);
        View head = View.inflate(this,R.layout.headview,null);
        marriage_title = (SimpleDraweeView) head.findViewById(R.id.marriage_title);
        marriage_lv.addHeaderView(head);
        marriage_lv.setRefreshTime("第一次刷新");
    }

    @Override
    public void initData() {
      HttpHelper.getMarriageCar(new HttpCallBack<MarriageResult>() {
          @Override
          public void onSuccess(MarriageResult result) {
              if (result!=null){
                  marriage_title.setImageURI(result.adpLogo);
                  marriage_title.setAspectRatio(2.5f);
                  carstyleList = result.carstyleList;
                  adapte = new MarriageAdapte(MarriageActivity.this,carstyleList);
                  marriage_lv.setAdapter(adapte);
                  marriage_lv.setListViewPlusListener(MarriageActivity.this);
              }
          }

          @Override
          public void onFail(String errMsg) {

          }
      });


    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.marriage_back:
               Intent intent = new Intent(this,HomeActivity.class);
               startActivity(intent);
               break;
       }

    }

    @Override
    public void onRefresh() {
        initData();
        if (time==null){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = formatter.format(new Date());
        }else {
            marriage_lv.setRefreshTime(time);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = formatter.format(new Date());
        }
        marriage_lv.stopRefresh();
    }

    @Override
    public void onLoadMore() {

    }
}
