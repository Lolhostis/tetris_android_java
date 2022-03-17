package fr.iut.dut2.tetris.application.model.src.classes.content.observateurs;


import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.Grille;
import fr.iut.dut2.tetris.application.views.GrilleWindowActivity;

public class ObservateurGrille extends ObservateurAbstrait {
    private Grille value;
    private final GrilleWindowActivity gameOverLauncher;

    public ObservateurGrille(Partie p, GrilleWindowActivity gameOverLauncher) {
        this.sujet = p;
        this.gameOverLauncher = gameOverLauncher;
    }

    @Override
    public void update() {
        value = sujet.getGrille();
        //gameOverLauncher.runOnUiThread(() -> looker.dessinerGrille(sujet)); //Le moment où la grille se dessine
    }

    public void gameOver() { // Pour délencher la fenetre de gameOver
        gameOverLauncher.GameOver();
    }
}
