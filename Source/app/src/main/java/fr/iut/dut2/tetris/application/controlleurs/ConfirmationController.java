package fr.iut.dut2.tetris.application.controlleurs;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorEvent;
import android.util.Log;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.ConfirmationWindow;
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

        Log.d("ThreadGrille","Thread has stopped running, you have to restart it by using Thread.start() (" + getClass().getSimpleName() + ")" );
        p.getGrille().running = false;

        context.startActivity(intent);
    }

    public void ConfirmationToPause() {
        context.finish();
    }
}
