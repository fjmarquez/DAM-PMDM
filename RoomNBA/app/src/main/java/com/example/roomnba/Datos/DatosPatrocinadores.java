package com.example.roomnba.Datos;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Patrocinador;
import com.example.roomnba.Entities.Relations.EquiposPatrocinadoresCrossRef;
import com.example.roomnba.R;

import java.util.ArrayList;

public class DatosPatrocinadores {

    public DatosPatrocinadores() {

    }

    public static ArrayList<Patrocinador> getListadoPatrocinadores() {

        //Datos para crear patrocinadores
        ArrayList<Patrocinador> listadoPatrocinadores = new ArrayList<Patrocinador>();
        String[] patrocinadores = {"Coca-Cola", "Pepsi"};


        for(int i = 0; i < patrocinadores.length; i++){

            listadoPatrocinadores.add(new Patrocinador(patrocinadores[i]));

        }

        return listadoPatrocinadores;
    }

    public static ArrayList<EquiposPatrocinadoresCrossRef> getListadoEquiposPatrocinadores() {

        //Datos para crear patrocinadores
        ArrayList<EquiposPatrocinadoresCrossRef> listadoEquiposPatrocinadores = new ArrayList<EquiposPatrocinadoresCrossRef>();
        int[] patrocinadores = { 1, 2, 1, 2, 1, 2, 1};
        int[] equipos = { 1, 2, 3, 4, 5, 6, 6 };


        for(int i = 0; i < patrocinadores.length; i++){

            listadoEquiposPatrocinadores.add(new EquiposPatrocinadoresCrossRef(equipos[i], patrocinadores[i]));

        }

        return listadoEquiposPatrocinadores;
    }

}
