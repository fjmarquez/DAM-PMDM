package com.example.roomnba.DatosEquipos;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.R;

import java.util.ArrayList;

public class DatosEquipos {

    public DatosEquipos(){

    }

    public static ArrayList<Equipo> getListadoEquipos() {

        //Datos para crear equipos
        ArrayList<Equipo> listadoEquipos = new ArrayList<Equipo>();
        String[] equiposNBA = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets"};
        int[] imgEquiposNBA = {R.drawable.atlanta, R.drawable.boston, R.drawable.nets};

        for(int i = 0; i < equiposNBA.length; i++){

            listadoEquipos.add(new Equipo(equiposNBA[i], imgEquiposNBA[i]));

        }

        return listadoEquipos;
    }

    public static void setListadoEquipos(ArrayList<Equipo> listadoEquipos) {
        listadoEquipos = listadoEquipos;
    }
}
