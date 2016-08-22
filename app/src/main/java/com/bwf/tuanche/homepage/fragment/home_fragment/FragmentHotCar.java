package com.bwf.tuanche.homepage.fragment.home_fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.adapter.HotCarAdapter;
import com.bwf.tuanche.homepage.homejson.bean.hotcar.HotCarBean;

import java.util.List;

/**
 * Created by BWF on 2016/8/17.
 */
public class FragmentHotCar extends BaseFragment {
    private RecyclerView  recyclerView;
    private HotCarAdapter hotCarAdapter;
    private  List<HotCarBean> list;

    public void setList(List<HotCarBean> list) {
        this.list = list;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_hotcar;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        recyclerView = findViewByIdNoCast(R.id.recyclerView);
    }

    @Override
    protected void initData() {
    if (list!=null&&list.size()!=0){
        hotCarAdapter = new HotCarAdapter(getContext(),list);
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(hotCarAdapter);
    }
    }

    @Override
    public void onClick(View v) {

    }
}
