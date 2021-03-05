package com.example.examen2t.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.examen2t.Adapter.SpinnerProgramadoresAdapter;
import com.example.examen2t.Entities.Bug;
import com.example.examen2t.Entities.Programador;
import com.example.examen2t.R;
import com.example.examen2t.Viewmodels.VMGeneral;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentListado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentListado extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private VMGeneral mViewModel;
    private RadioGroup rgPrioridad;
    private RadioButton rbAlta;
    private RadioButton rbBaja;
    private RadioButton rbTodas;
    private Spinner spinnerProgramadores;
    private SpinnerProgramadoresAdapter spinnerAdapter;

    private List<Programador> listaProgramadores;
    private List<Bug> listaBugs;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentListado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentListado.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentListado newInstance(String param1, String param2) {
        fragmentListado fragment = new fragmentListado();
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
        mViewModel = new ViewModelProvider(getActivity()).get(VMGeneral.class);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listado, container, false);

        rgPrioridad = (RadioGroup) v.findViewById(R.id.rGroupPrioridad);
        rbAlta = (RadioButton) v.findViewById(R.id.rbAlta);
        rbBaja = (RadioButton) v.findViewById(R.id.rbBaja);
        rbTodas = (RadioButton) v.findViewById(R.id.rbTodos);
        spinnerProgramadores = (Spinner) v.findViewById(R.id.spinnerProgramadores);

        spinnerAction();

        rgAction();

        return v;
    }

    public void spinnerAction(){
        listaProgramadores = mViewModel.getProgramadores().getValue();
        spinnerAdapter = new SpinnerProgramadoresAdapter(getActivity().getApplicationContext(), listaProgramadores);
        spinnerProgramadores.setAdapter(spinnerAdapter);
        spinnerProgramadores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Programador p = listaProgramadores.get(position);
                listaBugs = mViewModel.getBugPorDNI(p.getDni()).getValue();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void  rgAction(){
        rgPrioridad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rgPrioridad.getCheckedRadioButtonId() == R.id.rbBaja){

                }else if(rgPrioridad.getCheckedRadioButtonId() == R.id.rbAlta){

                }else{

                }

            }
        });
    }

}

