package classes.content.grille;

import classes.content.enums.MoveType;
import classes.content.enums.PieceType;
import classes.content.pieces.*;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Record ayant la responsabilité des controles concernant les pièces dans la grille.
 */
record ControlesPiece(int nombreDeColonne, int nombreDeLigne) {

    /**
     * Méthode permettant de créer une nouvelle pièce.
     *
     * @param grille grille de jeu
     */
    void addNewPiece(@NotNull Grille grille) {
        Random rand = new Random();
        int xPos = nombreDeColonne / 2 - 1;
        grille.type = rand.nextInt(7) + 1;
        PieceType ptype = PieceType.getType(grille.type);
        switch (ptype) {
            case CARRE -> grille.currentPiece = new PieceCarree(ptype, xPos, grille, grille.partie);
            case I -> grille.currentPiece = new PieceI(ptype, xPos, grille, grille.partie);
            case L_DROITE -> grille.currentPiece = new PieceLDroite(ptype, xPos, grille, grille.partie);
            case L_GAUCHE -> grille.currentPiece = new PieceLGauche(ptype, xPos, grille, grille.partie);
            case S_DROITE -> grille.currentPiece = new PieceSDroite(ptype, xPos, grille, grille.partie);
            case S_GAUCHE -> grille.currentPiece = new PieceSGauche(ptype, xPos, grille, grille.partie);
            case T -> grille.currentPiece = new PieceT(ptype, xPos, grille, grille.partie);
            default -> throw new IllegalStateException("Unexpected value: " + ptype);
        }
        grille.currentPiece.dessiner();
    }

    /**
     * Méthode permettant de vérifier si un mouvement est possible et appel les méthodes nécessaire si c'est possible.
     *
     * @param mtype  mouvement demandé
     * @param grille grille de jeu
     */
    void movePiece(MoveType mtype, @NotNull Grille grille) {
        if (grille.currentPiece.isValideMove(mtype)) {
            grille.currentPiece.clear();
            grille.currentPiece.doMouvement(mtype);
            grille.currentPiece.dessiner();
            //Loader.windowContr.drawPiece();
        }
    }

    /**
     * Méthode permettant d'insérer une nouvelle pièce dans la grille.
     *
     * @param x      position dans les x du point sur la grille
     * @param y      position dans les y du point sur la grille
     * @param grille grille de jeu
     */
    void setPiece(int x, int y, Grille grille) {
        if (x >= 0 && x < nombreDeColonne && y >= 0 && y < nombreDeLigne) {
            grille.grille[y][x] = grille.type;
        }
    }
}
