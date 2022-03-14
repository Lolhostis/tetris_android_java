package fr.iut.dut2.tetris.application.controlleurs;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.iut.dut2.tetris.R;
import fr.iut.dut2.tetris.application.views.LeaderboardViewHolder;

public class LeaderboardRecyclerAdapter extends RecyclerView.Adapter<LeaderboardViewHolder> {
    private final List<Integer> scores;

    public LeaderboardRecyclerAdapter(List<Integer> scores){
        this.scores = scores;
        Log.d("LeaderboardTaille",scores.size() + "" );
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_viewholder,parent,false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        holder.score.setText((position + 1) + " - " + scores.get(position));
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }
}
