package classes.parametres;

import java.io.Serializable;

public class Difficulte implements Serializable {
    private int difficulte = 1;

    public Difficulte() {

    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}
