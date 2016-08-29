package com.bwf.tuanche.ui.carselect.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.Constants;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.adapter.popcar.PopCarSleAdapter;
import com.bwf.tuanche.ui.carselect.bean.brand.PopSelCarBean;
import com.bwf.tuanche.ui.carselect.bean.brand.PopSelCarResultBean;

import java.util.ArrayList;
import java.util.List;

import static com.bwf.tuanche.R.drawable.base_tabpager_indicator_selected;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/18.
 * Description:
 */
public class SidePopupWindow extends PopupWindow implements View.OnClickListener {
    private TextView tv_pupwin_carsle_hot, tv_pupwin_carsle_price;
    private ListView lv_pupwin_carsle_hot, lv_pupwin_carsle_price;
    private Context context;
    private String cityId, brandId;
    private int type = -1;
    private boolean isOn;
    private PopCarSleAdapter hotAdapter, priceAdapter;
    private List<PopSelCarBean> carBeans;
    private View view_sidepop;
    private LoadAnimView lav_brandcar_sel;
    public void setRequestParams(String cityId, String brandId) {
        this.cityId = cityId;
        this.brandId = brandId;
        if (cityId != null && brandId != null) {
            type = 0;
            getData();
        }

    }


    public SidePopupWindow(Context context) {
        this(context, null);
    }

    public SidePopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SidePopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(context, R.layout.poptranswin, null);
        setContentView(view);
        setWidth(DisplayUtil.getDensity_Width(context));
        setHeight(DisplayUtil.getDensity_Height(context));
        setAnimationStyle(R.style.AppTheme);
       // setBackgroundDrawable(new BitmapDrawable());//点击pop外消失
        setAnimationStyle(R.style.SidePopwinAnmi);
        setFocusable(true);
        tv_pupwin_carsle_hot = (TextView) view.findViewById(R.id.tv_pupwin_carsle_hot);
        tv_pupwin_carsle_price = (TextView) view.findViewById(R.id.tv_pupwin_carsle_price);
        view_sidepop = view.findViewById(R.id.view_sidepop);
        tv_pupwin_carsle_hot.setOnClickListener(this);
        tv_pupwin_carsle_price.setOnClickListener(this);
        view_sidepop.setOnClickListener(this);

        lav_brandcar_sel = (LoadAnimView) view.findViewById(R.id.lav_brandcar_sel);
        lv_pupwin_carsle_hot = (ListView) view.findViewById(R.id.lv_pupwin_carsle_hot);
        lv_pupwin_carsle_price = (ListView) view.findViewById(R.id.lv_pupwin_carsle_price);

        hotAdapter = new PopCarSleAdapter(context);
        priceAdapter = new PopCarSleAdapter(context);

        lv_pupwin_carsle_hot.setAdapter(hotAdapter);
        lv_pupwin_carsle_price.setAdapter(priceAdapter);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_pupwin_carsle_hot:
                if (isOn) {
                    isOn = false;
                    type = 0;
                    tv_pupwin_carsle_hot.setTextColor(Color.parseColor("#FF4081"));
                    tv_pupwin_carsle_price.setTextColor(Color.parseColor("#000000"));
                    tv_pupwin_carsle_hot.setBackground(context.getDrawable(base_tabpager_indicator_selected));
                    tv_pupwin_carsle_price.setBackgroundColor(Color.parseColor("#EEEEEE"));
                    getData();
                }
                break;
            case R.id.tv_pupwin_carsle_price:
                if (!isOn) {
                    isOn = true;
                    type = 1;
                    tv_pupwin_carsle_hot.setTextColor(Color.parseColor("#000000"));
                    tv_pupwin_carsle_price.setTextColor(Color.parseColor("#FF4081"));
                    tv_pupwin_carsle_hot.setBackgroundColor(Color.parseColor("#EEEEEE"));
                    tv_pupwin_carsle_price.setBackground(context.getDrawable(base_tabpager_indicator_selected));

                    priceAdapter.settList(carBeans);
                    priceAdapter.notifyDataSetChanged();

                    getData();
                }
                break;
            case R.id.view_sidepop:
                SidePopupWindow.this.dismiss();
                break;
        }
    }

    private void getData() {
        lav_brandcar_sel.loadAnim();
        HttpHelper.getPopWinCarList(Constants.OPTION_POPWIN_SELECT_URL, cityId, brandId, type, new HttpArrayCallBack<PopSelCarResultBean>() {
            @Override
            public void onSuccess(List<PopSelCarResultBean> result) {
                List<PopSelCarBean> beans = new ArrayList<>();
                if (result != null && !result.isEmpty()) {
                    for (int i = 0; i < result.size(); i++) {
                        beans.addAll(result.get(i).styleList);
                    }
                }
                if (carBeans != null && !carBeans.isEmpty())
                    carBeans.clear();
                if (beans != null && !beans.isEmpty()) {
                    carBeans = beans;
                    PopSelCarBean.orderByName(carBeans);
                    if (type == 0) {
                        lv_pupwin_carsle_hot.setVisibility(View.VISIBLE);
                        lv_pupwin_carsle_price.setVisibility(View.GONE);
                        hotAdapter.settList(carBeans);
                        hotAdapter.notifyDataSetChanged();
                    } else if (type == 1) {
                        priceAdapter.settList(carBeans);
                        priceAdapter.notifyDataSetChanged();
                        lv_pupwin_carsle_hot.setVisibility(View.GONE);
                        lv_pupwin_carsle_price.setVisibility(View.VISIBLE);
                    }
                    lav_brandcar_sel.setVisibility(View.GONE);
                    lav_brandcar_sel.dismiss();

                }
            }

            @Override
            public void onFail(String errMsg) {
                lav_brandcar_sel.loadfail();
            }
        });
    }

    public void showSidepop(View view) {
        if (!isShowing())
            showAsDropDown(view);
    }

}
