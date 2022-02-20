package fr.iut.dut2.tetris.application.src.classes.content.pieces.deplaceur;

import classes.content.Partie;
import classes.content.enums.EtatRotation;
import classes.content.enums.MoveType;
import classes.content.grille.GrilleBase;
import classes.content.pieces.PieceBase;
import classes.content.pieces.Verifyer;
import classes.content.pieces.point.PointBase;
import classes.content.pieces.tourneur.TourneurBase;
import org.jetbrains.annotations.NotNull;

/**
 * Record ayant la responsabilité des déplacements latéraux d'une pièce.
 */
public record DeplaceurBase(PieceBase piece) {

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
    public void doMouvement(@NotNull MoveType mtype, PointBase[] points, GrilleBase grille, Partie partie, Verifyer verifyer, TourneurBase tourneur) {
        switch (mtype) {
            case GAUCHE -> deplacerGauche(points, grille, verifyer);
            case DROITE -> deplacerDroite(points, grille, partie, verifyer);
            case TOURNER_GAUCHE -> {
                if (verifyer.canGoGauche(points, grille) && verifyer.canGoDroite(points, grille, partie)) {
                    tourneur.tournerGauche(points, piece.type, piece.rotation);
                    int tmpRotation = piece.rotation.ordinal();
                    tmpRotation--;
                    if (tmpRotation < 0)
                        tmpRotation = 3;
                    piece.rotation = EtatRotation.getType(tmpRotation);
                }
            }
            case TOURNER_DROITE -> {
                if (verifyer.canGoGauche(points, grille) && verifyer.canGoDroite(points, grille, partie)) {
                    tourneur.tournerDroite(points, piece.type, piece.rotation);
                    int tmpRotation = piece.rotation.ordinal();
                    tmpRotation++;
                    if (tmpRotation > 3)
                        tmpRotation = 0;
                    piece.rotation = EtatRotation.getType(tmpRotation);
                }
            }
            case DESCENDRE -> descendre(points, grille, partie, verifyer);
        }
    }

    /**
     * Méthode permettant de faire descendre une pièce sur la grille.
     *
     * @param points   points d'une pièce
     * @param grille   grille de jeu
     * @param partie   partie possédant les attributs nécessaires
     * @param verifyer permet de faire des vérifications sur une pièce
     */
    void descendre(PointBase[] points, GrilleBase grille, Partie partie, @NotNull Verifyer verifyer) {
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
    void deplacerGauche(PointBase @NotNull [] points, GrilleBase grille, Verifyer verifyer) {
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
    void deplacerDroite(PointBase @NotNull [] points, GrilleBase grille, Partie partie, Verifyer verifyer) {
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
