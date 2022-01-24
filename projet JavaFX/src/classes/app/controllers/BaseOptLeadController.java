package classes.app.controllers;

import classes.app.loaders.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Controleur de la template Options/Leaderboard
 */
public class BaseOptLeadController extends Base_Mother {

    private final Loader loader;

    public BaseOptLeadController(Loader l) {
        loader = l;
    }

    public void ClickOptionsToMenu(@NotNull ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        loader.load(t, "Menu", true);
    }
}
