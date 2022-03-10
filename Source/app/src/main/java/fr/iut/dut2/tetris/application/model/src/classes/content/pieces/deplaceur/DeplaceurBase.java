package fr.iut.dut2.tetris.application.model.src.classes.content.pieces.deplaceur;


import androidx.annotation.NonNull;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.EtatRotation;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.GrilleBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.PieceBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.Verifyer;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.PointBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.tourneur.TourneurBase;

/**
 * Record ayant la responsabilité des déplacements latéraux d'une pièce.
 */
public class DeplaceurBase {

    private PieceBase piece;

    public PieceBase getPiece() {
        return piece;
    }

    public void setPiece(PieceBase piece) {
        this.piece = piece;
    }

    public DeplaceurBase(PieceBase piece){
        this.piece = piece;
    }

    /**
     * Méthode permettant de faire le mouvement demandé.
     *
     * @param mtype    mouvement demandé
     * @param points   points d'une pièce
     * @param grille   grille de jeu
     * @param partie   partie possédant les attributs nécessaires
     * @param verifyer permet de faire des vérifications sur une pièce
     * @param tourneur permet de tourner une pièce
     */
    public void doMouvement(@NonNull MovePiece mtype, PointBase[] points, GrilleBase grille, Partie partie, Verifyer verifyer, TourneurBase tourneur) {
        switch (mtype) {
            case GAUCHE : deplacerGauche(points, grille, verifyer); break;
            case DROITE : deplacerDroite(points, grille, partie, verifyer); break;
            case TOURNER_GAUCHE :
                if (verifyer.canGoGauche(points, grille) && verifyer.canGoDroite(points, grille, partie)) {
                    tourneur.tournerGauche(points, piece.type, piece.rotation);
                    int tmpRotation = piece.rotation.ordinal();
                    tmpRotation--;
                    if (tmpRotation < 0)
                        tmpRotation = 3;
                    piece.rotation = EtatRotation.getType(tmpRotation);
            }
                break;
            case TOURNER_DROITE :
                if (verifyer.canGoGauche(points, grille) && verifyer.canGoDroite(points, grille, partie)) {
                    tourneur.tournerDroite(points, piece.type, piece.rotation);
                    int tmpRotation = piece.rotation.ordinal();
                    tmpRotation++;
                    if (tmpRotation > 3)
                        tmpRotation = 0;
                    piece.rotation = EtatRotation.getType(tmpRotation);
                }
                break;
            case DESCENDRE : descendre(points, grille, partie, verifyer); break;
        }
    }

    /**
     * Méthode permettant de faire descendre une pièce sur la grille.
     *
     * @param points   points d'une pièce
     * @param grille   grille de jeu
     * @param partie   partie possédant les attributs nécessairess
     * @param verifyer permet de faire des vérifications sur une pièce
     */
    void descendre(PointBase[] points, GrilleBase grille, Partie partie, @NonNull Verifyer verifyer) {
        if (!verifyer.canGoBas(points, grille, partie)) {
            return;
        }
        for (PointBase pt : points) {
            if (pt.y == partie.getNbLignes() - 2)
                return;
        }
        for (PointBase pt : points) {
            pt.y++;
        }
    }

    /**
     * Méthode permettant de déplacer une pièce vers la gauche sur une grille.
     *
     * @param points   points d'une pièce
     * @param grille   grille de jeu
     * @param verifyer permet de faire des vérifications sur une pièce
     */
    void deplacerGauche(@NonNull PointBase[] points, GrilleBase grille, Verifyer verifyer) {
        for (PointBase pt : points) {
            if (grille.isBusy(pt.x - 1, pt.y))
                return;
            else if (!verifyer.canGoGauche(points, grille))
                return;
        }
        for (PointBase pt : points) {
            pt.x--;
        }
    }

    /**
     * Méthode permettant de déplacer une pièce vers la droite sur une grille.
     *
     * @param points   points d'une pièce
     * @param grille   grille de jeu
     * @param partie   partie possédant les attributs nécessaires
     * @param verifyer permet de faire des vérifications sur une pièce
     */
    void deplacerDroite(@NonNull PointBase[] points, GrilleBase grille, Partie partie, Verifyer verifyer) {
        for (PointBase pt : points) {
            if (grille.isBusy(pt.x + 1, pt.y))
                return;
            else if (!verifyer.canGoDroite(points, grille, partie))
                return;
        }
        for (PointBase pt : points) {
            pt.x++;
        }
    }
}
