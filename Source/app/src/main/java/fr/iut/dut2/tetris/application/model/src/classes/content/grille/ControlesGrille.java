package fr.iut.dut2.tetris.application.model.src.classes.content.grille;


import android.util.Log;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

/**
 * Classe ayant la responsabilité des contrôles concernant la grille.
 */
public class ControlesGrille{

    private int nombreDeColonne;
    private int nombreDeLigne;

    public int getNombreDeColonne() {
        return nombreDeColonne;
    }

    public void setNombreDeColonne(int nombreDeColonne) {
        this.nombreDeColonne = nombreDeColonne;
    }

    public int getNombreDeLigne() {
        return nombreDeLigne;
    }

    public void setNombreDeLigne(int nombreDeLigne) {
        this.nombreDeLigne = nombreDeLigne;
    }

    public ControlesGrille(int nombreDeColonne, int nombreDeLigne){
        this.nombreDeColonne = nombreDeColonne;
        this.nombreDeLigne = nombreDeLigne;
    }

    /**
     * Méthode retournant un booléen, true si l'emplacement sur la grille est vide, false sinon.
     *
     * @param x      position dans les x du point sur la grille
     * @param y      position dans les y du point sur la grille
     * @param grille grille de jeu
     * @return retourne un booléen disant si l'emplacement est vide ou non
     */
    public boolean isBusy(int x, int y, int[][] grille) {
        if (x < 1 || x > nombreDeColonne - 1 || y < 0 || y > nombreDeLigne - 1) {
            return true;
        }
        return grille[y][x] == 0;
    }

    /**
     * Méthode permettant de mettre à jour la grille en mémoire.
     *
     * @param grille grille de jeu
     */
    protected void update(int[][] grille) {
        for (int i = 0; i < nombreDeLigne; i++) {
            for (int j = 0; j < nombreDeColonne; j++) {
                if (i == nombreDeLigne - 1 || j == 0 || j == nombreDeColonne - 1)
                    System.out.print(" / ");
                else if (grille[i][j] != -1)
                    System.out.print(" " + grille[i][j] + " ");
                else
                    System.out.print("   ");

            }
            System.out.println();
        }
    }

    /**
     * Méthode permettant de nettoyer un point à des coordonnées précises.
     *
     * @param x      position dans les x du point sur la grille
     * @param y      position dans les y du point sur la grille
     * @param grille grille de jeu
     */
    public void clear(int x, int y, int[][] grille) {
        Log.d("Position",y + " | " + x);

        if (x >= 0 || x < nombreDeColonne - 1 || y >= 0 || y < nombreDeLigne)
            grille[y][x] = -1;
    }

    /**
     * Méthode permettant de nettoyer une ligne complète.
     *
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     */
    protected void clearFullLine(int[][] grille, Partie partie) {
        for (int i = 0; i < nombreDeLigne; i++) {
            int tmp = 0;
            for (int j = 0; j < nombreDeColonne; j++) {
                tmp += grille[i][j];
            }
            if (tmp == -2) {
                partie.setPoints(partie.getPoints() + (nombreDeColonne - 2) * 5);
                descendreLignes(i, grille);
            }
        }
    }

    /**
     * Méthode permettant de descendre une ligne dans la grille.
     *
     * @param ligne  numéro de la ligne à descendre
     * @param grille grille de jeu
     */
    protected void descendreLignes(int ligne, int[][] grille) {
        while (ligne > 0) {
            if (nombreDeColonne >= 0) System.arraycopy(grille[ligne - 1], 0, grille[ligne], 0, nombreDeColonne);
            ligne--;
        }
        for (int j = 0; j < nombreDeColonne; j++) {
            grille[0][j] = -1;
        }
    }

    /**
     * Méthode permettant de nettoyer l'entièreté de la grille.
     *
     * @param grille grille de jeu
     */
    public void clearGrille(int[][] grille) {
        for (int x = 1; x < nombreDeColonne - 1; x++) {
            for (int y = 0; y < nombreDeLigne; y++) {
                grille[y][x] = -1;
            }
        }
    }
}
