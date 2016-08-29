package com.bwf.czg;

import android.app.Dialog;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bwf.czg.entity.city.OpenCitys;
import com.bwf.czg.entity.city.ResultBean;
import com.bwf.czg.entity.dingwei.DingWeiResultBean;
import com.bwf.czg.entity.version.VersionResultBean;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SelectCityActivity extends BaseActivity {

    private ImageButton img_back;//返回键

    private TextView tv_selectCity;//顶部当前选择城市

    private TextView tv_nearCity1, tv_nearCity2, tv_nearCity3, tv_nearCity4;//周边城市

    //热门城市
    private TextView tv_hotCity1, tv_hotCity2, tv_hotCity3, tv_hotCity4, tv_hotCity5, tv_hotCity6, tv_hotCity7, tv_hotCity8;

    private TextView[] textViews;//周边城市与热门城市组合的数组

    //周边，热门城市的name,id
    private String name0, name1, name2, name3, name4, name5, name6, name7;
    private String near_Id0, near_Id1, near_Id2, near_Id3, id0, id1, id2, id3, id4, id5, id6, id7;
    private String[] ids;

    //获取当前城市
    private TextView tv_dingwei;
    private String id_DingWei, name_DingWei;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    public String longitude;//经度
    public String latitude;//纬度

    //加载更新dialog的View
    private View view;

    //城市列表ListView
    private ListView lv_city;
    private CityAdapter adapter;
    private List<OpenCitys> totalList;
    private List<OpenCitys> openCitys;


    @Override
    public int getContentViewId() {
        return R.layout.activity_select_city;
    }

    @Override
    public void beforeInitView() {
        //定位
        mLocationClient = new LocationClient(getApplicationContext());//声明LocationClient类
        mLocationClient.registerLocationListener(myListener);//注册监听函数
        initLocation();
        mLocationClient.start();
    }

    @Override
    public void initView() {

        //定位
        tv_dingwei = findViewByIdNoCast(R.id.tv_dingwei);
        //返回键
        img_back = findViewByIdNoCast(R.id.img_back);
        //当前城市
        tv_selectCity = findViewByIdNoCast(R.id.tv_selectCity);
        //周边城市
        tv_nearCity1 = findViewByIdNoCast(R.id.tv_nearCity1);
        tv_nearCity2 = findViewByIdNoCast(R.id.tv_nearCity2);
        tv_nearCity3 = findViewByIdNoCast(R.id.tv_nearCity3);
        tv_nearCity4 = findViewByIdNoCast(R.id.tv_nearCity4);
        //热门
        tv_hotCity1 = findViewByIdNoCast(R.id.tv_hotCity1);
        tv_hotCity2 = findViewByIdNoCast(R.id.tv_hotCity2);
        tv_hotCity3 = findViewByIdNoCast(R.id.tv_hotCity3);
        tv_hotCity4 = findViewByIdNoCast(R.id.tv_hotCity4);
        tv_hotCity5 = findViewByIdNoCast(R.id.tv_hotCity5);
        tv_hotCity6 = findViewByIdNoCast(R.id.tv_hotCity6);
        tv_hotCity7 = findViewByIdNoCast(R.id.tv_hotCity7);
        tv_hotCity8 = findViewByIdNoCast(R.id.tv_hotCity8);

        textViews = new TextView[]{tv_nearCity1, tv_nearCity2, tv_nearCity3, tv_nearCity4, tv_hotCity1, tv_hotCity2, tv_hotCity3, tv_hotCity4, tv_hotCity5, tv_hotCity6, tv_hotCity7, tv_hotCity8};

        //listView
        lv_city = findViewByIdNoCast(R.id.lv_city);


    }

    @Override
    public void initData() {
        adapter = new CityAdapter(this);//初始化ListView的adapter

        totalList = new ArrayList<>();

        lv_city.setAdapter(adapter);

        getCityData();//城市列表
        getVersionData();//版本

        setOnClick(img_back, tv_dingwei, tv_nearCity1, tv_nearCity2, tv_nearCity3, tv_nearCity4, tv_hotCity1, tv_hotCity2, tv_hotCity3, tv_hotCity4, tv_hotCity5, tv_hotCity6, tv_hotCity7, tv_hotCity8);

        lv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                adapter.clearSelection(position);
                adapter.notifyDataSetChanged();

                String name = openCitys.get(position).name;//
                String city_Id = openCitys.get(position).id;//当前点击城市的id
                tv_selectCity.setText("当前城市-" + name);
//                Toast.makeText(SelectCityActivity.this, "选中了 = " + name + "id = " + city_Id, Toast.LENGTH_SHORT).show();
                LogUtils.e(Arrays.toString(ids));
                setNoSelect();
                //如果id相同，则对应的热门和周边也变颜色
                for (int i = 0; i < ids.length; i++) {
                    if (city_Id.equals(ids[i])) {
                        setSelect(i);
                    }
                }
                MyApplication.getMyApplication().setCityId(city_Id);
                MyApplication.getMyApplication().setCityName(name);
            }
        });
    }

    /**
     * 监听
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:

                break;
            case R.id.tv_nearCity1:

                setSelect(0);
                break;
            case R.id.tv_nearCity2:

                setSelect(1);
                break;
            case R.id.tv_nearCity3:
                setSelect(2);
                break;
            case R.id.tv_nearCity4:
                setSelect(3);
                break;
            case R.id.tv_hotCity1:
//                Toast.makeText(SelectCityActivity.this, "name0 = " + name0 + "id0 = " + id0, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name0);
                setSelect(4);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id0.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id0);
                MyApplication.getMyApplication().setCityName(name0);

                break;
            case R.id.tv_hotCity2:
//                Toast.makeText(SelectCityActivity.this, "name0 = " + name1 + "id0 = " + id1, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name1);
                setSelect(5);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id1.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id1);
                MyApplication.getMyApplication().setCityName(name1);
                break;
            case R.id.tv_hotCity3:
//                Toast.makeText(SelectCityActivity.this, "name2 = " + name2 + "id2 = " + id2, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name2);
                setSelect(6);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id2.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id2);
                MyApplication.getMyApplication().setCityName(name2);
                break;
            case R.id.tv_hotCity4:
//                Toast.makeText(SelectCityActivity.this, "name3 = " + name3 + "id3 = " + id3, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name3);
                setSelect(7);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id3.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id3);
                MyApplication.getMyApplication().setCityName(name3);
                break;
            case R.id.tv_hotCity5:
//                Toast.makeText(SelectCityActivity.this, "name4 = " + name4 + "id4 = " + id4, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name4);
                setSelect(8);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id4.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id4);
                MyApplication.getMyApplication().setCityName(name4);
                break;
            case R.id.tv_hotCity6:
//                Toast.makeText(SelectCityActivity.this, "name5 = " + name5 + "id5 = " + id5, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name5);
                setSelect(9);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id5.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id5);
                MyApplication.getMyApplication().setCityName(name5);
                break;
            case R.id.tv_hotCity7:
//                Toast.makeText(SelectCityActivity.this, "name6 = " + name6 + "id6 = " + id6, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name6);
                setSelect(10);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id6.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id6);
                MyApplication.getMyApplication().setCityName(name6);
                break;
            case R.id.tv_hotCity8:
//                Toast.makeText(SelectCityActivity.this, "name7 = " + name7 + "id7 = " + id7, Toast.LENGTH_SHORT).show();
                tv_selectCity.setText("当前城市-" + name7);
                setSelect(11);
                for (int i = 0; i < totalList.size(); i++) {
                    if (id7.equals(totalList.get(i).id)) {
                        adapter.clearSelection(i);
                        adapter.setColor(i);
                        adapter.notifyDataSetChanged();
                    }
                }
                MyApplication.getMyApplication().setCityId(id7);
                MyApplication.getMyApplication().setCityName(name7);
                break;
            case R.id.tv_dingwei://定位
                MyApplication.getMyApplication().setCityId(id_DingWei);
                MyApplication.getMyApplication().setCityName(name_DingWei);
        }
    }

    //点击变色
    private void setSelect(int position) {
        for (int i = 0; i < textViews.length; i++) {
            if (i == position) {
                textViews[i].setTextColor(Color.parseColor("#FF6738"));
            } else {
                textViews[i].setTextColor(Color.parseColor("#959595"));
            }
        }
    }

    //全部未选中状态
    private void setNoSelect() {
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setTextColor(Color.parseColor("#959595"));
        }
    }


    //--------定位----------
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系int span=1000;
//        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location != null) {
                String province = location.getProvince();
                String city = location.getCity();
                String address = location.getAddrStr();
                longitude = "" + location.getLongitude();//经度
                latitude = "" + location.getLatitude();//纬度
                int errorCode = location.getLocType();
                Log.i("tag", "省:" + province);
                Log.i("tag", "市:" + city);
                Log.i("tag", "经度:" + longitude);
                Log.i("tag", "纬度:" + latitude);
                Log.i("tag", "详细地址:" + address);
                Log.i("tag", "errorCode:" + errorCode);

                getNowCityData();
            }
        }
    }


    /**
     * 根据经纬度获取当前城市
     */
    public void getNowCityData() {
        LogUtils.e("根据经纬度获取当前城市");
        HttpHelper.getNowCity(UrlUtils.CITY, longitude, latitude, new HttpCallBack<DingWeiResultBean>() {
            @Override
            public void onSuccess(final DingWeiResultBean result) {
                LogUtils.e("tag", "当前城市的信息" + result);
                if (result != null) {
                    name_DingWei = result.name;
                    id_DingWei = result.id;
                    tv_dingwei.setText(name_DingWei);
                    String id = result.id;
                    for (int i = 0; i < totalList.size(); i++) {
                        if (id.equals(totalList.get(i).id)) {
                            adapter.clearSelection(i);
                            adapter.setColor(i);
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    tv_dingwei.setText("网络异常，定位失败");
                }
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("tag", "" + errMsg);
            }
        });
    }

    /**
     * 获取城市列表
     */

    public void getCityData() {
        HttpHelper.getCitys(UrlUtils.CITY_ITEM, new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean result) {
                if (result != null) {
                    //热门城市
                    name0 = result.hotCitys.get(0).name;
                    name1 = result.hotCitys.get(1).name;
                    name2 = result.hotCitys.get(2).name;
                    name3 = result.hotCitys.get(3).name;
                    name4 = result.hotCitys.get(4).name;
                    name5 = result.hotCitys.get(5).name;
                    name6 = result.hotCitys.get(6).name;
                    name7 = result.hotCitys.get(7).name;
                    tv_hotCity1.setText(name0);
                    tv_hotCity2.setText(name1);
                    tv_hotCity3.setText(name2);
                    tv_hotCity4.setText(name3);
                    tv_hotCity5.setText(name4);
                    tv_hotCity6.setText(name5);
                    tv_hotCity7.setText(name6);
                    tv_hotCity8.setText(name7);
                    //获得热门城市的id
                    id0 = result.hotCitys.get(0).id;
                    id1 = result.hotCitys.get(1).id;
                    id2 = result.hotCitys.get(2).id;
                    id3 = result.hotCitys.get(3).id;
                    id4 = result.hotCitys.get(4).id;
                    id5 = result.hotCitys.get(5).id;
                    id6 = result.hotCitys.get(6).id;
                    id7 = result.hotCitys.get(7).id;
                    //周边near_Id0, near_Id1, near_Id2, near_Id3还没有值，为空
                    ids = new String[]{near_Id0, near_Id1, near_Id2, near_Id3, id0, id1, id2, id3, id4, id5, id6, id7};
                    //城市列表ListView加载
                    openCitys = result.openCitys;
                    if (openCitys != null && !openCitys.isEmpty()) {
                        totalList.addAll(openCitys);
                    }
                } else {
                    tv_hotCity1.setText("网络异常");
                    tv_hotCity2.setText("网络异常");
                    tv_hotCity3.setText("网络异常");
                    tv_hotCity4.setText("网络异常");
                    tv_hotCity5.setText("网络异常");
                    tv_hotCity6.setText("网络异常");
                    tv_hotCity7.setText("网络异常");
                    tv_hotCity8.setText("网络异常");
                    Toast.makeText(SelectCityActivity.this, "网络异常，未请求到数据，", Toast.LENGTH_SHORT).show();
                }
                adapter.setTotalList(totalList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    /**
     * --------------------------------版本更新-----------------------------------------
     */

    public void getVersionData() {
        HttpHelper.getVersionMsg(UrlUtils.VERSION, new HttpCallBack<VersionResultBean>() {

            @Override
            public void onSuccess(VersionResultBean result) {
                if (result != null) {
                    showVersionDialog();
                    TextView tv_version = (TextView) view.findViewById(R.id.tv_version);
                    TextView tv_versionMessage = (TextView) view.findViewById(R.id.tv_versionMessage);

                    tv_versionMessage.setText(result.description);
                    tv_version.setText(result.versionName);
                }

            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("tag", errMsg);
            }
        });
    }


    /**
     * 版本更新的dialog
     */
    private Dialog dialog;

    public void showVersionDialog() {
        if (dialog == null)
            dialog = new Dialog(this, R.style.Translucent_NoTitle);//自定义Dialog的style，边框透明化。。原来的：android.R.style.Theme_DeviceDefault_Dialog_NoActionBar
        view = View.inflate(this, R.layout.upgrade_dialog, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);//点击外部是否消失
        dialog.setCancelable(false);//点击返回键是否消失
        dialog.show();

        ImageView imageView = (ImageView) dialog.findViewById(R.id.img_newVersion);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_Update);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog != null && dialog.isShowing())
                    dialog.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog != null && dialog.isShowing())
                    dialog.dismiss();
            }
        });
    }
}
