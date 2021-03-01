package com.example.roomnba.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Jugador;
import com.example.roomnba.Entities.Relations.EquipoJugadores;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface JugadorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertArrayJugadores(ArrayList<Jugador> arrayE);

    @Query("SELECT * FROM jugadores")
    public List<Jugador> getJugadores();

    @Transaction
    @Query("SELECT * FROM equipos")
    public List<EquipoJugadores> getJugadoresEquipos();

    @Transaction
    @Query("SELECT * FROM equipos WHERE idEquipo = :idEquipo")
    public EquipoJugadores getJugadoresEquipos(int idEquipo);

}
