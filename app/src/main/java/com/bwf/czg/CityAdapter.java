package com.bwf.czg;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.czg.entity.city.OpenCitys;
import com.bwf.framwork.utils.PinYinUtil;
import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by caozhiguo on 2016/8/21.
 * Description:
 */
public class CityAdapter extends BaseAdapter {

    private Context context;
    private List<OpenCitys> totalList;


    public CityAdapter(Context context) {
        this.context = context;
    }

    public void setTotalList(List<OpenCitys> totalList) {
        this.totalList = totalList;
    }

    @Override
    public int getCount() {
        return totalList == null ? 0 : totalList.size();
    }

    @Override
    public Object getItem(int position) {
        return totalList == null ? null : totalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    //这句是把listview的点击position,传递过来
    private int selectedPosition = 0;

    public void clearSelection(int position) {
        selectedPosition = position;
    }

    ViewHolder viewHolder;
    int position;

    @Override
    public View getView(int position, View converView, ViewGroup parent) {

        if (converView == null) {
            viewHolder = new ViewHolder();
            converView = View.inflate(context, R.layout.city_listitem_1, null);
            viewHolder.item_CityName = (TextView) converView.findViewById(R.id.item_CityName);
            viewHolder.item_CityFirstName = (TextView) converView.findViewById(R.id.item_CityFirstName);
            converView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) converView.getTag();
        }
        OpenCitys openCitys = totalList.get(position);
        viewHolder.item_CityName.setText(openCitys.name);
        String A = PinYinUtil.getFirstTag(openCitys.py).toUpperCase();//获得首字母并转换为大写  toUpperCase()转换为大写，toLowerCase()转换为小写
        viewHolder.item_CityFirstName.setText(A);
        //如果和前面的首字母一致就隐藏
        String preA = (position - 1) >= 0 ? PinYinUtil.getFirstTag(totalList.get(position - 1).py).toUpperCase() : "";
        if (!preA.equals(A)) {
            viewHolder.item_CityFirstName.setVisibility(View.VISIBLE);
        }

        setColor(position);

        return converView;
    }

    //变色
    public void setColor(int position) {
        this.position = position;
        if (selectedPosition == position) {
            viewHolder.item_CityName.setTextColor(Color.parseColor("#FF6738"));
        } else {
            viewHolder.item_CityName.setTextColor(Color.parseColor("#404040"));
        }
    }
    public void setNoColor(){
        viewHolder.item_CityName.setTextColor(Color.parseColor("#404040"));
    }

    public class ViewHolder {
        TextView item_CityName;
        TextView item_CityFirstName;
    }

}