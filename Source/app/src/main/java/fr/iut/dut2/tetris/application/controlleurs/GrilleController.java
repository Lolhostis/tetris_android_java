package fr.iut.dut2.tetris.application.controlleurs;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.views.PauseWindow;

public class GrilleController {

    private final Activity context;
    private final Partie p;

    public GrilleController(Activity context, Partie p){
        this.context = context;
        this.p = p;

    }

    public void MovementApplier(MovePiece move){
        p.getGrille().movePiece(move);
        Log.d("Movement",move.toString());
    }

    public void GrilleToPause() {
        Intent intent = new Intent(context, PauseWindow.class);
        Log.d("Grille", "Grille paused");
        intent.putExtra("Partie",p);

        context.startActivity(intent);
    }
}
