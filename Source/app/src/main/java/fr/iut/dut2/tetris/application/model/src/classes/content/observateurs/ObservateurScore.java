package fr.iut.dut2.tetris.application.model.src.classes.content.observateurs;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.GrilleWindowActivity;

public class ObservateurScore extends ObservateurAbstrait{
    protected GrilleWindowActivity looker;
    private int value;

    public ObservateurScore(GrilleWindowActivity looker, Partie value){
        sujet = value;
        this.looker = looker;
    }

    @Override
    public void update() {
        value = sujet.getPoints();
        looker.bindScore(value);
    }
}
