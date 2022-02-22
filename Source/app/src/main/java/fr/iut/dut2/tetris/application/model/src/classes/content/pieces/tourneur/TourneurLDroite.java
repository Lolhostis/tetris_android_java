package fr.iut.dut2.tetris.application.model.src.classes.content.pieces.tourneur;


import androidx.annotation.NonNull;

import fr.iut.dut2.tetris.application.model.src.classes.content.enums.EtatRotation;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.PointBase;

/**
 * Tourneur d'une pièce de type "LDroite"
 */
class TourneurLDroite {

    /**
     * Méthode permettant de tourner un LDroite vers la gauche.
     *
     * @param pts      points d'une pièce
     * @param rotation état de la rotation de la pièce
     */
    protected void tournerGauche(PointBase[] pts, @NonNull EtatRotation rotation) {
        switch (rotation) {
            case ANGLE_0 :
                pts[0].x--;
                pts[0].y++;
                pts[2].x++;
                pts[2].y--;
                pts[3].y -= 2;
            case ANGLE_90 :
                pts[0].x--;
                pts[0].y--;
                pts[2].x++;
                pts[2].y++;
                pts[3].x += 2;
            case ANGLE_180 :
                pts[0].x++;
                pts[0].y--;
                pts[2].x--;
                pts[2].y++;
                pts[3].y += 2;
            case ANGLE_270 :
                pts[0].x++;
                pts[0].y++;
                pts[2].x--;
                pts[2].y--;
                pts[3].x -= 2;
        }
    }

    /**
     * Méthode permettant de tourner un I vers la droite.
     *
     * @param pts      points d'une pièce
     * @param rotation état de la rotation de la pièce
     */
    protected void tournerDroite(PointBase[] pts, @NonNull EtatRotation rotation) {
        switch (rotation) {
            case ANGLE_0 :
                pts[0].x++;
                pts[0].y++;
                pts[2].x--;
                pts[2].y--;
                pts[3].x -= 2;
            case ANGLE_90 :
                pts[0].x--;
                pts[0].y++;
                pts[2].x++;
                pts[2].y--;
                pts[3].y -= 2;
            case ANGLE_180 :
                pts[0].x--;
                pts[0].y--;
                pts[2].x++;
                pts[2].y++;
                pts[3].x += 2;
            case ANGLE_270 :
                pts[0].x++;
                pts[0].y--;
                pts[2].x--;
                pts[2].y++;
                pts[3].y += 2;
        }
    }
}
