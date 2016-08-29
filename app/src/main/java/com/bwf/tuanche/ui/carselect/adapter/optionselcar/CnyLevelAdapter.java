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
import com.bwf.tuanche.ui.carselect.bean.option.SeriesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:
 */
public class CnyLevelAdapter extends RecyclerView.Adapter<CnyLevelAdapter.ViewHolder> {
    private Context context;
    private List<SeriesBean> bean;
    private ImageLoader imageLoader;

    public void setBean(List<SeriesBean> bean) {
        this.bean = bean;
    }


    public CnyLevelAdapter(Context context) {
        this.context = context;
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_option_cnylevel, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.ll_option_cnylevel = (LinearLayout) view.findViewById(R.id.ll_option_cnylevel);
        viewHolder.sdv = (SimpleDraweeView) view.findViewById(R.id.sdv_option_cnylevel);
        viewHolder.text = (TextView) view.findViewById(R.id.tv_option_cnylevel);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String text, uri;
        final SeriesBean seriesBean = bean.get(position);
        if (seriesBean != null) {
            text = seriesBean.name;
            if (text != null)
                holder.text.setText(text);
            uri = seriesBean.icon;
            if (uri != null)
                imageLoader.disPlayImage(holder.sdv, uri);
        }
        seriesBean.isselected=false;
        holder.ll_option_cnylevel.setBackgroundColor(Color.parseColor("#EEEEEE"));
        holder.text.setTextColor(Color.parseColor("#000000"));
        holder.ll_option_cnylevel.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                boolean isselected = seriesBean.isselected;
               if (!isselected){
                   seriesBean.isselected=true;
                   holder.text.setTextColor(Color.parseColor("#FF4081"));
                   holder.ll_option_cnylevel.setBackground(context.getDrawable(R.drawable.option_carselback));
               }else {
                   seriesBean.isselected=false;
                   holder.ll_option_cnylevel.setBackgroundColor(Color.parseColor("#EEEEEE"));
                   holder.text.setTextColor(Color.parseColor("#000000"));
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
        public LinearLayout ll_option_cnylevel;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
