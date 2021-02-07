package iesnervion.fjmarquez.crudfragments.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import iesnervion.fjmarquez.crudfragments.Entities.Equipo;
import iesnervion.fjmarquez.crudfragments.R;
import iesnervion.fjmarquez.crudfragments.ViewModels.VMGeneral;

public class FragmentEditar extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText mETNombreEquipo;
    private ImageView mIVEquipo;
    private Button mBtnEditar;
    private VMGeneral mViewModel;
    private Bundle bundleEditar;
    private int itemPosition;
    private Equipo mEquipoEditar;


    public FragmentEditar() {

    }

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
        mETNombreEquipo.setText(""+mEquipoEditar.getNombreEquipo());
        mIVEquipo.setImageResource(mEquipoEditar.getImgEquipo());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditarEquipo:
                String nombreEquipo = mETNombreEquipo.getText().toString();
                mViewModel.getListaEquipos().getValue().get(itemPosition).setNombreEquipo(nombreEquipo);
                getActivity().onBackPressed();
                break;
        }
    }
}