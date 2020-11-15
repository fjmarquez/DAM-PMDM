package iesnervion.fjmarquez.spinnernba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TeamAdapter extends ArrayAdapter<Team> {

    public TeamAdapter(Context context, ArrayList<Team> teamList){
        super(context, 0, teamList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row, parent, false);
        }
        ImageView imgTeam = convertView.findViewById(R.id.imgTeam);
        TextView tvTeam = convertView.findViewById(R.id.tvNameTeam);

        Team t = getItem(position);
        if (t != null){
            imgTeam.setImageResource(t.getImgTeam());
            tvTeam.setText(t.getNameTeam());
        }


        return convertView;
    }


}
