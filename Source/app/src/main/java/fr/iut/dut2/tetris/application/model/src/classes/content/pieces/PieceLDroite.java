package fr.iut.dut2.tetris.application.model.src.classes.content.pieces;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.PieceType;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.GrilleBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.Point;

/**
 * Piece de type "LDroite"
 */
public class PieceLDroite extends PieceBase {

    /**
     * Constructeur d'une pièce LDroite
     *
     * @param type   type de la pièce
     * @param x      position de la case centrale sur l'axe des abscisses
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     */
    public PieceLDroite(PieceType type, int x, GrilleBase grille, Partie partie) {
        super(type, grille, partie);
        for (int i = 0; i < numPoints - 1; i++) {
            this.points[i] = new Point(x, i);
        }
        this.points[numPoints - 1] = new Point(x + 1, 2);
    }
}