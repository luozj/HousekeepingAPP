package com.example.enz.Housekeeping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;


public class Fragment03 extends Fragment{
    private TextView worktext,needtext;
    private RollPagerView rpv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate()的作用就是将一个用xml定义的布局文件查找出来.这里用来引用xml布局
        //与findViewById()的区别---inflate是加载一个布局文件，而findViewById则是从布局文件中查找一个控件。
        View view = inflater.inflate(R.layout.fragment03,container,false);
        worktext = (TextView) view.findViewById(R.id.my_work);
        /*
            点击 我的服务 跳转至自己提供的服务列表worklistactivity
         */
        worktext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),worklistactivity.class);
                startActivity(intent);
            }
        });
        needtext = (TextView) view.findViewById(R.id.my_need);
        /*
            点击 我的需求 跳转至自己发布的需求列表needlistactivity
         */
        needtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),needlistactivity.class);
                startActivity(intent);
            }
        });
        /*
            图片轮播
         */
        rpv = (RollPagerView) view.findViewById(R.id.my_rpv);
        MyRollPagerView myrpv = new MyRollPagerView();
        rpv.setAdapter(myrpv);
        /*
            监听对轮播图片的点击事件
         */
        rpv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}

