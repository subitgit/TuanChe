package com.bwf.tuanche.ui.detail.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;
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

    }

    @Override
    protected void initData() {

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void onClick(View v) {

    }

    public void setDatas(String result) {
        if (!TextUtils.isEmpty(result)) {
            result = result.replace("\\", "");
            List<GuaranteeBean> list = JSON.parseArray(result, GuaranteeBean.class);
            mAdapter = new DetailRecycleViewAdapter(list, getContext());
            recyclerView.setAdapter(mAdapter);
        }
    }
}
