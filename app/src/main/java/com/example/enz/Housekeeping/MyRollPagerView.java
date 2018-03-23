package com.example.enz.Housekeeping;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by Administrator on 2018/3/22.
 */

public class MyRollPagerView extends StaticPagerAdapter{
    /*
        选择需要轮播的图片
     */
    private  int[] img = {R.mipmap.planeta,R.mipmap.bunch,R.mipmap.falling};
    @Override
    /*
        下面的代码直接用别人写好的框架就好，只需更改xxx[position]中的xxx，如我就改成了对应我自己项目的img
     */
    public View getView(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(img[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }

    @Override
    public int getCount() {
        return img.length;
    }
}
