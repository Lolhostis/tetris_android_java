package classes.content.pieces.tourneur;

import classes.content.enums.EtatRotation;
import classes.content.pieces.point.PointBase;
import org.jetbrains.annotations.NotNull;

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
    protected void tournerGauche(PointBase[] pts, @NotNull EtatRotation rotation) {
        switch (rotation) {
            case ANGLE_0, ANGLE_180 -> move1(pts);
            case ANGLE_90, ANGLE_270 -> move2(pts);
        }
    }

    /**
     * Méthode permettant de tourner un I vers la droite.
     *
     * @param pts      points d'une pièce
     * @param rotation état de la rotation de la pièce
     */
    protected void tournerDroite(PointBase[] pts, @NotNull EtatRotation rotation) {
        switch (rotation) {
            case ANGLE_0, ANGLE_180 -> move1(pts);
            case ANGLE_90, ANGLE_270 -> move2(pts);
        }
    }


    /**
     * 1er type de déplacement.
     *
     * @param pts points d'une pièce
     */
    private void move1(PointBase @NotNull [] pts) {
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
    private void move2(PointBase @NotNull [] pts) {
        pts[0].x--;
        pts[0].y--;
        pts[2].x++;
        pts[2].y++;
        pts[3].x += 2;
        pts[3].y += 2;
    }
}
