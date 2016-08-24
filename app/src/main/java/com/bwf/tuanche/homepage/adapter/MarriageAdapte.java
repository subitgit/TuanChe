package com.bwf.tuanche.homepage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.homejson.bean.marriage.CarSty;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BWF on 2016/8/23.
 */
public class MarriageAdapte extends BaseAdapter {
    private Context context;
    private List<CarSty> carstyleList;

    public MarriageAdapte(Context context, List<CarSty> carstyleList) {
        this.context = context;
        this.carstyleList = carstyleList;
    }

    @Override
    public int getCount() {
        return carstyleList==null?0:carstyleList.size();
    }

    @Override
    public Object getItem(int position) {
        return carstyleList==null?null:carstyleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.marriage_item,null);
            holder.pic = (SimpleDraweeView) convertView.findViewById(R.id.pic);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.pic.setImageURI(carstyleList.get(position).logo);
        holder.name.setText(carstyleList.get(position).styleName);
        holder.price.setText(carstyleList.get(position).pricePrefix+carstyleList.get(position).price+carstyleList.get(position).priceSuffix);
        String s= carstyleList.get(position).content;
        SpannableStringBuilder builder = new SpannableStringBuilder(s);
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        builder.setSpan(span,2,s.length()-3,SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.num.setText(builder);
        return convertView;
    }
    public class ViewHolder{
        public SimpleDraweeView pic;
        public TextView name,price,num;
    }
}
