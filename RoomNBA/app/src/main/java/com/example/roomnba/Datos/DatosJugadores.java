package com.example.roomnba.Datos;

import com.example.roomnba.Entities.Jugador;

import java.util.ArrayList;

public class DatosJugadores {

    public DatosJugadores() {
    }

    public static ArrayList<Jugador> getListadoJugadores() {

        //Datos para crear jugadores

        ArrayList<Jugador> listadoJugadores = new ArrayList<Jugador>();

        String[] nombresJugadores = { "Trae", "Rajon", "Jayson", "Kemba", "James", "Kevin", "Lebron", "Anthony", "Kawhi", "Paul", "Jimmy", "Tyler" };
        String[] apellidosJugadores = { "Young", "Rondo", "Tatum", "Walker", "Harden", "Durant", "James", "Davis", "Leonard", "George", "Butler", "Herro" };
        int[] dorsalesJugadores = { 11, 7, 0, 8, 13, 7, 23, 3, 2, 13, 22, 14 };
        double[] alturaJugadores = { 1.85, 1.85, 2.03, 1.83, 1.96, 2.08, 2.06, 2.08, 2.01, 2.03, 2.01, 1.96 };
        int[] equipoJugadores = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };

        for(int i = 0; i < nombresJugadores.length; i++){

            listadoJugadores.add(new Jugador(nombresJugadores[i], apellidosJugadores[i], dorsalesJugadores[i], alturaJugadores[i], equipoJugadores[i]));

        }

        return listadoJugadores;

    }

}
