package com.examples.anu.listexampleapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Anu on 11/27/14.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private List<Integer> mThumbIds;

    public ImageAdapter(Context c,List<Integer> ids)
    {
        mContext = c;
        mThumbIds= ids;

    }



    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);


    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(mContext);
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds.get(position));
        return imageView;
    }
}
