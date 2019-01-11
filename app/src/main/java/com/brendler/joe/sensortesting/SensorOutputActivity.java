package com.brendler.joe.sensortesting;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class SensorOutputActivity extends AppCompatActivity implements SensorEventListener {

    private TextView sensorOutputTitleTextView;
    private TextView sensorOutputTextView;
    private String sensorTitleText;
    private String sensorOutputText;
    private String stringIndex;
    private Integer index;

    private Sensor mySensor;
    private SensorManager SM;

    private List<Sensor> sensorList;

    String sensorTypeName;
    String sensorReportingMode;
    String sensorIsWakeUp;
    String sensorUnits;
    String sensorDescription;
    String[] sensorValueNames;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_output);

        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = SM.getSensorList(Sensor.TYPE_ALL);

        if (getIntent().hasExtra("com.brendler.joe.sensortesting.SENSOR_INDEX")) {
            stringIndex = getIntent().getExtras().getString("com.brendler.joe.sensortesting.SENSOR_INDEX");
            index = Integer.parseInt(stringIndex);
            //  sensor
            mySensor = SM.getDefaultSensor(sensorList.get(index).getType());
            // Register sensor listener
            SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if (getIntent().hasExtra("com.brendler.joe.sensortesting.SENSOR_TITLE")) {
            sensorOutputTitleTextView = (TextView) findViewById(R.id.sensorOutputTitleTextView);
            sensorTitleText = getIntent().getExtras().getString("com.brendler.joe.sensortesting.SENSOR_TITLE");
            sensorOutputTitleTextView.setText(sensorTitleText);
        }

        if (getIntent().hasExtra("com.brendler.joe.sensortesting.SENSOR_TEXT")) {
            sensorOutputTextView = (TextView) findViewById(R.id.sensorOutputTextView);
            sensorOutputText = getIntent().getExtras().getString("com.brendler.joe.sensortesting.SENSOR_TEXT");
            sensorOutputTextView.setText(sensorOutputText);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String sensorName = sensorEvent.sensor.getName();
        Integer sensorType = sensorEvent.sensor.getType();
        SensorInfo sensorInfo = new SensorInfo(sensorType);

        sensorTypeName = sensorInfo.sensorTypeName();
        sensorReportingMode = sensorInfo.sensorReportingMode();
        sensorIsWakeUp = sensorInfo.sensorIsWakeupString;
        sensorUnits = sensorInfo.sensorUnits();
        sensorDescription = sensorInfo.sensorDescription();
        sensorValueNames = sensorInfo.sensorValueNames();

        Float sensorResolution = mySensor.getResolution();
        Float sensorRange = mySensor.getMaximumRange();
        Float sensorPower = mySensor.getPower();
        String sensorVendor = mySensor.getVendor();

        // populate sensor output details differently, depending on reporting mode and wakeup,
        StringBuilder msg = new StringBuilder();
        msg.append("Type: ").append(sensorTypeName).append(" (").append(sensorReportingMode).append(")");
        msg.append("\nWake-up: ").append(sensorIsWakeUp);
        msg.append("\nVendor: ").append(sensorVendor);
        msg.append("\n\nDescription: ").append(sensorDescription);
        msg.append("\n\n  Units: ").append(sensorUnits);
        msg.append("\n  Range: ").append(sensorRange.toString()).append(" ").append(sensorUnits);
        msg.append("\n  Resolution: ").append(sensorResolution.toString()).append(" ").append(sensorUnits);
        msg.append("\n  Power: ").append(sensorPower.toString()).append(" mA");
        msg.append("\n\n  Output: ");
        Integer i = 0;
        for ( Float val : sensorEvent.values ) {
            msg.append("\n    ").append(sensorValueNames[i]).append(": ").append(val.toString());
            i += 1;
        }
        sensorOutputTextView.setText(msg.toString());
//        sensorOutputTextView.setText("Placeholder");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
