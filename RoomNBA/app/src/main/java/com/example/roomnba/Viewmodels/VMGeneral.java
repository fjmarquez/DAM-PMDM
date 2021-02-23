package com.example.roomnba.Viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.roomnba.Database.DatabaseEquipos;
import com.example.roomnba.Entities.Equipo;

import java.util.ArrayList;

public class VMGeneral extends androidx.lifecycle.AndroidViewModel {

    //Atributos
    private MutableLiveData<ArrayList<Equipo>> listaEquipos = new MutableLiveData<ArrayList<Equipo>>();

    //Getters y Setters
    public MutableLiveData<ArrayList<Equipo>> getListaEquipos() {
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) DatabaseEquipos.getDatabase(getApplication().getApplicationContext()).equipoDAO().getListEquipos() ;
        listaEquipos.setValue(equipos);
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        /*this.listaEquipos.setValue(listaEquipos);*/
        DatabaseEquipos.getDatabase(getApplication().getApplicationContext()).equipoDAO().updateArrayEquipo(this.getListaEquipos().getValue());
    }

    public void anadirEquipoListaEquipos(Equipo equipo) {
        /*this.listaEquipos.getValue().add(equipo);*/
        DatabaseEquipos.getDatabase(getApplication().getApplicationContext()).equipoDAO().insertEquipo(equipo);
    }

    public void actualizarEquipoListaEquipos(Equipo equipo, int position){
        /*this.listaEquipos.getValue().get(position).setNombreEquipo(equipo.getNombreEquipo());
        this.listaEquipos.getValue().get(position).setImgEquipo(equipo.getImgEquipo());*/

        DatabaseEquipos.getDatabase(getApplication().getApplicationContext()).equipoDAO().updateEquipo(equipo);
    }

    public void eliminarEquipoListaEquipos(Equipo equipo){
        DatabaseEquipos.getDatabase(getApplication().getApplicationContext()).equipoDAO().deleteEquipo(equipo);
    }

    //Constructor
    public VMGeneral(@NonNull Application application) {
        super(application);

        ArrayList<Equipo> equipos = (ArrayList<Equipo>) DatabaseEquipos.getDatabase(application.getApplicationContext()).equipoDAO().getListEquipos() ;
        listaEquipos.setValue(equipos);

    }

}
