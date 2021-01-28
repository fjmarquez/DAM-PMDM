package iesnervion.fjmarquez.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPiedra;
    private Button btnPapel;
    private Button btnTijera;

    private ImageView userPiedra;
    private ImageView userPapel;
    private ImageView userTijera;

    private ImageView cpuPiedra;
    private ImageView cpuPapel;
    private ImageView cpuTijera;

    private final String[] cpuOpciones = {"piedra", "papel", "tijeras"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first();
        buttonActions();
    }

    public void first(){
        btnPiedra = findViewById(R.id.bntPiedra);
        btnPapel = findViewById(R.id.bntPapel);
        btnTijera = findViewById(R.id.bntTijera);

        userPapel = findViewById(R.id.userImgPapel);
        userPiedra = findViewById(R.id.userImgPiedra);
        userTijera = findViewById(R.id.userImgTijera);

        cpuPapel = findViewById(R.id.cpuImgPapel);
        cpuPiedra = findViewById(R.id.cpuImgPiedra);
        cpuTijera = findViewById(R.id.cpuImgTijera);
    }

    public void buttonActions(){
        btnPiedra.setOnClickListener(this);
        btnPapel.setOnClickListener(this);
        btnTijera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bntPapel:
                setVisibility(R.id.userImgPapel);
                eleccionCPU();
                break;

            case R.id.bntPiedra:
                setVisibility(R.id.userImgPiedra);
                eleccionCPU();
                break;

            case R.id.bntTijera:
                setVisibility(R.id.userImgTijera);
                eleccionCPU();
                break;

        }
    }

    private void eleccionCPU(){
        Random r = new Random();
        int random = r.nextInt(3 - 0);

        if(cpuOpciones[random] == "piedra"){
            setVisibility(R.id.cpuImgPiedra);
        }else if(cpuOpciones[random] == "papel"){
            setVisibility(R.id.cpuImgPapel);
        }else if(cpuOpciones[random] == "tijeras"){
            setVisibility(R.id.cpuImgTijera);
        }
    }

    private void setVisibility(int id){
        switch (id){
            case R.id.userImgPapel:
                userPiedra.setVisibility(View.INVISIBLE);
                userTijera.setVisibility(View.INVISIBLE);
                userPapel.setVisibility(View.VISIBLE);
                break;
            case R.id.cpuImgPapel:
                cpuPiedra.setVisibility(View.INVISIBLE);
                cpuTijera.setVisibility(View.INVISIBLE);
                cpuPapel.setVisibility(View.VISIBLE);
                break;
            case R.id.userImgPiedra:
                userPiedra.setVisibility(View.VISIBLE);
                userTijera.setVisibility(View.INVISIBLE);
                userPapel.setVisibility(View.INVISIBLE);
                break;
            case R.id.cpuImgPiedra:
                cpuPiedra.setVisibility(View.VISIBLE);
                cpuTijera.setVisibility(View.INVISIBLE);
                cpuPapel.setVisibility(View.INVISIBLE);
                break;
            case R.id.userImgTijera:
                userPiedra.setVisibility(View.INVISIBLE);
                userTijera.setVisibility(View.VISIBLE);
                userPapel.setVisibility(View.INVISIBLE);
                break;
            case R.id.cpuImgTijera:
                cpuPiedra.setVisibility(View.INVISIBLE);
                cpuTijera.setVisibility(View.VISIBLE);
                cpuPapel.setVisibility(View.INVISIBLE);
                break;
        }
    }

}