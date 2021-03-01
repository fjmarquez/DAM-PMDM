package com.example.roomnba.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Jugador;
import com.example.roomnba.R;

import java.util.ArrayList;

public class JugadoresAdapter extends RecyclerView.Adapter<JugadoresAdapter.RVJugadoresViewHolder>{

    private ArrayList<Jugador> listaJugadores;
    public JugadoresAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(JugadoresAdapter.OnItemClickListener listener){
        mListener = listener;
    }

    public JugadoresAdapter(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    @NonNull
    @Override
    public JugadoresAdapter.RVJugadoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewjugadores, parent, false);
        JugadoresAdapter.RVJugadoresViewHolder vh = new JugadoresAdapter.RVJugadoresViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull JugadoresAdapter.RVJugadoresViewHolder holder, int position) {
        Jugador jugadorActual = this.listaJugadores.get(position);

        holder.nombreJugador.setText(jugadorActual.getNombre());
        holder.apellidosJugador.setText(jugadorActual.getApellidos());

    }

    @Override
    public int getItemCount() {
        return this.listaJugadores.size();
    }

    public static class RVJugadoresViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreJugador;
        public TextView apellidosJugador;

        //Constructor
        public RVJugadoresViewHolder(@NonNull View itemView, final JugadoresAdapter.OnItemClickListener listener) {
            super(itemView);
            nombreJugador = itemView.findViewById(R.id.nombreJugador);
            apellidosJugador = itemView.findViewById(R.id.apellidosJugador);

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


        public TextView getNombreJugador() {
            return nombreJugador;
        }

        public void setNombreJugador(TextView nombreJugador) {
            this.nombreJugador = nombreJugador;
        }

        public TextView getApellidosJugador() {
            return apellidosJugador;
        }

        public void setApellidosJugador(TextView apellidosJugador) {
            this.apellidosJugador = apellidosJugador;
        }
    }

}
