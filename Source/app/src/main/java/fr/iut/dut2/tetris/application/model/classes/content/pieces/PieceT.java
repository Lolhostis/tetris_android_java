package classes.content.pieces;

import classes.content.Partie;
import classes.content.enums.PieceType;
import classes.content.grille.GrilleBase;
import classes.content.pieces.point.Point;
import org.jetbrains.annotations.NotNull;

/**
 * Piece de type "T"
 */
public class PieceT extends PieceBase {

    /**
     * Constructeur d'une pièce T
     *
     * @param type   type de la pièce
     * @param x      position de la case centrale sur l'axe des abscisses
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     */
    public PieceT(PieceType type, int x, @NotNull GrilleBase grille, Partie partie) {
        super(type, grille, partie);
        this.points[0] = new Point(x, 0);
        this.points[1] = new Point(x, 1);
        this.points[2] = new Point(x - 1, 0);
        this.points[3] = new Point(x + 1, 0);

    }


}