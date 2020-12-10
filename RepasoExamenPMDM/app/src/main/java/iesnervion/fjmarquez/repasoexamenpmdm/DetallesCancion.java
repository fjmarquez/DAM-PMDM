package iesnervion.fjmarquez.repasoexamenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetallesCancion extends AppCompatActivity {

    private TextView nombre;
    private TextView autor;
    private TextView genero;
    private cancion cancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cancion);
        init();
        cancion = new cancion();

        cancion = getIntent().getParcelableExtra("cancion");

        nombre.setText(cancion.getNombre());
        autor.setText(cancion.getAutor());
        genero.setText(cancion.getGenero());

    }

    public void init(){
        nombre = findViewById(R.id.nombrecancion);
        autor = findViewById(R.id.nombreautor);
        genero = findViewById(R.id.generocancion);
    }

}