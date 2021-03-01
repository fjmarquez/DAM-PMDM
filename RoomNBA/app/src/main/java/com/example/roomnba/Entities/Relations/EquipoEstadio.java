package com.example.roomnba.Entities.Relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Estadio;

public class EquipoEstadio {

    @Embedded
    public Estadio estadio;
    @Relation(
            parentColumn = "id",
            entityColumn = "idEstadio"
    )
    public Equipo equipo;
}
