package fr.iut.dut2.tetris.application.model.src.classes.content.observateurs;


import fr.iut.dut2.tetris.application.model.src.classes.content.grille.Grille;

public class ObservateurGrille extends ObservateurAbstrait {
    private Grille value;

    @Override
    public void update() {
        value = sujet.getGrille();
      //  looker.dessinerGrille(); //Le moment où la grille se dessine
    }

    /*public void gameOver() { // Pour délencher la fenetre de gameOver
        looker.GameOver();
    }*/
}
