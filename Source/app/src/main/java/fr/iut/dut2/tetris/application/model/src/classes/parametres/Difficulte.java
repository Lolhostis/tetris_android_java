package fr.iut.dut2.tetris.application.model.src.classes.parametres;

import java.io.Serializable;

public class Difficulte implements Serializable {
    private int difficulte = 0;

    public Difficulte() {

    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}
