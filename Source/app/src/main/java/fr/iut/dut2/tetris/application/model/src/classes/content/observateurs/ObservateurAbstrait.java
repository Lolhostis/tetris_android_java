package fr.iut.dut2.tetris.application.model.src.classes.content.observateurs;

import fr.iut.dut2.tetris.application.model.designers.Grille;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.GrilleWindowActivity;

public abstract class ObservateurAbstrait {
    protected Partie sujet;
    protected Grille looker;

    public abstract void update();

    public void setLooker(Grille looker) {
        this.looker = looker;
    }

    public void setSujet(Partie sujet) {
        this.sujet = sujet;
    }
}
