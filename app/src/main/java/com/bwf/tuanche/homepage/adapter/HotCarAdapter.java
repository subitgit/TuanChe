package com.bwf.tuanche.homepage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.homejson.bean.hotcar.HotCarBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/**
 * Created by BWF on 2016/8/17.
 */
public class HotCarAdapter extends RecyclerView.Adapter<HotCarAdapter.MyViewHolder> {
    private  Context context;
    private List<HotCarBean> list;
    private MyClick myClick;


    public HotCarAdapter(Context context, List<HotCarBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.hotcar_item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view,myClick);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.hotcar_image.setImageURI(list.get(position).logo);
        holder.hotcar_name.setText(list.get(position).styleName);
        String s = list.get(position).content;
        SpannableStringBuilder builder = new SpannableStringBuilder(s);
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        builder.setSpan(span,2,s.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.hotcar_num.setText(builder);
        holder.hotcar_price.setText(list.get(position).pricePrefix+list.get(position).price+list.get(position).priceSuffix);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public SimpleDraweeView hotcar_image;
        public TextView hotcar_name,hotcar_num,hotcar_price;
        public MyClick myClick;

        public MyViewHolder(View itemView,MyClick myClick) {
            super(itemView);
            hotcar_image = (SimpleDraweeView) itemView.findViewById(R.id.hotcar_image);
            hotcar_name = (TextView) itemView.findViewById(R.id.hotcar_name);
            hotcar_num = (TextView) itemView.findViewById(R.id.hotcar_num);
            hotcar_price = (TextView) itemView.findViewById(R.id.hotcar_price);
            this.myClick = myClick;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (myClick!=null){
                myClick.myClick(getPosition());
            }
        }
    }

    public interface MyClick{
        void myClick(int i);
    }
}
