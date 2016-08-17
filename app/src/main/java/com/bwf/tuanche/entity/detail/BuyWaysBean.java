package com.bwf.tuanche.entity.detail;

import java.util.List;

/**
 * Created by Sandal on 2016/8/17.
 * Description:
 */
public class BuyWaysBean {


    public List<BuyWayListBean> buyWayList ;

    public int showWhere;

    public int isMust;

    @Override
    public String toString() {
        return "BuyWaysBean{" +
                "buyWayList=" + buyWayList +
                ", showWhere=" + showWhere +
                ", isMust=" + isMust +
                '}';
    }
}
