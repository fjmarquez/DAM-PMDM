package com.example.examen2t.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.examen2t.Entities.Bug;
import com.example.examen2t.Entities.Relations.ProgramadorBug;

import java.util.List;

@Dao
public interface BugDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBug(Bug b);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertListBug(List<Bug> lBug);

    @Delete
    public void deleteBug(Bug b);

    @Transaction
    @Query("SELECT * FROM bugs")
    public List<Bug> getBugs();

    @Transaction
    @Query("SELECT * FROM bugs WHERE idProgramador = :dni")
    public List<Bug> getBugsPorDNI(String dni);


}
