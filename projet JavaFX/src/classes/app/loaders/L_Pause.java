package classes.app.loaders;

import classes.app.controllers.PauseController;
import classes.content.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Pause
 */

public class L_Pause extends AnchorPane {

    public PauseController controller;
    private Thread play;

    /**
     * Constructeur de la fenetre
     *
     * @param controller Controleur de la fenetre
     * @param p          Instance de la partie
     * @param play       Instance du thread de la partie
     */
    public L_Pause(PauseController controller, Partie p, Thread play) {
        try {
            URL fxmlURL = Loader.class.getResource("/views/Pause.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/Pause.css")).toExternalForm();
            this.getStylesheets().add(css);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);

            this.controller = controller;
            this.play = play;

            //Chaque fenêtre à un "fx:root" qui sera remplacé par l'instance crée
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            controller.setPartie(p);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
            } catch (IOException e) {
                System.out.println("Chargement de la pause : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode active lorsque le bouton "Retour au menu" est appuyé, permet de charger la page de confirmation
     *
     * @param actionEvent L'évènement envoyé par la fenetre
     */
    public void ClickPauseToConfirmation(ActionEvent actionEvent) {
        controller.ClickPauseToConfirmation(actionEvent);
    }

    /**
     * Méthode active lorsque le bouton "Continuer" est appuyé, permet de revenir sur la page de la grille
     *
     * @param actionEvent L'évènement envoyé par la fenetre
     */
    public void ClickPauseToGrille(ActionEvent actionEvent) {
        controller.ClickPauseToGrille(actionEvent);
    }

}
