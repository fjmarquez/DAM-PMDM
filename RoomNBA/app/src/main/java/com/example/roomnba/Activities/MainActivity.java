package com.example.roomnba.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.roomnba.DAO.EquipoDAO;
import com.example.roomnba.Database.DatabaseEquipos;
import com.example.roomnba.DatosEquipos.DatosEquipos;
import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.Fragments.FragmentLista;
import com.example.roomnba.Fragments.FragmentNuevo;
import com.example.roomnba.R;
import com.example.roomnba.Viewmodels.VMGeneral;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseEquipos databaseEquipos;
    private EquipoDAO equipoDAO;

    private FragmentNuevo mFragmentNuevo;
    private FragmentLista mFragmentLista;

    private FragmentContainerView mContenedorGeneral;
    private Button mBtnNuevo, mBtnLista;

    private VMGeneral mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        //ArrayList<Equipo> listadoPrueba = mViewModel.getListaEquipos().getValue();

    }

    //Funcion que inicializa los componentes necesarios
    public void init(){

        mContenedorGeneral = findViewById(R.id.contenedorGeneral);
        mBtnNuevo = findViewById(R.id.btnNuevo);
        mBtnNuevo.setOnClickListener(this);
        mBtnLista = findViewById(R.id.btnLista);
        mBtnLista.setOnClickListener(this);

        mFragmentNuevo = new FragmentNuevo();
        mFragmentLista = new FragmentLista();
        mViewModel = new VMGeneral(this.getApplication());

        initFragment(mFragmentLista);

    }

    //Funcion que recibe un fragment y lo muestra en pantalla
    public void initFragment(Fragment mFragment){

        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.contenedorGeneral, mFragment)
                .addToBackStack(null)
                .commit();

    }

    //Eventos onClick
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLista:
                initFragment(mFragmentLista);
                break;
            case R.id.btnNuevo:
                initFragment(mFragmentNuevo);
                break;
        }

    }
}