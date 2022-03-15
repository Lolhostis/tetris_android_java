package fr.iut.dut2.tetris.application.model.src.classes.content;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import fr.iut.dut2.tetris.application.model.src.classes.content.observateurs.ObservateurAbstrait;
import fr.iut.dut2.tetris.application.model.src.classes.content.observateurs.ObservateurGrille;
import fr.iut.dut2.tetris.application.model.src.classes.content.thread.Play;
import fr.iut.dut2.tetris.application.model.src.classes.parametres.Controles;
import fr.iut.dut2.tetris.application.model.src.classes.parametres.Difficulte;
import fr.iut.dut2.tetris.application.model.src.classes.parametres.Leaderboard;

/**
 * Classe représentant la partie, c'est la classe centrale de l'application.
 */
public class Partie implements Parcelable, Notifiyer {

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

    protected Partie(Parcel in) {
        nbColonnes = in.readInt();
        nbLignes = in.readInt();
        points = in.readInt();

        /*Log.d("ParcelPartie", "NbColonnes : " + nbColonnes);
        Log.d("ParcelPartie", "NbLignes : " + nbLignes);
        Log.d("ParcelPartie", "Points : " + points);*/

        grille = new Play(nbLignes, nbColonnes, this);
        leaderboard = new Leaderboard();

        int t = in.readInt();

        while(t != -1) {
            leaderboard.addScore(t);
            t = in.readInt();
        }
        String message = "Leaderboard : ";
        int cpt = 0;
        /*for(Integer i : leaderboard.getScores()){
            if(cpt == leaderboard.getScores().size() - 1 ){
                message += i;
            }
            else{
                message += i + " | ";
            }
            cpt++;
        }*/

        //Log.d("ParcelPartie", message);

        controles = new Controles();
        difficulte = new Difficulte();
        difficulte.setDifficulte(in.readInt());

        //Log.d("ParcelPartie", "Difficulté : " + difficulte.getDifficulte());
    }

    public static final Creator<Partie> CREATOR = new Creator<Partie>() {
        @Override
        public Partie createFromParcel(Parcel in) {
            return new Partie(in);
        }

        @Override
        public Partie[] newArray(int size) {
            return new Partie[size];
        }
    };

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(nbColonnes);
        parcel.writeInt(nbLignes);
        parcel.writeInt(points);

        leaderboard.addScore(800);
        leaderboard.addScore(500);
        leaderboard.addScore(1500);

        int cpt = 0;
        while(cpt < leaderboard.getScores().size()){
            parcel.writeInt(leaderboard.getScores().get(cpt));
            cpt++;
        }
        parcel.writeInt(-1);

        parcel.writeInt(difficulte.getDifficulte());
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

    /*public void GameOver() {
        for (ObservateurAbstrait obs : observateurs) {
            ((ObservateurGrille) obs).gameOver();
        }
    }*/
}