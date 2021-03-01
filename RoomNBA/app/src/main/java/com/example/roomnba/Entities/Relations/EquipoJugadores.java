package com.example.roomnba.Entities.Relations;

import android.media.audiofx.DynamicsProcessing;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Jugador;

import java.util.List;

public class EquipoJugadores {

    @Embedded public Equipo equipo;
    @Relation(
            parentColumn = "idEquipo",
            entityColumn = "idEquipoJugador"
    )
    public List<Jugador> jugadores;

}
