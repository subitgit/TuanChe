package com.bwf.tuanche.ui.detail;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CommentBean;
import com.bwf.tuanche.entity.detail.CommentListBean;
import com.bwf.tuanche.ui.detail.adapter.DetailCommentListAdapter;
import com.bwf.tuanche.view.RefreshableListView;

import java.util.ArrayList;
import java.util.List;

public class CommentListActivity extends BaseActivity {

    private RefreshableListView listView;
    private DetailCommentListAdapter mAdapter;
    private TextView tv_commentTotal,tv_price_score,tv_saler_score, tv_shop_score;
    private RatingBar ratingBar;
    private ImageView iv_back;
    @Override
    public int getContentViewId() {
        return R.layout.activity_comment_list;
    }

    @Override
    public void beforeInitView() {
        cityId = getIntent().getStringExtra("cityId");
        brandId = getIntent().getStringExtra("brandId");
    }

    @Override
    public void initView() {
        listView = findViewByIdNoCast(R.id.listView);
        iv_back = findViewByIdNoCast(R.id.iv_back);

    }

    private List<CommentListBean> list;
    @Override
    public void initData() {
        addRatingHeaderView();
        list = new ArrayList<>();
        mAdapter = new DetailCommentListAdapter(list, this);
        listView.setAdapter(mAdapter);
        getDatas();
        listView.setOnLoadMoreListener(new RefreshableListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
                offset++;
                getDatas();
            }

            @Override
            public void refresh() {
                offset = 1;
                getDatas();
            }
        });

        iv_back.setOnClickListener(this);
    }

    private void addRatingHeaderView() {
        View view = View.inflate(this, R.layout.header_commont_list_rating, null);

        tv_commentTotal = (TextView) view.findViewById(R.id.tv_commentTotal);
        tv_price_score = (TextView) view.findViewById(R.id.tv_price_score);
        tv_saler_score = (TextView) view.findViewById(R.id.tv_saler_score);
        tv_shop_score = (TextView) view.findViewById(R.id.tv_shop_score);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        listView.addHeaderView(view);
    }

    private int offset = 1;
    private String cityId,brandId;
    private void getDatas() {
        if (TextUtils.isEmpty(cityId) || TextUtils.isEmpty(brandId)) {
            return;
        }
        HttpHelper.getCommentList(this,offset + "", cityId, brandId, new HttpCallBack<CommentBean>() {
            @Override
            public void onSuccess(CommentBean result) {
                listView.setComplete();
                if (result != null) {

                    if (offset == 1) {
                        initRating(result);
                        list.clear();
                    }
                    list.addAll(result.commentList);
                    mAdapter.settList(list);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFail(String errMsg) {
            }
        });

    }

    private void initRating(CommentBean result) {
        tv_shop_score.setText(String.format(getString(R.string.comment_num),result.shopScore));
        tv_saler_score.setText(String.format(getString(R.string.comment_num),result.salerScore));
        tv_price_score.setText(String.format(getString(R.string.comment_num),result.priceScore));
        tv_commentTotal.setText(String.format(getString(R.string.comment_num),result.commentTotal));
        ratingBar.setRating(Float.parseFloat(result.commentTotal));
    }

    @Override
    public void onClick(View v) {
        if (v == iv_back) {
            onBackPressed();
        }
    }
}
