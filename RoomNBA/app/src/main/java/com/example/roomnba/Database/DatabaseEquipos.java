package com.example.roomnba.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomnba.DAO.EquipoDAO;
import com.example.roomnba.DatosEquipos.DatosEquipos;
import com.example.roomnba.Entities.Equipo;

import java.util.concurrent.Executors;

@Database(entities = {Equipo.class}, version = 1)
public abstract class DatabaseEquipos extends RoomDatabase {

    public abstract EquipoDAO equipoDAO();

    private static DatabaseEquipos INSTANCE;



    public static DatabaseEquipos getDatabase(final Context context){

        RoomDatabase.Callback dbCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        DatabaseEquipos.getDatabase(context.getApplicationContext()).equipoDAO().insertArrayEquipo(DatosEquipos.getListadoEquipos());
                    }
                });

            }
        };

        if(INSTANCE == null) {
            synchronized (DatabaseEquipos.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseEquipos.class,
                            "EquiposNBA.db").addCallback(dbCallback).allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }






}
