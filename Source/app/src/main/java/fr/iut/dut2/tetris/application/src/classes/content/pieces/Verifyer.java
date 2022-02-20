package fr.iut.dut2.tetris.application.src.classes.content.pieces;

import classes.content.Partie;
import classes.content.enums.MoveType;
import classes.content.grille.GrilleBase;
import classes.content.pieces.point.Point;
import classes.content.pieces.point.PointBase;
import org.jetbrains.annotations.NotNull;

/**
 * Record ayant la responsabilité des vérifications des pièces sur la grille.
 */
public record Verifyer(int numPoints) {

    /**
     * Méthode retournant true si le mouvement demandé existe, false sinon.
     *
     * @param mtype mouvement demandé
     * @return booléen disant si le mouvement demandé est valide
     */
    boolean isValideMove(@NotNull MoveType mtype) {
        switch (mtype) {
            case GAUCHE, DROITE, TOURNER_GAUCHE, TOURNER_DROITE, DESCENDRE -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Méthode retournant true si la pièce peut aller vers le bas, sinon false.
     *
     * @param points points d'une pièce
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     * @return booléen disant si la piece peut aller vers le bas
     */
    public boolean canGoBas(PointBase[] points, GrilleBase grille, Partie partie) {

        PointBase[] pts = new PointBase[numPoints];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Point(points[i].x, points[i].y);
        }
        for (PointBase pt : pts)
            if (grille.isBusy(pt.x, pt.y + 1))
                return false;
            else if (pt.y == partie.getNbLignes() - 2) {
                return false;
            }
        return true;
    }

    /**
     * Méthode retournant true si la pièce peut aller vers la droite, sinon false.
     *
     * @param points points d'une pièce
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     * @return booléen disant si la piece peut aller vers le bas
     */
    public boolean canGoDroite(PointBase[] points, GrilleBase grille, Partie partie) {
        PointBase[] pts = new PointBase[numPoints];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Point(points[i].x, points[i].y);
        }
        for (PointBase pt : pts)
            if (grille.isBusy(pt.x + 1, pt.y))
                return false;
            else if (pt.x == partie.getNbColonnes() - 2) {
                return false;
            }
        return true;
    }

    /**
     * Méthode retournant true si la pièce peut aller vers la gauche, sinon false.
     *
     * @param points points d'une pièce
     * @param grille grille de jeu
     * @return booléen disant si la piece peut aller vers le bas
     */
    public boolean canGoGauche(PointBase[] points, GrilleBase grille) {
        PointBase[] pts = new PointBase[numPoints];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Point(points[i].x, points[i].y);
        }
        for (PointBase pt : pts)
            if (grille.isBusy(pt.x - 1, pt.y))
                return false;
            else if (pt.x == 1) {
                return false;

            }
        return true;
    }
}
