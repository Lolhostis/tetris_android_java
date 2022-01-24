package classes.app.loaders;

import classes.app.controllers.BaseOptLeadController;
import classes.app.controllers.OptionsController;
import classes.content.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Options
 */
public class L_Options extends AnchorPane {

    @FXML
    private Label difficulte;

    @FXML
    private Canvas canvas;

    @FXML
    private Slider slider;

    private OptionsController controller;
    private BaseOptLeadController controllerTemplate;

    /**
     * Constructeur de la fenetre
     *
     * @param controller         Controlleur de la fenetre
     * @param p                  Instance de la partie
     * @param controllerTemplate Controlleur du template
     */
    public L_Options(OptionsController controller, Partie p, BaseOptLeadController controllerTemplate) {

        try {
            URL fxmlURL = Loader.class.getResource("/views/Options.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/Options.css")).toExternalForm();
            this.getStylesheets().add(css);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);


            this.controller = controller;
            this.controller.setPartie(p);

            this.controllerTemplate = controllerTemplate;


            //Chaque fenêtre à un "fx:root" qui sera remplacé par l'instance crée
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
                initialisation();
            } catch (IOException e) {
                System.out.println("Chargement des options : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction d'initialisation de la fenetre, gère l'affichage lors du chargement
     */
    public void initialisation() {
        controller.initialisation(canvas, slider, difficulte);
    }

    /**
     * Méthode active lorsque le bouton "Controles" est appuyé, permet de charger la page des controles
     *
     * @param actionEvent L'évènement envoyé par la fenetre
     */
    public void ClickOptionsToControls(ActionEvent actionEvent) {
        controller.ClickOptionsToControls(actionEvent);
    }

    /**
     * Méthode active lorsque le bouton "Retour au menu" est appuyé, permet de charger la page du menu
     *
     * @param actionEvent L'évènement envoyé par la fenetre
     */
    public void ClickOptionsToMenu(ActionEvent actionEvent) {
        controllerTemplate.ClickOptionsToMenu(actionEvent);
    }

    /**
     * Méthode active dès un quelconque changement de la valeur du slider
     *
     * @param mouseEvent L'évènement envoyé par la fenetre
     */
    public void ClickSliderDifficulty(MouseEvent mouseEvent) {
        controller.ClickSliderDifficulty(slider, difficulte, canvas);
    }
}
