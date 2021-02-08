package iesnervion.fjmarquez.crudfragments.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import iesnervion.fjmarquez.crudfragments.Entities.Equipo;
import iesnervion.fjmarquez.crudfragments.R;
import iesnervion.fjmarquez.crudfragments.ViewModels.VMGeneral;

public class FragmentBorrar extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText mETPositionBorrarEquipo;
    private Button mBtnBorrarEquipo;
    private VMGeneral mViewModel;

    public FragmentBorrar() {
        // Required empty public constructor
    }

    public static FragmentBorrar newInstance(String param1, String param2) {
        FragmentBorrar fragment = new FragmentBorrar();
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
        View v = inflater.inflate(R.layout.fragment_borrar, container, false);

        init(v);


        return v;
    }

    public void init(View v){
        mBtnBorrarEquipo = (Button) v.findViewById(R.id.btnBorrarEquipo);
        mBtnBorrarEquipo.setOnClickListener(this);
        mETPositionBorrarEquipo = (EditText) v.findViewById(R.id.etPositionBorrarEquipo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBorrarEquipo:
                try {
                    String editTextNumero = mETPositionBorrarEquipo.getText().toString();
                    int positionBorrar = Integer.parseInt(editTextNumero);

                    Equipo equipo = mViewModel.getListaEquipos().getValue().get(positionBorrar);
                    //mViewModel.getListaEquipos().getValue().remove(equipo);

                    ArrayList<Equipo> listaAux = mViewModel.getListaEquipos().getValue();
                    listaAux.remove(positionBorrar);

                    getActivity().onBackPressed();
                } catch(NumberFormatException nfe) {
                    Toast.makeText(getActivity(), "Could not parse " + nfe, Toast.LENGTH_SHORT).show();
                }
        }
    }
}