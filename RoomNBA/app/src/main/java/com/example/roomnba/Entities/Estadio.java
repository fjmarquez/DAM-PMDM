package com.example.roomnba.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "estadios")
public class Estadio {

    //Atributos

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="nombreEstadio")
    private String nombre;
    @ColumnInfo (name="capacidadEstadio")
    private int capacidad;
    @ColumnInfo (name="localizacionEstadio")
    private String localizacion;


    public Estadio(String nombre, Integer capacidad, String localizacion) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
