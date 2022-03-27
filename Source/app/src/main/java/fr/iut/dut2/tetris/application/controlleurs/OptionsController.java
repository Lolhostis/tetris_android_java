package fr.iut.dut2.tetris.application.controlleurs;

import android.widget.TextView;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class OptionsController {

    private final Partie partie;

    public OptionsController(Partie p){
        partie = p;
    }

    public void ChangeDifficulte(int i, TextView textView){
        switch (i){
            case 0 : textView.setText(R.string.DiffFacile); break;
            case 1 : textView.setText(R.string.DiffNormale); break;
            case 2 : textView.setText(R.string.DiffDifficile); break;
            case 3 : textView.setText(R.string.DiffExtreme); break;
        }

        partie.getDifficulte().setDifficulte(i);
        partie.setNbLignes(25 - (i * 5));
    }
}
