package classes.content.grille;

import classes.content.Partie;
import classes.content.enums.MoveType;
import classes.content.pieces.PieceBase;

/**
 * Classe abstraite représentant une Grille.
 */
public abstract class GrilleBase {
    protected final int pieceTypes = 7; //nombre de pièces différentes, toujours la même valeur, on peut donc la mettre final
    public int[][] grille;
    protected int nombreDeLigne;
    protected int nombreDeColonne;
    protected PieceBase currentPiece;
    protected int type;
    protected Partie partie;


    /**
     * Constructeur d'une GrilleBase.
     *
     * @param nbLignes   nombre de lignes de la grille
     * @param nbColonnes nombre de colonnes de la grille
     * @param partie     partie possédant les attributs nécessaires
     */
    public GrilleBase(int nbLignes, int nbColonnes, Partie partie) {
        nombreDeLigne = nbLignes;
        nombreDeColonne = nbColonnes;
        grille = new int[nombreDeLigne][nombreDeColonne];
        for (int i = 0; i < nombreDeLigne; i++) {
            for (int j = 0; j < nombreDeColonne; j++) {
                grille[i][j] = -1;
            }
        }
        this.partie = partie;
    }

    /**
     * Méthode permettant de terminer une partie.
     */
    protected abstract void gameOver();

    /**
     * Méthode permettant de créer une nouvelle pièce.
     */
    protected abstract void addNewPiece();

    /**
     * Méthode de déplacer une pièce dans la grille.
     *
     * @param mtype mouvement demandé
     */
    public abstract void movePiece(MoveType mtype);

    /**
     * Méthode permettant d'insérer une nouvelle pièce dans la grille.
     *
     * @param x position dans les x du point sur la grille
     * @param y position dans les y du point sur la grille
     */
    public abstract void setPiece(int x, int y);

    /**
     * Méthode retournant un booléen, true si l'emplacement sur la grille est vide, false sinon.
     *
     * @param x position dans les x du point sur la grille
     * @param y position dans les y du point sur la grille
     * @return retourne un booléen disant si l'emplacement est vide ou non
     */
    public abstract boolean isBusy(int x, int y);

    /**
     * Méthode permettant de mettre à jour la grille en mémoire.
     */
    protected abstract void update();

    /**
     * Méthode permettant de nettoyer un point à des coordonnées précises.
     *
     * @param x position dans les x du point sur la grille
     * @param y position dans les y du point sur la grille
     */
    public abstract void clear(int x, int y);

    /**
     * Méthode permettant de nettoyer une ligne complète.
     */
    protected abstract void clearFullLine();

    /**
     * Méthode permettant de nettoyer l'entièreté de la grille.
     */
    public abstract void clearGrille();

}