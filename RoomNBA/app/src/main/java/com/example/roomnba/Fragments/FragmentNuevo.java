package com.example.roomnba.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.R;
import com.example.roomnba.Viewmodels.VMGeneral;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNuevo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNuevo extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText mETNombreNuevoEquipo;
    private Button mBtnNuevoEquipo;
    private VMGeneral mViewModel;

    public FragmentNuevo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNuevo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNuevo newInstance(String param1, String param2) {
        FragmentNuevo fragment = new FragmentNuevo();
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
        View v = inflater.inflate(R.layout.fragment_nuevo, container, false);

        init(v);

        return v;
    }

    public void init(View v){
        mETNombreNuevoEquipo = (EditText) v.findViewById(R.id.etNombreEquipoNuevo);
        mBtnNuevoEquipo = (Button) v.findViewById(R.id.btnNuevoEquipo);
        mBtnNuevoEquipo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNuevoEquipo:
                String nombreEquipoNuevo = mETNombreNuevoEquipo.getText().toString();
                mViewModel.anadirEquipoListaEquipos(new Equipo(nombreEquipoNuevo, R.drawable.nba, 1));
                getActivity().onBackPressed();
                break;
        }
    }

}