package com.example.roomnba.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patrocinadores")
public class Patrocinador {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idPatrocinador")
    private int id;
    @ColumnInfo(name = "empresa")
    private String empresa;

    public Patrocinador(String empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
