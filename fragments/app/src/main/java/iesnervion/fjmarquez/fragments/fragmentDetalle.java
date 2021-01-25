package iesnervion.fjmarquez.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentDetalle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentDetalle extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MyViewModel vm;

    private TextView txtDetalle;

    final Observer<Integer> btnObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer integer) {

            if(vm.getBtnSelecionado().getValue().intValue() == 1){

                txtDetalle.setText("Boton 1 pulsado");

            }else if(vm.getBtnSelecionado().getValue().intValue() == 2){

                txtDetalle.setText("Boton 2 pulsado");

            }

        }
    };

    public fragmentDetalle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentDetalle.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentDetalle newInstance(String param1, String param2) {
        fragmentDetalle fragment = new fragmentDetalle();
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

        View v = inflater.inflate(R.layout.fragment_detalle, container, false);

        txtDetalle = (TextView) v.findViewById(R.id.txtDetalle);



        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        vm = new ViewModelProvider(getActivity()).get(MyViewModel.class);

        vm.getBtnSelecionado().observe(getViewLifecycleOwner(), btnObserver);

    }


}