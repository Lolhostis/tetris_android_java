package fr.iut.dut2.tetris.application.model.src.classes.content.grille;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;

/**
 * Classe représentant une grille, elle hérite de GrilleBase.
 */
public class Grille extends GrilleBase {
    protected ControlesPiece ctrlPiece;
    protected ControlesGrille ctrlGrille;

    /**
     * Constructeur d'une Grille.
     *
     * @param nbLignes   nombre de lignes de la grille
     * @param nbColonnes nombre de colonnes de la grille
     * @param p          partie possédant les attributs nécessaires
     */
    public Grille(int nbLignes, int nbColonnes, Partie p) {
        super(nbLignes, nbColonnes, p);
        this.ctrlPiece = new ControlesPiece(nombreDeColonne, nombreDeLigne);
        this.ctrlGrille = new ControlesGrille(nombreDeColonne, nombreDeLigne);
    }

    /**
     * Méthode permettant de terminer une partie.
     */
    protected void gameOver() {
        partie.GameOver();
    }

    /**
     * Méthode permettant de créer une nouvelle pièce.
     */
    protected void addNewPiece() {
        ctrlPiece.addNewPiece(this);
    }

    @Override
    /**
     * Méthode permettant de déplacer une pièce dans la grille.
     *
     * @param mtype mouvement demandé
     */
    public void movePiece(MovePiece mtype) {
        ctrlPiece.movePiece(mtype, this);
        partie.notifier();
    }

    /**
     * Méthode permettant d'insérer une nouvelle pièce dans la grille.
     *
     * @param x position dans les x du point sur la grille
     * @param y position dans les y du point sur la grille
     */
    public void setPiece(int x, int y) {
        ctrlPiece.setPiece(x, y, this);
    }

    /**
     * Méthode retournant un booléen, true si l'emplacement sur la grille est vide, false sinon.
     *
     * @param x position dans les x du point sur la grille
     * @param y position dans les y du point sur la grille
     * @return retourne un booléen disant si l'emplacement est vide ou non
     */
    public boolean isBusy(int x, int y) {
        return ctrlGrille.isBusy(x, y, grille);
    }

    /**
     * Méthode permettant de mettre à jour la grille en mémoire.
     */
    protected void update() {
        ctrlGrille.update(grille);
    }

    /**
     * Méthode permettant de nettoyer un point à des coordonnées précises.
     *
     * @param x position dans les x du point sur la grille
     * @param y position dans les y du point sur la grille
     */
    public void clear(int x, int y) {
        ctrlGrille.clear(x, y, grille);
    }

    /**
     * Méthode permettant de nettoyer une ligne complète.
     */
    protected void clearFullLine() {
        ctrlGrille.clearFullLine(grille, partie);
    }

    /**
     * Méthode permettant de nettoyer l'entièreté de la grille.
     */
    public void clearGrille() {
        ctrlGrille.clearGrille(grille);
    }
}