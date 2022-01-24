package classes.app.controllers;

import classes.app.loaders.Loader;
import classes.content.Partie;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Controleur de la fenetre Options
 */
public class OptionsController extends RootController {

    private final Loader loader;
    private Partie partie;

    /**
     * Constructeur de controleur
     *
     * @param p Instance de la partie
     * @param l Instance du loader
     */
    public OptionsController(Partie p, Loader l) {
        partie = p;
        loader = l;
    }

    /**
     * Setter de la partie
     *
     * @param partie Instance d'une partie
     */
    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    /**
     * Fonction active lorsque le bouton "Controles" est appuyé, charge les controles
     *
     * @param actionEvent Evènement généré par la fenêtre
     */
    public void ClickOptionsToControls(@NotNull ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();
        loader.load(t, "Controls", false);
    }

    /**
     * Initialisation de la fenêtre, selon la difficulté, l'affichage lors de l'ouverture est géré par cette fonction
     *
     * @param canvas     Canvas où sera dessiné la grille d'aperçu
     * @param slider     Slider de difficulté
     * @param difficulte Label où se trouvera la difficulté
     */
    public void initialisation(Canvas canvas, Slider slider, Label difficulte) {
        if (partie.getDifficulte().getDifficulte() == 0) {
            slider.setValue(0);
            difficulte.setText("Facile");

            changeCanvasAndGrid(0, canvas);
        } else if (partie.getDifficulte().getDifficulte() == 1) {
            slider.setValue(1);
            difficulte.setText("Normal");

            changeCanvasAndGrid(1, canvas);
        } else if (partie.getDifficulte().getDifficulte() == 2) {
            slider.setValue(2);
            difficulte.setText("Difficile");

            changeCanvasAndGrid(2, canvas);
        } else {
            slider.setValue(3);
            difficulte.setText("Extrême");

            changeCanvasAndGrid(3, canvas);
        }
    }

    private void changeCanvasAndGrid(int difficulte, @NotNull Canvas canvas) {
        canvas.setWidth(200);
        partie.setNbLignes(25 - difficulte * 5);
        canvas.setHeight(partie.getNbLignes() * 20);

        partie.getDifficulte().setDifficulte(difficulte);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Color.WHITE);

        for (int i = 20; i < canvas.getWidth(); i += 20) {
            gc.fillRect(i, 0, 0.1, canvas.getHeight());
        }
        for (int j = 20; j < canvas.getHeight(); j += 20) {
            gc.fillRect(0, j, canvas.getWidth(), 0.1);
        }
    }

    public void ClickSliderDifficulty(@NotNull Slider slider, Label difficulte, Canvas canvas) {
        if (slider.getValue() < 1) {
            slider.setValue(0);
            difficulte.setText("Facile");

            changeCanvasAndGrid(0, canvas);
        } else if (slider.getValue() < 2) {
            slider.setValue(1);
            difficulte.setText("Normal");

            changeCanvasAndGrid(1, canvas);
        } else if (slider.getValue() < 3) {
            slider.setValue(2);
            difficulte.setText("Difficile");

            changeCanvasAndGrid(2, canvas);
        } else {
            slider.setValue(3);
            difficulte.setText("Extrême");

            changeCanvasAndGrid(3, canvas);
        }
    }
}
