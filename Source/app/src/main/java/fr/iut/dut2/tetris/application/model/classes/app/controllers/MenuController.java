package classes.app.controllers;

import classes.app.loaders.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Controleur de la fenetre Menu
 */
public class MenuController extends RootController {

    private final Loader loader;

    /**
     * Constructeur du controleur
     *
     * @param l Instance du loader
     */
    public MenuController(Loader l) {
        loader = l;
    }

    /**
     * Fonction active lorsque le bouton "Options" est appuyé, charge les options
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickMenuToOptions(@NotNull ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        loader.load(t, "Options", true);
    }

    /**
     * Fonction active lorsque le bouton "Leaderboard" est appuyé", charge le leaderboard
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickMenuToLeaderboard(@NotNull ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        loader.load(t, "LeaderBoard", true);
    }

    /**
     * Fonction active lorsque le bouton "Play" est appuyé, charge la grille
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickMenuToPlay(@NotNull ActionEvent actionEvent) {

        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        loader.load(t, "Grille", true);
    }
}
