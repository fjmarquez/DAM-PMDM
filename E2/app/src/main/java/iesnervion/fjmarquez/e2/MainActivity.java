package iesnervion.fjmarquez.e2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtPalabra;
    private Button btnEnviar;
    private TextView lblPalabra;
    private Button btnAzul;
    private Button btnVerde;
    private Button btnRojo;

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
        btnAzul = findViewById(R.id.btnAzul);
        btnVerde = findViewById(R.id.btnVerde);
        btnRojo = findViewById(R.id.btnRojo);
    }

    public void buttonsActions(){
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = txtPalabra.getText().toString();
                lblPalabra.setText(p);
            }
        });

        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lblPalabra.getText().length() > 0){
                    lblPalabra.setTextColor(Color.BLUE);
                }
            }
        });
        btnVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lblPalabra.getText().length() > 0){
                    lblPalabra.setTextColor(Color.GREEN);
                }
            }
        });
        btnRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lblPalabra.getText().length() > 0){
                    lblPalabra.setTextColor(Color.RED);
                }
            }
        });

    }
}