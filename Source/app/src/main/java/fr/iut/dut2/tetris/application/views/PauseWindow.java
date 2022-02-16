package fr.iut.dut2.tetris.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;

public class PauseWindow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_window);
    }

    public void PauseToGrille(View view) {
        finish();
    }

    public void PauseToConfirmation(View view){
        Intent intent = new Intent(this, ConfirmationWindow.class);
        startActivity(intent);
    }
}
