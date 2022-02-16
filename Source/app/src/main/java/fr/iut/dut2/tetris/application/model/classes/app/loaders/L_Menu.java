package classes.app.loaders;

import classes.app.controllers.MenuController;
import classes.content.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Menu
 */
public class L_Menu extends AnchorPane {

    private MenuController controller;

    /**
     * Constructeur de la fenetre du Menu
     *
     * @param controller Controleur qui gérera les évènements renvoyés par la fenêtre
     * @param p          Instance de la partie
     */
    public L_Menu(MenuController controller, Partie p) {
        try {
            URL fxmlURL = Loader.class.getResource("/views/Menu.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/Menu.css")).toExternalForm();
            this.getStylesheets().add(css);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);

            this.controller = controller;
            this.controller.setPartie(p);


            //Chaque fenêtre à un "fx:root" qui sera remplacé par l'instance crée
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
            } catch (IOException e) {
                System.out.println("Chargement du menu : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode active lorsque le bouton "Options" est appuyé, permet de charger la page des options
     *
     * @param actionEvent L'évènement envoyé par la fenetre
     */
    public void ClickMenuToOptions(ActionEvent actionEvent) {
        controller.ClickMenuToOptions(actionEvent);
    }

    /**
     * Méthode active lorsque le bouton "Leaderboard" est appuyé, permet de charger la page du leaderboard
     *
     * @param actionEvent L'évènement envoyé par la fenetre
     */
    public void ClickMenuToLeaderboard(ActionEvent actionEvent) {
        controller.ClickMenuToLeaderboard(actionEvent);
    }

    /**
     * Méthode active lorsque le bouton "Play" est appuyé, permet de charger la page de la grille
     *
     * @param actionEvent L'évènement envoyé par la fenetre
     */
    public void ClickMenuToPlay(ActionEvent actionEvent) {
        controller.ClickMenuToPlay(actionEvent);
    }
}
