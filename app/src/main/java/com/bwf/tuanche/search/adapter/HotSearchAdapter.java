package com.bwf.tuanche.search.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by BWF on 2016/8/18.
 */
public class HotSearchAdapter extends RecyclerView.Adapter<HotSearchAdapter.MyViewHolder>{
    private Context context;
    private List<String> strings;

    public HotSearchAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hotsearch_item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.tv = (TextView) view.findViewById(R.id.hotsearch_item_tv);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings==null?0:strings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
