package fr.iut.dut2.tetris.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class MainWindow extends AppCompatActivity {

    private Partie p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);
        if(p == null){
            p = new Partie(24,12);
        }

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
        Intent MenuOptions = new Intent(this, OptionsWindow.class);
        MenuOptions.putExtra("Partie", p);
        startActivity(MenuOptions);
    }

    public void MenuToLeaderboard(View view) {
        Intent MenuLeaderboard = new Intent(this, LeaderboardWindow.class);
        startActivity(MenuLeaderboard);
    }

    public void MenuToGrille(View view){
        Intent MenuGrille = new Intent(this, GrilleWindow.class);
        startActivity(MenuGrille);
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
