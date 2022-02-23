package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;


public class OptionsWindow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_window);
        Partie partie = getIntent().getParcelableExtra("Partie");
        SeekBar bar = findViewById(R.id.seekBar2);
        bar.setKeyProgressIncrement(1);
        bar.setMax(3);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                TextView textView = findViewById(R.id.TexteDifficulte);
                switch (i){
                    case 0 : textView.setText(R.string.DiffFacile); break;
                    case 1 : textView.setText(R.string.DiffNormale); break;
                    case 2 : textView.setText(R.string.DiffDifficile); break;
                    case 3 : textView.setText(R.string.DiffExtreme); break;
                }

                partie.getDifficulte().setDifficulte(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        TextView textView = findViewById(R.id.TexteDifficulte);
        switch (partie.getDifficulte().getDifficulte()){
            case 0 : textView.setText(R.string.DiffFacile); break;
            case 1 : textView.setText(R.string.DiffNormale); break;
            case 2 : textView.setText(R.string.DiffDifficile); break;
            case 3 : textView.setText(R.string.DiffExtreme); break;
        }
    }

    public void OptionsToMenu(View view) {
        finish();
    }
}
