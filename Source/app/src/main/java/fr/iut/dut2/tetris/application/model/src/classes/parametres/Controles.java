package fr.iut.dut2.tetris.application.model.src.classes.parametres;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

import static java.util.Objects.requireNonNull;

public class Controles implements Serializable {
    private String depdroite;
    private String depgauche;
    private String rotdroite;
    private String rotgauche;
    private String acceleration;

    public String getDepdroite() {
        return depdroite;
    }

    public void setDepdroite(String depdroite) {
        this.depdroite = depdroite;
    }

    public String getDepgauche() {
        return depgauche;
    }

    public void setDepgauche(String depgauche) {
        this.depgauche = depgauche;
    }

    public String getRotdroite() {
        return rotdroite;
    }

    public void setRotdroite(String rotdroite) {
        this.rotdroite = rotdroite;
    }

    public String getRotgauche() {
        return rotgauche;
    }

    public void setRotgauche(String rotgauche) {
        this.rotgauche = rotgauche;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }
}
