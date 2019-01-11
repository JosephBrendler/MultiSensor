package com.brendler.joe.sensortesting;

/**
 * Created by Joe on 1/14/2018.
 *  Local class with String methods, returning information about sensors that is either not
 *  available at all, or is not available in the older APIs supported by older phones. (for
 *  example, Sensor.getReportingMode() is not available in APIs prior to 21, so we implement
 *  similar functionality here, and SensorInfo.sensorDescription() provides the detailed description
 *  found at https://source.android.com/devices/sensors/sensor-types but not available in any API)
 */

public class SensorInfo {

    String sensorTypeString;
    String sensorReportingModeString;
    String sensorIsWakeupString, isDynamicString;
    String sensorUnitsString;
    String sensorDescriptionString;
    String[] sensorValueNamesStringArray;

    // Constructor
    public SensorInfo(Integer t) {
        Integer type = t;

        switch (type){
//            case 0 :
            case 1 :
                sensorTypeString = "Accelerometer";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "m/s^2";
                sensorDescriptionString = "Acceleration vector [x (right of screen), y (up screen), z (out of screen)] applied to the device.  Measures forces applied to the sensor itself.  Always includes gravity -9.81 m/s^2.";
                sensorValueNamesStringArray = convertStringListToStringArray("X,Y,Z");
                break;
            case 2 :
                sensorTypeString = "Magnetic Field";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "uT";
                sensorDescriptionString = "Ambient magnetic field in the X, Y and Z axis, in uT.";
                sensorValueNamesStringArray = convertStringListToStringArray("X,Y,Z");
                break;
            case 3 :
                sensorTypeString = "Orientation (Deprecated)";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "deg";
                sensorDescriptionString = "Deprecated. Azimuth (angle between the magnetic north y-axis, around the z-axis (0 to 359). 0=North, 90=East, 180=South, 270=West), Pitch (rotation around x-axis (-180 to 180), with positive values when the z-axis moves toward the y-axis.), and Roll (rotation around the y-axis (-90 to 90) increasing as the device moves clockwise.).";
                sensorValueNamesStringArray = convertStringListToStringArray("Azimuth,Pitch,Roll");
                break;
            case 4 :
                sensorTypeString = "Gyroscope";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "rad/s";
                sensorDescriptionString = "Rate of rotation around the X, Y and Z axis in rad/s. An estimation of the drift on each axis is reported as well.";;
                sensorValueNamesStringArray = convertStringListToStringArray("speed around X,speed around Y,speed around Z");
                break;
            case 5 :
                sensorTypeString = "Light";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "SI lux";
                sensorDescriptionString = "Ambient light level in SI lux units";
                sensorValueNamesStringArray = convertStringListToStringArray("Light Level,Not Documented (IR?),Not Documented");
                break;
            case 6 :
                sensorTypeString = "Pressure";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "hPa (millibar)";
                sensorDescriptionString = "Atmospheric pressure in hPa (millibar)";
                sensorValueNamesStringArray = convertStringListToStringArray("Atmospheric PressureNot Documented,Not Documented");
                break;
            case 7 :
                sensorTypeString = "Temperature (Deprecated)";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "(Deprecated) deg C";
                sensorDescriptionString = "Deprecated. Temperature in degree Celsius.";
                sensorValueNamesStringArray = convertStringListToStringArray("(Deprecated) Temperature");
                break;
            case 8 :
                sensorTypeString = "Proximity";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "cm";
                sensorDescriptionString = "Proximity sensor distance measured in centimeters.";
                sensorValueNamesStringArray = convertStringListToStringArray("Distance");
                break;
            case 9 :
                sensorTypeString = "Gravity";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "m/s^2";
                sensorDescriptionString = "Direction and magnitude of gravity in m/s^2. The coordinate system is the same as is used by the acceleration sensor. When the device is at rest, the output should be identical to that of the accelerometer.";
                sensorValueNamesStringArray = convertStringListToStringArray("X,Y,Z");
                break;
            case 10 :
                sensorTypeString = "Linear Acceleration";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "m/s^2";
                sensorDescriptionString = "Vector indicating acceleration along each device axis, not including gravity, in m/s^2. The coordinate system is the same as is used by the acceleration sensor. LINEAR ACCELERATION = ACCELERATION - GRAVITY.";
                sensorValueNamesStringArray = convertStringListToStringArray("X,Y,Z");
                break;
            case 11 :
                sensorTypeString = "Rotation Vector";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "unitless";
                sensorDescriptionString = "Orientation of the device as a combination of an angle and an axis, in which the device has rotated through an angle θ around an axis [x, y, z]. The magnitude of the rotation vector is equal to sin(θ/2), and its direction is equal to the direction of the axis of rotation.  The three elements of the rotation vector (components of a unit quaternion) unitless. The x,y, and z axis are defined in the same way as the acceleration sensor.";
                sensorValueNamesStringArray = convertStringListToStringArray("x*sin(θ/2),y*sin(θ/2),z*sin(θ/2),cos(θ/2),Estimated Heading");
                break;
            case 12 :
                sensorTypeString = "Relative Humidity";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "%";
                sensorDescriptionString = "Relative ambient air humidity in percent (saturation = 100%)";
                sensorValueNamesStringArray = convertStringListToStringArray("Relative Humidity");
                break;
            case 13 :
                sensorTypeString = "Ambient Temperature";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "deg C";
                sensorDescriptionString = "Ambient (room) temperature in degree Celsius";
                sensorValueNamesStringArray = convertStringListToStringArray("Ambient Temperature");
                break;
            case 14 :
                sensorTypeString = "Magnetic Field Uncalibrated";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "uT";
                sensorDescriptionString = "Similar to MAGNETIC FIELD, in uT, where soft iron distortions that arise due to the interaction with the earth's magnetic field are included uncalib values, but for this sensor, the hard iron distortions that arise due to the magnetized iron, steel or permanent magnets on the device, are reported separately as bias values.";
                sensorValueNamesStringArray = convertStringListToStringArray("x_uncalib,y_uncalib,z_uncalib,x_bias,y_bias,z_bias");
                break;
            case 15 :
                sensorTypeString = "Game Rotation Vector";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "unitless";
                sensorDescriptionString = "Identical to TYPE_ROTATION_VECTOR except that it doesn't use the geomagnetic field. Therefore the Y axis doesn't point north, but instead to some other reference, that reference is allowed to drift by the same order of magnitude as the gyroscope drift around the Z axis.";
                sensorValueNamesStringArray = convertStringListToStringArray("x*sin(θ/2),y*sin(θ/2),z*sin(θ/2),cos(θ/2),Estimated Heading");
                break;
            case 16 :
                sensorTypeString = "Gyroscope Uncalibrated";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "rad/s";
                sensorDescriptionString = "Rate of rotation around the X, Y and Z axes, in rad/s. An estimation of the drift on each axis is reported as well.";
                sensorValueNamesStringArray = convertStringListToStringArray("speed around X,speed around Y,speed around Z,drift around X,drift around Y,drift around Z");
                break;
            case 17 :
                sensorTypeString = "Significant Motion";
                sensorReportingModeString = "*One-shot*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "n/a";
                sensorDescriptionString = "Triggers when the detecting a “significant motion”: a motion that might lead to a change in the user location.";
                sensorValueNamesStringArray = convertStringListToStringArray("Significant Motion");
                break;
            case 18 :
                sensorTypeString = "Step Detector";
                sensorReportingModeString = "*Special*";
                sensorIsWakeupString = "No";
                sensorUnitsString = "1.0";
                sensorDescriptionString = "Event produces a timestamp representing when the foot hit the ground.";
                sensorValueNamesStringArray = convertStringListToStringArray("Step");
                break;
            case 19 :
                sensorTypeString = "Step Counter";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "steps";
                sensorDescriptionString = "Reports the number of steps taken by the user since the last reboot while activated.";
                sensorValueNamesStringArray = convertStringListToStringArray("Step Count");
                break;
            case 20 :
                sensorTypeString = "Geomagnetic Rotation Vector";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "unitless";
                sensorDescriptionString = "Similar to a rotation vector sensor but using a magnetometer and no gyroscope.";
                sensorValueNamesStringArray = convertStringListToStringArray("x*sin(θ/2),y*sin(θ/2),z*sin(θ/2),cos(θ/2),Estimated Heading");
                break;
            case 21 :
                sensorTypeString = "Heart Rate";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "beats/min";
                sensorDescriptionString = "Reports the current heart rate of the person touching the device.";
                sensorValueNamesStringArray = convertStringListToStringArray("Heart Rate");
                break;
            case 22 :
                sensorTypeString = "Tilt Detector";
                sensorReportingModeString = "*Special*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "Unk";
                sensorDescriptionString = "Detects tilt and generates a tilt event, defined by the direction of the 2-seconds window average gravity changing by at least 35 degrees since the activation or the last event generated by the sensor.";
                sensorValueNamesStringArray = convertStringListToStringArray("Unknown,Unknown,Unknown");
                break;
//            case 23 :
//            case 24 :
            case 25 :
                sensorTypeString = "Pickup Gesture Detector";
                sensorReportingModeString = "*One-shot*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "1|0";
                sensorDescriptionString = "Triggers when the device is picked up regardless of wherever it was before (desk, pocket, bag).";
                sensorValueNamesStringArray = convertStringListToStringArray("1");
                break;
//            case 26 :
//            case 27 :
            case 28 :
                sensorTypeString = "Pose 6DOF";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "quaternion and translation in SI units";
                sensorDescriptionString = "Event consists of a rotation expressed as a quaternion and a translation expressed in SI units. The event also contains a delta rotation and translation that show how the device.s pose has changed since the previous sequence numbered pose. The event uses the cannonical Android Sensor axes.";
                sensorValueNamesStringArray = convertStringListToStringArray("x*sin(θ/2),y*sin(θ/2),z*sin(θ/2),cos(θ/2),Trans_X,Trans_Y,Trans_Z,dq_X,dq_Y,dq_Z,dq_axis,d_Trans_X,d_Trans_Y,d_Trans_Z,Sequence Number");
                break;
            case 29 :
                sensorTypeString = "Stationary Detect";
                sensorReportingModeString = "*Special?*";
                sensorIsWakeupString = "No?";
                sensorUnitsString = "1.0";
                sensorDescriptionString = "Event is produced if the device has been stationary for at least 5 seconds with a maximal latency of 5 additional seconds.";
                sensorValueNamesStringArray = convertStringListToStringArray("Stationary");
                break;
            case 30 :
                sensorTypeString = "Motion Detect";
                sensorReportingModeString = "*One-shot*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "1.0";
                sensorDescriptionString = "Event is produced if the device has been in motion for at least 5 seconds with a maximal latency of 5 additional seconds. ie: it may take up anywhere from 5 to 10 seconds afte the device has been at rest to trigger this event. The only allowed value is 1.0.";
                sensorValueNamesStringArray = convertStringListToStringArray("Motion");
                break;
            case 31 :
                sensorTypeString = "Heart Beat";
                sensorReportingModeString = "*One-shot*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "1.0|0.0 confidence";
                sensorDescriptionString = "Returns an event everytime a heart beat peak is detected. Peak here ideally corresponds to the positive peak in the QRS complex of an ECG signal.  The float value returned expresses a  confidence value of 0.0 indicates complete uncertainty - that a peak is as likely to be at the indicated timestamp as anywhere else. A confidence value of 1.0 indicates complete certainly - that a peak is completely unlikely to be anywhere else on the QRS complex.";
                sensorValueNamesStringArray = convertStringListToStringArray("Heart Beat");
                break;
//            case 32 :
//            case 33 :
            case 34 :
                sensorTypeString = "Low Latency Offbody Detect";
                sensorReportingModeString = "*One-shot?*";
                sensorIsWakeupString = "*Yes?*";
                sensorUnitsString = "1.0|0.0 on|off";
                sensorDescriptionString = "Returns an event every time the device transitions from off-body to on-body and from on-body to off-body.  The float value returned is 1.0 if the device is on-body, 0.0 if the device is off-body. ";
                sensorValueNamesStringArray = convertStringListToStringArray("On-Body");
                break;
            case 35 :
                sensorTypeString = "Accelerometer Uncalibrated";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "m/s^2";
                sensorDescriptionString = "Similar to ACCELEROMETER, in m/s^s.  Factory calibration and temperature compensation will still be applied to the \"uncalibrated\" measurement.  Factory bias and temperature compensation are reported in bias values.";
                sensorValueNamesStringArray = convertStringListToStringArray("x_uncalib,y_uncalib,z_uncalib,x_bias,y_bias,z_bias");
                break;

            case 65536 :
                sensorTypeString = "Tilt";
                sensorReportingModeString = "*Special?*";
                sensorIsWakeupString = "*Yes?*";
                sensorUnitsString = "Unk";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Unk");
                break;
            case 65558 :
                sensorTypeString = "Screen Orientation";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "deg";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Orientation");
                break;
            case 65559 :
                sensorTypeString = "Motion Sense";
                sensorReportingModeString = "*One-shot?*";
                sensorIsWakeupString = "*Yes?*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Motion");
                break;
            case 65560 :
                sensorTypeString = "Grip";
                sensorReportingModeString = "*One-shot?*";
                sensorIsWakeupString = "*Yes?*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Unk";
                sensorValueNamesStringArray = convertStringListToStringArray("Motion");
                break;
            case 65561 :
                sensorTypeString = "MAX86902";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "None";
                sensorDescriptionString = "Unk";
                sensorValueNamesStringArray = convertStringListToStringArray("Motion");
                break;
            case 65562 :
                sensorTypeString = "HRM (Heart Rate Monitor) Sensor";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "None";
                sensorDescriptionString = "Unk";
                sensorValueNamesStringArray = convertStringListToStringArray("Motion");
                break;
            case 65565 :
                sensorTypeString = "MAX86902 UV Ray";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "None";
                sensorDescriptionString = "Unk";
                sensorValueNamesStringArray = convertStringListToStringArray("Motion");
                break;
            case 65571 :
                sensorTypeString = "HRMLED IR";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "Unk";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("IR Light");
                break;
            case 65572 :
                sensorTypeString = "HRMLED Red";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No";
                sensorUnitsString = "Unk";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("IR Light");
                break;
            case 65578 :
                sensorTypeString = "Light IR";
                sensorReportingModeString = "On-change";
                sensorIsWakeupString = "No";
                sensorUnitsString = "Unk";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("IR Light");
                break;
            case 65579 :
                sensorTypeString = "Gyro Interrupt";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "No?";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Gyro Interrupt Triggered");
                break;

            case 33171000 :
                sensorTypeString = "Basic Gestures";
                sensorReportingModeString = "*One-shot*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Gesture");
                break;
            case 33171001 :
                sensorTypeString = "Gyro Tap Secondary";
                sensorReportingModeString = "*Special*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Tap");
                break;
            case 33171002 :
                sensorTypeString = "Facing";
                sensorReportingModeString = "*Special*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Unk");
                break;
            case 33171003 :
                sensorTypeString = "Gestures: Tilt";
                sensorReportingModeString = "*Special*";
                sensorIsWakeupString = "*Yes*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Tilt");
                break;
            case 33171006 :
                sensorTypeString = "Absolute Motion Detector";
                sensorReportingModeString = "Continuous";
                sensorIsWakeupString = "*Yes?*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Absolute Motion");
                break;
            case 33171007 :
                sensorTypeString = "Relative Motion Detector";
                sensorReportingModeString = "*One-shot?*";
                sensorIsWakeupString = "*Yes?*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Relative Motion");
                break;
            case 33171008 :
                sensorTypeString = "V(ertical?) Motion Detector";
                sensorReportingModeString = "*One-shot?*";
                sensorIsWakeupString = "*Yes?*";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("V(ertical?) Motion");
                break;
            case 33171009 :
                sensorTypeString = "Pedometer";
                sensorReportingModeString = "On-change?";
                sensorIsWakeupString = "No";
                sensorUnitsString = "Steps?";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Steps");
                break;
            case 33171010 :
                sensorTypeString = "Pedestrian Activity Monitor";
                sensorReportingModeString = "On-change?";
                sensorIsWakeupString = "No";
                sensorUnitsString = "Steps?";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Steps");
                break;
            case 33171011 :
                sensorTypeString = "Motion Accelerometer";
                sensorReportingModeString = "Continuous?";
                sensorIsWakeupString = "No";
                sensorUnitsString = "Steps?";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("X,Y,Z");
                break;
            case 33171013 :
                sensorTypeString = "RGB";
                sensorReportingModeString = "Unk";
                sensorIsWakeupString = "No?";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
//                sensorValueNamesStringArray = convertStringListToStringArray("Red,Green,Blue,CT");
                sensorValueNamesStringArray = convertStringListToStringArray("RGB_CT");
                break;
            case 33171016 :
                sensorTypeString = "BU52061NVX Rohm Hall Effect";
                sensorReportingModeString = "Unk";
                sensorIsWakeupString = "No?";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Unk");
                break;
            case 33171017 :
                sensorTypeString = "pixart_ppg";
                sensorReportingModeString = "Unk";
                sensorIsWakeupString = "No?";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Unk");
                break;
            case 33171018 :
                sensorTypeString = "pixart_ppg_raw";
                sensorReportingModeString = "Unk";
                sensorIsWakeupString = "No?";
                sensorUnitsString = "None";
                sensorDescriptionString = "Undocumented";
                sensorValueNamesStringArray = convertStringListToStringArray("Unk");
                break;

            default :
                sensorTypeString = "Uknown Sensor";
                sensorReportingModeString = "Unk";
                sensorIsWakeupString = "Unk";
                sensorUnitsString = "Unk";
                sensorDescriptionString = "Unk";
                sensorValueNamesStringArray = convertStringListToStringArray("Unk");
                break;
        }
    }

    public String sensorTypeName() {
        return sensorTypeString;
    }

    public String sensorReportingMode() { return sensorReportingModeString; }

    public String sensorIsWakeUp() { return sensorIsWakeupString; }

    public String sensorUnits() {
        return sensorUnitsString;
    }

    public String sensorDescription() {
        return sensorDescriptionString;
    }

    public String[] sensorValueNames() { return sensorValueNamesStringArray; }


    private String[] convertStringListToStringArray(String s) {
        String item;
        String[] stringArray = new String[50];
        // fill array with values parsed from string
        if (s.length() > 0) {
            if (s.contains(",")) {
                // split several items
                stringArray = s.split(",");
            } else {
                // assign single item
                stringArray[0] = s;
            }
        } else {
            // empty list; assign null item
            stringArray[0] = "";
        }
        return stringArray;
    }


}
