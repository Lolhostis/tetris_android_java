package fr.iut.dut2.tetris.application.model.src.classes.content.thread;

import android.util.Log;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.Grille;

/**
 * Classe possédant la matérialisation de la boucle de jeu.
 */
public class Play extends Grille implements Runnable {

    public boolean paused = false;
    public boolean running = false;

    /**
     * Constructeur d'un Play
     *
     * @param nbLignes   nombre de lignes de la grille
     * @param nbColonnes nombre de colonnes de la grille
     * @param p          partie possédant les attributs nécessaires
     */
    public Play(int nbLignes, int nbColonnes, Partie p) {
        super(nbLignes, nbColonnes, p);
    }

    @Override
    public void run() {
        float i = 75;
        int cpt = 1;
        addNewPiece();
        running = true;
        update();

        while (currentPiece.canGoBas() && running) {
            do {
                if (!paused) {
                    try {

                        if (i - Math.sqrt(cpt) < 100)
                            //noinspection BusyWait
                            Thread.sleep(100);
                        else
                            //noinspection BusyWait
                            Thread.sleep((long) ((long) i - (Math.sqrt(cpt) * 20)));
                        cpt++;

                    } catch (InterruptedException e) {
                        try {
                            Thread.currentThread().join();
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        running = false;
                        return;
                    }
                    movePiece(MovePiece.DESCENDRE);
                    update();
                }

            } while (currentPiece.canGoBas() && running);
            this.type = 0;
            currentPiece.dessiner();
            clearFullLine();
            addNewPiece();
            update();
        }
        clearGrille();
        gameOver();
    }
}
