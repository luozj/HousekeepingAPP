package com.example.enz.Housekeeping;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;

/**
 * Created by Administrator on 2018/3/21.
 */

public class needdetailactivity extends Activity{
    private RollPagerView rpv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.needdetailactivity);

        /*
            接收传过来的参数
         */
        Bundle bundle = getIntent().getExtras();
        String need_shuoming = bundle.getString("listitem");
        String need_jiage = bundle.getString("listitem_2");
        /*
            把参数输入至控件
         */
        TextView need_shuoming_text = (TextView) findViewById(R.id.need_da_textView1);
        need_shuoming_text.setText(need_shuoming);
        TextView need_jiage_text = (TextView) findViewById(R.id.need_da_textView3);
        need_jiage_text.setText(need_jiage);

       /*
            图片轮播
         */
        rpv = (RollPagerView)findViewById(R.id.need_da_rpv);
        MyRollPagerView myrpv = new MyRollPagerView();
        rpv.setAdapter(myrpv);
    }
}
