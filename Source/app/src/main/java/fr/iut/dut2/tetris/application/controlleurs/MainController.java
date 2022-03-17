package fr.iut.dut2.tetris.application.controlleurs;

import android.content.Intent;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.GrilleWindowActivity;
import fr.iut.dut2.tetris.application.views.LeaderboardWindow;
import fr.iut.dut2.tetris.application.views.OptionsWindow;

public class MainController {

    private final AppCompatActivity context;
    private Partie p;

    private final int OPTIONS_RESULT_CODE = 10;
    private final int LEADERBOARD_RESULT_CODE = 11;

    private final ActivityResultLauncher<Intent> mStartForResult;

    public MainController(AppCompatActivity context, Partie partie){
        this.context = context;
        p = partie;

        mStartForResult = context.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == OPTIONS_RESULT_CODE){
                        Intent intent = result.getData();
                        if(intent != null){
                            p = intent.getParcelableExtra("Partie");
                        }
                    }
                    else if(result.getResultCode() == LEADERBOARD_RESULT_CODE){
                        Intent intent = result.getData();
                        if(intent != null){
                            p = intent.getParcelableExtra("Partie");
                        }
                    }

                });
    }

    public void MenuToOptions() {
        Intent MenuOptions = new Intent(context, OptionsWindow.class);
        MenuOptions.putExtra("Partie", p);

        mStartForResult.launch(MenuOptions);
    }

    public void MenuToLeaderboard(){
        Intent MenuLeaderboard = new Intent(context, LeaderboardWindow.class);
        MenuLeaderboard.putExtra("Partie", p);

        mStartForResult.launch(MenuLeaderboard);
    }

    public void MenuToGrille(){
        Intent MenuGrille = new Intent(context, GrilleWindowActivity.class);
        MenuGrille.putExtra("Partie", p);

        mStartForResult.launch(MenuGrille);
    }
}
