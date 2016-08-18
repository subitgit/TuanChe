package com.bwf.tuanche.ui.detail.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CarDetailResponseBean;
import com.bwf.tuanche.ui.detail.CommentListActivity;
import com.bwf.tuanche.ui.detail.adapter.DetailCommentListAdapter;
import com.bwf.tuanche.view.MeasureHeightListView;

/**
 * Created by Sandal on 2016/8/17.
 * Description:
 */
public class CarDetailFragment2 extends BaseFragment{

    private TextView tv_commentTotal,tv_allcomment;
    private RatingBar ratingBar;
    private MeasureHeightListView lv_appraise;
    @Override
    protected int getResource() {
        return R.layout.car_detail_fragment2;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_commentTotal = findViewByIdNoCast(R.id.tv_commentTotal);
        ratingBar = findViewByIdNoCast(R.id.ratingBar);
        lv_appraise = findViewByIdNoCast(R.id.lv_appraise);
        tv_allcomment = findViewByIdNoCast(R.id.tv_allcomment);

    }

    @Override
    protected void initData() {
        setOnClick(tv_allcomment);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_allcomment) {
            Bundle bundle = new Bundle();
            bundle.putString("cityId",cityId);
            bundle.putString("brandId",brandId);
            IntentUtils.openActivity(getContext(), CommentListActivity.class,bundle);
        }

    }

    private String cityId,brandId;
    private DetailCommentListAdapter mAdapter;
    public void setDatas(CarDetailResponseBean result, String cityId, String brandId) {
        this.cityId = cityId;
        this.brandId = brandId;

        tv_commentTotal.setText(String.format(getContext().getString(R.string.comment_num),result.commentTotal));
        ratingBar.setRating(Float.parseFloat(result.commentTotal));
        mAdapter = new DetailCommentListAdapter(result.comment.commentList, getContext());
        lv_appraise.setAdapter(mAdapter);
        ListViewUtils.measureListViewHeight(lv_appraise);
        tv_allcomment.setText(String.format(getContext().getString(R.string.total_comment_num),result.comment.count));
    }
}
