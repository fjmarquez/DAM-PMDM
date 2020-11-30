package iesnervion.fjmarquez.intent4;

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

public class UbicacionAdapter extends ArrayAdapter<Ubicacion> {

    public UbicacionAdapter(Context context, ArrayList<Ubicacion> teamList){
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
        ViewHolder mViewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);

        mViewHolder.txtUbicacion = (TextView) convertView.findViewById(R.id.txtUbicacion);
        convertView.setTag(mViewHolder);

        Ubicacion u = getItem(position);

        if (position == 0) {
            // Set the hint text color gray
            mViewHolder.txtUbicacion.setTextColor(Color.LTGRAY);
        }else {
            mViewHolder.txtUbicacion.setTextColor(Color.BLACK);
        }

        if (u != null){
            mViewHolder.txtUbicacion.setText(u.getUbicacion());
        }


        return convertView;
    }

    static class ViewHolder {
        TextView txtUbicacion;

        public TextView getTxtEquipo() {
            return txtUbicacion;
        }
    }
}
