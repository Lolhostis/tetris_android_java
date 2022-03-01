package fr.iut.dut2.tetris.application.model.designers;

import android.view.View;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public abstract class AbstractDesigner {
    protected View view;

    public AbstractDesigner(View view) {
        this.view = view;
    }

  //  public abstract void dessinerGrille(Partie p, Label Score);

    public abstract void chargerGrille(Partie p);

    public View getView() {
        return view;
    }

    public void setCanvas(View view) {
        this.view = view;
    }
}
