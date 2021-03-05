package com.example.examen2t.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.examen2t.Entities.Programador;
import com.example.examen2t.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentInsertProg#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentInsertProg extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText etNombre;
    private EditText etDNI;
    private Button btnAceptar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentInsertProg() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentInsertProg.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentInsertProg newInstance(String param1, String param2) {
        fragmentInsertProg fragment = new fragmentInsertProg();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_insert_prog, container, false);

        etDNI = (EditText) v.findViewById(R.id.etDNIProgramador);
        etNombre = (EditText) v.findViewById(R.id.etNombreProgramador);
        btnAceptar = (Button) v.findViewById(R.id.btnInsertarProgramador);
        btnAceptar.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInsertarProgramador:
                Programador p = new Programador(etNombre.getText().toString(), etDNI.getText().toString());
                etNombre.setText("");
                etDNI.setText("");
                //Llamaria al dao a traves del vm y añadiria el programdor a la bd

        }
    }
}