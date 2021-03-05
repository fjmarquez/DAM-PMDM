package com.example.examen2t.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "programadores")
public class Programador {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String dni;
    private String nombre;

    public Programador(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Programador() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
