package classes.app.observateurs;

import classes.app.loaders.L_Grille;
import classes.content.Partie;

public abstract class ObservateurAbstrait {
    protected Partie sujet;
    protected L_Grille looker;

    public abstract void update();

    public void setLooker(L_Grille looker) {
        this.looker = looker;
    }

    public void setSujet(Partie sujet) {
        this.sujet = sujet;
    }
}
