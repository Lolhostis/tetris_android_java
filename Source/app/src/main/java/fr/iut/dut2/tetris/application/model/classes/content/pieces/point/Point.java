package classes.content.pieces.point;

/**
 * Classe représentant un point.
 */
public class Point extends PointBase {
    public int x;
    public int y;

    /**
     * Constructeur d'un point.
     *
     * @param x paramètre x du point
     * @param y paramètre y du point
     */
    public Point(int x, int y) {
        super(x, y);
    }
}
