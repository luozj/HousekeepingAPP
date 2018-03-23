package com.example.enz.Housekeeping;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager vp;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    /**
     * Fragment
     */
    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;

    private TextView textView01,textView02,textView03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
    }



    private void setView() {
        //通过查找id的方式获取控件并监听其点击事件
        textView01= (TextView) findViewById(R.id.textView01);
        textView01.setOnClickListener(this);
        textView02= (TextView) findViewById(R.id.textView02);
        textView02.setOnClickListener(this);
        textView03= (TextView) findViewById(R.id.textView03);
        textView03.setOnClickListener(this);

        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        mFragmentList.add(fragment01);
        mFragmentList.add(fragment02);
        mFragmentList.add(fragment03);
        //适配器读取MyFragmentList
        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        //初始化viewPager
        vp = (ViewPager)findViewById(R.id.viewp_01);


        //添加OnPageChangeListener的API
        //网上以前常用的setOnPageChangeListener的方法过期，而且编译不通过
        //经查找发现需更换成addOnPageChangeListener
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //页面在滑动过程中不停触发该方法
            //position：当前滑动到的位置
            //positionOffset：偏移量的百分比
            //positionOffsetPixels：偏移量的数值
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            //ViewPager跳转到新页面时触发该方法，position表示新页面的位置。
            public void onPageSelected(int position) {
              switch (position){
                  case 0:
                      textView01.setTextColor(android.graphics.Color.parseColor("#ffffff"));
                      textView02.setTextColor(android.graphics.Color.parseColor("#d1d1d1"));
                      textView03.setTextColor(android.graphics.Color.parseColor("#d1d1d1"));

                      textView01.setBackgroundColor(android.graphics.Color.parseColor("#FF4040"));
                      textView02.setBackgroundColor(android.graphics.Color.parseColor("#ffffff"));
                      textView03.setBackgroundColor(android.graphics.Color.parseColor("#ffffff"));
                      //把当前位置传递到动画方法中，进行滑动
                      break;

                  case 1:
                      textView01.setTextColor(android.graphics.Color.parseColor("#d1d1d1"));
                      textView02.setTextColor(android.graphics.Color.parseColor("#ffffff"));
                      textView03.setTextColor(android.graphics.Color.parseColor("#d1d1d1"));

                      textView01.setBackgroundColor(android.graphics.Color.parseColor("#ffffff"));
                      textView02.setBackgroundColor(android.graphics.Color.parseColor("#FF4040"));
                      textView03.setBackgroundColor(android.graphics.Color.parseColor("#ffffff"));
                      //把当前位置传递到动画方法中，进行滑动
                      break;

                  case 2:
                      textView01.setTextColor(android.graphics.Color.parseColor("#d1d1d1"));
                      textView02.setTextColor(android.graphics.Color.parseColor("#d1d1d1"));
                      textView03.setTextColor(android.graphics.Color.parseColor("#ffffff"));

                      textView01.setBackgroundColor(android.graphics.Color.parseColor("#ffffff"));
                      textView02.setBackgroundColor(android.graphics.Color.parseColor("#ffffff"));
                      textView03.setBackgroundColor(android.graphics.Color.parseColor("#FF4040"));
                      //把当前位置传递到动画方法中，进行滑动
                      break;
              }
            }
            @Override
            //当页面的滑动状态改变时该方法会被触发
            //页面的滑动状态有3个：“0”表示什么都不做，“1”表示开始滑动，“2”表示结束滑动。
            public void onPageScrollStateChanged(int state) {
            }
        });
        //把数据传递给适配器中，进行数据处理。
        vp.setAdapter(mFragmentAdapter);
    }


    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.textView01:
              //设置viewPager的当前Tab
              //setCurrentItem(int index)方法主要用来制定初始化的页面
              //例如加入3个页面通过setCurrentItem(0)制定第一个页面为当前页面
              vp.setCurrentItem(0);
              break;
          case R.id.textView02:
              vp.setCurrentItem(1);
              break;
          case R.id.textView03:
              vp.setCurrentItem(2);
              break;
      }
    }
}
