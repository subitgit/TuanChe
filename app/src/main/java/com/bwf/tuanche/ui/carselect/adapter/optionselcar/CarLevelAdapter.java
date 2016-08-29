package com.bwf.tuanche.ui.carselect.adapter.optionselcar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.bean.option.BosBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:
 */
public class CarLevelAdapter extends RecyclerView.Adapter<CarLevelAdapter.ViewHolder> {
    private Context context;
    private List<BosBean> bean;
    private ImageLoader imageLoader;

    public void setBean(List<BosBean> bean) {
        this.bean = bean;
    }


    public CarLevelAdapter(Context context) {
        this.context = context;
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_option_carlevel, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.ll_option_carlevel = (LinearLayout) view.findViewById(R.id.ll_option_carlevel);
        viewHolder.sdv = (SimpleDraweeView) view.findViewById(R.id.sdv_option_carlevel);
        viewHolder.text = (TextView) view.findViewById(R.id.tv_option_carlevel);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String text, uri;
        final BosBean bosBean = bean.get(position);
        if (bosBean != null) {
            text = bosBean.name;
            if (text != null)
                holder.text.setText(text);
            uri = bosBean.defIcon;
            if (uri != null) {
                imageLoader.disPlayImage(holder.sdv, uri);
            }
        }
        bosBean.isselected=false;
        holder.ll_option_carlevel.setBackgroundColor(Color.parseColor("#EEEEEE"));
        holder.text.setTextColor(Color.parseColor("#000000"));
        holder.ll_option_carlevel.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                boolean isselected = bosBean.isselected;
                if (!isselected){
                    bosBean.isselected=true;
                    holder.text.setTextColor(Color.parseColor("#FF4081"));
                    if (bosBean.icon!=null)
                    imageLoader.disPlayImage(holder.sdv,bosBean.icon);
                }else {
                    bosBean.isselected=false;
                    holder.text.setTextColor(Color.parseColor("#000000"));
                    imageLoader.disPlayImage(holder.sdv, bosBean.defIcon);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView sdv;
        public TextView text;
        public LinearLayout ll_option_carlevel;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
