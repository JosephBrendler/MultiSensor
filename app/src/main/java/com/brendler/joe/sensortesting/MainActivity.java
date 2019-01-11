package com.brendler.joe.sensortesting;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {

    ListView sensorListView;

    List<String> sensorNames = new ArrayList<String>();
    List<String> sensorVendors = new ArrayList<String>();
    List<String> sensorTypeNames = new ArrayList<String>();
    List<String> sensorReportingModes = new ArrayList<String>();

    SensorManager sensorManager;
    List<Sensor> sensorList;
    Integer sensorListSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        sensorListSize = (Integer)sensorList.size();




        // Initialize capability lists for each sensor
        for ( Sensor s : sensorList ) {
            sensorNames.add(s.getName().toString());
            sensorVendors.add(s.getVendor().toString());
            Integer type = s.getType();
            String typeName, reportingMode;
            // use my custome class SensorInfo to get a little more info about this sensor
            SensorInfo sensorInfo = new SensorInfo(type);
            typeName = sensorInfo.sensorTypeName();
            reportingMode = sensorInfo.sensorReportingMode();
            sensorTypeNames.add(typeName);
            sensorReportingModes.add(reportingMode);
        }

        // Populate the sensor_listview_details for each sensor in the list and display in activity_main
        // as touch-sensitive rows, each of which will launch the activity_sensor_capability for that sensor
        sensorListView = (ListView)findViewById(R.id.sensorListView);
        SensorAdapter sensorAdapter = new SensorAdapter(this, sensorNames, sensorVendors, sensorTypeNames, sensorReportingModes);
        sensorListView.setAdapter(sensorAdapter);
        sensorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // populate the textview fields of activity_sensor_capability with data for sensor i, and launch it
                String stringIndex = "" + i;
                String title = "Sensor: " + sensorNames.get(i);
                String msg = "Activating sensor...";
                Intent showSensorOutputActivity = new Intent(getApplicationContext(), SensorOutputActivity.class);
                showSensorOutputActivity.putExtra("com.brendler.joe.sensortesting.SENSOR_INDEX", stringIndex);
                showSensorOutputActivity.putExtra("com.brendler.joe.sensortesting.SENSOR_TITLE", title);
                showSensorOutputActivity.putExtra("com.brendler.joe.sensortesting.SENSOR_TEXT", msg);
                startActivity(showSensorOutputActivity);
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // not using this here in this activity
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // not using this here in this activity
    }
}
