package com.bwf.tuanche.ui.detail.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CommentListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sandal on 2016/8/18.
 * Description:
 */
public class DetailCommentListAdapter extends BaseListAdpter<CommentListBean, DetailCommentListAdapter.ViewHolder> {

    private Context context;

    public DetailCommentListAdapter(Context context) {
        super(context);

    }


    public DetailCommentListAdapter(List<CommentListBean> commentListBeen, Context context) {
        super(commentListBeen, context);
        lines = new HashMap<>();
        this.context = context;

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
        viewHolder.imageView = findViewByIdNoCast(R.id.imageView);
        viewHolder.iv_fold = findViewByIdNoCast(R.id.iv_fold);
        lineHeight = viewHolder.tv_content.getLineHeight();

        return viewHolder;
    }

    private Map<Integer, HideText> lines;
    private int lineHeight;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final ViewHolder holder, CommentListBean commentListBean, final int position) {

        if (Boolean.parseBoolean(commentListBean.fine)) {
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }
        ImageLoader.getInstance().disPlayImage(holder.simpleDraweeView, commentListBean.memberPic);
        holder.ratingBar_score.setRating(Float.parseFloat(commentListBean.score));
        holder.tv_date.setText(commentListBean.commentDate);
        holder.tv_name.setText(commentListBean.userName);
        holder.tv_content.setText(commentListBean.content);


        //设置textview的可折叠效果
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.tv_content.getLayoutParams();
        if (lines.containsKey(position)) {//当前item的textview行数已经保存到hashmap里

            if (lines.get(position).line > 3) {//从hashmap取出当前item的textview行数，大于3时，设置textview高度
                params.height = 3 * lineHeight;
                holder.iv_fold.setVisibility(View.VISIBLE);
                holder.iv_fold.setImageResource(R.mipmap.icon_grey_arrow_down);
                setOnclick(holder,position);
            } else {//小于3时，设置textview高度
                params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                holder.iv_fold.setVisibility(View.INVISIBLE);
                holder.tv_content.setOnClickListener(null);//复用的textview的监听去掉
            }
            holder.tv_content.setLayoutParams(params);

        } else {//当前item的textview行数没有保存到hashmap里
            holder.tv_content.post(new Runnable() {
                @Override
                public void run() {
                    //把当前item的textview行数保存
                    lines.put(position, new HideText(holder.tv_content.getLineCount(),true));
                    if (holder.tv_content.getLineCount() > 3) {//行数大于3
                        params.height = 3 * lineHeight;
                        holder.iv_fold.setVisibility(View.VISIBLE);
                        holder.iv_fold.setImageResource(R.mipmap.icon_grey_arrow_down);

                        //
                        setOnclick(holder, position);
                    } else {//行数小于3
                        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
                        holder.iv_fold.setVisibility(View.INVISIBLE);
                    }
                    holder.tv_content.setLayoutParams(params);
                }
            });
        }
    }

    /**
     * 设置监听 展开和收起textview
     * @param holder
     * @param position
     */
    private void setOnclick(final ViewHolder holder, final int position) {
        holder.tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HideText hideText = lines.get(position);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.tv_content.getLayoutParams();
                if (hideText.isHide) {//当前textview是折叠起来的
                    params.height = hideText.line * lineHeight;
                    holder.iv_fold.setImageResource(R.mipmap.icon_grey_arrow_up);

                } else {//当前textview是展开的
                    params = (RelativeLayout.LayoutParams) holder.tv_content.getLayoutParams();
                    params.height = 3 * lineHeight;
                    holder.iv_fold.setImageResource(R.mipmap.icon_grey_arrow_down);
                }
                holder.tv_content.setLayoutParams(params);
                hideText.isHide = !hideText.isHide;
            }
        });
    }

    public class ViewHolder extends BaseListAdpter.ViewHolder {

        TextView tv_name, tv_date, tv_content;
        RatingBar ratingBar_score;
        SimpleDraweeView simpleDraweeView;
        ImageView imageView, iv_fold;

    }

    public class HideText {
        Integer line;
        boolean isHide;

        public HideText(Integer line, boolean isHide) {
            this.line = line;
            this.isHide = isHide;
        }
    }


}
