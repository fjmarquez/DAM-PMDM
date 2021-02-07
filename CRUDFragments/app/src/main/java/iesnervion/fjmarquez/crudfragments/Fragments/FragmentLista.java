package iesnervion.fjmarquez.crudfragments.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import iesnervion.fjmarquez.crudfragments.Adapters.EquipoAdapter;
import iesnervion.fjmarquez.crudfragments.Entities.Equipo;
import iesnervion.fjmarquez.crudfragments.R;
import iesnervion.fjmarquez.crudfragments.ViewModels.VMGeneral;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLista extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    //Atributos
    private RecyclerView rvEquipos;
    private EquipoAdapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private VMGeneral mViewModel;


    public FragmentLista() {

    }

    public static FragmentLista newInstance(String param1, String param2) {
        FragmentLista fragment = new FragmentLista();
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
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        rvEquipos = (RecyclerView) v.findViewById(R.id.rvEquipos);
        rvEquipos.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(getActivity());
        rvAdapter = new EquipoAdapter(mViewModel.getListaEquipos().getValue());
        rvAdapter.setOnItemClickListener(new EquipoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FragmentEditar mFragmentEditar = new FragmentEditar();
                Bundle bundleEditar = new Bundle();
                bundleEditar.putInt("item", position);
                mFragmentEditar.setArguments(bundleEditar);
                getParentFragmentManager().beginTransaction().replace(R.id.contenedorGeneral, mFragmentEditar).addToBackStack(null).commit();

            }
        });
        rvEquipos.setLayoutManager(rvLayoutManager);
        rvEquipos.setAdapter(rvAdapter);



        return v;
    }
}