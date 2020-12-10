package iesnervion.fjmarquez.repasoexamenpmdm;

import android.os.Parcel;
import android.os.Parcelable;

public class cancion implements Parcelable {

    private int id;
    private String nombre;
    private String autor;
    private String genero;

    public cancion(int id, String nombre, String autor, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    public cancion(){
        this.id = 0;
        this.nombre = "";
        this.autor = "";
        this.genero = "";
    }

    public cancion (Parcel in){
        readFromParcel(in);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public static final Parcelable.Creator<cancion> CREATOR = new Parcelable.Creator<cancion>(){
        public cancion createFromParcel(Parcel in){
            return new cancion(in);
        }

        @Override
        public cancion[] newArray(int size) {
            return new cancion[size];
        }
    };



    private void readFromParcel(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        autor = in.readString();
        genero = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(autor);
        dest.writeString(genero);
    }
}
