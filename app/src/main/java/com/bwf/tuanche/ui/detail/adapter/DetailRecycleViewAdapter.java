package com.bwf.tuanche.ui.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.GuaranteeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Sandal on 2016/8/19.
 * Description:
 */
public class DetailRecycleViewAdapter extends RecyclerView.Adapter<DetailRecycleViewAdapter.ViewHolder> {


    private List<GuaranteeBean> list;
    private Context context;

    public DetailRecycleViewAdapter(List<GuaranteeBean> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_detail_guarantee_recycle, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView);
        viewHolder.tv_description = (TextView) view.findViewById(R.id.tv_description);
        viewHolder.tv_title = (TextView) view.findViewById(R.id.tv_title);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_title.setText(list.get(position).title);
        holder.tv_description.setText(list.get(position).describe);
        ImageLoader.getInstance().disPlayImage(holder.simpleDraweeView, list.get(position).imgurl);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        TextView tv_title, tv_description;
        SimpleDraweeView simpleDraweeView;
    }

}
