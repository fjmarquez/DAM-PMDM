package iesnervion.fjmarquez.viewmodelnba.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import iesnervion.fjmarquez.viewmodelnba.Adapters.Adaptador;
import iesnervion.fjmarquez.viewmodelnba.R;
import iesnervion.fjmarquez.viewmodelnba.VM.VMEquiposNBA;

public class MainActivity extends AppCompatActivity {

    private VMEquiposNBA viewModel;
    private Adaptador adaptador;

    private Button btnNuevoEquipo;
    private EditText ETnombreNuevoEquipo;
    private ListView listviewEquipos;
    //private List<String> listaEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        adaptador = new Adaptador(this, viewModel.listaEquiposNBA);

        listviewEquipos.setAdapter(adaptador);

        listviewEquipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String equipo = viewModel.listaEquiposNBA.get(position);
                Toast.makeText(MainActivity.this, "Delete "+equipo, Toast.LENGTH_SHORT).show();
                viewModel.listaEquiposNBA.remove(equipo);
                adaptador.notifyDataSetChanged();

            }

        });

        btnNuevoEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nuevoEquipo = ETnombreNuevoEquipo.getText().toString();

                if(nuevoEquipo.length() > 5){

                    viewModel.listaEquiposNBA.add(nuevoEquipo);

                    ETnombreNuevoEquipo.setText("");

                }
            }
        });

    }

    public void init(){

        viewModel = new ViewModelProvider(this).get(VMEquiposNBA.class);
        listviewEquipos = findViewById(R.id.listaEquipos);
        btnNuevoEquipo = findViewById(R.id.btnAnadir);
        ETnombreNuevoEquipo = findViewById(R.id.nombreNuevoEquipo);

    }

}