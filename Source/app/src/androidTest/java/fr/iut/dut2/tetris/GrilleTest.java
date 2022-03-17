package fr.iut.dut2.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class GrilleTest {

    @Test
    public void GrilleSize(){
        Partie p = new Partie(24,12);

        assertEquals(p.getNbLignes(),24);
        assertEquals(p.getNbColonnes(),12);
    }
}
