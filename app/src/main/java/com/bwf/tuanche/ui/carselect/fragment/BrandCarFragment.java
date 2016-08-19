package com.bwf.tuanche.ui.carselect.fragment;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.Constants;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.PinYinUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.CarSelectMainActivity;
import com.bwf.tuanche.ui.carselect.adapter.brandsel.BrandCarSelectAdapter;
import com.bwf.tuanche.ui.carselect.adapter.brandsel.HotCarGridAdapter;
import com.bwf.tuanche.ui.carselect.bean.BrandCarBean;
import com.bwf.tuanche.ui.carselect.bean.BrandCarRessult;
import com.bwf.tuanche.ui.carselect.pubwincallback.BrandId;
import com.bwf.tuanche.ui.carselect.view.LoadAnimView;

import java.util.ArrayList;
import java.util.List;

/**
 * 品牌选车
 */
public class BrandCarFragment extends BaseFragment implements Handler.Callback ,BrandId{
    private List<BrandCarBean> brandCarBeans, hotBrandCarBeans;
    private LinearLayout ll_brandcar_select;
    private Handler handler;
    private BrandId brandId;
    private LoadAnimView lav_brand;
    //  private List<String> names;
    private String cityId = "156";
    private String convertname = "";

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_brand_car;
    }

    @Override
    protected void beforeInitView() {
        handler = new Handler(this);

        // names = new ArrayList<>();
    }

    @Override
    protected void initView(View rootView) {
        ll_brandcar_select = findViewByIdNoCast(R.id.ll_brandcar_select);
        lav_brand = findViewByIdNoCast(R.id.lav_brand);
        getData();
        getListData();
    }

    @Override
    protected void initData() {

        if (brandCarBeans != null && !brandCarBeans.isEmpty()) {
            BrandCarRessult.orderBrandCar(brandCarBeans);
            for (int i = 0; i < brandCarBeans.size(); i++) {
                String name = PinYinUtil.getFirstTag(brandCarBeans.get(i).name);
                if (!convertname.equals(name)) {
                    // names.add(name);
                    convertname = name;
                    addView();
                }
            }
        }

    }

    @Override
    public void onClick(View v) {

    }

    private void addViewHot() {
        if (hotBrandCarBeans == null || hotBrandCarBeans.isEmpty())
            return;
        LogUtils.e("------------------------------------");
        View view = View.inflate(getContext(), R.layout.item_brandcarsel_hot, null);
        TextView tv_lable_carsel = (TextView) view.findViewById(R.id.tv_lable_carselhot);
        tv_lable_carsel.setText("热门");
        RecyclerView rlv_carsel = (RecyclerView) view.findViewById(R.id.rlv_carselhot);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        rlv_carsel.setLayoutManager(manager);
        HotCarGridAdapter adapter = new HotCarGridAdapter(getContext());
        adapter.setHotBrandCarBeans(hotBrandCarBeans);
        adapter.setBrandId(this);
        rlv_carsel.setAdapter(adapter);

        ll_brandcar_select.addView(view);

    }

    private void addView() {
        /*if (!names.isEmpty()) {
            for (int j = 0; j < names.size(); j++) {
                if (names.get(j).equals(convertname)){
                    return;
                }
            }
        }*/
        View view = View.inflate(getContext(), R.layout.item_brandcarsel, null);
        TextView tv_lable_carsel = (TextView) view.findViewById(R.id.tv_lable_carsel);
        tv_lable_carsel.setText(convertname);
        ListView lv_carsel = (ListView) view.findViewById(R.id.lv_carsel);
        BrandCarSelectAdapter adapter = new BrandCarSelectAdapter(getContext());
        List<BrandCarBean> beans = new ArrayList<>();
        for (int i = 0; i < brandCarBeans.size(); i++) {
            String name = PinYinUtil.getFirstTag(brandCarBeans.get(i).name);
            if (convertname.equals(name)) {
                beans.add(brandCarBeans.get(i));
            }
        }
        adapter.settList(beans);
        adapter.setBrandId(this);
        lv_carsel.setAdapter(adapter);
        ListViewUtils.measureListViewHeight(lv_carsel);
        ll_brandcar_select.addView(view);
        ll_brandcar_select.setVisibility(View.VISIBLE);
        lav_brand.dismiss();
    }

    private void getData() {
        lav_brand.loadAnim();
        HttpHelper.getBrandCarSelectHot(Constants.BRANDCAR_SELECT_HOT_URL, cityId, new HttpCallBack<BrandCarRessult>() {
            @Override
            public void onSuccess(BrandCarRessult result) {
                if (result != null) {
                    hotBrandCarBeans = result.list;
                    addViewHot();
                }
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e(errMsg+"-------------");
            }
        });
        HttpHelper.getBrandCarSelect(Constants.BRANDCAR_SELECT_IN_URL, cityId, new HttpArrayCallBack<BrandCarBean>() {

            @Override
            public void onSuccess(List<BrandCarBean> result) {
                if (result != null) {
                    brandCarBeans = result;
                    LogUtils.e(brandCarBeans.toString());
                    handler.sendEmptyMessageDelayed(1,100);
                }
            }

            @Override
            public void onFail(String errMsg) {
                lav_brand.loadfail();
                LogUtils.e(errMsg);
            }
        });
    }
    private void getListData(){

    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case 1:
                initData();
                break;
        }
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context!=null&&context instanceof CarSelectMainActivity)
            brandId = (BrandId) context;
    }

    @Override
    public void setOnBrandId(String id) {
        brandId.setOnBrandId(id);
    }

    @Override
    public void setOnNullBrandId() {

    }


}
