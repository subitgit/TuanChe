package com.bwf.tuanche.ui.carselect.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwf.framwork.Constants;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.ui.carselect.adapter.optionselcar.CarLevelAdapter;
import com.bwf.tuanche.ui.carselect.adapter.optionselcar.CnyLevelAdapter;
import com.bwf.tuanche.ui.carselect.adapter.optionselcar.DisplacementLevelAdapter;
import com.bwf.tuanche.ui.carselect.bean.option.OptionResultBean;

/**
 * 在线选车
 * A simple {@link Fragment} subclass.
 */
public class OptionCarFragment extends BaseFragment {

    private RecyclerView rlv_carlevel, rlv_cnylevel, rlv_displacement;
    private Button btn_option_reset, btn_option_check;
    private CarLevelAdapter caradapter;
    private CnyLevelAdapter cnyadapter;
    private DisplacementLevelAdapter disadapter;
    private OptionResultBean resultBean;

    @Override
    protected int getResource() {
        return R.layout.fragment_option_car;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        rlv_carlevel = findViewByIdNoCast(R.id.rlv_carlevel);
        rlv_cnylevel = findViewByIdNoCast(R.id.rlv_cnylevel);
        rlv_displacement = findViewByIdNoCast(R.id.rlv_displacement);
        btn_option_reset = findViewByIdNoCast(R.id.btn_option_reset);
        btn_option_check = findViewByIdNoCast(R.id.btn_option_check);
    }

    @Override
    protected void initData() {
        setOnClick(R.id.btn_option_reset,R.id.btn_option_check);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        rlv_displacement.setLayoutManager(manager);
        GridLayoutManager manager1 = new GridLayoutManager(getContext(), 3);
        rlv_carlevel.setLayoutManager(manager1);
        GridLayoutManager manager2 = new GridLayoutManager(getContext(), 3);
        rlv_cnylevel.setLayoutManager(manager2);
        caradapter = new CarLevelAdapter(getContext());
        cnyadapter = new CnyLevelAdapter(getContext());
        disadapter = new DisplacementLevelAdapter(getContext());
        rlv_carlevel.setAdapter(caradapter);
        rlv_cnylevel.setAdapter(cnyadapter);
        rlv_displacement.setAdapter(disadapter);
        getData();
    }

    public void setAdapterData() {
        if (resultBean != null) {
            if (resultBean.bos != null && !resultBean.bos.isEmpty())
                caradapter.setBean(resultBean.bos);
            if (resultBean.series != null && !resultBean.series.isEmpty())
                cnyadapter.setBean(resultBean.series);
            if (resultBean.levle != null && !resultBean.levle.isEmpty())
                disadapter.setBean(resultBean.levle);
            caradapter.notifyDataSetChanged();
            cnyadapter.notifyDataSetChanged();
            disadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_option_reset:
                setAdapterData();
                break;
            case R.id.btn_option_check:
                break;
        }

    }

    private void getData() {
        HttpHelper.getOptionSelect(Constants.OPTION_SELECT_URL, new HttpCallBack<OptionResultBean>() {
            @Override
            public void onSuccess(OptionResultBean result) {
                resultBean = result;
                setAdapterData();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
}
