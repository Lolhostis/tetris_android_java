package fr.iut.dut2.tetris.application.controlleurs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.MainWindow;

public class OptLeadController {

    private final Activity context;
    private final Partie p;

    private final int OPTIONS_RESULT_MENU_CODE = 10;
    private final int LEADERBOARD_RESULT_MENU_CODE = 11;

    public OptLeadController(Activity context, Partie partie){
        this.context = context;
        p = partie;
    }

    public void RetourAuMenu(View view){
        Intent intent = new Intent(context, MainWindow.class);
        intent.putExtra("Partie", p);

        if(context.getClass().getSimpleName().equals("OptionsWindow")){
            context.setResult(OPTIONS_RESULT_MENU_CODE, intent);
        }
        else if(context.getClass().getSimpleName().equals("LeaderboardWindow")){
            context.setResult(LEADERBOARD_RESULT_MENU_CODE, intent);
        }
        context.finish();
    }
}
