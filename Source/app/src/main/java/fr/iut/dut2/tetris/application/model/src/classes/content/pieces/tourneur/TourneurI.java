package fr.iut.dut2.tetris.application.model.src.classes.content.pieces.tourneur;

import fr.iut.dut2.tetris.application.model.src.classes.content.enums.EtatRotation;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.PointBase;

/**
 * Tourneur d'une pièce de type "I"
 */
class TourneurI {

    /**
     * Méthode permettant de tourner un I vers la gauche.
     *
     * @param pts      points d'une pièce
     * @param rotation état de la rotation de la pièce
     */
    protected void tournerGauche(PointBase[] pts, EtatRotation rotation) {
        switch (rotation) {
            case ANGLE_0 : move1(pts);
            case ANGLE_180 : move1(pts);

            case ANGLE_90 : move2(pts);
            case ANGLE_270 : move2(pts);
        }
    }

    /**
     * Méthode permettant de tourner un I vers la droite.
     *
     * @param pts      points d'une pièce
     * @param rotation état de la rotation de la pièce
     */
    protected void tournerDroite(PointBase[] pts, EtatRotation rotation) {
        switch (rotation) {
            //case ANGLE_0, ANGLE_180 -> move1(pts);
            //case ANGLE_90, ANGLE_270 -> move2(pts);

            case ANGLE_0 : move1(pts);
            case ANGLE_180 : move1(pts);

            case ANGLE_90 : move2(pts);
            case ANGLE_270 : move2(pts);
        }
    }


    /**
     * 1er type de déplacement.
     *
     * @param pts points d'une pièce
     */
    private void move1(PointBase[] pts) {
        pts[0].x++;
        pts[0].y++;
        pts[2].x--;
        pts[2].y--;
        pts[3].x -= 2;
        pts[3].y -= 2;
    }


    /**
     * 2eme type de déplacement.
     *
     * @param pts points d'une pièce
     */
    private void move2(PointBase [] pts) {
        pts[0].x--;
        pts[0].y--;
        pts[2].x++;
        pts[2].y++;
        pts[3].x += 2;
        pts[3].y += 2;
    }
}
