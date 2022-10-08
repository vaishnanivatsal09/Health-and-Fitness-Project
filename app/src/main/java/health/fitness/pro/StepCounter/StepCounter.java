package health.fitness.pro.StepCounter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import health.fitness.pro.R;

public class StepCounter extends AppCompatActivity implements SensorEventListener {

    private TextView stepText;
    private SensorManager sensorManager;
    private Sensor mStepDetector;
    boolean isDetectorSensorPresent;
    int stepDetect = 00;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        stepText = (TextView) findViewById(R.id.stepText);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null)
        {
            mStepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isDetectorSensorPresent = true;
        }
        else {
            stepText.setText("Detector Sensor is Not Present");
            isDetectorSensorPresent = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepDetector){
            stepDetect = (int) (stepDetect+sensorEvent.values[0]);
            stepText.setText(String.valueOf(stepDetect));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
         if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null)
            sensorManager.registerListener(this,mStepDetector,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null)
            sensorManager.unregisterListener(this,mStepDetector);
    }

    public void reset(View view) {
        stepDetect = 0;
        stepText.setText("0");
    }
}