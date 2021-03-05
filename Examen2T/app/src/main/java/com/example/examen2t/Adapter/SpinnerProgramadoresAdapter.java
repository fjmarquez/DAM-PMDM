package com.example.examen2t.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.examen2t.Entities.Programador;
import com.example.examen2t.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerProgramadoresAdapter extends ArrayAdapter<Programador> {

    public SpinnerProgramadoresAdapter(Context context, List<Programador> listProgramadores){
        super(context, 0, listProgramadores);
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

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinnerrow, parent, false);

        mViewHolder.nombre = (TextView) convertView.findViewById(R.id.nombre);
        convertView.setTag(mViewHolder);

        Programador p = getItem(position);


        if (p != null){
            mViewHolder.nombre.setText(p.getNombre());
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
