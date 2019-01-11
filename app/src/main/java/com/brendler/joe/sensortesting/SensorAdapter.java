package com.brendler.joe.sensortesting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe on 1/11/2018.
 */

public class SensorAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    List<String> sensorNames = new ArrayList<String>();
    List<String> sensorVendors = new ArrayList<String>();
    List<String> sensorTypeNames = new ArrayList<String>();
    List<String> sensorReportingModes = new ArrayList<String>();

    public SensorAdapter(Context c, List<String> n, List<String> v, List<String> t, List<String> r) {
        sensorNames = n;
        sensorVendors = v;
        sensorTypeNames = t;
        sensorReportingModes = r;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sensorNames.size();
    }

    @Override
    public Object getItem(int i) {
        return sensorNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.sensor_listview_details, null);
        TextView sensorNameTextView = (TextView) v.findViewById(R.id.sensorNameTextView);
        TextView sensorVendorTextView = (TextView) v.findViewById(R.id.sensorVendorTextView);
        TextView sensorTypeNameTextView = (TextView) v.findViewById(R.id.sensorTypeNameTextView);


        String typeName = "  " + (i + 1) + ".  " + sensorTypeNames.get(i) + " (" + sensorReportingModes.get(i) + ")";
        String name = sensorNames.get(i);
        name = "     Sensor Name: " + name;
        String vendor = "     Vendor: " + sensorVendors.get(i);

        sensorNameTextView.setText(name);
        sensorVendorTextView.setText(vendor);
        sensorTypeNameTextView.setText(typeName);

        return v;
    }
}
