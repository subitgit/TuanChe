package com.bwf.tuanche.ui.carselect.adapter.brandsel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.bean.BrandCarBean;
import com.bwf.tuanche.ui.carselect.pubwincallback.BrandId;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:
 */
public class BrandCarSelectAdapter extends BaseListAdpter<BrandCarBean, BrandCarSelectAdapter.ViewHolder> {
    private BrandId brandId;

    public void setBrandId(BrandId brandId) {
        this.brandId = brandId;
    }

    private ImageLoader imageLoader;
    public BrandCarSelectAdapter(Context context) {
        super(context);
        imageLoader = ImageLoader.getInstance();
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
        viewHolder.ll_brand_carsel = findViewByIdNoCast(R.id.ll_brand_carsel);
        viewHolder.sdv_brandcar_selcon = findViewByIdNoCast(R.id.sdv_brandcar_selcon);
        viewHolder.tv_brandcar_selcon = findViewByIdNoCast(R.id.tv_brandcar_selcon);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final BrandCarBean brandCarBean, int position) {
        if (brandCarBean != null) {
            String uri = brandCarBean.logo;
            String text = brandCarBean.name;
            if (uri != null)
                imageLoader.disPlayImage(holder.sdv_brandcar_selcon,uri);
            if (text != null)
                holder.tv_brandcar_selcon.setText(text);
            holder.ll_brand_carsel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        String id = brandCarBean.id;
                    if (id!=null)
                        brandId.setOnBrandId(id);
                    else
                        brandId.setOnNullBrandId();
                }
            });
        }

    }

    public class ViewHolder extends BaseListAdpter.ViewHolder {
        public SimpleDraweeView sdv_brandcar_selcon;
        public TextView tv_brandcar_selcon;
        public LinearLayout ll_brand_carsel;
    }
}
