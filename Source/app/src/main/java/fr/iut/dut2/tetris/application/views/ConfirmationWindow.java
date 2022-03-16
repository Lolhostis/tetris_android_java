package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.ConfirmationController;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class ConfirmationWindow extends AppCompatActivity {

    private ConfirmationController controller;
    private Partie partie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_window);
        partie = getIntent().getParcelableExtra("Partie");
        controller = new ConfirmationController(this, partie);
    }

    public void ConfirmationToMenu(View view){
        controller.ConfirmationToMenu();
    }

    public void ConfirmationToPause(View view){
        controller.ConfirmationToPause();
    }
}
