package iesnervion.fjmarquez.e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSumar;
    private EditText txtN1;
    private EditText txtN2;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first();

        buttons();
    }

    public void first(){
        btnSumar = findViewById(R.id.btnSumar);
        txtN1 = findViewById(R.id.txtN1);
        txtN2 = findViewById(R.id.txtN2);
        lblResultado = findViewById(R.id.lblResultado);
    }

    public void buttons(){
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(txtN1.getText().toString());
                int n2 = Integer.parseInt(txtN2.getText().toString());
                int suma = (n1 + n2);

                Toast.makeText(MainActivity.this, String.valueOf(suma), Toast.LENGTH_SHORT).show();


            }
        });
    }
}