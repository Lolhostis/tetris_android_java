package fr.iut.dut2.tetris.application.controlleurs;

import android.app.Activity;
import android.content.Intent;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.MainWindow;

public class ConfirmationController {

    private final Activity context;
    private final Partie p;

    public ConfirmationController(Activity context, Partie p){
        this.context = context;
        this.p = p;
    }

    public void ConfirmationToMenu() {
        Intent intent = new Intent(context, MainWindow.class);
        intent.putExtra("Partie", p);

        p.getGrille().running = false;



        //Pour fermer toutes les fenetres
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        context.startActivity(intent);
    }

    public void ConfirmationToPause() {
        context.finish();
    }
}
