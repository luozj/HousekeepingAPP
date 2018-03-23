package com.example.enz.Housekeeping;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment02 extends ListFragment {
    private ListView list;
    private SimpleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate()的作用就是将一个用xml定义的布局文件查找出来.这里用来引用xml布局
        //与findViewById()的区别---inflate是加载一个布局文件，而findViewById则是从布局文件中查找一个控件。
        View view = inflater.inflate(R.layout.fragment02,container,false);
        list = (ListView) view.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
            硬解码插入数据
         */
        final String[] listItem = {
                "急需通下水道专业工", "急需通下水道专业工", "急需通下水道专业工", "急需通下水道专业工", "急需通下水道专业工",};
        final String[] listItem_2 = {
                "400RMB", "600RMB", "470RMB", "410RMB", "800RMB",};
        final int[] iconItem = {
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher ,};
        adapter = new SimpleAdapter(
                getActivity(),                                  //context:上下文(当前的Activity)
                getData(listItem,listItem_2, iconItem),         //data:一个嵌套Map集合类型的list集合数据源
                R.layout.fragment02_item,                       //resource:ListView的布局文件
                new String[] { "name","price", "icon" },        //from:Map中的键名
                new int[] { R.id.need_text01,R.id.need_text02, R.id.need_img }); //to:布局文件中相匹配的控件的id
        setListAdapter(adapter);
        /*
            监听ListView中每个item的点击事件
         */
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                b.putString("listitem", listItem[i]);
                b.putString("listitem_2",listItem_2[i]);
                Intent intent = new Intent(getActivity(),needdetailactivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    private List<? extends Map<String,?>> getData(String[] listItem, String[] listItem_2, int[] iconItem) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", listItem[i]);
            map.put("price", listItem_2[i]);
            map.put("icon", iconItem[i]);
            list.add(map);
        }
        return list;
    }


}
