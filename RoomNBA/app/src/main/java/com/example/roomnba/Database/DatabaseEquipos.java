package com.example.roomnba.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomnba.DAO.EquipoDAO;
import com.example.roomnba.DAO.EquiposPatrocinadoresCrossRefDAO;
import com.example.roomnba.DAO.EstadioDAO;
import com.example.roomnba.DAO.JugadorDAO;
import com.example.roomnba.DAO.PatrocinadorDAO;
import com.example.roomnba.Datos.DatosEquipos;
import com.example.roomnba.Datos.DatosEstadios;
import com.example.roomnba.Datos.DatosJugadores;
import com.example.roomnba.Datos.DatosPatrocinadores;
import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Entities.Estadio;
import com.example.roomnba.Entities.Jugador;
import com.example.roomnba.Entities.Patrocinador;
import com.example.roomnba.Entities.Relations.EquiposPatrocinadoresCrossRef;

import java.util.concurrent.Executors;

@Database(entities = {Equipo.class, Estadio.class, Jugador.class, Patrocinador.class, EquiposPatrocinadoresCrossRef.class}, version = 9)
public abstract class DatabaseEquipos extends RoomDatabase {

    public abstract EquipoDAO equipoDAO();

    public abstract EstadioDAO estadioDAO();

    public abstract JugadorDAO jugadorDAO();

    public abstract PatrocinadorDAO patrocinadorDAO();

    public abstract EquiposPatrocinadoresCrossRefDAO equiposPatrocinadoresCrossRefDAO();

    private static DatabaseEquipos INSTANCE;



    public static DatabaseEquipos getDatabase(final Context context){

        RoomDatabase.Callback dbCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        DatabaseEquipos.getDatabase(context.getApplicationContext()).patrocinadorDAO().insertArrayPatrocinadores(DatosPatrocinadores.getListadoPatrocinadores());
                        DatabaseEquipos.getDatabase(context.getApplicationContext()).equipoDAO().insertArrayEquipo(DatosEquipos.getListadoEquipos());
                        DatabaseEquipos.getDatabase(context.getApplicationContext()).equiposPatrocinadoresCrossRefDAO().insertArrayEquiposPatrocinadores(DatosPatrocinadores.getListadoEquiposPatrocinadores());
                        DatabaseEquipos.getDatabase(context.getApplicationContext()).estadioDAO().insertArrayEstadio(DatosEstadios.getListadoEstadios());
                        DatabaseEquipos.getDatabase(context.getApplicationContext()).jugadorDAO().insertArrayJugadores(DatosJugadores.getListadoJugadores());
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
