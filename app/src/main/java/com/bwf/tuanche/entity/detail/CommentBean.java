package com.bwf.tuanche.entity.detail;

import java.util.List;

/**
 * Created by Sandal on 2016/8/17.
 * Description:
 */
public class CommentBean {


    public int count;

    public double commentTotal;

    public List<CommentListBean> commentList ;

    @Override
    public String toString() {
        return "CommentBean{" +
                "count=" + count +
                ", commentTotal=" + commentTotal +
                ", commentList=" + commentList +
                '}';
    }
}
