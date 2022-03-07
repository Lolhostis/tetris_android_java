package fr.iut.dut2.tetris.application.model.designers;

import android.graphics.Rect;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.List;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public interface Designer {
    public void dessinerGrille(@NonNull Partie p); //, Text Score)
    public void dessinerPiece(int p, List<PositionPiece> listeRectanglesPiece);
}
