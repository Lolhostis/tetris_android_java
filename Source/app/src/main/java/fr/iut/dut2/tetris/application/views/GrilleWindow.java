package fr.iut.dut2.tetris.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;

public class GrilleWindow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grille_window);
    }

    public void GrilleToPause(View view) {
        Intent intent = new Intent(this,PauseWindow.class);
        startActivity(intent);
    }
}
