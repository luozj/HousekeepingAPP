package com.example.enz.Housekeeping;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

	List<Fragment> fragmentList = new ArrayList<Fragment>();


	public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
	}

	@Override
	public Fragment getItem(int position) {
		//通过position设置对应的Fragment
		return fragmentList.get(position);
	}

	@Override
	public int getCount() {
		//你的fragment集合的参数长度
		return fragmentList.size();
	}

}
