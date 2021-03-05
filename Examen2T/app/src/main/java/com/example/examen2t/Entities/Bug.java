package com.example.examen2t.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bugs")
public class Bug {

    @PrimaryKey()
    @NonNull
    private int identificador;
    private String prioridad;
    private String idProgramador;

    public Bug(int identificador, String prioridad, String idProgramador) {
        this.identificador = identificador;
        this.idProgramador = idProgramador;
        this.prioridad = prioridad;
    }

    public Bug(){

    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getIdProgramador() {
        return idProgramador;
    }

    public void setIdProgramador(String idProgramador) {
        this.idProgramador = idProgramador;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
