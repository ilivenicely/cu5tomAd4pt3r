// Mccormick Robert
// JAV1 - MDV3810-O 01
// CustomAdapter.java


package com.example.robertmccormick.mccormickrob_ce05;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.robertmccormick.mccormickrob_ce05.DataList;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;
    private ArrayList<DataList> allDataList = new ArrayList<>();

    public CustomAdapter(Context applicationContext, ArrayList<DataList> _allDataList) {
        this.context = applicationContext;
        this.allDataList.clear();
        this.allDataList.addAll(_allDataList);
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return allDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(final int position, View convertView,
                        ViewGroup parent) {
        final MyViewHolder mViewHolder;
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_list, null);
            mViewHolder = new MyViewHolder();
            mViewHolder.row_name = (TextView) convertView.findViewById(R.id.row_name);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }
        DataList mPerson = allDataList.get(position);
        mViewHolder.row_name.setText(mPerson.getName());

        return convertView;
    }

    private class MyViewHolder {
        TextView row_name;

    }

}