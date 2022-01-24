package classes.app.loaders;

import classes.app.controllers.GameOverController;
import classes.content.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Game Over
 */
public class L_GameOver extends AnchorPane {

    public GameOverController controller;
    private Partie partie;

    /**
     * Constructeur de la fênetre
     *
     * @param controller Le controlleur qui gérera les evènements javafx
     * @param p          L'instance de la partie en cours
     */
    public L_GameOver(GameOverController controller, Partie p) {
        try {
            URL fxmlURL = Loader.class.getResource("/views/GameOver.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/GameOver.css")).toExternalForm();
            this.getStylesheets().add(css);

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);

            controller.setPartie(p);
            this.controller = controller;
            partie = p;

            //Chaque fenêtre à un "fx:root" qui sera remplacé par l'instance crée
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
            } catch (IOException e) {
                System.out.println("Chargement de la grille : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Oui" de la fenetre, permet de revenir à la grille
     *
     * @param actionEvent L'évènement envoyé par la fênetre
     */
    public void ClickConfirmationToGrille(ActionEvent actionEvent) {
        controller.getPartie().getLeaderboard().addScore(controller.getPartie().getPoints());
        controller.getPartie().getLeaderboard().sauvegarder();
        controller.ClickConfirmationToGrille(actionEvent);

    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Non" de la fenetre, permet de revenir au menu principal
     *
     * @param actionEvent L'évènement envoyé par la fênetre
     */
    public void ClickConfirmationToMenu(ActionEvent actionEvent) {
        controller.ClickConfirmationToMenu(actionEvent);
        controller.getPartie().getLeaderboard().addScore(controller.getPartie().getPoints());
        controller.getPartie().getLeaderboard().sauvegarder();
    }

}
