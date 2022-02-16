package classes.app.loaders;

import classes.app.controllers.ControlsController;
import classes.content.Partie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import classes.parametres.Controles;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Classe représentant la fênetre et le controlleur de la fenetre Controles
 */
public class L_Controls extends VBox {

    public ControlsController controller;


    /**
     * Les champs représentant chaque bouton (sauf annulation, réinitialisation et validation) de la fenetre Controles
     */
    @FXML
    private Button Inputdepdroite;

    @FXML
    private Button Inputdepgauche;

    @FXML
    private Button Inputrotdroite;

    @FXML
    private Button Inputrotgauche;

    @FXML
    private Button Inputacc;

    /**
     * Constructeur de la fenêtre des Controles
     *
     * @param controller Controleur gérant les évènements reçus par la fenêtre (this)
     * @param p          Une instance de la partie
     */
    public L_Controls(ControlsController controller, Partie p) {
        try {

            //Chargement de la fenetre
            URL fxmlURL = Loader.class.getResource("/views/Controls.fxml");
            String css = Objects.requireNonNull(Loader.class.getResource("/css/Controls.css")).toExternalForm();
            this.getStylesheets().add(css);
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);

            //Assignement des variables
            this.controller = controller;
            this.controller.setPartie(p);


            //Remplacement de la source de la fenêtre (Son contenu)
            fxmlLoader.setRoot(this);

            //Remplacement du controller de la fenêtre pour que les évènements soient envoyés sur cette instance
            fxmlLoader.setController(this);

            try {
                //Ceci représente la fenêtre chargée
                fxmlLoader.load();
                initalisation();
            } catch (IOException e) {
                System.out.println("Chargement des controles : ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initalisation() {
        controller.getPartie().getControles().initialiser();
        Inputdepgauche.setText(controller.getPartie().getControles().getDepgauche());
        Inputdepdroite.setText(controller.getPartie().getControles().getDepdroite());
        Inputrotgauche.setText(controller.getPartie().getControles().getRotgauche());
        Inputrotdroite.setText(controller.getPartie().getControles().getRotdroite());
        Inputacc.setText(controller.getPartie().getControles().getAcceleration());
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Décaler à gauche", lance le processus de changement de touche de l'input de déplacement gauche
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickControlsInputDepGauche(ActionEvent actionEvent) {
        controller.ClickControlsInputDepGauche(actionEvent, Inputdepgauche);
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Décaler à droite", lance le processus de changement de touche de l'input de déplacement droit
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickControlsInputDepDroite(ActionEvent actionEvent) {
        controller.ClickControlsInputDepDroite(actionEvent, Inputdepdroite);
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Tourner à droite", lance le processus de changement de touche de l'input de rotation Droite
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickControlsInputRotDroite(ActionEvent actionEvent) {
        controller.ClickControlsInputRotDroite(actionEvent, Inputrotdroite);
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Tourner à gauche" lance le processus de changement de touche de l'input de rotation gauche
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickControlsInputRotGauche(ActionEvent actionEvent) {
        controller.ClickControlsInputRotGauche(actionEvent, Inputrotgauche);
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Accélerer", lance le processus de changement de touche de l'input d'accélération
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickControlsInputAcceleration(ActionEvent actionEvent) {
        controller.ClickControlsInputAcceleration(actionEvent, Inputacc);
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Annuler", permet d'annuler tout changement fait lors de la fenêtre courante
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickAnnulation(ActionEvent actionEvent) {
        controller.ClickAnnulation(actionEvent);
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Réinitialiser les touches", permet de remettre les touches par défaut
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickReinitialisation(ActionEvent actionEvent) {
        controller.ClickReinitialisation(actionEvent);
    }

    /**
     * Méthode active lorsque l'utilisateur appuie sur le bouton "Valider", permet de confirmer et de sauvegarder les touches entrées
     *
     * @param actionEvent L'évènement envoyé par la fenêtre
     */
    public void ClickValidation(ActionEvent actionEvent) {
        controller.ClickValidation(actionEvent);
    }

    /**
     * Méthode active lorsque qu'une touche est pressé, permet de changer de controles
     *
     * @param event L'évènement envoyé par la fenêtre
     */
    public void ControlChange(KeyEvent event) {
        controller.ControlChange(event, Inputdepdroite, Inputdepgauche, Inputrotdroite, Inputrotgauche, Inputacc);
    }
}
