package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.GameOverController;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class GameOverWindow extends AppCompatActivity {
    private GameOverController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_window);

        Partie p = getIntent().getParcelableExtra("Partie");

        controller = new GameOverController(this, p);
    }

    public void GameOverToGrille(View view){
        controller.GameOverToGrille();
    }

    public void GameOverToMenu(View view){
        controller.GameOverToMenu();
    }
}
