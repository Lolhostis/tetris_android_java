package classes.app.dessinateurs;

import classes.content.Partie;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public class DessinateurBasique extends Dessinateur {

    public DessinateurBasique(Canvas canvas) {
        super(canvas);
    }

    @Override
    public void dessinerGrille(@NotNull Partie p, Label Score) {
        for (int i = 0; i < p.getNbLignes(); i++) {
            //System.out.println();
            for (int j = 0; j < p.getNbColonnes(); j++) {
                drawRect(p.getGrille().grille[i][j], i, j);
            }
        }
        Platform.runLater(() -> Score.setText("Score : \n" + p.getPoints()));

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);

        for (int i = 20; i < canvas.getWidth(); i += 20) {
            gc.fillRect(i, 0, 0.1, canvas.getHeight());
        }
        for (int j = 20; j < canvas.getHeight(); j += 20) {
            gc.fillRect(0, j, canvas.getWidth(), 0.1);
        }
        //System.out.println();
    }

    public void chargerGrille(@NotNull Partie p) {
        int nbLignes = p.getNbLignes();
        int nbColonnes = p.getNbColonnes();
        int tailleCase = 20;

        System.out.println("Grille");

        canvas.setFocusTraversable(true);

        p.setPoints(0);

        canvas.setHeight((nbLignes - 1) * tailleCase);
        canvas.setWidth((nbColonnes - 2) * tailleCase);


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Color.WHITE);

        for (int i = tailleCase; i < canvas.getWidth(); i += tailleCase) {
            gc.fillRect(i, 0, 0.1, canvas.getHeight());
        }
        for (int j = tailleCase; j < canvas.getHeight(); j += tailleCase) {
            gc.fillRect(0, j, canvas.getWidth(), 0.1);
        }
    }

    private void drawRect(int p, int coordX, int coordY) {
        Color c = switch (p) {
            case 0 -> Color.GRAY;
            case 1 -> Color.RED;
            case 2 -> Color.GREEN;
            case 3 -> Color.YELLOW;
            case 4 -> Color.BROWN;
            case 5 -> Color.MAGENTA;
            case 6 -> Color.BLUE;
            case 7 -> Color.PURPLE;
            default -> Color.BLACK;
        };

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(c);

        gc.fillRect((coordY - 1) * 20, coordX * 20, 20, 20);
    }
}
