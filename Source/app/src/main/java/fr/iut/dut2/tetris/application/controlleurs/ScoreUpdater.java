package fr.iut.dut2.tetris.application.controlleurs;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreUpdater {

    private final AppCompatActivity context;

    public ScoreUpdater(AppCompatActivity context){
        this.context = context;
    }

    public void bindScore(TextView textView, int score){
        context.runOnUiThread(() -> textView.setText(score + ""));
    }
}
