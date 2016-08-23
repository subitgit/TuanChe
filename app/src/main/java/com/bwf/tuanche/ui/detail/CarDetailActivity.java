package com.bwf.tuanche.ui.detail;

import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CarDetailResponseBean;
import com.bwf.tuanche.ui.detail.fragment.CarDetailFragment1;
import com.bwf.tuanche.ui.detail.fragment.CarDetailFragment2;
import com.bwf.tuanche.ui.detail.fragment.CarDetailFragment3;
import com.bwf.tuanche.ui.detail.fragment.CarDetailFragment4;
import com.bwf.tuanche.view.CustomScrollView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class CarDetailActivity extends BaseActivity implements CustomScrollView.OnScrollListener {


    private CarDetailFragment1 fragment1;
    private CarDetailFragment2 fragment2;
    private CarDetailFragment3 fragment3;
    private CarDetailFragment4 fragment4;
    private TextView tv_name, tv_location, tv_groupbuy_froat;
    private ImageView iv_back, iv_share;
    private CustomScrollView scrollView;
    private RelativeLayout rl_title;

    @Override
    public int getContentViewId() {
        return R.layout.activity_car_detail;
    }

    private String cityId, brandId, styleId,cityName;

    @Override
    public void beforeInitView() {
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        brandId = getIntent().getStringExtra("brandId");
        styleId = getIntent().getStringExtra("styleId");

        statusBarHeight = getStatusBarHeight();
    }

    @Override
    public void initView() {
        tv_name = findViewByIdNoCast(R.id.tv_name);
        tv_location = findViewByIdNoCast(R.id.tv_location);
        iv_back = findViewByIdNoCast(R.id.iv_back);
        iv_share = findViewByIdNoCast(R.id.iv_share);
        scrollView = findViewByIdNoCast(R.id.scrollView);
        rl_title = findViewByIdNoCast(R.id.rl_title);
        tv_groupbuy_froat = findViewByIdNoCast(R.id.tv_groupbuy_froat);
        fragment1 = (CarDetailFragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment2 = (CarDetailFragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragment3 = (CarDetailFragment3) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        fragment4 = (CarDetailFragment4) getSupportFragmentManager().findFragmentById(R.id.fragment4);
    }

    @Override
    public void initData() {
        scrollView.setOnScrollListener(this);
        initPopupWindow();
        setOnClick(tv_location, iv_back, iv_share,tv_qq,tv_qzone,tv_cancel,view_bg);
        tv_location.setText("成都站");
        getDatas();
        initShareAction();
    }

    private ShareAction qqAction,qzoneAction;
    private void initShareAction() {
        qqAction=new ShareAction(this);
        qzoneAction = new ShareAction(this);

        qqAction.setPlatform(SHARE_MEDIA.QQ)
//                    .setCallback(umShareListener)
                .withText("hello umeng video")
                .withTargetUrl("http://www.baidu.com");
//                    .withMedia(image)

        qzoneAction.setPlatform(SHARE_MEDIA.QZONE)
//                    .setCallback(umShareListener)
                .withText("hello umeng video")
                .withTargetUrl("http://www.baidu.com");
//                    .withMedia(image)

    }

    private TextView tv_qq,tv_qzone,tv_cancel;
    private View view_bg;

    private PopupWindow mPopupWindow;
    private void initPopupWindow() {

        //分享
        mPopupWindow = new PopupWindow(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        View view = View.inflate(this, R.layout.view_detail_share_window, null);

        mPopupWindow.setContentView(view);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setFocusable(true);
        mPopupWindow.setAnimationStyle(R.style.style_share_window_anim);

        tv_qq = (TextView) view.findViewById(R.id.tv_qq);
        tv_qzone = (TextView) view.findViewById(R.id.tv_qzone);
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        view_bg = view.findViewById(R.id.view_bg);

    }

    private void getDatas() {

        HttpHelper.getDetail(this,"156", "31", "166", new HttpCallBack<CarDetailResponseBean>() {
            @Override
            public void onSuccess(CarDetailResponseBean result) {
                if (result != null) {
                    tv_name.setText(result.styleName + "-");
                    fragment1.setDatas(result);
                    fragment2.setDatas(result, "156", "31");
                    fragment3.setDatas(result);

                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == tv_location) {

        } else if (v == iv_back) {
            onBackPressed();
        } else if (v == iv_share) {
            mPopupWindow.showAtLocation(iv_share, Gravity.BOTTOM,0,0);
        }else if (v == tv_qq) {
            qqAction.share();

        }else if (v == tv_qzone) {
            qzoneAction.share();
        }else if (v == tv_cancel) {
            if (mPopupWindow.isShowing()) {
                mPopupWindow.dismiss();
            }
        }else if (v == view_bg) {
            if (mPopupWindow.isShowing()) {
                mPopupWindow.dismiss();
            }
        }


    }

    private int[] loc = new int[2];
    private int statusBarHeight;
    private boolean isShow;//显示悬浮团购报名
    @Override
    public void onScroll(int scrollY) {
        fragment1.getTv_groupbuy().getLocationOnScreen(loc);
        if (loc[1] - statusBarHeight - rl_title.getHeight() + fragment1.getTv_groupbuy().getHeight() <= 0) {
            if (!isShow) {
                tv_groupbuy_froat.setVisibility(View.VISIBLE);
                isShow = true;
            }
        } else {
            if (isShow) {
                tv_groupbuy_froat.setVisibility(View.GONE);
                isShow = false;
            }

        }
    }

    /**
     * 获取状态栏高度
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}