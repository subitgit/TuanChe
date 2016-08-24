package com.bwf.tuanche.homepage.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bwf.tuanche.R;

/**
 * Created by BWF on 2016/8/18.
 */
public class ButtonBar extends LinearLayout implements View.OnClickListener{
    private View[] views = new View[4];
    private View home_imag;
    private ImageView[] imageViews = new ImageView[4];
    private TextView[] textViews = new TextView[4];
    private  Integer[][] integers = new Integer[4][2];
    private Select select;

    public ButtonBar(Context context) {
        this(context,null);
    }

    public ButtonBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ButtonBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void setSelect(Select select) {
        this.select = select;
    }

    public void init(Context context){
        View view = View.inflate(context, R.layout.button_bar,null);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        addView(view);

        views[0] = view.findViewById(R.id.homePage);
        views[1] = view.findViewById(R.id.order);
        views[2] = view.findViewById(R.id.sever);
        views[3] = view.findViewById(R.id.user);
        for (int i = 0;i<views.length;i++){
            views[i].setOnClickListener(this);
        }
        home_imag = view.findViewById(R.id.home_imag);
        home_imag.setOnClickListener(this);

        imageViews[0] = (ImageView) view.findViewById(R.id.homePage_imag);
        imageViews[1] = (ImageView) view.findViewById(R.id.order_imag);
        imageViews[2] = (ImageView) view.findViewById(R.id.sever_imag);
        imageViews[3] = (ImageView) view.findViewById(R.id.user_imag);

        textViews[0] = (TextView) view.findViewById(R.id.homePage_tv);
        textViews[1] = (TextView) view.findViewById(R.id.order_tv);
        textViews[2] = (TextView) view.findViewById(R.id.sever_tv);
        textViews[3] = (TextView) view.findViewById(R.id.user_tv);

        integers[0][0] = R.drawable.nav_icon_home_nor;
        integers[0][1] = R.drawable.nav_icon_home_sel;
        integers[1][0] = R.drawable.nav_icon_order_nor;
        integers[1][1] = R.drawable.nav_icon_order_sel;
        integers[2][0] = R.drawable.nav_icon_server_nor;
        integers[2][1] = R.drawable.nav_icon_server_sel;
        integers[3][0] = R.drawable.nav_icon_my_nor;
        integers[3][1] = R.drawable.nav_icon_my_sel;
        beSelected(0);
    }

    public void reSet(){
        for (int i = 0;i<views.length;i++){
            imageViews[i].setImageResource(integers[i][0]);
            textViews[i].setTextColor(Color.BLACK);
        }
    }

    public void beSelected(int position){
        reSet();
        for (int i = 0;i<views.length;i++){
            if (i == position){
                imageViews[i].setImageResource(integers[i][1]);
                textViews[i].setTextColor(Color.RED);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homePage:
                beSelected(0);
                if (select!=null){
                    select.selected(0);
                }
            break;
            case R.id.order:
                beSelected(1);
                if (select!=null){
                    select.selected(1);
                }
                break;
            case R.id.sever:
                beSelected(2);
                if (select!=null){
                    select.selected(2);
                }

                break;
            case R.id.user:
                beSelected(3);
                if (select!=null){
                    select.selected(3);
                }
                break;
            case  R.id.home_imag:
                if (select!=null){
                    select.selected(4);
                }
                break;

        }

    }
    public interface Select{
        void selected(int i);
    }
}
