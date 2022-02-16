package classes.app.loaders;

import classes.app.controllers.GrilleController;
import classes.app.dessinateurs.Dessinateur;
import classes.app.observateurs.ObservateurAbstrait;
import classes.content.Partie;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Grille
 */
public class L_Grille extends AnchorPane {

    private final ObservateurAbstrait observateur;
    private final Dessinateur dessinateur;
    public GrilleController controller;
    private Thread play;
    @FXML
    private Canvas canvas;
    @FXML
    private Label Score;
    @FXML
    private Label bestScore;

    /**
     * Contructeur de la fenêtre Grille
     *
     * @param controller  Controleur qui gérera les évènements de la fenetre
     * @param p           Instance de la partie
     * @param observateur Observateur observant la grille de la partie
     * @param dessinateur Dessinateur dessinant la grille
     * @param play        Thread sur lequel tournera la partie
     */
    public L_Grille(GrilleController controller, Partie p, ObservateurAbstrait observateur, Dessinateur dessinateur, Thread play) {
        this.observateur = observateur;
        this.dessinateur = dessinateur;
        this.observateur.setLooker(this);
        this.observateur.setSujet(p);

        if (this.play == null) {
            this.play = play;
        }

        try {
            URL fxmlURL = Loader.class.getResource("/views/Grille.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/Grille.css")).toExternalForm();
            this.getStylesheets().add(css);

            this.controller = controller;
            this.controller.setPartie(p);

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);

            //Chaque fenêtre à un "fx:root" qui sera remplacé par l'instance crée
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
                canvas.setFocusTraversable(true);
                this.dessinateur.setCanvas(canvas);
                chargerGrille();
                controller.getPartie().getGrille().running = true;
                this.play.start();
            } catch (IOException e) {
                System.out.println("Chargement de la grille : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode active lors de l'activation d'une touche sur la fenêtre
     *
     * @param event Evènement généré par la fenetre
     */
    public void KeyPressed(KeyEvent event) {
        controller.KeyPressed(event);
    }

    /**
     * Méthode qui dessine la grille sur le thread javafx
     */
    public void dessinerGrille() {

        //Platform.runLater fait pour que le dessin ne se fasse pas lors du thread de la partie
        Platform.runLater(() -> {
            dessinateur.dessinerGrille(controller.getPartie(), Score);
            if (controller.getPartie().getLeaderboard().getScores().size() > 0) {
                if (controller.getPartie().getPoints() >= controller.getPartie().getLeaderboard().getScores().get(0)) {
                    Score.setText("Nouveau meilleur score !\nScore : \n" + controller.getPartie().getPoints());
                }
            } else {
                if (controller.getPartie().getPoints() >= 0) {
                    Score.setText("Nouveau meilleur score !\nScore : \n" + controller.getPartie().getPoints());
                }
            }

        });

    }

    /**
     * Méthode qui permet de charger la grille lors de la première apparition
     */
    public void chargerGrille() {
        dessinateur.chargerGrille(controller.getPartie());
        if (controller.getPartie().getLeaderboard().getScores().size() == 0) {
            bestScore.setText("Meilleur score : \n" + 0);
        } else {
            bestScore.setText("Meilleur score : \n" + controller.getPartie().getLeaderboard().getScores().get(0));
        }
    }

    /**
     * Méthode qui s'active lorsque le joueur perd
     */
    public void GameOver() {
        controller.gameOver();
    }
}
