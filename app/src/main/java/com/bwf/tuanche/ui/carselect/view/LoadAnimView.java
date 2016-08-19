package com.bwf.tuanche.ui.carselect.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwf.tuanche.R;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/19.
 * Description:
 */
public class LoadAnimView extends LinearLayout {
    private Context context;

    public LoadAnimView(Context context) {
        this(context, null);
    }

    public LoadAnimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initAnimView();
    }

    private AnimationDrawable drawable;
    private LinearLayout ll_loaderror, ll_data_loading;
    private ImageView img_loading;

    public void loadAnim() {
        img_loading.setImageResource(R.drawable.load);
        drawable = (AnimationDrawable) img_loading.getDrawable();
        drawable.start();
        ll_data_loading.setVisibility(VISIBLE);
    }

    public void dismiss() {
        drawable.stop();
        ll_data_loading.setVisibility(View.GONE);

    }

    public void loadfail() {
        ll_loaderror.setVisibility(View.VISIBLE);
        drawable.stop();
        img_loading.setVisibility(GONE);
    }

    private void initAnimView() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        View view = View.inflate(context, R.layout.data_loading, null);
        view.setLayoutParams(layoutParams);
        addView(view);
        ll_loaderror = (LinearLayout) findViewById(R.id.ll_loaderror);
        ll_data_loading = (LinearLayout) findViewById(R.id.ll_data_loading);
        img_loading = (ImageView) findViewById(R.id.img_loading);

    }
}
