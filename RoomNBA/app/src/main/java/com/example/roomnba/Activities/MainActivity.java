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

        ArrayList<Equipo> listado = DatosEquipos.getListadoEquipos();



        ArrayList<Equipo> listaPrueba = (ArrayList<Equipo>) DatabaseEquipos.getDatabase(this.getApplicationContext()).equipoDAO().getListEquipos() ;

    }
}