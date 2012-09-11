package com.zipcerio.tedbootstrap;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity 
implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
	private ActionBar mAb;
	private ViewPager mPager;
	private MainAdapter mAdapter;
	
	private static final String TAB1 = Tab1Fragment.class.getName();
	private static final String TAB2 = Tab2Fragment.class.getName();
	private static final String TAB3 = Tab3Fragment.class.getName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_main);
		initViewPager();
		initTabs();
	}
	
	private void initTabs() {
		mAb = getSupportActionBar();
		mAb.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab1 = mAb.newTab().setText("Tab1");
		ActionBar.Tab tab2 = mAb.newTab().setText("Tab2");
		ActionBar.Tab tab3 = mAb.newTab().setText("Tab3");
		
		tab1.setTabListener(this);
		tab2.setTabListener(this);
		tab3.setTabListener(this);
		
		mAb.addTab(tab1, true);
		mAb.addTab(tab2);
		mAb.addTab(tab3);
	}

	private void initViewPager() {
		List<Fragment> fgs = new ArrayList<Fragment>();
		
		mAdapter = new MainAdapter(getSupportFragmentManager(), fgs);
		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(this);
		
		fgs.add(Fragment.instantiate(this, TAB1));
		fgs.add(Fragment.instantiate(this, TAB2));
		fgs.add(Fragment.instantiate(this, TAB3));
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		mAb.getTabAt(position).select();
	}

}