package com.example.examen2t.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.examen2t.Entities.Programador;
import com.example.examen2t.Entities.Relations.ProgramadorBug;

import java.util.List;

@Dao
public interface ProgramadorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProgramador(Programador p);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertListProgramador(List<Programador> listP);

    @Delete
    public void deleteProgramador(Programador p);

    @Transaction
    @Query("SELECT * FROM programadores")
    public List<ProgramadorBug> getProgramadorBugs();

    @Transaction
    @Query("SELECT * FROM programadores")
    public List<Programador> getProgramadores();

}
