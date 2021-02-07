package iesnervion.fjmarquez.crudfragments.Entities;

public class Equipo {

    //Atributos
    private String nombreEquipo;
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
}
