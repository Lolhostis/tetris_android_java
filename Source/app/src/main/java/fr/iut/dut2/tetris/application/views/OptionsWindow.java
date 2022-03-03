package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.OptLeadController;
import fr.iut.dut2.tetris.application.controlleurs.OptionsController;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;


public class OptionsWindow extends AppCompatActivity {

    private OptLeadController controllerTemplate;
    private OptionsController controller;
    private Partie p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_window);
        p = getIntent().getParcelableExtra("Partie");
        controllerTemplate = new OptLeadController(this, p);
        controller = new OptionsController(p);
        SeekBar bar = findViewById(R.id.seekBar2);
        bar.setKeyProgressIncrement(1);
        bar.setMax(3);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                controller.ChangeDifficulte(i,findViewById(R.id.TexteDifficulte));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        TextView textView = findViewById(R.id.TexteDifficulte);
        switch (p.getDifficulte().getDifficulte()){
            case 0 : textView.setText(R.string.DiffFacile); break;
            case 1 : textView.setText(R.string.DiffNormale); break;
            case 2 : textView.setText(R.string.DiffDifficile); break;
            case 3 : textView.setText(R.string.DiffExtreme); break;
        }
    }

    public void OptionsToMenu(View view) {
        controllerTemplate.RetourAuMenu(view);
    }
}
