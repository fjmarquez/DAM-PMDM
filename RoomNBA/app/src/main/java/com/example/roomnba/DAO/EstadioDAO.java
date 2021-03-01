package com.example.roomnba.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Estadio;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EstadioDAO {

    //Inserts

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertEstadio(Estadio e);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertArrayEstadio(ArrayList<Estadio> eList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertListEstadio(List<Estadio> eList);

    //Updates

    @Update
    public void updateEstadio(Estadio e);

    @Update
    public void updateArrayEstadio(ArrayList<Estadio> eList);

    @Update
    public void updateListEstadio(List<Estadio> eList);

    //Deletes

    @Delete
    public void deleteEstadio(Estadio e);

    @Delete
    public void deleteArrayEstadio(ArrayList<Estadio> eList);

    @Delete
    public void deleteListEstadio(List<Estadio> eList);

    //QUERYS

    @Query("SELECT id, nombreEstadio, capacidadEstadio, localizacionEstadio FROM estadios")
    public List<Estadio> getListEstadios();

    @Query("SELECT id, nombreEstadio, capacidadEstadio, localizacionEstadio FROM estadios WHERE id = :id")
    public Estadio getEstadioId(int id);

}
