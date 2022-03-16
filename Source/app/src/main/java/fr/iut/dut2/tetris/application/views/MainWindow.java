package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.MainController;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class MainWindow extends AppCompatActivity {

    private Partie p;
    private MainController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_window);
        if(getIntent().getParcelableExtra("Partie") != null){
            p = getIntent().getParcelableExtra("Partie");
        }
        if(p == null){
            p = new Partie(24,12);
        }
        //p.getLeaderboard().chargerFichier();
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
        controller.MenuToOptions();
    }

    public void MenuToLeaderboard(View view) {
        controller.MenuToLeaderboard();
    }

    public void MenuToGrille(View view){
        controller.MenuToGrille();
    }

    @Override
    public void onBackPressed() {
        //On désactive le bouton en ne mettant aucune instruction
    }
}
