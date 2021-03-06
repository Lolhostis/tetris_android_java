package fr.iut.dut2.tetris.application.model.src.classes.content.pieces.tourneur;


import androidx.annotation.NonNull;

import fr.iut.dut2.tetris.application.model.src.classes.content.enums.EtatRotation;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.PointBase;

/**
 * Tourneur d'une pièce de type "SDroite"
 */
public class TourneurSDroite {

    /**
     * Méthode permettant de tourner un SDroite vers la gauche.
     *
     * @param pts      points d'une pièce
     * @param rotation état de la rotation de la pièce
     */
    protected void tournerGauche(PointBase[] pts, @NonNull EtatRotation rotation) {
        switch (rotation) {
            case ANGLE_0 :
                pts[0].x--;
                pts[0].y++;
                pts[2].x--;
                pts[2].y--;
                pts[3].y -= 2;
                break;

            case ANGLE_90 :
                pts[0].x--;
                pts[0].y--;
                pts[2].x++;
                pts[2].y--;
                pts[3].x += 2;
                break;

            case ANGLE_180 :
                pts[0].x++;
                pts[0].y--;
                pts[2].x++;
                pts[2].y++;
                pts[3].y += 2;
                break;

            case ANGLE_270 :
                pts[0].x++;
                pts[0].y++;
                pts[2].x--;
                pts[2].y++;
                pts[3].x -= 2;
                break;

        }
    }

    /**
     * Méthode permettant de tourner un SDroite vers la droite.
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
                pts[2].y++;
                pts[3].x -= 2;
                break;

            case ANGLE_90 :
                pts[0].x--;
                pts[0].y++;
                pts[2].x--;
                pts[2].y--;
                pts[3].y -= 2;
                break;

            case ANGLE_180:
                pts[0].x--;
                pts[0].y--;
                pts[2].x++;
                pts[2].y--;
                pts[3].x += 2;
                break;

            case ANGLE_270 :
                pts[0].x++;
                pts[0].y--;
                pts[2].x++;
                pts[2].y++;
                pts[3].y += 2;
                break;

        }
    }
}
