package com.example.examen2t.DataForDB;

import com.example.examen2t.Entities.Programador;

import java.util.ArrayList;
import java.util.List;

public class DataProgramador {

    public static List<Programador> getListadoProgramadores() {

        //Datos para crear equipos
        ArrayList<Programador> listaProgramadores = new ArrayList<Programador>();
        String[] nombres = {"Javier", "Manuel", "Fernando"};
        String[] dni = {"44778899p", "22556633w", "77441155a"};

        for(int i = 0; i < nombres.length; i++){

            listaProgramadores.add(new Programador(nombres[i], dni[i]));

        }

        return listaProgramadores;
    }

}
