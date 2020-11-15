package iesnervion.fjmarquez.actv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteTeamAdapter extends ArrayAdapter<team> {

    private List<team> teamListFull;

    public AutoCompleteTeamAdapter(@NonNull Context context, @NonNull List<team> teamList) {
        super(context, 0, teamList);
        teamListFull = new ArrayList<>(teamList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return teamFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.row, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.tvNameTeam);
        ImageView imageViewTeam = convertView.findViewById(R.id.imgTeam);

        team team = getItem(position);

        if(team != null){
            textViewName.setText(team.getNameTeam());
            imageViewTeam.setImageResource(team.getImgTeam());
        }

        return convertView;
    }

    private Filter teamFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<team> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                suggestions.addAll(teamListFull);
            } else if (constraint.length() > 2) {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (team t : teamListFull){
                    if (t.getNameTeam().toLowerCase().contains(filterPattern)){
                        suggestions.add(t);
                    }
                }
            }
            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();

        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((team) resultValue).getNameTeam();
        }
    };
}
