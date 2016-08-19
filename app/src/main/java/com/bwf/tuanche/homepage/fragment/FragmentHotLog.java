package com.bwf.tuanche.homepage.fragment;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.homejson.bean.hotlogo.HotLogListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BWF on 2016/8/17.
 */
public class FragmentHotLog extends BaseFragment {
    private List<HotLogListBean> list;
    private SimpleDraweeView[] logopics = new SimpleDraweeView[8];
    private TextView[] logos = new TextView[8];
    private TextView[] nums = new TextView[8];


    public void setList(List<HotLogListBean> list) {
        this.list = list;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_hotlog;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        logopics[0] = findViewByIdNoCast(R.id.hotlog_log1);
        logopics[1] = findViewByIdNoCast(R.id.hotlog_log2);
        logopics[2] = findViewByIdNoCast(R.id.hotlog_log3);
        logopics[3] = findViewByIdNoCast(R.id.hotlog_log4);
        logopics[4] = findViewByIdNoCast(R.id.hotlog_log5);
        logopics[5] = findViewByIdNoCast(R.id.hotlog_log6);
        logopics[6] = findViewByIdNoCast(R.id.hotlog_log7);
        logopics[7] = findViewByIdNoCast(R.id.hotlog_log8);

        logos[0] = findViewByIdNoCast(R.id.hotlog_tv1);
        logos[1] = findViewByIdNoCast(R.id.hotlog_tv2);
        logos[2] = findViewByIdNoCast(R.id.hotlog_tv3);
        logos[3] = findViewByIdNoCast(R.id.hotlog_tv4);
        logos[4] = findViewByIdNoCast(R.id.hotlog_tv5);
        logos[5] = findViewByIdNoCast(R.id.hotlog_tv6);
        logos[6] = findViewByIdNoCast(R.id.hotlog_tv7);
        logos[7] = findViewByIdNoCast(R.id.hotlog_tv8);

        nums[0] = findViewByIdNoCast(R.id.hotlog_num1);
        nums[1] = findViewByIdNoCast(R.id.hotlog_num2);
        nums[2] = findViewByIdNoCast(R.id.hotlog_num3);
        nums[3] = findViewByIdNoCast(R.id.hotlog_num4);
        nums[4] = findViewByIdNoCast(R.id.hotlog_num5);
        nums[5] = findViewByIdNoCast(R.id.hotlog_num6);
        nums[6] = findViewByIdNoCast(R.id.hotlog_num7);
        nums[7] = findViewByIdNoCast(R.id.hotlog_num8);

    }

    @Override
    protected void initData() {
        if (list!=null&&list.size()!=0){
            for (int i = 0;i<list.size();i++){
                logopics[i].setImageURI(list.get(i).logo);
                logos[i].setText(list.get(i).name);
                String str = "有"+list.get(i).baseNum+"人报名";
                SpannableStringBuilder builder = new SpannableStringBuilder(str);
                ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
                builder.setSpan(span,1,str.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                nums[i].setText(builder);
            }
        }

    }

    @Override
    public void onClick(View v) {

    }
}
