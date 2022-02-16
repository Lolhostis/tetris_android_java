package fr.iut.dut2.tetris.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;

public class ConfirmationWindow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_window);
    }

    public void ConfirmationToMenu(View view){
        Intent intent = new Intent(this, MainWindow.class);
        startActivity(intent);
    }

    public void ConfirmationToPause(View view){
        finish();
    }
}
