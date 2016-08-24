package com.bwf.tuanche.search.ui;
import android.content.Intent;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.SearchHistory;
import com.bwf.framwork.db.model.SearchHistoryModel;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.ui.HomeActivity;
import com.bwf.tuanche.search.adapter.HotSearchAdapter;
import com.bwf.tuanche.search.adapter.SearchHistoryAdapter;

import java.util.Date;
import java.util.List;
import static android.support.v7.widget.GridLayoutManager.*;

/**
 * Created by BWF on 2016/8/18.
 */
public class SearchActivity extends BaseActivity {
    private ImageView search_back;
    private EditText search_etv;
    private TextView search_tv;
    private  ImageView search_delete;
    private RecyclerView hotsearec_recy;
    private LinearLayout search_history;
    private ListView search_history_lv,search_lv;
    private HotSearchAdapter hotSearchAdapter;
    private SearchHistoryAdapter searchHistoryAdapter;
    private SearchHistoryModel searchHistoryModel;

    @Override
    public int getContentViewId() {
        return R.layout.search_activity;
    }

    @Override
    public void beforeInitView() {

    }

    public void isHistoryShow() {
        List<SearchHistory>   historys = searchHistoryModel.getAllHistory();
        if (historys!=null&&historys.size()!=0){
            searchHistoryAdapter = new SearchHistoryAdapter(this,historys);
          for (int i = 0;i<historys.size();i++){
              LogUtils.e(historys.get(i).toString());
          }
            search_history.setVisibility(View.VISIBLE);
            search_history_lv.setAdapter(searchHistoryAdapter);
        }
    }

    @Override
    public void initView() {
        search_back = findViewByIdNoCast(R.id.search_back);
        search_back.setOnClickListener(this);
        search_etv = findViewByIdNoCast(R.id.search_etv);
        search_tv = findViewByIdNoCast(R.id.search_tv);
        search_tv.setOnClickListener(this);
        search_delete = findViewByIdNoCast(R.id.search_delete);
        hotsearec_recy = findViewByIdNoCast(R.id.hotsearec_recy);
        search_history = findViewByIdNoCast(R.id.search_history);
        search_lv = findViewByIdNoCast(R.id.search_lv);
        search_history_lv = findViewByIdNoCast(R.id.search_history_lv);
        View foot = View.inflate(this,R.layout.history_foot,null);
        search_history_lv.addFooterView(foot,null,true);
        searchHistoryModel = new SearchHistoryModel();
    }

    @Override
    public void initData() {
        isHistoryShow();
        getHotCarData();
        search_etv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String str = search_etv.getText().toString();
                if (str==null||str.equals("")){
                    search_lv.setVisibility(View.VISIBLE);
                    search_delete.setVisibility(View.INVISIBLE);
                }else {
                    search_lv.setVisibility(View.VISIBLE);
                    search_delete.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    public void getHotCarData() {
        HttpHelper.getHotSearch("156", new HttpArrayCallBack<String>() {
            @Override
            public void onSuccess(List result) {
                hotSearchAdapter = new HotSearchAdapter(SearchActivity.this,result);
                GridLayoutManager manager = new GridLayoutManager(SearchActivity.this,4);
                SpanSizeLookup sizeLookup = new SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (((position+2)%6==0)||((position+1)%6==0)){
                            return 2;
                        }
                        return 1;
                    }
                };
                manager.setSpanSizeLookup(sizeLookup);
                hotsearec_recy.setLayoutManager(manager);
                hotsearec_recy.setAdapter(hotSearchAdapter);
            }
            @Override
            public void onFail(String errMsg) {

            }
        });
        search_history_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==searchHistoryAdapter.getCount()){
                    searchHistoryModel.clearAll();
                    search_history.setVisibility(View.INVISIBLE);

                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_tv:
                String str = search_etv.getText().toString();
                List<SearchHistory>   historys = searchHistoryModel.getAllHistory();
                if (str!=null&&!str.equals("")){
                    if (historys!=null&&historys.size()!=0){
                        for (int i = 0;i<historys.size();i++){
                            if (str.equals(historys.get(i).history)){
                                searchHistoryModel.deleteHistory(str);
                            }
                        }
                    }
                    Date date = new Date();
                    SearchHistory searchHistory = new SearchHistory(str,date.getTime()+"");
                    searchHistoryModel.insertHistory(searchHistory);
                }else {
                   ToastUtil.showToast("搜索内容不能为空");
                }
            break;
            case R.id.search_back:
                Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.search_delete:
                search_etv.setText("");
                 break;

        }

    }


}
