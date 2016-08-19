package com.bwf.tuanche.ui.carselect.bean;

import com.bwf.framwork.utils.PinYinUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Suzaku_Zhang YongCan on 2016/8/16.
 * Description:
 */
public class BrandCarRessult {
    public List<BrandCarBean> list;

    public static void orderBrandCar(List<BrandCarBean> list){
        Collections.sort(list, new Comparator<BrandCarBean>() {
            @Override
            public int compare(BrandCarBean lhs, BrandCarBean rhs) {
                String l = PinYinUtil.getFirstTag(lhs.name);
                String r = PinYinUtil.getFirstTag(rhs.name);
                int i= l.compareTo(r);
                return i;
            }
        });
    }

    @Override
    public String toString() {
        return "BrandCarResultBean{" +
                "list=" + list +
                '}';
    }
}
