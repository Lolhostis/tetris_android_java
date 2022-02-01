package pack1.test.Application.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pack1.test.Application.R;

public class LeaderboardWindow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_window);
    }

    public void LeaderBoardToMenu(View view) {
        finish();
    }
}
