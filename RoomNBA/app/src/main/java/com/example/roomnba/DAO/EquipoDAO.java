package com.example.roomnba.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Relations.EquipoEstadio;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface EquipoDAO {

    //INSERTS

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertEquipo(Equipo e);

    //Eliminar uno de los dos, o insertListEquipo o insertArrayEquipo dependiendo de cual no necesite
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertListEquipo(List<Equipo> listE);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertArrayEquipo(ArrayList<Equipo> arrayE);

    //UPDATES

    @Update
    public void updateEquipo(Equipo e);

    @Update
    public void updateListEquipo(List<Equipo> listE);

    @Update void updateArrayEquipo(ArrayList<Equipo> arrayE);

    //DELETES

    @Delete
    public void deleteEquipo(Equipo e);

    @Delete
    public void deleteListEquipo(List<Equipo> listE);

    @Delete
    public void deleteArrayEquipo(ArrayList<Equipo> arrayE);

    //QUERYS

    @Query("SELECT * FROM equipos")
    public List<Equipo> getListEquipos();

    @Query("SELECT * FROM equipos WHERE idEquipo = :id")
    public Equipo getEquipoId(int id);

    @Transaction
    @Query("SELECT * FROM estadios WHERE id = :idEstadio")
    public EquipoEstadio getEquipoEstadio(int idEstadio);

    /*@Transaction
    @Query("SELECT * FROM jugadores WHERE idEquipoJugador = :idEquipo")
    public List<Jugador> getJugadoresEquipo(int idEquipo);*/





}
