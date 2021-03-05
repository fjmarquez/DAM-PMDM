package com.example.examen2t.Entities.Relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.examen2t.Entities.Bug;
import com.example.examen2t.Entities.Programador;

import java.util.List;

public class ProgramadorBug {

    @Embedded
    public Programador programador;
    @Relation(
            parentColumn = "dni",
            entityColumn = "idProgramador"
    )
    public List<Bug> bugs;

}
