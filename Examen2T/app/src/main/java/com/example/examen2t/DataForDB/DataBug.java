package com.example.examen2t.DataForDB;

import com.example.examen2t.Entities.Bug;
import com.example.examen2t.Entities.Programador;

import java.util.ArrayList;
import java.util.List;

public class DataBug {

    public static List<Bug> getListadoBugs() {

        //Datos para crear equipos
        ArrayList<Bug> listaBugs = new ArrayList<Bug>();
        int[] identificador = {1, 2, 3, 4};
        String[] prioridades = {"ALTA", "BAJA", "BAJA", "ALTA"};
        String[] dni = {"44778899p", "22556633w", "77441155a", "77441155a"};

        for(int i = 0; i < identificador.length; i++){

            listaBugs.add(new Bug(identificador[i], prioridades[i], dni[i]));

        }

        return listaBugs;
    }

}
