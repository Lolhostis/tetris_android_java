package fr.iut.dut2.tetris.application.views;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.MainController;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class MainWindow extends AppCompatActivity {

    private Partie p;
    private MainController controller;

    // private boolean stop = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                String message = sensorEvent.sensor.getName() + " | ";
                for(float f :  sensorEvent.values){
                    message += f + " | ";
                }
                //TextView text = findViewById(R.id.value);
                Log.d("Sensors", message);
                //text.setText(message);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        manager.registerListener(listener,sensor,10);
        setContentView(R.layout.main_window);
        if(p == null){
            p = new Partie(24,12);
        }
        controller = new MainController(this, p);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void MenuToOptions(View view) {
        controller.MenuToOptions(view);
    }

    public void MenuToLeaderboard(View view) {
        controller.MenuToLeaderboard(view);
    }

    public void MenuToGrille(View view){
        controller.MenuToGrille(view);
    }

    @Override
    public void onBackPressed() {
        //On désactive le bouton en ne mettant aucune instruction
    }
}
