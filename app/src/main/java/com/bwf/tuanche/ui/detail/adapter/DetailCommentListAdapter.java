package com.bwf.tuanche.ui.detail.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CommentListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Sandal on 2016/8/18.
 * Description:
 */
public class DetailCommentListAdapter extends BaseListAdpter<CommentListBean,DetailCommentListAdapter.ViewHolder>{

    public DetailCommentListAdapter(Context context) {
        super(context);
    }


    public DetailCommentListAdapter(List<CommentListBean> commentListBeen, Context context) {
        super(commentListBeen, context);
    }

    @Override
    public int getResourceId() {
        return R.layout.item_detail_comment_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tv_date = findViewByIdNoCast(R.id.tv_date);
        viewHolder.simpleDraweeView = findViewByIdNoCast(R.id.simpleDraweeView);
        viewHolder.ratingBar_score = findViewByIdNoCast(R.id.ratingBar_score);
        viewHolder.tv_content = findViewByIdNoCast(R.id.tv_content);
        viewHolder.tv_name = findViewByIdNoCast(R.id.tv_name);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, CommentListBean commentListBean, int position) {

        ImageLoader.getInstance().disPlayImage(holder.simpleDraweeView,commentListBean.memberPic);
        holder.ratingBar_score.setRating(Float.parseFloat(commentListBean.score));
        holder.tv_content.setText(commentListBean.content);
        holder.tv_date.setText(commentListBean.commentDate);
        holder.tv_name.setText(commentListBean.userName);
    }

    public class ViewHolder extends BaseListAdpter.ViewHolder {

        TextView tv_name,tv_date,tv_content;
        RatingBar ratingBar_score;
        SimpleDraweeView simpleDraweeView;

    }

}
