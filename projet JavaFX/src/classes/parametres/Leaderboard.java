package classes.parametres;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Leaderboard implements Serializable {
    public List<Integer> scores = new LinkedList<>();

    public Leaderboard() {
        chargerFichier();
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void addScore(int value) {
        if (scores.size() >= 10) {
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

    public void chargerFichier() {
        URL s = requireNonNull(this.getClass().getResource("/persistance/Leaderboard.ser"));
        File f = null;
        try {
            f = new File(s.toURI());
            try {
                ObjectInputStream reader = new ObjectInputStream(new FileInputStream(f));
                Integer scoreCharge = (Integer) reader.readObject();
                while (scoreCharge != null) {
                    addScore(scoreCharge);
                    scoreCharge = (Integer) reader.readObject();
                }
            } catch (EOFException ex) {
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichier \"" + f.getName() + "\" non trouvé \n" +
                    "Chemin : " + f.getPath());
        } catch (IOException | URISyntaxException | ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void sauvegarder() {
        URL s = requireNonNull(this.getClass().getResource("/persistance/Leaderboard.ser"));
        File f = null;
        try {
            f = new File(s.toURI());
            if (!f.exists()) {
                if (!f.createNewFile())
                    throw new Exception("Le fichier n'a pas été créé correctement.");
            }
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(f));
            for (Integer score : scores) {
                writer.writeObject(score);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier \"" + f.getName() + "\" non trouvé \n" +
                    "Chemin : " + f.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
