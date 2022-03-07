package fr.iut.dut2.tetris.application.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
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
        Log.d("ThreadGrille","Thread created (" + getClass().getSimpleName() + ")");
        controller = new GrilleController(this, p);

//        Grille maGrille = new Grille(this); //FAUX - sinon instancie 2 grilles car il y en a déjà une instanciée à partir de la vue .XML
        Grille maGrille = findViewById(R.id.Grille);
        maGrille.dessinerGrille(p);
        List<PositionPiece> liste =  new ArrayList<>();
        liste.add(new PositionPiece(1,1));
        maGrille.dessinerPiece(1, liste);

       // Designer designer = new Designer();
     //   designer.chargerGrille(new Partie(x,y));
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!p.getGrille().running) {
            Log.d("ThreadGrille", "Thread has normally stopped, restarting... (" + getClass().getSimpleName() + ")");
            thread.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("ThreadGrille", "Stopping thread due to app stop signal (" + getClass().getSimpleName() + ")");
        thread.interrupt();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ThreadGrille", "Pausing thread due to app pause signal (" + getClass().getSimpleName() + ")");
        p.getGrille().paused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        p.getGrille().paused = false;
        Log.d("ThreadGrille", "Continuing thread due to app resume signal (" + getClass().getSimpleName() + ")" );
    }

    public void GrilleToPause(View view) {
        controller.GrilleToPause();
    }
}
