package com.example.roomnba.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.R;

import java.util.ArrayList;

public class EquipoAdapter extends RecyclerView.Adapter<EquipoAdapter.RVEquiposViewHolder>{

    private ArrayList<Equipo> listaEquipos;
    public OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public EquipoAdapter(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    @NonNull
    @Override
    public RVEquiposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewrow, parent, false);
        RVEquiposViewHolder vh = new RVEquiposViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RVEquiposViewHolder holder, int position) {
        Equipo equipoActual = this.listaEquipos.get(position);

        holder.imgEquipo.setImageResource(equipoActual.getImgEquipo());
        holder.nombreEquipo.setText(equipoActual.getNombreEquipo());
    }

    @Override
    public int getItemCount() {
        return this.listaEquipos.size();
    }

    public static class RVEquiposViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgEquipo;
        public TextView nombreEquipo;

        //Constructor
        public RVEquiposViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imgEquipo = itemView.findViewById(R.id.imgEquipo);
            nombreEquipo = itemView.findViewById(R.id.nombreEquipo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        //Getters y Setters
        public ImageView getImgEquipo() {
            return imgEquipo;
        }

        public void setImgEquipo(ImageView imgEquipo) {
            this.imgEquipo = imgEquipo;
        }

        public TextView getNombreEquipo() {
            return nombreEquipo;
        }

        public void setNombreEquipo(TextView nombreEquipo) {
            this.nombreEquipo = nombreEquipo;
        }
    }

}