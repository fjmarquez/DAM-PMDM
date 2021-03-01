package com.example.roomnba.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.roomnba.Entities.Patrocinador;
import com.example.roomnba.Entities.Relations.EquiposPatrocinadoresCrossRef;

import java.util.ArrayList;

@Dao
public interface EquiposPatrocinadoresCrossRefDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertArrayEquiposPatrocinadores(ArrayList<EquiposPatrocinadoresCrossRef> arrayEP);

}
