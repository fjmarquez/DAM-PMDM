package iesnervion.fjmarquez.e4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtPalabra;
    private Button btnEnviar;
    private TextView lblPalabra;
    private Button btnAumentar;
    private Button btnDisminuir;

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
        btnAumentar = findViewById(R.id.btnAumentar);
        btnDisminuir = findViewById(R.id.btnDisminuir);

    }

    public void buttonsActions(){
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = txtPalabra.getText().toString();
                lblPalabra.setText(p);
            }
        });
        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //float size = lblPalabra.getTextSize();
                int s = Math.round(lblPalabra.getTextSize());
                lblPalabra.setTextSize(TypedValue.COMPLEX_UNIT_PX ,s+1);
                Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            }
        });

        btnDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //float size = lblPalabra.getTextSize();
                int s = Math.round(lblPalabra.getTextSize());
                lblPalabra.setTextSize(TypedValue.COMPLEX_UNIT_PX ,s-1);
                Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();

            }
        });
    }
}