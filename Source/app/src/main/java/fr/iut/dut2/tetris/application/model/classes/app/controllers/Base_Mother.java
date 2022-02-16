package classes.app.controllers;

import classes.content.Partie;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

/**
 * Classe mère des 3 controleurs de template
 */
public abstract class Base_Mother {

    protected Pane child;

    protected Partie partie;

    @FXML
    protected Pane basePane;

    /**
     * Setter de la partie
     *
     * @param partie Instance de partie
     */
    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    /**
     * Getter de la fenetre à l'intérieur du template
     *
     * @return La fenetre à l'intérieur du template
     */
    public Pane getChild() {
        return child;
    }

    /**
     * Setter de la fenetre à l'intérieur du template
     *
     * @param p La fenetre à mettre
     */
    public void setChild(Pane p) {

        //On vérifie que la fenetre n'est pas vide
        if (child != null) {

            //Si la fenetre chargée est la fenetre donnée en argument, on ne fait rien
            if (child.equals(p)) {
                return;
            }
        }
        basePane.getChildren().remove(child);

        child = p;
        basePane.getChildren().add(child);
    }
}
