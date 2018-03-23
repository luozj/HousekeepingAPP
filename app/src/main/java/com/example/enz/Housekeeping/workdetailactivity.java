package com.example.enz.Housekeeping;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;

/**
 * Created by Administrator on 2018/3/19.
 */

public class workdetailactivity extends Activity {
    private RollPagerView rpv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workdetailactivity);

         /*
            接收传过来的参数
         */
        Bundle bundle = getIntent().getExtras();
        String work_shuoming=bundle.getString("listitem");
        String work_jiage=bundle.getString("listitem_2");
        /*
            把参数输入至控件
         */
        TextView work_shuoming_text= (TextView) findViewById(R.id.work_da_textView1);
        work_shuoming_text.setText(work_shuoming);
        TextView work_jiage_text= (TextView) findViewById(R.id.work_da_textView3);
        work_jiage_text.setText(work_jiage);

        /*
            图片轮播
         */
        rpv = (RollPagerView)findViewById(R.id.work_da_rpv);
        MyRollPagerView myrpv = new MyRollPagerView();
        rpv.setAdapter(myrpv);
    }
}
