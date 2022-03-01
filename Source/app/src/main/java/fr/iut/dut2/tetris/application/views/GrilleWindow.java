package fr.iut.dut2.tetris.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;

public class GrilleWindow extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TimeLine", "Grille started");
        setContentView(R.layout.grille_window);
       // Designer designer = new Designer();
     //   designer.chargerGrille(new Partie(x,y));
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

        //Arreter le thread
        //Facultatif : Sauvegarder le score de la partie en cours
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Pause du thread (le thread a un attribut paused)
    }

    @Override
    protected void onResume() {
        super.onResume();

        //On continue le thread (en mettant paused à false)
    }

    public void GrilleToPause(View view) {
        Intent intent = new Intent(this,PauseWindow.class);
        startActivity(intent);
    }
}
