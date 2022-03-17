package fr.iut.dut2.tetris;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class PartieTest {

    @Test
    public void PartieLeaderboard(){
        Partie p = new Partie(24,12);

        List<Integer> tmp = p.getLeaderboard().getScores();
        Collections.sort(tmp);
        Collections.reverse(tmp);
        Assert.assertEquals(tmp,p.getLeaderboard().getScores());
    }

    @Test
    public void PartieDifficulte(){
        Partie p = new Partie(24,12);

        Assert.assertTrue((p.getDifficulte().getDifficulte() >= 0 && p.getDifficulte().getDifficulte() < 4));
    }
}
