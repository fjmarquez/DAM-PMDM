package com.example.roomnba.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;

import com.example.roomnba.DAO.EquipoDAO;
import com.example.roomnba.Database.DatabaseEquipos;
import com.example.roomnba.DatosEquipos.DatosEquipos;
import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.R;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private DatabaseEquipos databaseEquipos;
    private EquipoDAO equipoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RoomDatabase.Callback dbCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        DatabaseEquipos.getDatabase(getApplicationContext()).equipoDAO().insertArrayEquipo(DatosEquipos.getListadoEquipos());
                    }
                });

            }
        };

        ArrayList<Equipo> listaPrueba = (ArrayList<Equipo>) equipoDAO.getListEquipos() ;

    }
}