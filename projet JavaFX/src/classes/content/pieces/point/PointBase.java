package classes.content.pieces.point;

/**
 * Classe abstraite représentant un point d'une pièce.
 */
public abstract class PointBase {
    public int x;
    public int y;

    /**
     * Constructeur d'un pointBase.
     *
     * @param x paramètre x d'une pièce.
     * @param y paramètre y d'une pièce.
     */
    public PointBase(int x, int y) {
        this.x = x;
        this.y = y;
    }
}