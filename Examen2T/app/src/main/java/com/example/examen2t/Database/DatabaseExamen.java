package com.example.examen2t.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.examen2t.DAO.BugDAO;
import com.example.examen2t.DAO.ProgramadorDAO;
import com.example.examen2t.DataForDB.DataBug;
import com.example.examen2t.DataForDB.DataProgramador;
import com.example.examen2t.Entities.Bug;
import com.example.examen2t.Entities.Programador;

import java.util.concurrent.Executors;


@Database(entities = {Programador.class, Bug.class}, version = 2)
public abstract class DatabaseExamen extends RoomDatabase {

    public abstract BugDAO bugDAO();

    public abstract ProgramadorDAO programadorDAO();

    private static DatabaseExamen INSTANCE;

    public static DatabaseExamen getDatabase(final Context context){

        RoomDatabase.Callback dbCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        //Poblar base de datos

                        DatabaseExamen.getDatabase(context.getApplicationContext()).programadorDAO().insertListProgramador(DataProgramador.getListadoProgramadores());
                        DatabaseExamen.getDatabase(context.getApplicationContext()).bugDAO().insertListBug(DataBug.getListadoBugs());

                    }
                });

            }
        };

        if(INSTANCE == null) {
            synchronized (DatabaseExamen.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseExamen.class,
                            "examen.db").addCallback(dbCallback).allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;

    }

}
