package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.PauseController;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class PauseWindow extends AppCompatActivity {

    private PauseController controller;
    private Partie p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_window);
        p = getIntent().getParcelableExtra("Partie");
        controller = new PauseController(this, p);
    }

    public void PauseToGrille(View view) {
        controller.PauseToGrille();
    }

    public void PauseToConfirmation(View view){
        controller.PauseToConfirmation();
    }
}
