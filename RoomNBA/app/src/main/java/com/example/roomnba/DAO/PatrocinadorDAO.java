package com.example.roomnba.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomnba.Entities.Patrocinador;
import com.example.roomnba.Entities.Relations.EquipoPatrocinadores;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PatrocinadorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertArrayPatrocinadores(ArrayList<Patrocinador> arrayP);

    @Query("SELECT * FROM patrocinadores")
    public List<Patrocinador> getEquipoPatrocinadores();

    @Transaction
    @Query("SELECT * FROM equipos")
    public List<EquipoPatrocinadores> getlistadoEquipoPatrocinadores();


}
