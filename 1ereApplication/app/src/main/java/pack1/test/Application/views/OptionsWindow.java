package pack1.test.Application.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pack1.test.Application.R;

public class OptionsWindow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_window);
    }

    public void OptionsToMenu(View view) {
        finish();
    }
}
