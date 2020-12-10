package iesnervion.fjmarquez.repasoexamenpmdm;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<cancion> {

    public SpinnerAdapter(Context context, ArrayList<cancion> listCancion){
        super(context, 0, listCancion);
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

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row, parent, false);

        mViewHolder.nombre = (TextView) convertView.findViewById(R.id.nombre);
        convertView.setTag(mViewHolder);

        cancion c = getItem(position);

        if (position == 0) {
            // Set the hint text color gray
            mViewHolder.nombre.setTextColor(Color.LTGRAY);
        }else {
            mViewHolder.nombre.setTextColor(Color.BLACK);
        }

        if (c != null){
            mViewHolder.nombre.setText(c.getNombre());
        }

        return convertView;
    }


    //Viewholder
    static class ViewHolder{
        TextView nombre;

        public TextView getNombre() {
            return nombre;
        }

        public TextView setNombre() {
            return nombre;
        }
    }

}


