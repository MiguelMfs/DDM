package com.example.sensores;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView sensorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorTextView = findViewById(R.id.sensor_text);

        // Obtém o serviço de sensores
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Obtém o acelerômetro
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Registra o listener
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Desregistra o listener
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Pode ser ignorado se não precisar acompanhar mudanças de precisão
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0]; // Eixo X
            float y = event.values[1]; // Eixo Y
            float z = event.values[2]; // Eixo Z

            String texto = String.format("Acelerômetro:\nX: %.2f\nY: %.2f\nZ: %.2f", x, y, z);
            sensorTextView.setText(texto);
        }
    }
}
