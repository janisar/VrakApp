package com.example.vrakapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adapter extends BaseAdapter {

	private Context context;
	private List<ImageView> images;
	
	public Adapter(Context context) {
		this.context = context;
		this.images = new ArrayList<ImageView>();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = null;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	if (images.size() != 0) {
        		imageView = images.get(0);
        	}
        } else {
            imageView = (ImageView) convertView;
        }
        imageView = images.get(0);
        return imageView;
	}

	public void addImage(ImageView image) {
		images.add(image);
	}
}
