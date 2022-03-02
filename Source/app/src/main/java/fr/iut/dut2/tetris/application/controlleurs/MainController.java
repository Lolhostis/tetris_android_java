package fr.iut.dut2.tetris.application.controlleurs;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.GrilleWindow;
import fr.iut.dut2.tetris.application.views.LeaderboardWindow;
import fr.iut.dut2.tetris.application.views.OptionsWindow;

public class MainController {

    private AppCompatActivity context;
    private Partie p;

    private final int OPTIONS_RESULT_CODE = 10;
    private final int LEADERBOARD_RESULT_CODE = 11;

    private ActivityResultLauncher<Intent> mStartForResult;

    public MainController(AppCompatActivity context, Partie partie){
        this.context = context;
        p = partie;

        mStartForResult = context.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == OPTIONS_RESULT_CODE){
                        Intent intent = result.getData();
                        if(intent != null){
                            Log.d("PartieTimeLine", "Got result from Options");
                            p = intent.getParcelableExtra("Partie");
                            Log.d("ParcelPartie",  "Difficulté reçue : " + p.getDifficulte().getDifficulte());
                        }
                    }
                    else if(result.getResultCode() == LEADERBOARD_RESULT_CODE){
                        Log.d("PartieTimeLine", "Got result from Leaderboard");
                        Intent intent = result.getData();
                        if(intent != null){
                            p = intent.getParcelableExtra("Partie");
                        }
                    }

                });
    }

    public void MenuToOptions(View view) {

        Intent MenuOptions = new Intent(context, OptionsWindow.class);
        MenuOptions.putExtra("Partie", p);

        mStartForResult.launch(MenuOptions);
    }

    public void MenuToLeaderboard(View view){
        Intent MenuLeaderboard = new Intent(context, LeaderboardWindow.class);
        MenuLeaderboard.putExtra("Partie", p);

        mStartForResult.launch(MenuLeaderboard);
    }

    public void MenuToGrille(View view){
        Intent MenuGrille = new Intent(context, GrilleWindow.class);
        context.startActivity(MenuGrille);
    }
}
