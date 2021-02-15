package iesnervion.fjmarquez.nbaroom.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import iesnervion.fjmarquez.nbaroom.R;

@Entity
public class Equipo {

    //Propiedades privadas
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "departamento")
    private String departamento;
    @ColumnInfo(name = "img")
    private int img;

    //Constructor
    public Equipo(){
        this.id = 0;
        this.departamento = "";
        this.img = R.drawable.nba;
    }

    /*
    public Equipo(int id, String departamento, int img){
        this.id = id;
        this.departamento = departamento;
        this.img = img;
    }
    */

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
