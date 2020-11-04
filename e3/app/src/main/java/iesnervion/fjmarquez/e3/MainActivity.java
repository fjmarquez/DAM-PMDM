package iesnervion.fjmarquez.e3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtPalabra;
    private Button btnEnviar;
    private TextView lblPalabra;
    private Button btnAlinearDerecha;
    private Button btnalinearIzquierda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first();
        buttonsActions();
    }

    public void first(){
        txtPalabra = findViewById(R.id.txtPalabra);
        btnEnviar = findViewById(R.id.btnEnviar);
        lblPalabra = findViewById(R.id.lblPalabra);
        btnAlinearDerecha = findViewById(R.id.btnAlinearDerecha);
        btnalinearIzquierda = findViewById(R.id.btnAlinearIzquierda);

    }

    public void buttonsActions(){
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = txtPalabra.getText().toString();
                lblPalabra.setText(p);
            }
        });

        btnAlinearDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblPalabra.setGravity(Gravity.RIGHT);
            }
        });

        btnalinearIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblPalabra.setGravity(Gravity.LEFT);
            }
        });



    }
}