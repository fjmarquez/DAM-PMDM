package com.example.roomnba.Datos;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.R;

import java.util.ArrayList;

public class DatosEquipos {

    public DatosEquipos(){

    }

    public static ArrayList<Equipo> getListadoEquipos() {

        //Datos para crear equipos
        ArrayList<Equipo> listadoEquipos = new ArrayList<Equipo>();
        String[] equiposNBA = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "LA Lakers", "LA Clippers", "Miami Heat"};
        int[] imgEquiposNBA = {R.drawable.atlanta, R.drawable.boston, R.drawable.nets, R.drawable.lakers, R.drawable.clippers, R.drawable.miami};
        int[] estadios = {1, 2, 3, 4, 5, 6};

        for(int i = 0; i < equiposNBA.length; i++){

            listadoEquipos.add(new Equipo(equiposNBA[i], imgEquiposNBA[i], estadios[i]));

        }

        return listadoEquipos;
    }

}
