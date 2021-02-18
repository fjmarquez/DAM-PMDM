package com.example.roomnba.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Equipo {

    //Atributos
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo (name="nombreEquipo")
    private String nombreEquipo;
    @ColumnInfo (name="imgEquipo")
    private int imgEquipo;

    //Constructor
    public Equipo (String nombreEquipo, int imgEquipo){
        this.nombreEquipo = nombreEquipo;
        this.imgEquipo = imgEquipo;
    }

    //Getters
    public String getNombreEquipo(){
        return this.nombreEquipo;
    }

    public int getImgEquipo(){
        return this.imgEquipo;
    }

    //Setters
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void setImgEquipo(int imgEquipo) {
        this.imgEquipo = imgEquipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
