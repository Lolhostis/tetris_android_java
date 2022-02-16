package classes.content.pieces;


import classes.content.Partie;
import classes.content.enums.PieceType;
import classes.content.grille.GrilleBase;
import classes.content.pieces.point.Point;
import org.jetbrains.annotations.NotNull;

/**
 * Piece de type "CARRE"
 */
public class PieceCarree extends PieceBase {

    /**
     * Constructeur d'une pièce CARRE
     *
     * @param type   type de la pièce
     * @param x      position de la case centrale sur l'axe des abscisses
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     */
    public PieceCarree(PieceType type, int x, @NotNull GrilleBase grille, Partie partie) {
        super(type, grille, partie);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.points[i * 2 + j] = new Point(x + i, j);
            }
        }
    }
}

