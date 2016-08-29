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

import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.bean.option.LevelBean;

import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/17.
 * Description:
 */
public class DisplacementLevelAdapter extends RecyclerView.Adapter<DisplacementLevelAdapter.ViewHolder> {
    private Context context;
    private List<LevelBean> bean;

    public void setBean(List<LevelBean> bean) {
        this.bean = bean;
    }


    public DisplacementLevelAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_option_displacement, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.ll_option_displacement = (LinearLayout) view.findViewById(R.id.ll_option_displacement);
        viewHolder.text = (TextView) view.findViewById(R.id.tv_option_displacement);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String text;
        final LevelBean levelBean = bean.get(position);
        if (levelBean != null) {
            text = levelBean.name;
            if (text != null)
                holder.text.setText(text);
        }
        levelBean.isselected=false;
        holder.ll_option_displacement.setBackgroundColor(Color.parseColor("#EEEEEE"));
        holder.text.setTextColor(Color.parseColor("#000000"));
        holder.ll_option_displacement.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                boolean isselected = levelBean.isselected;
                if (!isselected){
                    levelBean.isselected=true;
                    holder.text.setTextColor(Color.parseColor("#FF4081"));
                    holder.ll_option_displacement.setBackground(context.getDrawable(R.drawable.option_carselback));
                }else {
                    levelBean.isselected=false;
                    holder.ll_option_displacement.setBackgroundColor(Color.parseColor("#EEEEEE"));
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
        public TextView text;
        public LinearLayout ll_option_displacement;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
