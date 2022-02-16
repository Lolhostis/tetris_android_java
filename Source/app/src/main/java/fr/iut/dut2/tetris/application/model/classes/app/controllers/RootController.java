package classes.app.controllers;

import classes.content.Partie;

/**
 * Classe mère des controleurs des fenêtres non-templates
 */
public abstract class RootController {
    protected Partie partie;

    /**
     * Getter de la partie
     *
     * @return L'attribut partie
     */
    public Partie getPartie() {
        return partie;
    }

    /**
     * Setter de la partie
     *
     * @param partie Une instance de partie
     */
    public void setPartie(Partie partie) {
        this.partie = partie;
    }
}
