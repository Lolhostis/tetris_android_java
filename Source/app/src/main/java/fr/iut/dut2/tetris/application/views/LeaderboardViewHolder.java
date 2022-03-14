package fr.iut.dut2.tetris.application.views;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut.dut2.tetris.R;

public class LeaderboardViewHolder extends RecyclerView.ViewHolder {

    public TextView score;

    public LeaderboardViewHolder(@NonNull View itemView) {
        super(itemView);

        score = itemView.findViewById(R.id.UnScore);
    }
}
