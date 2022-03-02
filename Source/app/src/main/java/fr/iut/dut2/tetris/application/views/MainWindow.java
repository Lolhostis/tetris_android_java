package fr.iut.dut2.tetris.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){

            Log.d("Transfer", "Request code : " + requestCode);
            Log.d("Transfer", "Result code : " + resultCode);

            Log.d("Transfer", "Coming from Options");
            assert data != null;
            p = data.getParcelableExtra("Partie");
        }


    }
}
