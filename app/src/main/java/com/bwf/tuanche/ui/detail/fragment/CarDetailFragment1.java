package com.bwf.tuanche.ui.detail.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entity.detail.CarDetailResponseBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Sandal on 2016/8/17.
 * Description:
 */
public class CarDetailFragment1 extends BaseFragment{

    private SimpleDraweeView simpleDraweeView;
    private TextView tv_partake,tv_save_up_money,tv_partake_string,tv_save_up_string,tv_Date,tv_location,tv_notice,tv_about_price;
    private RelativeLayout rl_price;
    @Override
    protected int getResource() {
        return R.layout.car_detail_fragment1;
    }

    @Override
    protected void beforeInitView() {
    }

    @Override
    protected void initView(View rootView) {

        simpleDraweeView = findViewByIdNoCast(R.id.simpleDraweeView);
        tv_partake = findViewByIdNoCast(R.id.tv_partake);
        tv_save_up_money = findViewByIdNoCast(R.id.tv_save_up_money);
        tv_partake_string = findViewByIdNoCast(R.id.tv_partake_string);
        tv_save_up_string = findViewByIdNoCast(R.id.tv_save_up_string);
        tv_Date = findViewByIdNoCast(R.id.tv_Date);
        tv_location = findViewByIdNoCast(R.id.tv_location);
        tv_notice = findViewByIdNoCast(R.id.tv_notice);
        rl_price = findViewByIdNoCast(R.id.rl_price);
        tv_about_price = findViewByIdNoCast(R.id.tv_about_price);

    }

    private PopupWindow pricePop;
    @Override
    protected void initData() {
        setOnClick(rl_price);

        initPopupWindow();
    }

    private void initPopupWindow() {

        //现场公布
        pricePop = new PopupWindow(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
        View view = View.inflate(getContext(), R.layout.view_detail_price_window, null);
        pricePop.setContentView(view);
        pricePop.setTouchable(true);
        pricePop.setBackgroundDrawable(new BitmapDrawable());
        pricePop.setFocusable(true);
        pricePop.setAnimationStyle(R.style.style_share_window_anim);
    }

    @Override
    public void onClick(View v) {
        if (v == rl_price) {
            pricePop.showAsDropDown(tv_about_price, -DisplayUtil.dip2px(getContext(),25f),0);

        }

    }

    public void setDatas(CarDetailResponseBean result) {
        ImageLoader.getInstance().disPlayImage(simpleDraweeView,result.logo);
        tv_save_up_string.setText(result.saveUpString);
        tv_save_up_money.setText(result.saveUpMoney);
        tv_partake_string.setText(getContext().getString(R.string.man_num_string));
        tv_partake.setText(String.format(getContext().getString(R.string.man_num),result.manNum+""));
        tv_Date.setText(result.groupbuyDate+ "(" +result.groupbuyWeek+")");
        tv_notice.setText(getContext().getString(R.string.groupbuy_date));
        tv_location.setText(result.regular4sShop);

    }
}
