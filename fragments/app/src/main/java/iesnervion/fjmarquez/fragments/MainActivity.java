package iesnervion.fjmarquez.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    private ViewModel vm;
    final fragmentNavegacion fNav = new fragmentNavegacion();
    final fragmentDetalle fDet = new fragmentDetalle();
    private boolean smallScreen;
    final Observer<Integer> btnObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer integer) {

            if (smallScreen == true && vm.getBtnSelecionado().getValue().intValue() != 0){

                getSupportFragmentManager().beginTransaction().replace(R.id.contenedorGeneral, fDet).addToBackStack(null).commit();

            }else if(smallScreen != true && vm.getBtnSelecionado().getValue().intValue() != 0){

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCDetalle, fDet).addToBackStack(null).commit();

            }

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = new ViewModelProvider(this).get(ViewModel.class);

        vm.getBtnSelecionado().observe(this, btnObserver);

        if(findViewById(R.id.contenedorGeneral) != null){
            smallScreen = true;
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorGeneral, fNav).addToBackStack(null).commit();
        }





    }

}