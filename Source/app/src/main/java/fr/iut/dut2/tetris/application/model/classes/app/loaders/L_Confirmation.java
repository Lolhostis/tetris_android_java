package classes.app.loaders;

import classes.app.controllers.ConfirmationController;
import classes.content.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Confirmation
 */
public class L_Confirmation extends AnchorPane {

    private ConfirmationController controller;
    private Thread play;

    /**
     * Constructeur de la fenetre
     *
     * @param controller Controleur de la fenetre
     * @param p          Instance de la partie
     * @param play       Instance du thread de la partie
     */
    public L_Confirmation(ConfirmationController controller, Partie p, Thread play) {
        try {
            URL fxmlURL = Loader.class.getResource("/views/Confirmation.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/Confirmation.css")).toExternalForm();
            this.getStylesheets().add(css);
            this.play = play;

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            controller.setPartie(p);
            this.controller = controller;
            //Chaque fenêtre à un "fx:root" qui sera remplacé par l'instance crée
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
            } catch (IOException e) {
                System.out.println("Chargement de la confirmation : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Se déclenche lorsque le bouton "Oui" est activé, permet de retourner au Menu
     *
     * @param actionEvent Action du bouton
     */
    public void ClickConfirmationToMenu(ActionEvent actionEvent) {
        controller.ClickConfirmationToMenu(actionEvent, play);
    }

    /**
     * Se déclenche lorsque le bouton "Non" est activé, permet de revenir à la fenêtre de pause
     *
     * @param actionEvent Action du bouton
     */
    public void ClickConfirmationToPause(ActionEvent actionEvent) {
        controller.ClickConfirmationToPause(actionEvent);
    }
}
