package classes.app.loaders;

import classes.app.controllers.BaseOptLeadController;
import classes.app.controllers.LeaderBoardController;
import classes.content.Partie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Leaderboard
 */

public class L_Leaderboard extends AnchorPane {

    private LeaderBoardController controller;
    private BaseOptLeadController controllerTemplate;

    @FXML
    private VBox tabScores;

    /**
     * @param controller         Controlleur qui gérera les évènements de la fenêtre
     * @param p                  Instance de la partie
     * @param controllerTemplate Controlleur qui gérera les évènements du template
     */
    public L_Leaderboard(LeaderBoardController controller, Partie p, BaseOptLeadController controllerTemplate) {

        try {
            URL fxmlURL = Loader.class.getResource("/views/LeaderBoard.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/LeaderBoard.css")).toExternalForm();
            this.getStylesheets().add(css);

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);

            controller.setPartie(p);
            this.controller = controller;
            this.controllerTemplate = controllerTemplate;


            //Chaque fenêtre à un "fx:root" qui sera remplacé par l'instance crée
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
                chargerScores();
            } catch (IOException e) {
                System.out.println("Chargement du leaderboard : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui affiche les 10 meilleurs scores
     */
    public void chargerScores() {
        int cpt = 1;
        for (Integer i : controller.getPartie().getLeaderboard().getScores()) {

            Label label = new Label();
            label.setText(cpt + " - " + i);
            tabScores.getChildren().add(label);
            cpt++;
        }
    }
}
