package fr.iut.dut2.tetris.application.controlleurs;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.grille.Grille;
import fr.iut.dut2.tetris.application.model.src.classes.content.thread.Play;
import fr.iut.dut2.tetris.application.views.GrilleWindowActivity;
import fr.iut.dut2.tetris.application.views.MainWindow;

public class GameOverController {
    private final AppCompatActivity context;
    private Partie p;

    private final ActivityResultLauncher<Intent> mStartForResult;

    public GameOverController(AppCompatActivity context, Partie p){
        this.context = context;
        this.p = p;

        mStartForResult = context.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent intent = result.getData();

                    assert intent != null;
                    this.p = intent.getParcelableExtra("Partie");
                });
    }

    public void GameOverToGrille(){
        p.getGrille().running = false;

        Intent intent = new Intent(context.getApplicationContext(), GrilleWindowActivity.class);
        p.getLeaderboard().addScore(p.getPoints());
        p.setPoints(0);
        intent.putExtra("Partie",p);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        context.setResult(12, intent);
        context.startActivity(intent);

    }

    public void GameOverToMenu(){
        Intent intent = new Intent(context.getApplicationContext(), MainWindow.class);
        p.getLeaderboard().addScore(p.getPoints());
        p.setPoints(0);

        intent.putExtra("Partie",p);
        context.setResult(12, intent);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mStartForResult.launch(intent);
    }
}
