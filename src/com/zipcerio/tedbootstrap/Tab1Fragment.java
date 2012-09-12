package com.zipcerio.tedbootstrap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

public class Tab1Fragment extends SherlockFragment {
	private ListView mList;

	@Override
	public View onCreateView(LayoutInflater inf, ViewGroup grp, Bundle icicle) {
		View v = inf.inflate(R.layout.f_tab1, grp, false);
		mList = (ListView) v.findViewById(R.id.listView1);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ContactArrayAdapter adapter = new ContactArrayAdapter(getActivity(),
				R.layout.l_item, Cheese.STRINGS);
		mList.setAdapter(adapter);
	}
}
