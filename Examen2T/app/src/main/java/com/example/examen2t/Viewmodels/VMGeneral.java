package com.example.examen2t.Viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;

import com.example.examen2t.DataForDB.DataBug;
import com.example.examen2t.Database.DatabaseExamen;
import com.example.examen2t.Entities.Bug;
import com.example.examen2t.Entities.Programador;
import com.example.examen2t.Entities.Relations.ProgramadorBug;

import java.util.ArrayList;
import java.util.List;

import static com.example.examen2t.Database.DatabaseExamen.getDatabase;

public class VMGeneral extends androidx.lifecycle.AndroidViewModel {

    //Constructor

    public VMGeneral(@NonNull Application application){

        super(application);
        this.btnSelecionado.setValue(0);
        List<Programador> listaprogramadores = DatabaseExamen.getDatabase(getApplication().getApplicationContext()).programadorDAO().getProgramadores();
        programadores.setValue(listaprogramadores);

        List<Bug> listabugs = DatabaseExamen.getDatabase(getApplication().getApplicationContext()).bugDAO().getBugs();
        bugs.setValue(listabugs);
    }

    //Boton seleccionado

    private MutableLiveData<Integer> btnSelecionado = new MutableLiveData<Integer>();;

    public MutableLiveData<Integer> getBtnSelecionado() {
        return btnSelecionado;
    }

    public void setBtnSelecionado(Integer btnSelecionado) {
        this.btnSelecionado.setValue(btnSelecionado);
    }

    //Programador

    private MutableLiveData<List<Programador>> programadores = new MutableLiveData<List<Programador>>();

    public MutableLiveData<List<Programador>> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(MutableLiveData<List<Programador>> programadores) {
        this.programadores = programadores;
    }

    //Bug

    public void setBtnSelecionado(MutableLiveData<Integer> btnSelecionado) {
        this.btnSelecionado = btnSelecionado;
    }

    public MutableLiveData<List<Bug>> getBugs() {
        return bugs;
    }

    public void setBugs(MutableLiveData<List<Bug>> bugs) {
        this.bugs = bugs;
    }

    private MutableLiveData<List<Bug>> bugs = new MutableLiveData<List<Bug>>();

    public MutableLiveData<List<Bug>> getBugPorDNI(String dni){
        MutableLiveData<List<Bug>> bugsPorDNI = new MutableLiveData<List<Bug>>();
        bugsPorDNI.setValue(DatabaseExamen.getDatabase(getApplication().getApplicationContext()).bugDAO().getBugsPorDNI(dni));
        return bugsPorDNI;
    }



}
