package com.bwf.tuanche.ui.carselect.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.bean.BrandCarBean;

import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:
 */
public class BrandCarSelectAdapter extends BaseListAdpter<BrandCarBean,BrandCarSelectAdapter.ViewHolder>{


    public BrandCarSelectAdapter(Context context) {
        super(context);
    }

    public BrandCarSelectAdapter(List<BrandCarBean> brandCarBeen, Context context) {
        super(brandCarBeen, context);
    }

    @Override
    public int getResourceId() {
        return R.layout.item_ll_brand_carsel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, BrandCarBean brandCarBean, int position) {

    }

    public class ViewHolder extends BaseListAdpter.ViewHolder{

    }
}
