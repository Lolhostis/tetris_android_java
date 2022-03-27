package fr.iut.dut2.tetris.application.controlleurs;

import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;
import fr.iut.dut2.tetris.application.model.src.classes.content.enums.MovePiece;
import fr.iut.dut2.tetris.application.views.GameOverWindow;
import fr.iut.dut2.tetris.application.views.PauseWindow;

public class GrilleController {

    private final AppCompatActivity context;
    private Partie p;

    private final ActivityResultLauncher<Intent> mStartForResult;

    public GrilleController(AppCompatActivity context, Partie p){
        this.context = context;
        this.p = p;

        mStartForResult = context.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent intent = result.getData();

                    assert intent != null;
                    this.p = intent.getParcelableExtra("Partie");
                });
    }

    public void MovementApplier(MovePiece move){
        if(p.getGrille().running){
            p.getGrille().movePiece(move);
        }
    }

    public void GrilleToPause() {
        Intent intent = new Intent(context, PauseWindow.class);
        intent.putExtra("Partie",p);

        context.startActivity(intent);
    }

    public void GameOver() {

        p.getGrille().running = false;
        Intent intent = new Intent(context, GameOverWindow.class);

        intent.putExtra("Partie",p);

        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mStartForResult.launch(intent);
    }
}
