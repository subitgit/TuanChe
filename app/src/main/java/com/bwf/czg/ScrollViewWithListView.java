package com.bwf.czg;

import android.content.Context;
import android.widget.ListView;

/**
 * Created by caozhiguo on 2016/8/23.
 * Description:自定义ListView，重写onMeasure方法，解决ScrollView嵌套ListView只显示一条数据的问题
 */
public class ScrollViewWithListView extends ListView {

    public ScrollViewWithListView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Integer.MAX_VALUE >> 2,如果不设置，系统默认设置是显示两条
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
