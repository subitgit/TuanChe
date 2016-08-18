package com.bwf.tuanche.ui.detail;

import android.view.View;
import android.widget.ListView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CommentBean;
import com.bwf.tuanche.entity.detail.CommentListBean;
import com.bwf.tuanche.ui.detail.adapter.DetailCommentListAdapter;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;

public class CommentListActivity extends BaseActivity {

    private ListView listView;
    private DetailCommentListAdapter mAdapter;
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
    }

    private List<CommentListBean> list;
    @Override
    public void initData() {
        mAdapter = new DetailCommentListAdapter(list, this);
        listView.setAdapter(mAdapter);
        getDatas();
    }

    private int offset = 0;
    private String cityId,brandId;
    private void getDatas() {

        HttpHelper.getCommentList(this,offset + "", cityId, brandId, new HttpCallBack<CommentBean>() {
            @Override
            public void onSuccess(CommentBean result) {

                if (result != null) {
                    list = result.commentList;
                    mAdapter.settList(result.commentList);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
