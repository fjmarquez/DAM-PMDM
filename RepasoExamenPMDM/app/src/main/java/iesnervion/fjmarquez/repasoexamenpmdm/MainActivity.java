package iesnervion.fjmarquez.repasoexamenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgGeneros;
    private RadioButton rbTodos;
    private RadioButton rbRock;
    private RadioButton rbPop;
    private CheckBox cbFavoritos;
    private EditText filter;
    private ListView lvCanciones;
    private RVAdapter lvAdapter;
    private Spinner spinnerCanciones;
    private SpinnerAdapter spinnerAdapter;
    private Button btnDetalles;

    private ArrayList<cancion> listaCanciones;
    private ArrayList<cancion> listaListView;
    private ArrayList<cancion> listaSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializamos los componentes
        init();

        //accion para el radiogroup
        rgAction();

        //rellenamos e inicializamos listas
        fill();

        //preparamos el recyclerView
        lvAction();
        
        //preparamos el spinner
        spinnerAction();

        //preparamos el boton
        btnAction();

        //preparamos el checkbox
        cbAction();
    }

    //funcion para inicializar los componentes de la actividad
    public void init(){
        rgGeneros = findViewById(R.id.rGroupGeneros);
        rbTodos = findViewById(R.id.rbTodos);
        rbPop = findViewById(R.id.rbPop);
        rbRock = findViewById(R.id.rbRock);
        cbFavoritos = findViewById(R.id.cbFavoritos);
        filter = findViewById(R.id.filter);
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 0){
                    listaListView.clear();
                    for (cancion c : listaCanciones)
                    {
                        listaListView.add(c);
                    }
                }else {
                    filter(s.toString());
                }
                lvAdapter.notifyDataSetChanged();
            }
        });
        lvCanciones = findViewById(R.id.rvCanciones);
        spinnerCanciones = findViewById(R.id.spinnerCanciones);
        btnDetalles = findViewById(R.id.btnDetalles);
    }

    //filtro
    private void filter(String s){
        ArrayList<cancion> copiaTmp = new ArrayList<>();

        for (cancion c: listaListView)
        {

                copiaTmp.add(c);

        }

        listaListView.clear();

        for (cancion c: copiaTmp)
        {
            if(c.getNombre().contains(s) || c.getAutor().contains(s)){
                listaListView.add(c);
            }
        }

        copiaTmp.clear();

    }

    //mock
    public void fill(){
        listaSpinner = new ArrayList<>();
        listaListView = new ArrayList<>();
        listaCanciones = new ArrayList<>();
        listaCanciones.add(new cancion(0, "Cancion 1", "Autor de la cancion 1", "Pop"));
        listaCanciones.add(new cancion(1, "Cancion 2", "Autor de la cancion 2", "Rock"));
        listaCanciones.add(new cancion(2, "Cancion 3", "Autor de la cancion 3", "Pop"));
        listaCanciones.add(new cancion(3, "Cancion 4", "Autor de la cancion 4", "Rock"));
        listaCanciones.add(new cancion(4, "Cancion 5", "Autor de la cancion 5", "Pop"));
        listaCanciones.add(new cancion(5, "Cancion 6", "Autor de la cancion 6", "Rock"));
        listaCanciones.add(new cancion(6, "Cancion 7", "Autor de la cancion 7", "Pop"));
        listaCanciones.add(new cancion(7, "Cancion 8", "Autor de la cancion 8", "Rock"));
        listaCanciones.add(new cancion(8, "Cancion 9", "Autor de la cancion 9", "Pop"));
        listaCanciones.add(new cancion(9, "Cancion 10", "Autor de la cancion 10", "Rock"));

    }

    //Acciones para el radioGroup
    public void  rgAction(){
        rgGeneros.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rgGeneros.getCheckedRadioButtonId() == R.id.rbTodos){
                    Toast.makeText(getApplicationContext(), "Todos", Toast.LENGTH_SHORT).show();
                    listaListView.clear();
                    for (cancion c: listaCanciones)
                    {
                        listaListView.add(c);
                    }
                    lvAdapter.notifyDataSetChanged();
                }else if(rgGeneros.getCheckedRadioButtonId() == R.id.rbPop){
                    Toast.makeText(getApplicationContext(), "Pop", Toast.LENGTH_SHORT).show();
                    listaListView.clear();
                    for (cancion c: listaCanciones)
                    {
                        if(c.getGenero() == "Pop"){
                            listaListView.add(c);
                        }
                    }
                    lvAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(getApplicationContext(), "Rock", Toast.LENGTH_SHORT).show();
                    listaListView.clear();
                    for (cancion c: listaCanciones)
                    {
                        if(c.getGenero() == "Rock"){
                            listaListView.add(c);
                        }
                    }
                    lvAdapter.notifyDataSetChanged();
                }

            }
        });
    }

    public void lvAction(){
        for (cancion c: listaCanciones)
        {
            listaListView.add(c);
        }


        lvAdapter = new RVAdapter(this, listaListView);
        lvCanciones.setAdapter(lvAdapter);

        lvCanciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+listaListView.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                listaSpinner.add(listaListView.get(position));
                spinnerAdapter.notifyDataSetChanged();
            }
        });

    }

    public void spinnerAction(){

        listaSpinner.add(new cancion(-1, "Selecciona una cancion", "",""));
        spinnerAdapter = new SpinnerAdapter(this, listaSpinner);
        spinnerCanciones.setAdapter(spinnerAdapter);

        spinnerCanciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void btnAction(){
        btnDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancion c = (cancion) spinnerCanciones.getSelectedItem();
                Toast.makeText(MainActivity.this, ""+c.getNombre(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DetallesCancion.class);
                intent.putExtra("cancion", c);
                startActivity(intent);

            }
        });
    }


    public void cbAction(){
        cbFavoritos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listaListView.clear();
                    for(cancion c : listaSpinner){
                        listaListView.add(c);
                    }
                    listaListView.remove(0);
                    lvAdapter.notifyDataSetChanged();
                }else {
                    listaListView.clear();
                    for(cancion c : listaCanciones){
                        listaListView.add(c);
                    }
                    lvAdapter.notifyDataSetChanged();
                }
            }
        });
    }


}