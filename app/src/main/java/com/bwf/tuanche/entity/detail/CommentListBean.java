package com.bwf.tuanche.entity.detail;

import java.util.List;

/**
 * Created by Sandal on 2016/8/17.
 * Description:
 */
public class CommentListBean {

    public String userName;

    public String commentDate;

    public String score;

    public String content;

    public String memberPic;//头像图片

    public List<CommentPicListBean> commentPicList ;

    public String fine;


    @Override
    public String toString() {
        return "CommentListBean{" +
                "userName='" + userName + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", score=" + score +
                ", content='" + content + '\'' +
                ", memberPic='" + memberPic + '\'' +
                ", commentPicList=" + commentPicList +
                ", fine=" + fine +
                '}';
    }
}