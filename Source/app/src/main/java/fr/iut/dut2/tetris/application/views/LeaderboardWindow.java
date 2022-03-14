package fr.iut.dut2.tetris.application.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.controlleurs.LeaderboardRecyclerAdapter;
import fr.iut.dut2.tetris.application.controlleurs.OptLeadController;
import fr.iut.dut2.tetris.application.model.src.classes.content.Partie;

public class LeaderboardWindow extends AppCompatActivity {

    private OptLeadController controller;
    private Partie p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_window);

        p = getIntent().getParcelableExtra("Partie");
        RecyclerView recyclerView = findViewById(R.id.Scores);
        LeaderboardRecyclerAdapter adapter = new LeaderboardRecyclerAdapter(p.getLeaderboard().getScores());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        controller = new OptLeadController(this, p);
    }

    public void LeaderBoardToMenu(View view) {
        controller.RetourAuMenu(view);
    }
}
