package com.example.roomnba.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.roomnba.Entities.Equipo;
import com.example.roomnba.R;
import com.example.roomnba.Viewmodels.VMGeneral;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEditar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEditar extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText mETNombreEquipo;
    private ImageView mIVEquipo;
    private Button mBtnEditar;
    private Button mBtnBorrar;
    private VMGeneral mViewModel;
    private Bundle bundleEditar;
    private int itemPosition;
    private Equipo mEquipoEditar;

    public FragmentEditar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEditar.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEditar newInstance(String param1, String param2) {
        FragmentEditar fragment = new FragmentEditar();
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

        View v = inflater.inflate(R.layout.fragment_editar, container, false);

        bundleEditar = this.getArguments();
        itemPosition = bundleEditar.getInt("item");
        mEquipoEditar = mViewModel.getListaEquipos().getValue().get(itemPosition);

        init(v);

        return v;

    }

    public void init(View v){
        mETNombreEquipo = (EditText) v.findViewById(R.id.etNombreEquipoEditar);
        mIVEquipo = (ImageView) v.findViewById(R.id.ivEquipoEditar);
        mBtnEditar = (Button) v.findViewById(R.id.btnEditarEquipo);
        mBtnEditar.setOnClickListener(this);
        mBtnBorrar = (Button) v.findViewById(R.id.btnBorrarEquipo);
        mBtnBorrar.setOnClickListener(this);
        mETNombreEquipo.setText(""+mEquipoEditar.getNombreEquipo());
        mIVEquipo.setImageResource(mEquipoEditar.getImgEquipo());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditarEquipo:
                mEquipoEditar.setNombreEquipo(mETNombreEquipo.getText().toString());
                mEquipoEditar.setImgEquipo(R.drawable.nba2);
                mViewModel.actualizarEquipoListaEquipos(mEquipoEditar, itemPosition);
                getActivity().onBackPressed();
                break;
            case R.id.btnBorrarEquipo:
                mViewModel.eliminarEquipoListaEquipos(mEquipoEditar);
                getActivity().onBackPressed();
                break;
        }
    }


}