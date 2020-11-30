package iesnervion.fjmarquez.intent4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Ubicacion> listaAndalucia;
    private Spinner spinnerUbicaciones;
    private UbicacionAdapter ubicacionAdapter;
    private Boolean firstCallSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        crearUbicaciones();

        ubicacionAdapter = new UbicacionAdapter(this, listaAndalucia);
        spinnerUbicaciones.setAdapter(ubicacionAdapter);

        spinnerUbicaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!firstCallSpinner){
                    Ubicacion clickUbicacion = (Ubicacion) parent.getItemAtPosition(position);
                    String clickedUbicacionName = clickUbicacion.getUbicacion();
                    String geo = "geo:"+clickUbicacion.getLatitud()+","+clickUbicacion.getLonguitud();
                    Uri uriGeo = Uri.parse(geo); //Crea una uri a partir de un String con la informacion necesaria
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriGeo); //Crea un intent con la uri creada anteriormente
                    mapIntent.setPackage("com.google.android.apps.maps"); //Indica que el intent sera recibido por Google Maps
                    startActivity(mapIntent); //Lanza el intent

                    Toast.makeText(MainActivity.this, "You clicked " + clickedUbicacionName, Toast.LENGTH_SHORT).show();
                }
                firstCallSpinner = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void init(){
        spinnerUbicaciones = findViewById(R.id.spinnerUbicaciones);
        firstCallSpinner = true;
    }

    public void crearUbicaciones(){
        listaAndalucia = new ArrayList<>();

        listaAndalucia.add( new Ubicacion("Seleccione una ubicacion", 0.0, 0.0));

        listaAndalucia.add( new Ubicacion("Sevilla", 37.38283, -5.97317));

        listaAndalucia.add(new Ubicacion("Huelva", 37.26638, -6.94004));

        listaAndalucia.add(new Ubicacion("Cadiz", 36.52672, -6.2891));

        listaAndalucia.add(new Ubicacion("Cordoba", 37.89155 , -4.77275));

        listaAndalucia.add(new Ubicacion("Jaen", 37.76922 , -3.79028));

        listaAndalucia.add(new Ubicacion("Granada", 37.18817, -3.60667));

        listaAndalucia.add(new Ubicacion("Malaga", 36.72016, -4.42034));

        listaAndalucia.add(new Ubicacion("Almeria", 36.83814, -2.45974));

    }

}