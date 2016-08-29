package com.bwf.tuanche.ui.carselect.adapter.popcar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.bean.brand.PopSelCarBean;
import com.bwf.tuanche.ui.detail.CarDetailActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/18.
 * Description:
 */
public class PopCarSleAdapter extends BaseListAdpter<PopSelCarBean, PopCarSleAdapter.ViewHolder> {
    private ImageLoader imageLoader;
    private Map<String, Integer> convertNames;
    private Context context;

    public PopCarSleAdapter(Context context) {
        super(context);
        this.context = context;
        imageLoader = ImageLoader.getInstance();
        convertNames = new HashMap<>();
        convertNames.put("", -1);
    }

    @Override
    public int getResourceId() {
        return R.layout.item_pop_carsel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tv_pop_carsel_lable = findViewByIdNoCast(R.id.tv_pop_carsel_lable);
        viewHolder.ll_pop_carsel = findViewByIdNoCast(R.id.ll_pop_carsel);
        viewHolder.sdv_pop_carsel = findViewByIdNoCast(R.id.sdv_pop_carsel);
        viewHolder.tv_pop_carsel_name = findViewByIdNoCast(R.id.tv_pop_carsel_name);
        viewHolder.tv_pop_carsel_direct_price = findViewByIdNoCast(R.id.tv_pop_carsel_direct_price);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final PopSelCarBean popSelCarBean, int position) {
        if (popSelCarBean == null)
            return;
        holder.tv_pop_carsel_lable.setVisibility(View.GONE);
        String brandName = popSelCarBean.brandName.replace("-", "").replace(" ", "");
        boolean flag = true;
        for (Map.Entry<String, Integer> entry : convertNames.entrySet()) {
            if (entry.getKey().equals(brandName) && entry.getValue() != position) {
                flag = false;
            }
            if (entry.getKey().equals(brandName) && entry.getValue() == position) {
                holder.tv_pop_carsel_lable.setText(brandName);
                holder.tv_pop_carsel_lable.setVisibility(View.VISIBLE);
            }
        }
        if (flag)
            convertNames.put(brandName, position);
        if (popSelCarBean.styleName != null)
            holder.tv_pop_carsel_name.setText(popSelCarBean.styleName);
        if (popSelCarBean.basePrice != null && popSelCarBean.price != null)
            holder.tv_pop_carsel_direct_price.setText("指导价格:" + popSelCarBean.price + "万");
        if (popSelCarBean.logo != null)
            imageLoader.disPlayImage(holder.sdv_pop_carsel, popSelCarBean.logo);
        holder.ll_pop_carsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String brandId = popSelCarBean.brandId;
                String  styleId=popSelCarBean.id;
                if (brandId!=null)
                    bundle.putString("brandId",brandId);
                if (styleId!=null)
                    bundle.putString("styleId",styleId);
                IntentUtils.openActivity(context, CarDetailActivity.class, bundle);
            }
        });

    }

    public class ViewHolder extends BaseListAdpter.ViewHolder {
        public TextView tv_pop_carsel_lable, tv_pop_carsel_name, tv_pop_carsel_direct_price;
        public SimpleDraweeView sdv_pop_carsel;
        public LinearLayout ll_pop_carsel;
    }
}
