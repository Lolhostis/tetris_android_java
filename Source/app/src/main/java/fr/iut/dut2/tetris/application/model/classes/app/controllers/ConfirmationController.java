package classes.app.controllers;

import classes.app.loaders.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;


/**
 * Controleur de la fenetre de confirmation
 */
public class ConfirmationController extends RootController {

    private final Loader loader;

    /**
     * Constructeur du controleur
     *
     * @param l Instance du loader
     */
    public ConfirmationController(Loader l) {
        loader = l;
    }

    /**
     * Se déclenche lorsque le bouton "Oui" est activé
     *
     * @param actionEvent Action du bouton
     */
    public void ClickConfirmationToMenu(@NotNull ActionEvent actionEvent, @NotNull Thread play) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        Stage base = loader.getStage("Menu");

        Stage pause = loader.getStage("Pause");

        pause.close();
        t.close();

        base.setTitle("Menu");
        loader.load(base, "Menu", true);
        partie.getGrille().paused = false;
        play.interrupt();
        partie.getGrille().running = false;
        partie.getGrille().clearGrille();
    }

    /**
     * Se déclenche lorsque le bouton "Non" est activé
     *
     * @param actionEvent Action du bouton
     */
    public void ClickConfirmationToPause(@NotNull ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        t.close();
    }
}
