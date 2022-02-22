package fr.iut.dut2.tetris.application.model.src.classes.content.pieces;

import androidx.annotation.NonNull;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.EtatRotation;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.PieceType;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.GrilleBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.deplaceur.DeplaceurBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.point.PointBase;
import fr.iut.dut2.tetris.application.model.src.classes.content.pieces.tourneur.TourneurBase;

/**
 * Classe abstraite représentant une pièce
 */
public abstract class PieceBase {
    protected final int numPoints = 4;
    private final Verifyer verifyer;
    private final DeplaceurBase deplaceur;
    private final TourneurBase tourneur;
    public PointBase[] points;
    public EtatRotation rotation;
    public PieceType type;
    protected GrilleBase grille;
    protected Partie partie;

    /**
     * Constructeur d'une PieceBase
     *
     * @param type   type de la pièce
     * @param grille grille de jeu
     * @param partie partie possédant les attributs nécessaires
     */
    public PieceBase(PieceType type, GrilleBase grille, Partie partie) {
        this.type = type;
        this.grille = grille;
        this.points = new PointBase[numPoints];
        this.rotation = EtatRotation.ANGLE_0;
        this.partie = partie;
        verifyer = new Verifyer(numPoints);
        deplaceur = new DeplaceurBase(this);
        tourneur = new TourneurBase();
    }

    /**
     * méthode permettant de retourner le numéro de la pièce.
     *
     * @return chaine de caractère formatée
     */
    @NonNull
    @Override
    public String toString() {
        return String.valueOf(PieceType.toString(String.valueOf(type)));
    }


    /**
     * Méthode permettant de fixer la pièce sur la grille.
     */
    public void dessiner() {
        for (PointBase point : points) {
            this.grille.setPiece(point.x, point.y);
        }
    }

    /**
     * Méthode permettant de nettoyer les points renseignés.
     */
    public void clear() {
        for (PointBase point : points) {
            this.grille.clear(point.x, point.y);
        }
    }

    /**
     * Retourne true si le mouvement est valide, false sinon.
     *
     * @param mtype mouvement demandé
     * @return booléen disant si le mouvement est valide ou non.
     */
    public boolean isValideMove(MovePiece mtype) {
        return verifyer.isValideMove(mtype);
    }


    /**
     * Méthode permettant de faire le mouvement demandé.
     *
     * @param mtype mouvement demandé
     */
    public void doMouvement(MovePiece mtype) {
        deplaceur.doMouvement(mtype, points, grille, partie, verifyer, tourneur);
    }

    /**
     * Retourne true si la pièce peut continuer à descendre, false sinon.
     *
     * @return booléen disant si la pièce peut encore descendre sur la grille.
     */
    public boolean canGoBas() {
        return verifyer.canGoBas(points, grille, partie);
    }
}