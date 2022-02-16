package classes.content;

import classes.app.Notifiyer;
import classes.app.observateurs.ObservateurAbstrait;
import classes.app.observateurs.ObservateurGrille;
import classes.content.thread.Play;
import classes.parametres.Controles;
import classes.parametres.Difficulte;
import classes.parametres.Leaderboard;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe représentant la partie, c'est la classe centrale de l'application.
 */
public class Partie implements Notifiyer {

    private final int nbColonnes;
    private final Leaderboard leaderboard;
    private final List<ObservateurAbstrait> observateurs = new LinkedList<>();
    private Controles controles;
    private int nbLignes;
    private int points;
    private Play grille;
    private Difficulte difficulte;

    /**
     * Constructeur d'une partie.
     *
     * @param nbLignes   nombre de lignes
     * @param nbColonnes nombre de colonnes.
     */
    public Partie(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        grille = new Play(nbLignes, nbColonnes, this);
        leaderboard = new Leaderboard();
        controles = new Controles();
        difficulte = new Difficulte();
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    public Controles getControles() {
        return controles;
    }

    public void setControles(Controles controles) {
        this.controles = controles;
    }

    /**
     * Getter du nombre de lignes.
     *
     * @return nombre de lignes
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Setter du nombre de lignes.
     *
     * @param nbLignes nombre de lignes
     */
    public void setNbLignes(int nbLignes) {
        this.nbLignes = nbLignes;
    }

    /**
     * Getter des points.
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Setter des points.
     *
     * @param points points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Getter de la grille.
     *
     * @return grille
     */
    public Play getGrille() {
        return grille;
    }

    /**
     * Setter de la grille.
     *
     * @param grille grille
     */
    public void setGrille(Play grille) {
        this.grille = grille;
    }

    /**
     * Getter du nombre de colonnes.
     *
     * @return nombre de colonnes
     */
    public int getNbColonnes() {
        return nbColonnes;
    }

    /**
     * Getter du loader.
     *
     * @return loader
     */
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    @Override
    public void notifier() {
        for (ObservateurAbstrait obs : observateurs) {
            obs.update();
        }
    }

    public void attach(ObservateurAbstrait observateur) {
        observateurs.add(observateur);
    }


    public void detach(ObservateurAbstrait observateur) {
        observateurs.remove(observateur);
    }

    public void GameOver() {
        for (ObservateurAbstrait obs : observateurs) {
            ((ObservateurGrille) obs).gameOver();
        }
    }
}