package com.bwf.tuanche.entity.detail;

import java.util.List;

/**
 * Created by Sandal on 2016/8/17.
 * Description:
 */
public class CommentBean {


    public String count;

    public String commentTotal;

    public List<CommentListBean> commentList ;

    //更多评论的属性
    public String priceScore;
    public String salerScore;
    public String shopScore;
    public String offset;

    @Override
    public String toString() {
        return "CommentBean{" +
                "count='" + count + '\'' +
                ", commentTotal='" + commentTotal + '\'' +
                ", commentList=" + commentList +
                ", priceScore='" + priceScore + '\'' +
                ", salerScore='" + salerScore + '\'' +
                ", shopScore='" + shopScore + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
