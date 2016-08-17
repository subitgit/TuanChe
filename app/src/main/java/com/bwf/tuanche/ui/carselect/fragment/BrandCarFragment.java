package com.bwf.tuanche.ui.carselect.fragment;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.Constants;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.PinYinUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.bean.BrandCarBean;
import com.bwf.tuanche.ui.carselect.bean.BrandCarResultBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 品牌选车
 */
public class BrandCarFragment extends BaseFragment {
    private List<BrandCarBean> brandCarBeans;
    private LinearLayout ll_brandcar_select;
    private List<String> names;
    private int cityId = 156;
    private String convertname="";

    @Override
    protected int getResource() {
        return R.layout.fragment_brand_car;
    }

    @Override
    protected void beforeInitView() {
        getData();
        names = new ArrayList<>();
    }

    @Override
    protected void initView(View rootView) {
        ll_brandcar_select = findViewByIdNoCast(R.id.ll_brandcar_select);
    }

    @Override
    protected void initData() {
        if (brandCarBeans != null && !brandCarBeans.isEmpty()) {
            for (int i = 0; i < brandCarBeans.size(); i++) {
                boolean flag = true;
                String name = PinYinUtil.getFirstTag(brandCarBeans.get(i).getName());
                if (!convertname.equals(name)) {
                    names.add(name);
                    convertname = name;
                    addView();
                    }

                if (!names.isEmpty()) {
                    for (int j = 0; j < names.size(); j++) {
                        if (names.get(j).equals(name)){

                        }
                    }
                }
            }

        }
    }

    @Override
    public void onClick(View v) {

    }

    private void addView() {
        View view = View.inflate(getContext(),R.layout.item_brandcarsel,null);
        TextView tv_lable_carsel = (TextView) view.findViewById(R.id.tv_lable_carsel);
        tv_lable_carsel.setText(convertname);
        ListView lv_carsel = (ListView) view.findViewById(R.id.lv_carsel);


    }

    private void getData() {
        HttpHelper.getBrandCarSelect(Constants.BRANDCAR_SELECT_IN, cityId, new HttpCallBack<BrandCarResultBean>() {
            @Override
            public void onSuccess(BrandCarResultBean result) {
                if (result != null) {
                    brandCarBeans = result.result.list;
                    LogUtils.e(brandCarBeans.toString());
                }
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e(errMsg);
            }
        });
    }
}
