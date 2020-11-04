package iesnervion.fjmarquez.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
                userPiedra.setVisibility(View.INVISIBLE);
                userTijera.setVisibility(View.INVISIBLE);
                userPapel.setVisibility(View.VISIBLE);
                break;

            case R.id.bntPiedra:
                userPiedra.setVisibility(View.VISIBLE);
                userTijera.setVisibility(View.INVISIBLE);
                userPapel.setVisibility(View.INVISIBLE);
                break;

            case R.id.bntTijera:
                userPiedra.setVisibility(View.INVISIBLE);
                userTijera.setVisibility(View.VISIBLE);
                userPapel.setVisibility(View.INVISIBLE);
                break;

        }
    }
}