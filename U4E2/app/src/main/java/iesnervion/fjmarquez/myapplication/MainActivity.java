package iesnervion.fjmarquez.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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

    private final String[] OPCIONES = {"piedra", "papel", "tijeras"};

    private String jugadaUser = "";
    private String jugadaCPU = "";
    private String ganador = "";

    private int userWin = 0;
    private int cpuWin = 0;
    private int empate = 0;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editorPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first();
        buttonActions();
    }

    public void first(){
        preferences = getSharedPreferences("results", Context.MODE_PRIVATE);
        editorPreferences = preferences.edit();

        userWin = preferences.getInt("usuario", 0);
        cpuWin = preferences.getInt("cpu", 0);
        empate = preferences.getInt("empate", 0);

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
                electionCPU();
                electWinner();
                break;

            case R.id.bntPiedra:
                setVisibility(R.id.userImgPiedra);
                electionCPU();
                electWinner();
                break;

            case R.id.bntTijera:
                setVisibility(R.id.userImgTijera);
                electionCPU();
                electWinner();
                break;

        }
    }

    private void electionCPU(){
        Random r = new Random();
        int random = r.nextInt(3 - 0);

        if(OPCIONES[random] == "piedra"){
            setVisibility(R.id.cpuImgPiedra);
        }else if(OPCIONES[random] == "papel"){
            setVisibility(R.id.cpuImgPapel);
        }else if(OPCIONES[random] == "tijeras"){
            setVisibility(R.id.cpuImgTijera);
        }
    }

    private void setVisibility(int id){
        switch (id){
            case R.id.userImgPapel:
                userPiedra.setVisibility(View.INVISIBLE);
                userTijera.setVisibility(View.INVISIBLE);
                userPapel.setVisibility(View.VISIBLE);
                jugadaUser = OPCIONES[1];
                Toast.makeText(this, ""+jugadaUser, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cpuImgPapel:
                cpuPiedra.setVisibility(View.INVISIBLE);
                cpuTijera.setVisibility(View.INVISIBLE);
                cpuPapel.setVisibility(View.VISIBLE);
                jugadaCPU = OPCIONES[1];
                Toast.makeText(this, ""+jugadaCPU, Toast.LENGTH_SHORT).show();
                break;
            case R.id.userImgPiedra:
                userPiedra.setVisibility(View.VISIBLE);
                userTijera.setVisibility(View.INVISIBLE);
                userPapel.setVisibility(View.INVISIBLE);
                jugadaUser = OPCIONES[0];
                Toast.makeText(this, ""+jugadaUser, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cpuImgPiedra:
                cpuPiedra.setVisibility(View.VISIBLE);
                cpuTijera.setVisibility(View.INVISIBLE);
                cpuPapel.setVisibility(View.INVISIBLE);
                jugadaCPU = OPCIONES[0];
                Toast.makeText(this, ""+jugadaCPU, Toast.LENGTH_SHORT).show();
                break;
            case R.id.userImgTijera:
                userPiedra.setVisibility(View.INVISIBLE);
                userTijera.setVisibility(View.VISIBLE);
                userPapel.setVisibility(View.INVISIBLE);
                jugadaUser = OPCIONES[2];
                Toast.makeText(this, ""+jugadaUser, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cpuImgTijera:
                cpuPiedra.setVisibility(View.INVISIBLE);
                cpuTijera.setVisibility(View.VISIBLE);
                cpuPapel.setVisibility(View.INVISIBLE);
                jugadaCPU = OPCIONES[2];
                Toast.makeText(this, ""+jugadaCPU, Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void electWinner(){
        if(jugadaUser == OPCIONES[0]){
            if (jugadaUser == OPCIONES[0] && jugadaCPU == OPCIONES[1]){
                ganador = "cpu";
            }else if(jugadaUser == OPCIONES[0] && jugadaCPU == OPCIONES[2]){
                ganador = "user";
            }else if(jugadaUser == OPCIONES[0] && jugadaCPU == OPCIONES[0]){
                ganador = "empate";
            }
        }else if (jugadaUser == OPCIONES[1]){
            if (jugadaUser == OPCIONES[1] && jugadaCPU == OPCIONES[2]){
                ganador = "cpu";
            }else if(jugadaUser == OPCIONES[1] && jugadaCPU == OPCIONES[0]){
                ganador = "user";
            }else if(jugadaUser == OPCIONES[1] && jugadaCPU == OPCIONES[1]){
                ganador = "empate";
            }
        }else{
            if (jugadaUser == OPCIONES[2] && jugadaCPU == OPCIONES[0]){
                ganador = "cpu";
            }else if(jugadaUser == OPCIONES[2] && jugadaCPU == OPCIONES[1]){
                ganador = "user";
            }else if(jugadaUser == OPCIONES[2] && jugadaCPU == OPCIONES[2]){
                ganador = "empate";
            }
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyResult();
            }
        }, 1000);

    }

    public void notifyResult(){

        String mensajeGanador;

        if(ganador == "user"){
            mensajeGanador = "¡Enhorabuena! has ganado";

            userWin = preferences.getInt("user", 0);
            editorPreferences.putInt("user", userWin+1);
            editorPreferences.commit();
            userWin = preferences.getInt("user", 0);

        }else if(ganador == "cpu") {
            mensajeGanador = "¡Vaya! Has perdido";

            cpuWin = preferences.getInt("cpu", 0);
            editorPreferences.putInt("cpu", cpuWin+1);
            editorPreferences.commit();
            cpuWin = preferences.getInt("cpu", 0);

        }
        else {
            mensajeGanador = "¡Ups! Empate";

            empate = preferences.getInt("empate", 0);
            editorPreferences.putInt("empate", empate+1);
            editorPreferences.commit();
            empate = preferences.getInt("empate", 0);

        }

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(mensajeGanador + "\n\n" + "Ganadas por usuario= " + userWin + "\n" + "Ganadas por CPU= " + cpuWin + "\n" + "Empatadas = " + empate);
        builder1.setTitle("Partida finalizada");

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}