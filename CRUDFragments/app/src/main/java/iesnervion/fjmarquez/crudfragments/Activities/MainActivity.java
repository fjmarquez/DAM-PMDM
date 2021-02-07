package iesnervion.fjmarquez.crudfragments.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import iesnervion.fjmarquez.crudfragments.Fragments.FragmentBorrar;
import iesnervion.fjmarquez.crudfragments.Fragments.FragmentLista;
import iesnervion.fjmarquez.crudfragments.Fragments.FragmentNuevo;
import iesnervion.fjmarquez.crudfragments.R;
import iesnervion.fjmarquez.crudfragments.ViewModels.VMGeneral;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FragmentContainerView mContenedorGeneral;
    private Button mBtnNuevo, mBtnLista, mBtnBorrar;
    private VMGeneral mViewModel;
    private FragmentNuevo mFragmentNuevo;
    private FragmentLista mFragmentLista;
    private FragmentBorrar mFragmentBorrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        fragmentInitial();

    }

    /*
    * Esta funcion cargara por defecto el fragmentLista cuando la actividad se cree
    * */
    public void fragmentInitial(){
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.contenedorGeneral, mFragmentLista)
                .addToBackStack(null)
                .commit();
    }

    /*
    * En esta funcion inicializamos los atributos correspondientes a la actividad
    * */
    public void init(){
        mContenedorGeneral = findViewById(R.id.contenedorGeneral);

        mBtnNuevo = findViewById(R.id.btnNuevo);
        mBtnLista = findViewById(R.id.btnLista);
        mBtnBorrar = findViewById(R.id.btnBorrar);
        mBtnNuevo.setOnClickListener(this);
        mBtnLista.setOnClickListener(this);
        mBtnBorrar.setOnClickListener(this);

        mFragmentNuevo = new FragmentNuevo();
        mFragmentLista = new FragmentLista();
        mFragmentBorrar = new FragmentBorrar();
    }

    /*
    *  En esta funcion se definen los eventos onClick de la actividad
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNuevo:
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.contenedorGeneral, mFragmentNuevo)
                        .addToBackStack(null)
                        .commit();
                Toast.makeText(this, "Nuevo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLista:
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.contenedorGeneral, mFragmentLista)
                        .addToBackStack(null)
                        .commit();
                Toast.makeText(this, "Lista", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBorrar:
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.contenedorGeneral, mFragmentBorrar)
                        .addToBackStack(null)
                        .commit();
                Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}