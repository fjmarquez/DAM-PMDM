package iesnervion.fjmarquez.spinnernba;

import android.content.Context;
import android.graphics.Color;
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
        /*TextView tv = convertView.findViewById(R.id.tvNameTeam);
        if (position == 0) {
            // Set the hint text color gray
            tv.setTextColor(Color.GRAY);
        }else {
            tv.setTextColor(Color.BLACK);
        }*/
        return initView(position, convertView, parent);
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0) {
            // Disable the first item from Spinner
            // First item will be use for hint
            return false;
        } else {
            return true;
        }
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row, parent, false);
        }else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row2, parent, false);
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
