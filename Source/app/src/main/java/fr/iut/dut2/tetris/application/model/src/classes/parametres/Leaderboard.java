package fr.iut.dut2.tetris.application.model.src.classes.parametres;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.requireNonNull;

import android.net.Uri;

public class Leaderboard implements Serializable {
    private List<Integer> scores = new LinkedList<>();

    public List<Integer> getScores() {
        return scores;
    }

    public void addScore(int value) {
        if (scores.size() >= 5) {
            scores.add(value);
            Collections.sort(scores);
            Collections.reverse(scores);
            removeScore(scores.get(scores.size() - 1));
            return;
        }
        scores.add(value);
        Collections.sort(scores);
        Collections.reverse(scores);
    }

    public void removeScore(int value) {
        scores.remove((Integer) value);
        Collections.sort(scores);
        Collections.reverse(scores);
    }
}
