package fr.iut.dut2.tetris.application.views;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.GrilleController;
import fr.iut.dut2.tetris.application.model.designers.Grille;
import fr.iut.dut2.tetris.application.model.designers.PositionPiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;

public class GrilleWindowActivity extends AppCompatActivity {

    private GrilleController controller;
    private Partie p;
    private Thread thread;

    private TextView textView_score;
    private long elapsed_time = System.nanoTime();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Grille", "Grille started");
        setContentView(R.layout.grille_window);

        p = getIntent().getParcelableExtra("Partie");
        thread = new Thread(p.getGrille());
        Log.d("ThreadGrille", "Thread created (" + getClass().getSimpleName() + ")");
        controller = new GrilleController(this, p);

//        Grille maGrille = new Grille(this); //FAUX - sinon instancie 2 grilles car il y en a déjà une instanciée à partir de la vue .XML
        Grille maGrille = findViewById(R.id.Grille);
        maGrille.dessinerGrille(p);
        List<PositionPiece> liste = new ArrayList<>();
        for (int i = 1; i < p.getNbColonnes(); i++) {
            liste.add(new PositionPiece(2, i));
        }

        liste.remove(4);
        liste.remove(4);
        liste.remove(6);

        maGrille.dessinerPiece(1, liste);

        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                String message = sensorEvent.sensor.getName() + " | ";

                long current_time = System.nanoTime();
                float[] data = sensorEvent.values;
                long waitTime = (long) (2  * Math.pow(10,8));

                if(sensorEvent.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION){
                    int sensitivity = 5;



                    Log.d("Mouvement","" + (current_time - elapsed_time));

                    if(current_time - elapsed_time > waitTime) {
                        if (data[0] >= sensitivity) {
                            controller.MovementApplier(MovePiece.DROITE);
                            elapsed_time = System.nanoTime();
                        } else if (data[0] <= -sensitivity) {
                            controller.MovementApplier(MovePiece.GAUCHE);
                            elapsed_time = System.nanoTime();
                        }
                    }
                }
                else if(sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE){
                    int sensitivity = 5;

                    if(current_time - elapsed_time > waitTime) {
                        if (data[1] >= sensitivity) {
                            controller.MovementApplier(MovePiece.TOURNER_DROITE);
                            elapsed_time = System.nanoTime();
                        } else if (data[1] <= -sensitivity) {
                            controller.MovementApplier(MovePiece.TOURNER_GAUCHE);
                            elapsed_time = System.nanoTime();
                        }
                    }
                }


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

        Sensor sensorRot = manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        manager.registerListener(listener,sensorRot, 10);




        // Designer designer = new Designer();
        //   designer.chargerGrille(new Partie(x,y));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ThreadGrille","Running : " + p.getGrille().running);
        if (!p.getGrille().running) {
            p.getGrille().running = true;
            p.getGrille().paused = false;
            Log.d("ThreadGrille", "Thread has normally stopped, restarting... (" + getClass().getSimpleName() + ")");
            thread.start();

        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("ThreadGrille", "Stopping thread due to app stop signal (" + getClass().getSimpleName() + ")");
        /*thread.interrupt();

        p.getGrille().paused = false;
        thread = new Thread(p.getGrille());*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ThreadGrille", "Pausing thread due to app pause signal (" + getClass().getSimpleName() + ")");
        if (!p.getGrille().paused) {
            p.getGrille().paused = true;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (p.getGrille().paused) {
            p.getGrille().paused = false;
        }

        Log.d("ThreadGrille", "Continuing thread due to app resume signal (" + getClass().getSimpleName() + ")");
    }

    public void GrilleToPause(View view) {
        controller.GrilleToPause();
    }
}
