package com.example.enz.Housekeeping;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jude.rollviewpager.RollPagerView;

/**
 * Created by Administrator on 2018/3/21.
 */

public class updateneed  extends Activity{
    private RollPagerView rpv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateneedactivity);

        /*
            图片轮播
         */
        rpv = (RollPagerView)findViewById(R.id.updateneed_rpv);
        MyRollPagerView myrpv = new MyRollPagerView();
        rpv.setAdapter(myrpv);
    }
}
