package fr.iut.dut2.tetris.application.model.src.classes.content.pieces;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.PieceType;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.GrilleBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.Point;

/**
 * Piece de type "SGauche"
 */
public class PieceSGauche extends PieceBase {

    /**
     * Constructeur d'une pièce SGauche
     *
     * @param type   type de la pièce
     * @param x      position de la case centrale sur l'axe des abscisses
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     */
    public PieceSGauche(PieceType type, int x, GrilleBase grille, Partie partie) {
        super(type, grille, partie);
        this.points[0] = new Point(x, 0);
        this.points[1] = new Point(x, 1);
        this.points[2] = new Point(x - 1, 1);
        this.points[3] = new Point(x - 1, 2);

    }


}