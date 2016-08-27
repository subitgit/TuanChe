package com.bwf.czg.entity.city;

import com.bwf.czg.entity.city.HotCitys;
import com.bwf.czg.entity.city.OpenCitys;
import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by caozhiguo on 2016/8/18.
 * Description:
 */
public class ResultBean extends BaseBean {
    public List<HotCitys> hotCitys;
    public List<OpenCitys> openCitys;

    @Override
    public String toString() {
        return "ResultBean{" +
                "hotCitys=" + hotCitys +
                ", openCitys=" + openCitys +
                '}';
    }
}
