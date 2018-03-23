package com.example.enz.Housekeeping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/21.
 */

public class needlistactivity extends Activity {
    private ListView list;
    private SimpleAdapter adapter;
    private Button bt;
    private RollPagerView rpv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.needlistactivity);

        setView();
        /*
            点击 发布新的需求 就跳转至addneed页面
         */
        bt = (Button) findViewById(R.id.needlist_buttom);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(needlistactivity.this,addneed.class);
                startActivity(intent);
            }
        });
        /*
            点击ListView的item就跳转至updateneed，可提供修改及删除功能---未传递数据过去，仅模型
         */
        list = (ListView) findViewById(R.id.needlist_listview);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(needlistactivity.this,updateneed.class);
                startActivity(intent);
            }
        });

        /*
            图片轮播
         */
        rpv = (RollPagerView)findViewById(R.id.needlist_rpv);
        MyRollPagerView myrpv = new MyRollPagerView();
        rpv.setAdapter(myrpv);
    }

    private void setView() {
        /*
            硬解码插入数据
         */
        list = (ListView) findViewById(R.id.needlist_listview);
        final String[] listItem = {
                "急需通下水道专业工", "急需通下水道专业工", "急需通下水道专业工", "急需通下水道专业工", "急需通下水道专业工",};
        final String[] listItem_2 = {
                "400RMB", "600RMB", "470RMB", "410RMB", "800RMB",};
        final int[] iconItem = {
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher ,};

        adapter = new SimpleAdapter(
                this,                                           //context:上下文(当前的Activity)
                getData(listItem,listItem_2, iconItem),         //data:一个嵌套Map集合类型的list集合数据源
                R.layout.needlistactivity_item,                 //resource:ListView的布局文件
                new String[] { "name","price", "icon" },        //from:Map中的键名
                new int[] { R.id.needlist_text01,R.id.needlist_text02, R.id.needlist_img }); //to:布局文件中相匹配的控件的id
        list.setAdapter(adapter);
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
