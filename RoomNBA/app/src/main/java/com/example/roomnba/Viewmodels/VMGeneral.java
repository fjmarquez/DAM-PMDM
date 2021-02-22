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
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos.setValue(listaEquipos);
        DatabaseEquipos.getDatabase(getApplication().getApplicationContext()).equipoDAO().updateArrayEquipo(this.getListaEquipos().getValue());
    }

    public void setListaEquipos(Equipo equipo) {
        this.listaEquipos.getValue().add(equipo);
        DatabaseEquipos.getDatabase(getApplication().getApplicationContext()).equipoDAO().updateEquipo(equipo);
    }

    //Constructor
    public VMGeneral(@NonNull Application application) {
        super(application);

        ArrayList<Equipo> equipos = (ArrayList<Equipo>) DatabaseEquipos.getDatabase(application.getApplicationContext()).equipoDAO().getListEquipos() ;
        listaEquipos.setValue(equipos);

    }

}
