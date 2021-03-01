package com.example.roomnba.Datos;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Estadio;
import com.example.roomnba.R;

import java.util.ArrayList;

public class DatosEstadios {

    public DatosEstadios() {
    }

    public static ArrayList<Estadio> getListadoEstadios() {

        //Datos para crear estadios
        ArrayList<Estadio> listadoEstadios = new ArrayList<Estadio>();
        String[] estadiosNBA = {"Estadio Atlanta", "Estadio Boston", "Estadio Brooklyn", "Estadio LA Lakers", "Estadio LA Clippers", "Estadio Miami"};
        int[] capacidadEstadiosNBA = {1500, 1800, 1200, 3500, 1800, 2700};
        String[] localizacionEstadiosNBA = {"Atlanta EEUU", "Boston EEUU", "Brooklyn EEUU", "Los Angeles EEUU", "Los Angeles EEUU", "Miami EEUU"};

        for(int i = 0; i < estadiosNBA.length; i++){

            listadoEstadios.add(new Estadio(estadiosNBA[i], capacidadEstadiosNBA[i], localizacionEstadiosNBA[i]));

        }

        return listadoEstadios;
    }

}
