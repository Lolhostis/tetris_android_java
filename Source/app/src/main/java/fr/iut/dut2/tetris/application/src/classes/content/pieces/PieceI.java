package fr.iut.dut2.tetris.application.src.classes.content.pieces;

import classes.content.Partie;
import classes.content.enums.PieceType;
import classes.content.grille.GrilleBase;
import classes.content.pieces.point.Point;
import org.jetbrains.annotations.NotNull;

/**
 * Piece de type "I"
 */
public class PieceI extends PieceBase {

    /**
     * Constructeur d'une pièce I
     *
     * @param type   type de la pièce
     * @param x      position de la case centrale sur l'axe des abscisses
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     */
    public PieceI(PieceType type, int x, @NotNull GrilleBase grille, Partie partie) {
        super(type, grille, partie);
        for (int i = 0; i < numPoints; i++) {
            this.points[i] = new Point(x, i);
        }
    }
}