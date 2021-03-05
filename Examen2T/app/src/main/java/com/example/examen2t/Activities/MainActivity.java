package com.example.examen2t.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.examen2t.Fragments.fragmentInsertBug;
import com.example.examen2t.Fragments.fragmentInsertProg;
import com.example.examen2t.Fragments.fragmentListado;
import com.example.examen2t.Fragments.fragmentOpciones;
import com.example.examen2t.R;
import com.example.examen2t.Viewmodels.VMGeneral;

public class MainActivity extends AppCompatActivity {

    private fragmentOpciones fOpciones = new fragmentOpciones();
    private fragmentInsertProg fInsertProg = new fragmentInsertProg();
    private fragmentListado fListado = new fragmentListado();
    private fragmentInsertBug fInsertBug = new fragmentInsertBug();

    private VMGeneral mViewmodel;

    final Observer<Integer> btnObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer integer) {

            if(mViewmodel.getBtnSelecionado().getValue().intValue() == 1){

                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentCInsert, fInsertBug).addToBackStack(null).commit();

            }else if(mViewmodel.getBtnSelecionado().getValue().intValue() == 2){

                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentCInsert, fInsertProg).addToBackStack(null).commit();

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewmodel = new ViewModelProvider(this).get(VMGeneral.class);
        mViewmodel.getBtnSelecionado().observe(this, btnObserver);

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentCOpciones, fOpciones).addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentCInsert, fInsertProg).addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentCListado, fListado).addToBackStack(null).commit();

    }
}