package fr.iut.dut2.tetris.application.model.src.classes.content.pieces;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.GrilleBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.Point;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.PointBase;

/**
 * Record ayant la responsabilité des vérifications des pièces sur la grille.
 */
public class Verifyer {

    private int numPoints;

    public int getNumPoints() {
        return numPoints;
    }

    public Verifyer(int numPoints){
        this.numPoints = numPoints;
    }

    public void setNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    /**
     * Méthode retournant true si le mouvement demandé existe, false sinon.
     *
     * @param mtype mouvement demandé
     * @return booléen disant si le mouvement demandé est valide
     */
    boolean isValideMove(MovePiece mtype) {
        switch (mtype) {
            case DESCENDRE :
            case TOURNER_DROITE :
            case TOURNER_GAUCHE :
            case GAUCHE :
            case DROITE :
                return true;
            default :
                return false;
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
