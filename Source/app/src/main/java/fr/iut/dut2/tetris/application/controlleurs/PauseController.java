package fr.iut.dut2.tetris.application.controlleurs;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.ConfirmationWindow;

public class PauseController {

    private Activity context;
    private Partie p;

    public PauseController(Activity context, Partie p){
        this.context = context;
        this.p = p;
    }


    public void PauseToGrille(){
        Log.d("Grille", "Grille unpaused");
        context.finish();
    }

    public void PauseToConfirmation(){
        Intent intent = new Intent(context, ConfirmationWindow.class);
        intent.putExtra("Partie", p);


        context.startActivity(intent);
    }

}
