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
import fr.iut.dut2.tetris.application.controlleurs.GrilleController;
import fr.iut.dut2.tetris.application.controlleurs.ScoreUpdater;
import fr.iut.dut2.tetris.application.model.designers.Grille;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.observateurs.ObservateurGrille;
import fr.iut.dut2.tetris.application.model.src.classes.content.observateurs.ObservateurScore;

public class GrilleWindowActivity extends AppCompatActivity {

    private GrilleController controller;
    private Partie p;
    private Thread thread;

    private TextView textView_score;
    private long elapsed_time = System.nanoTime();
    private ScoreUpdater scoreUpdater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Grille", "Grille started");
        setContentView(R.layout.grille_window);

        p = getIntent().getParcelableExtra("Partie");

        scoreUpdater = new ScoreUpdater(this);
        ObservateurScore obsScore = new ObservateurScore(this,p);
        ObservateurGrille obsGrille = new ObservateurGrille(p);
        Grille maGrille = findViewById(R.id.Grille);
        controller = new GrilleController(this, p);

        p.attach(obsScore);
        p.attach(obsGrille);

        obsGrille.setLooker(maGrille);

        if(!p.getGrille().running){
            thread = new Thread(p.getGrille());
        }

        TextView textView = findViewById(R.id.BestScore);
        if(p.getLeaderboard().getScores().size() == 0){
            scoreUpdater.bindScore(textView,0);
        }
        else{
            scoreUpdater.bindScore(textView,p.getLeaderboard().getScores().get(0));
        }

        maGrille.dessinerGrille(p);

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
                    int sensitivity = 8;



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

        textView_score = findViewById(R.id.Score);

        // Designer designer = new Designer();
        //   designer.chargerGrille(new Partie(x,y));
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!p.getGrille().running) {
            p.getGrille().running = true;
            p.getGrille().paused = false;
            thread.start();
        }
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

    }

    public void GrilleToPause(View view) {
        controller.GrilleToPause();
    }

    public void bindScore(int points) {
        scoreUpdater.bindScore(textView_score, points);
    }
}
