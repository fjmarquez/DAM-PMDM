package com.example.roomnba.Entities.Relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Patrocinador;

import java.util.List;

public class EquipoPatrocinadores {

    @Embedded public Equipo equipo;
    @Relation(
            parentColumn = "idEquipo",
            entityColumn = "idPatrocinador",
            associateBy = @Junction(EquiposPatrocinadoresCrossRef.class)
    )
    public List<Patrocinador> patrocinadores;

}
