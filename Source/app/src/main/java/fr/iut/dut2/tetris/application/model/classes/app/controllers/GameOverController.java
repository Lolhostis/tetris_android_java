package classes.app.controllers;

import classes.app.loaders.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Controleur de la fenetre GameOver
 */
public class GameOverController extends RootController {

    private final Loader loader;

    /**
     * Constructeur du controleur
     *
     * @param l Instance du loader
     */
    public GameOverController(Loader l) {
        loader = l;
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Oui" de la fenetre de GameOver, permet de rejouer (Sauvegarde le score)
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickConfirmationToGrille(@NotNull ActionEvent actionEvent) {
        partie.getGrille().clearGrille();
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        t.close();
        Stage grille = loader.getStage("Menu");
        loader.load(grille, "Grille", true);

    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur "Non" sur la fenêtre de GameOver, permet de revenir au menu (Sauvegarde le score)
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickConfirmationToMenu(@NotNull ActionEvent actionEvent) {
        partie.getGrille().clearGrille();
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        t.close();
        Stage menu = loader.getStage("Menu");
        loader.load(menu, "Menu", true);
    }
}
