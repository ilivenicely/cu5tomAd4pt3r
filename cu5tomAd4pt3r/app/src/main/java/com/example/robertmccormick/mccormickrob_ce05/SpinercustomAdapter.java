// Mccormick Robert
// JAV1 - MDV3810-O 01
// SpinnerCustomAdapter.java


package com.example.robertmccormick.mccormickrob_ce05;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.robertmccormick.mccormickrob_ce05.DataList;

import java.util.ArrayList;

public class SpinercustomAdapter extends ArrayAdapter<DataList> {
    private ArrayList<DataList> allDataLists = new ArrayList<>();
    private Context mContext;
    LayoutInflater mInflater;
    public SpinercustomAdapter(Context mContext, int textViewResourceId, ArrayList<DataList> _allDataLists) {
        super(mContext, textViewResourceId, _allDataLists);
        this.mContext=mContext;
        this.allDataLists.clear();
        this.allDataLists.addAll(_allDataLists);
        this.mInflater = (LayoutInflater) mContext
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        DataList rowItem = getItem(position);
        View rowview = mInflater.inflate(R.layout.row_list,parent,false);
        TextView row_name = (TextView) rowview.findViewById(R.id.row_name);
        row_name.setText(rowItem.getName());
        return rowview;
    }

}
