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

public class worklistactivity extends Activity {
    private ListView list;
    private SimpleAdapter adapter;
    private Button bt;
    private RollPagerView rpv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worklistactivity);

        setView();
        /*
            点击 发布新的服务 就跳转至addwork页面
         */
        bt = (Button) findViewById(R.id.worklist_buttom);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(worklistactivity.this,addwork.class);
                startActivity(intent);
            }
        });
        /*
            点击ListView的item就跳转至updatework，可提供修改及删除功能---未传递数据过去，仅模型
         */
        list = (ListView)findViewById(R.id.worklist_listview);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(worklistactivity.this,updatework.class);
                startActivity(intent);
            }
        });

        /*
            图片轮播
         */
        rpv = (RollPagerView)findViewById(R.id.worklist_rpv);
        MyRollPagerView myrpv = new MyRollPagerView();
        rpv.setAdapter(myrpv);
    }

    private void setView() {
        list = (ListView) findViewById(R.id.worklist_listview);
        final String[] listItem = {
                "张三通下水道", "李四通下水道", "王五通下水道", "张三修电脑", "李四修电脑",};
        final String[] listItem_2 = {
                "400", "400", "400", "400", "400",};
        final int[] iconItem = {
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher ,};
        adapter = new SimpleAdapter(
                this,                                       //context:上下文(当前的Activity)
                getData(listItem,listItem_2, iconItem),     //data:一个嵌套Map集合类型的list集合数据源
                R.layout.worklistactivity_item,             //resource:ListView的布局文件
                new String[] { "name","price", "icon" },    //from:Map中的键名
                new int[] { R.id.worklist_text01,R.id.worklist_text02, R.id.worklist_img }); //to:布局文件中相匹配的控件的id
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
