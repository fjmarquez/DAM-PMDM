package com.example.examen2t.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.examen2t.Entities.Bug;
import com.example.examen2t.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentInsertBug#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentInsertBug extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText etIdentificador;
    private EditText etIdProgramador;
    private RadioGroup rgPrioridad;
    private RadioButton rbAlta;
    private RadioButton rbBaja;
    private Button btnAceptar ;

    public fragmentInsertBug() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentInsertBug.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentInsertBug newInstance(String param1, String param2) {
        fragmentInsertBug fragment = new fragmentInsertBug();
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
        View v = inflater.inflate(R.layout.fragment_insert_bug, container, false);

        etIdentificador = (EditText) v.findViewById(R.id.etIdentificadorBug);
        etIdProgramador = (EditText) v.findViewById(R.id.etDNIProgramador);
        rgPrioridad = (RadioGroup) v.findViewById(R.id.rGroupPrioridad);
        rbAlta = (RadioButton) v.findViewById(R.id.rbAlta);
        rbBaja = (RadioButton) v.findViewById(R.id.rbBaja);
        btnAceptar = (Button) v.findViewById(R.id.btnInsertarBug);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInsertarBug:
                if(rgPrioridad.getCheckedRadioButtonId() == R.id.rbBaja){
                    Bug b = new Bug((int)etIdentificador.getText(), "BAJA", etIdProgramador.getText().toString());
                }else if(rgPrioridad.getCheckedRadioButtonId() == R.id.rbAlta){
                    Bug b = new Bug((int)etIdentificador.getText(), "ALTA", etIdProgramador.getText().toString());
                }

                etIdProgramador.setText("");
                etIdentificador.setText("");
                rgPrioridad.clearCheck();

                //Añadiria el bug a la bd mediatne el viewmodel
        }
    }
}