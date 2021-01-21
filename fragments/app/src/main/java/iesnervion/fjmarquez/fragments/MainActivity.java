package iesnervion.fjmarquez.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    private ViewModel vm;
    final fragmentNavegacion fNav = new fragmentNavegacion();
    final fragmentDetalle fDet = new fragmentDetalle();
    private boolean smallScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = new ViewModelProvider(this).get(ViewModel.class);

        if(findViewById(R.id.contenedorGeneral) != null){
            smallScreen = true;
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorGeneral, fNav).addToBackStack(null).commit();
        }
        else{
            smallScreen = false;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCNavegacion, fNav).addToBackStack(null).commit();
        }

    }

}