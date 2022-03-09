package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.GrilleController;
import fr.iut.dut2.tetris.application.model.designers.Grille;
import fr.iut.dut2.tetris.application.model.designers.PositionPiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class GrilleWindowActivity extends AppCompatActivity {

    private GrilleController controller;
    private Partie p;
    private Thread thread;

    private TextView textView_score;

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
