package com.bwf.tuanche.search.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.SearchHistory;
import com.bwf.tuanche.R;
import java.util.List;

/**
 * Created by BWF on 2016/8/18.
 */
public class SearchHistoryAdapter extends BaseAdapter {
    private Context context;
    private List<SearchHistory> strings;


    public SearchHistoryAdapter(Context context, List<SearchHistory> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings==null?0:strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings==null?null:strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler holer = null;
        if (convertView==null){
            holer = new ViewHoler();
            convertView = View.inflate(context, R.layout.searchhistory_item,null);
            holer.tv = (TextView) convertView.findViewById(R.id.search_history_tv);
            convertView.setTag(holer);
        }else {
            holer = (ViewHoler) convertView.getTag();
        }
        holer.tv.setText(strings.get(position).history);
        return convertView;
    }

    public class ViewHoler{
        public TextView tv;

    }
}
