package com.bwf.tuanche.entity.detail;

/**
 * Created by Sandal on 2016/8/19.
 * Description:
 */
public class GuaranteeBean {
    public String id;

    public String createTime;

    public String status;

    public String sort;

    public String title;

    public String sourceId;

    public String versionCode;

    public String dataType;

    public String describe;

    public String datakey;

    public String dataValue;

    public String linkurl;

    public String imgurl;

    public String isDel;

    public String ts;

    @Override
    public String toString() {
        return "GuaranteeBean{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", status='" + status + '\'' +
                ", sort='" + sort + '\'' +
                ", title='" + title + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", dataType='" + dataType + '\'' +
                ", describe='" + describe + '\'' +
                ", datakey='" + datakey + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", isDel='" + isDel + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }
}
