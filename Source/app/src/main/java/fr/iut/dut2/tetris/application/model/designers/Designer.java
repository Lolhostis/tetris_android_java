package fr.iut.dut2.tetris.application.model.designers;

import androidx.annotation.NonNull;

import java.util.List;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public interface Designer {
    public void dessinerGrille(@NonNull Partie p); //, Text Score)

    public void changePaintColor(int p);
}
