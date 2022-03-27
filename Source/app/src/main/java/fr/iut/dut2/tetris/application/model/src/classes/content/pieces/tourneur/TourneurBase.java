package fr.iut.dut2.tetris.application.model.src.classes.content.pieces.tourneur;

import fr.iut.dut2.tetris.application.model.src.classes.content.enums.EtatRotation;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.PieceType;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.PointBase;

/**
 * Classe permettant de faire le choix du tourneur à adopter en fonction de la pièce instanciée.
 */
public class TourneurBase {

    /**
     * Méthode permettant de faire le choix du tourneur en fonction du type de la pièce, et de tourner cette pièce vers la gauche.
     *
     * @param points   points d'une pièce
     * @param type     type de la pièce
     * @param rotation état de la rotation de la pièce
     */
    public void tournerGauche(PointBase[] points, PieceType type, EtatRotation rotation) {
        switch (type) {
            case CARRE : new TourneurCarre().tournerGauche(); break;
            case I : new TourneurI().tournerGauche(points, rotation); break;
            case L_DROITE : new TourneurLDroite().tournerGauche(points, rotation); break;
            case L_GAUCHE : new TourneurLGauche().tournerGauche(points, rotation); break;
            case S_DROITE : new TourneurSDroite().tournerGauche(points, rotation); break;
            case S_GAUCHE : new TourneurSGauche().tournerGauche(points, rotation); break;
            case T : new TourneurT().tournerGauche(points, rotation); break;
        }
    }

    /**
     * Méthode permettant de faire le choix du tourneur en fonction du type de la pièce, et de tourner cette pièce vers la droite.
     *
     * @param points   points d'une pièce
     * @param type     type de la pièce
     * @param rotation état de la rotation de la pièce
     */
    public void tournerDroite(PointBase[] points, PieceType type, EtatRotation rotation) {
        switch (type) {
            case CARRE : new TourneurCarre().tournerDroite(); break;
            case I : new TourneurI().tournerDroite(points, rotation); break;
            case L_DROITE : new TourneurLDroite().tournerDroite(points, rotation); break;
            case L_GAUCHE : new TourneurLGauche().tournerDroite(points, rotation); break;
            case S_DROITE : new TourneurSDroite().tournerDroite(points, rotation); break;
            case S_GAUCHE : new TourneurSGauche().tournerDroite(points, rotation); break;
            case T : new TourneurT().tournerDroite(points, rotation); break;
        }
    }
}
