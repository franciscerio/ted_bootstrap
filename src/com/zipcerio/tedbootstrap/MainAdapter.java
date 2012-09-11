package com.zipcerio.tedbootstrap;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MainAdapter extends FragmentPagerAdapter {
	private List<Fragment> mFragments;

	public MainAdapter(FragmentManager fm, List<Fragment> fgs) {
		super(fm);
		mFragments = fgs;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// super.destroyItem(container, position, object);
	}

}
