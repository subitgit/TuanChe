package com.bwf.framwork.db.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.bwf.framwork.base.BaseModel;
import com.bwf.framwork.bean.SearchHistory;
import com.bwf.framwork.bean.UserBean;
import com.bwf.framwork.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BWF on 2016/8/18.
 */
public class SearchHistoryModel extends BaseModel {
    public static final String TABLE_NAME = "historydb";//

    private static Map<String, String> paramsMap = new HashMap<>();

    static {
        paramsMap.put(_ID, "integer primary key autoincrement");//
        paramsMap.put("history", "TEXT NOT NULL");//空值没起作用
        paramsMap.put("date", "TEXT  NOT NULL");
    }
    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Map<String, String> getParamsMap() {
        return paramsMap;
    }

    /**
     * 插入单条浏览历史
     * @param searchHistory
     */

    public void insertHistory(SearchHistory searchHistory) {
        if (searchHistory == null)
            return;
        ContentValues values = new ContentValues();
        values.put("history", searchHistory.history);
        values.put("date", searchHistory.date);
        insert(TABLE_NAME, values);
        LogUtils.e(searchHistory.toString());
    }

    /**
     * 根据history删除一条数据
     * @param history
     */
    public void deleteHistory(String history){
        String[] strings = new String[1];
        strings[0] = history;
        delete(TABLE_NAME,"history",new String[]{"宝马"});
    }

    /**
     * 查找所有历史记录 返回List<SearchHistory>
     * @return  List<String>
     */
    public List<SearchHistory> getAllHistory(){
        String sql = "SELECT * FROM historydb";
        Cursor cursor = select(sql);
        List<SearchHistory> strings = new ArrayList<>();
        while (cursor.moveToNext()){
            String history = cursor.getString(cursor.getColumnIndex("history"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            SearchHistory searchHistory = new SearchHistory(history,date);
            strings.add(searchHistory);
        }

        Collections.sort(strings, new Comparator<SearchHistory>() {
            @Override
            public int compare(SearchHistory lhs, SearchHistory rhs) {
                if (Long.parseLong(lhs.date)>  Long.parseLong(rhs.date)){
                    return -1;
                }else if (Long.parseLong(lhs.date)== Long.parseLong(rhs.date)){
                    return 0;
                }else {
                    return 1;
                }
            }
        });


        return strings;
    }


    /**
     * 清空所有历史记录
     */
    public void clearAll(){
            clear(SearchHistoryModel.TABLE_NAME);
    }


}
