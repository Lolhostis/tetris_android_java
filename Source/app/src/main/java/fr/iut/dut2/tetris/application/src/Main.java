package fr.iut.dut2.tetris.application.src;

import classes.app.loaders.Loader;
import classes.app.observateurs.ObservateurGrille;
import classes.content.Partie;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Partie p = new Partie(25, 12);
        Loader l = new Loader(p, new ObservateurGrille());
        l.loadVuesAndRoot();
        l.loadwithStage("Menu", true);

        Stage menu = l.getStage("Menu");
        menu.setOnCloseRequest(windowEvent -> {
            System.exit(0);
        });

    }
}