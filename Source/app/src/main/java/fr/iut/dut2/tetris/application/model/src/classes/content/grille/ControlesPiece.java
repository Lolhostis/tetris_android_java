package fr.iut.dut2.tetris.application.model.src.classes.content.grille;

import androidx.annotation.NonNull;

import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.PieceType;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceCarree;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceI;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceLDroite;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceLGauche;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceSDroite;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceSGauche;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceT;

import java.util.Random;

/**
 * Record ayant la responsabilité des controles concernant les pièces dans la grille.
 */
public class ControlesPiece{

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

    public ControlesPiece(int nombreDeColonne, int nombreDeLigne){
        this.nombreDeColonne = nombreDeColonne;
        this.nombreDeLigne = nombreDeLigne;
    }

    /**
     * Méthode permettant de créer une nouvelle pièce.
     *
     * @param grille grille de jeu
     */
    protected void addNewPiece(@NonNull Grille grille) {
        Random rand = new Random();
        int xPos = nombreDeColonne / 2 - 1;
        grille.type = rand.nextInt(7) + 1;
        PieceType ptype = PieceType.getType(grille.type);
        switch (ptype) {
            case CARRE : grille.currentPiece = new PieceCarree(ptype, xPos, grille, grille.partie); break;
            case I : grille.currentPiece = new PieceI(ptype, xPos, grille, grille.partie); break;
            case L_DROITE : grille.currentPiece = new PieceLDroite(ptype, xPos, grille, grille.partie); break;
            case L_GAUCHE : grille.currentPiece = new PieceLGauche(ptype, xPos, grille, grille.partie); break;
            case S_DROITE : grille.currentPiece = new PieceSDroite(ptype, xPos, grille, grille.partie); break;
            case S_GAUCHE : grille.currentPiece = new PieceSGauche(ptype, xPos, grille, grille.partie); break;
            case T : grille.currentPiece = new PieceT(ptype, xPos, grille, grille.partie); break;
            default : throw new IllegalStateException("Unexpected value: " + ptype);
        }
        //grille.currentPiece.dessiner();
    }

    /**
     * Méthode permettant de vérifier si un mouvement est possible et appel les méthodes nécessaire si c'est possible.
     *
     * @param mtype  mouvement demandé
     * @param grille grille de jeu
     */
    public void movePiece(MovePiece mtype, @NonNull Grille grille) {
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
    public void setPiece(int x, int y, Grille grille) {
        if (x >= 0 && x < nombreDeColonne && y >= 0 && y < nombreDeLigne) {
            grille.grille[y][x] = grille.type;
        }
    }
}
