package classes.app.dessinateurs;

import classes.content.Partie;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public abstract class Dessinateur {

    protected Canvas canvas;

    public Dessinateur(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract void dessinerGrille(Partie p, Label Score);

    public abstract void chargerGrille(Partie p);

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
