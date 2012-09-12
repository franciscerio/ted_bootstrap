package com.zipcerio.tedbootstrap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactArrayAdapter extends ArrayAdapter<String> {
	private LayoutInflater mInflater;
	private String[] mArr;
	private Context mContext;
	private int mLayoutRes;

	public ContactArrayAdapter(Context context, int res, String[] objects) {
		super(context, res, objects);
		mContext = context;
		mLayoutRes = res;
		mArr = objects;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if (convertView == null) {
			convertView = mInflater.inflate(mLayoutRes, parent, false);
			holder = new ViewHolder();
			holder.text = (TextView) convertView.findViewById(R.id.textView1);
			convertView.setTag(holder);
			
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.text.setText(mArr[position]);
		
		return convertView;
	}
	
	static class ViewHolder {
		TextView text;
	}
	
}
