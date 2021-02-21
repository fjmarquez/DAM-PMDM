package com.example.roomnba.DAO;

import android.media.audiofx.DynamicsProcessing;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomnba.Entities.Equipo;

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

    @Query("SELECT * from equipos")
    public List<Equipo> getListEquipos();

    @Query("SELECT id, nombreEquipo, imgEquipo FROM equipos WHERE id = :id")
    public Equipo getEquipoId(int id);


}
