package classes.app.controllers;

import classes.app.loaders.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;


/**
 * Controleur de la fenetre des controles
 */
public class ControlsController extends RootController {

    private final Loader loader;
    public String InputDepGauche;
    public String InputDepDroite;
    public String InputRotGauche;
    public String InputRotDroite;
    public String InputAcc;
    boolean changedepdroite = false;
    boolean changedepgauche = false;
    boolean changerotdroite = false;
    boolean changerotgauche = false;
    boolean changeacc = false;

    /**
     * Constructeur du controleur
     *
     * @param l Instance du loader
     */
    public ControlsController(Loader l) {
        loader = l;
    }

    /**
     * Enclenche le processus pour changer la touche de déplacement gauche
     *
     * @param actionEvent    Evènement lancé par la fenetre
     * @param Inputdepgauche Bouton concerné par le changement de texte
     */
    public void ClickControlsInputDepGauche(ActionEvent actionEvent, @NotNull Button Inputdepgauche) {

        resetAll();
        Inputdepgauche.setText("Press key");
        changedepgauche = true;
    }

    /**
     * Enclenche le processus pour changer la touche de déplacement droit
     *
     * @param actionEvent    Evènement lancé par la fenetre
     * @param Inputdepdroite Bouton concerné par le changement de texte
     */
    public void ClickControlsInputDepDroite(ActionEvent actionEvent, @NotNull Button Inputdepdroite) {


        resetAll();
        Inputdepdroite.setText("Press key");
        changedepdroite = true;
    }


    /**
     * Enclenche le processus pour changer la touche de rotation droite
     *
     * @param actionEvent    Evènement lancé par la fenetre
     * @param Inputrotdroite Bouton concerné par le changement de texte
     */
    public void ClickControlsInputRotDroite(ActionEvent actionEvent, @NotNull Button Inputrotdroite) {


        resetAll();
        Inputrotdroite.setText("Press key");
        changerotdroite = true;
    }

    /**
     * Enclenche le processus pour changer la touche de rotation gauche
     *
     * @param actionEvent    Evènement lancé par la fenetre
     * @param Inputrotgauche Bouton concerné par le changement de texte
     */
    public void ClickControlsInputRotGauche(ActionEvent actionEvent, @NotNull Button Inputrotgauche) {

        resetAll();
        Inputrotgauche.setText("Press key");
        changerotgauche = true;
    }

    /**
     * Enclenche le processus pour changer la touche d'accélération
     *
     * @param actionEvent Evènement lancé par la fenetre
     * @param Inputacc    Bouton concerné par le changement de texte
     */
    public void ClickControlsInputAcceleration(ActionEvent actionEvent, @NotNull Button Inputacc) {

        resetAll();
        Inputacc.setText("Press key");
        changeacc = true;
    }

    /**
     * Méthode utilisé lorsque le bouton "Annuler" est utilisé
     *
     * @param actionEvent Evènement lancé par la fenetre
     */
    public void ClickAnnulation(@NotNull ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        t.setTitle("Options");
        partie.getControles().initialiser();
        loader.load(t, "Options", true);
    }

    /**
     * Méthode utilisé lorsque le bouton "Réinitialiser les touches" est utilisé
     *
     * @param actionEvent Evènement lancé par la fenetre
     */
    public void ClickReinitialisation(@NotNull ActionEvent actionEvent) {
        partie.getControles().reinitialiser();
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();
        loader.load(t, "Controls", true);
    }

    /**
     * Méthode utilisé lorsque le bouton "Valider" est utilisé
     *
     * @param actionEvent Evènement lancé par la fenetre
     */
    public void ClickValidation(@NotNull ActionEvent actionEvent) {

        partie.getControles().valider();
        Button b = (Button) actionEvent.getSource();
        Stage t = (Stage) b.getScene().getWindow();

        loader.load(t, "Options", true);
    }

    /**
     * Remet tous les changements en cours à 0
     */
    private void resetAll() {
        changedepdroite = false;
        changedepgauche = false;
        changerotdroite = false;
        changerotgauche = false;
        changeacc = false;
    }

    /**
     * Assigne le controle et le texte envoyé par la fenetre
     *
     * @param event          Evènement lancé par la fenêtre
     * @param Inputdepdroite Bouton de déplacement droit
     * @param Inputdepgauche Bouton de déplacement gauche
     * @param Inputrotdroite Bouton de rotation droite
     * @param Inputrotgauche Bouton de rotation gauche
     * @param Inputacc       Bouton d'accélération
     */
    public void ControlChange(KeyEvent event, Button Inputdepdroite, Button Inputdepgauche, Button Inputrotdroite, Button Inputrotgauche, Button Inputacc) {
        if (changedepdroite) {
            Inputdepdroite.setText(event.getCode().getName());
            partie.getControles().setDepdroite(event.getCode().getName());
            changedepdroite = false;
        } else if (changedepgauche) {
            Inputdepgauche.setText(event.getCode().getName());
            partie.getControles().setDepgauche(event.getCode().getName());
            changedepgauche = false;

        } else if (changerotdroite) {
            Inputrotdroite.setText(event.getCode().getName());
            partie.getControles().setRotdroite(event.getCode().getName());
            changerotdroite = false;
        } else if (changerotgauche) {
            partie.getControles().setRotgauche(event.getCode().getName());
            Inputrotgauche.setText(event.getCode().getName());
            changerotgauche = false;
        } else if (changeacc) {
            Inputacc.setText(event.getCode().getName());
            partie.getControles().setAcceleration(event.getCode().getName());
            changeacc = false;
        }
    }
}
