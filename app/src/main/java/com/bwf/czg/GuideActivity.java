package com.bwf.czg;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {
    private ViewPager viewPager;
    private List<View> viewList;
    private View guide1,guide2;
    private MyPagerAdapter adapter;
    private Button btn_begin;




    @Override
    public int getContentViewId() {
        return R.layout.activity_guide;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        SharePrefreceHelper.getInstence(this).setIsFirst(false);

        //ViewPager
        viewPager= findViewByIdNoCast(R.id.vp_guide);
        LayoutInflater inflater = getLayoutInflater();
        guide1 = inflater.inflate(R.layout.guide1,null);
        guide2 = inflater.inflate(R.layout.guide2,null);

        viewList = new ArrayList<>();
        viewList.add(guide1);
        viewList.add(guide2);
        adapter = new MyPagerAdapter();
        viewPager.setAdapter(adapter);
        //立即开始
        btn_begin = (Button) guide2.findViewById(R.id.btn_begin);

    }

    @Override
    public void initData() {
        btn_begin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_begin:
                IntentUtils.openActivity(this,SelectCityActivity.class);
        }
    }

    //ViewPager的适配器内部类
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
             return viewList.get(position);

        }
    }
}
