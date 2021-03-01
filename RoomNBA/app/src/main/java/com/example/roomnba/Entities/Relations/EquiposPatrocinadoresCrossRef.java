package com.example.roomnba.Entities.Relations;

import androidx.room.Entity;

@Entity(primaryKeys = {"idEquipo", "idPatrocinador"})
public class EquiposPatrocinadoresCrossRef {

    public int idEquipo;
    public int idPatrocinador;

    public EquiposPatrocinadoresCrossRef(int idEquipo, int idPatrocinador) {
        this.idEquipo = idEquipo;
        this.idPatrocinador = idPatrocinador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }
}
