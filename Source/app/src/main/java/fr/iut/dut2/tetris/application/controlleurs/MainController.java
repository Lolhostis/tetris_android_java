package fr.iut.dut2.tetris.application.controlleurs;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.views.GrilleWindowActivity;
import fr.iut.dut2.tetris.application.views.LeaderboardWindow;
import fr.iut.dut2.tetris.application.views.MainWindow;
import fr.iut.dut2.tetris.application.views.OptionsWindow;

public class MainController {

    private final MainWindow context;
    private Partie p;

    private final ActivityResultLauncher<Intent> mStartForResult;

    public MainController(MainWindow context, Partie partie) {
        this.context = context;
        p = partie;

        mStartForResult = context.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent intent = result.getData();
                    if(intent != null){
                        p = intent.getParcelableExtra("Partie");
                        this.context.setPartie(p);
                    }
                });
    }

    public void MenuToOptions() {
        Intent MenuOptions = new Intent(context, OptionsWindow.class);
        MenuOptions.putExtra("Partie", p);

        mStartForResult.launch(MenuOptions);
    }

    public void MenuToLeaderboard() {
        Intent MenuLeaderboard = new Intent(context, LeaderboardWindow.class);
        MenuLeaderboard.putExtra("Partie", p);

        mStartForResult.launch(MenuLeaderboard);
    }

    public void MenuToGrille() {
        Intent MenuGrille = new Intent(context, GrilleWindowActivity.class);
        MenuGrille.putExtra("Partie", p);

        mStartForResult.launch(MenuGrille);
    }
}
