package com.bwf.tuanche.ui.carselect.adapter.brandsel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
public class HotCarGridAdapter extends RecyclerView.Adapter<HotCarGridAdapter.ViewHolder> {
    private Context context;

    private BrandId brandId;

    private ImageLoader imageLoader;

    List<BrandCarBean> hotBrandCarBeans;

    public void setHotBrandCarBeans(List<BrandCarBean> hotBrandCarBeans) {
        this.hotBrandCarBeans = hotBrandCarBeans;
    }
    public void setBrandId(BrandId brandId) {
        this.brandId = brandId;
    }
    public HotCarGridAdapter(Context context) {
        this.context = context;
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rlv_brand_carselhot, null);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.ll_rlv_brand_carselhot = (LinearLayout) view.findViewById(R.id.ll_rlv_brand_carselhot);
        viewHolder.sdv_brandcar_selhotcon = (SimpleDraweeView) view.findViewById(R.id.sdv_brandcar_selhotcon);
        viewHolder.tv_brandcar_selhotcon = (TextView) view.findViewById(R.id.tv_brandcar_selhotcon);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (hotBrandCarBeans == null||hotBrandCarBeans.isEmpty())
            return;
        String uri = hotBrandCarBeans.get(position).logo;
        String lable = hotBrandCarBeans.get(position).name;
        if (uri!=null)
            imageLoader.disPlayImage(holder.sdv_brandcar_selhotcon,uri);
        if (lable!=null)
            holder.tv_brandcar_selhotcon.setText(lable);
        holder.ll_rlv_brand_carselhot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = hotBrandCarBeans.get(position).id;
                if (id!=null)
                    brandId.setOnBrandId(id);
                else
                    brandId.setOnNullBrandId();
            }
        });

    }

    @Override
    public int getItemCount() {
        return hotBrandCarBeans == null ? 0 : hotBrandCarBeans.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView sdv_brandcar_selhotcon;
        public TextView tv_brandcar_selhotcon;
        public LinearLayout ll_rlv_brand_carselhot;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
