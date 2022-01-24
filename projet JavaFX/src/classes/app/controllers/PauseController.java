package classes.app.controllers;

import classes.app.loaders.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Controleur de la fenetre Pause
 */
public class PauseController extends RootController {

    private final Loader loader;

    /**
     * Constructeur du controleur
     *
     * @param l Instance du loader
     */
    public PauseController(Loader l) {
        loader = l;
    }

    /**
     * Fonction active lorsque que le bouton "Retour au menu" est appuyé, charge la fenetre de confirmation
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickPauseToConfirmation(ActionEvent actionEvent) {
        loader.loadwithStage("Confirmation", false);
    }

    /**
     * Fonction active lorsque le bouton "Continuer" est appuyé, ferme la fenetre de pause
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickPauseToGrille(@NotNull ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        partie.getGrille().paused = false;
        t.close();
    }
}
