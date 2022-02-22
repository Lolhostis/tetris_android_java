package fr.iut.dut2.tetris.application.model.src.classes.content.pieces;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.PieceType;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.GrilleBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.Point;

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
    public PieceCarree(PieceType type, int x, GrilleBase grille, Partie partie) {
        super(type, grille, partie);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.points[i * 2 + j] = new Point(x + i, j);
            }
        }
    }
}

