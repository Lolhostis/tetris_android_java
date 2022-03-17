package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.GameOverController;

public class GameOverWindow extends AppCompatActivity {
    private GameOverController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_window);

        controller = new GameOverController(this);
    }

    public void GameOverToGrille(View view){
        controller.GameOverToGrille();
    }

    public void GameOverToMenu(View view){
        controller.GameOverToMenu();
    }
}
