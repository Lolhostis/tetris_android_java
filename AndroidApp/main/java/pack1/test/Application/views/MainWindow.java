package pack1.test.Application.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pack1.test.Application.R;

public class MainWindow extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void MenuToOptions(View view) {
        Intent MenuOptions = new Intent(this, OptionsWindow.class);
        startActivity(MenuOptions);
    }

    public void MenuToLeaderboard(View view) {
        Intent MenuLeaderboard = new Intent(this, LeaderboardWindow.class);
        startActivity(MenuLeaderboard);
    }
}
