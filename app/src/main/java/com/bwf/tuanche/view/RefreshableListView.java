package com.bwf.tuanche.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bwf.framwork.Constants;
import com.bwf.tuanche.R;

/**
 * Created by Sandal on 2016/8/2.
 * Description:
 */
public class RefreshableListView extends ListView implements AbsListView.OnScrollListener {
    public RefreshableListView(Context context) {
        this(context, null);
    }

    public RefreshableListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private TextView tv_noDatas;
    private TextView tv_refresh;
    private ProgressBar pb_loadmore;
    private ImageView iv_refresh;
    private Context context;

    private void init(Context context) {
        this.context = context;
        addPullUpHeaderFooter(context);
        addPullDownRefreshHeader(context);
        setOnScrollListener(this);

    }


    private int headerViewHeight;
    private View headerView;

    private AnimationDrawable animationDrawable;

    private void addPullDownRefreshHeader(Context context) {
        headerView = View.inflate(context, R.layout.header_pull_down_refresh, null);
        tv_refresh = (TextView) headerView.findViewById(R.id.textView);
        iv_refresh = (ImageView) headerView.findViewById(R.id.imageView);
        animationDrawable = (AnimationDrawable) iv_refresh.getDrawable();
        addHeaderView(headerView, null, false);
        headerView.measure(0, 0);
        headerViewHeight = headerView.getMeasuredHeight();
        headerView.setPadding(0, -headerViewHeight, 0, 0);


        state = DONE;
    }

    public static final int DONE = 1;//完成状态
    public static final int PULL_TO_REFRESH = 2;//下拉不可刷新状态
    public static final int RELEASE_TO_REFRESH = 3;//释放可刷新状态
    public static final int REFRESHING = 4;//释放可刷新状态
    public static final int LOADING_MORE = 5;//正在加载更多


    private float lastY;
    private float currentY;
    private int state;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (getFirstVisiblePosition() != 0) {
            return super.onTouchEvent(ev);
        }

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastY = ev.getY();
                if (state == DONE) {
                    state = PULL_TO_REFRESH;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                currentY = ev.getY();
                int offSetY = (int) (currentY - lastY);
                if (state != REFRESHING && offSetY > 0) {
                    setSelection(0);//解决下滑后再往上滑时ListView已经不再开头的位置
                    headerView.setPadding(0, -headerViewHeight + offSetY, 0, 0);

                    if (offSetY > headerViewHeight && state == PULL_TO_REFRESH) {
                        tv_refresh.setText(context.getString(R.string.release_to_refresh));
//                        iv_refresh.clearAnimation();
//                        iv_refresh.startAnimation(drag_animation);
                        state = RELEASE_TO_REFRESH;
                    }
                    if (offSetY < headerViewHeight && state == RELEASE_TO_REFRESH) {
                        tv_refresh.setText(context.getString(R.string.pull_down_to_refresh));
//                        iv_refresh.clearAnimation();
//                        iv_refresh.startAnimation(relese_animation);
                        state = PULL_TO_REFRESH;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (state == PULL_TO_REFRESH) {
//                    headerView.setPadding(0, -headerViewHeight, 0, 0);
                    startValueAnim(headerView, Math.abs((int) (headerView.getPaddingTop() / speed)), headerView.getPaddingTop(), -headerViewHeight);
                }
                if (state == RELEASE_TO_REFRESH) {
//                    headerView.setPadding(0, 0, 0, 0);
                    startValueAnim(headerView, (int) (headerView.getPaddingTop() / speed), headerView.getPaddingTop(), 0);
                    animationDrawable.start();
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.refresh();
                        tv_refresh.setText(context.getString(R.string.loading));

                    }
                    state = REFRESHING;

                }
                if (state == REFRESHING) {
//                    headerView.setPadding(0, 0, 0, 0);
                    startValueAnim(headerView, (int) (headerView.getPaddingTop() / speed), headerView.getPaddingTop(), 0);
                }
                break;
        }

        return super.onTouchEvent(ev);
    }


    private void addPullUpHeaderFooter(Context context) {
        View footerView = View.inflate(context, R.layout.footer_pull_up_loadmore, null);
        tv_noDatas = (TextView) footerView.findViewById(R.id.textView);
        pb_loadmore = (ProgressBar) footerView.findViewById(R.id.progress);
        addFooterView(footerView, null, false);

    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState != SCROLL_STATE_IDLE || state == LOADING_MORE || state == REFRESHING) {
            return;
        }
        if (getLastVisiblePosition() == getCount() - 1 && getLastVisiblePosition() != 0) {
            if ((getCount() - 3) % Constants.COUNTT == 0) {
                tv_noDatas.setText(context.getString(R.string.loading));
                pb_loadmore.setVisibility(View.VISIBLE);
                if (onLoadMoreListener != null) {
                    onLoadMoreListener.loadMore();
                    state = LOADING_MORE;
                }
            } else {
                tv_noDatas.setText(context.getString(R.string.no_more_datas));
                pb_loadmore.setVisibility(View.INVISIBLE);
            }


        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }


    public interface OnLoadMoreListener {
        void loadMore();

        void refresh();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    private OnLoadMoreListener onLoadMoreListener;

    public void setComplete() {
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        setSelection(0);
        state = DONE;
        int i = (int) (headerViewHeight / speed);
        startValueAnim(headerView, (int) (headerViewHeight / speed), 0, -headerViewHeight);
//        headerView.setPadding(0, -headerViewHeight, 0, 0);
        iv_refresh.setVisibility(View.VISIBLE);
        tv_refresh.setText(context.getString(R.string.pull_down_to_refresh));
    }

    private ValueAnimator animator;
    private float speed = 2f;//动画加速度

    public <T extends ViewGroup> void startValueAnim(View view, int duration, int... value) {
        if (animator == null) {
            animator = ValueAnimator.ofInt(value);
            animator.setDuration(duration);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int value = (int) animation.getAnimatedValue();
                    headerView.setPadding(0, value, 0, 0);
                }
            });

            animator.start();
        } else {
            if (animator.isRunning()) {
                animator.cancel();
            }
            animator.setDuration(duration);
            animator.setIntValues(value);
            animator.start();
        }
    }


}
