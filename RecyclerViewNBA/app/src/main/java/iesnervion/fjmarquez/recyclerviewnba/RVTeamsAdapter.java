package iesnervion.fjmarquez.recyclerviewnba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVTeamsAdapter extends RecyclerView.Adapter<RVTeamsAdapter.RVTeamsViewHolder> {

    private ArrayList<Team> teamsList;

    public RVTeamsAdapter(ArrayList<Team> teamsList) {
        this.teamsList = teamsList;
    }

    @NonNull
    @Override
    public RVTeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_items, parent, false);
        RVTeamsViewHolder vh = new RVTeamsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RVTeamsViewHolder holder, int position) {
        Team currentTeam = this.teamsList.get(position);

        holder.imgTeam.setImageResource(currentTeam.getImgTeam());
        holder.nameTeam.setText(currentTeam.getNameTeam());
    }

    @Override
    public int getItemCount() {
        return this.teamsList.size();
    }

    public static class RVTeamsViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgTeam;
        public TextView nameTeam;

        public RVTeamsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTeam = itemView.findViewById(R.id.imgTeam);
            nameTeam = itemView.findViewById(R.id.nameTeam);
        }
    }
}
