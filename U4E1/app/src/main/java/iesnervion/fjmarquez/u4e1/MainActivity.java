package iesnervion.fjmarquez.u4e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAc;
    private Button btnDel;
    private Button btnAns;
    private Button btnPi;
    private Button btnDiv;
    private Button btnMul;
    private Button btnRes;
    private Button btnSum;
    private Button btnPunto;
    private Button btnIgual;
    private Button btn9;
    private Button btn8;
    private Button btn7;
    private Button btn6;
    private Button btn5;
    private Button btn4;
    private Button btn3;
    private Button btn2;
    private Button btn1;
    private Button btn0;

    private TextView txtResultado;
    private TextView txtIntroducido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint2);
        //first();
        //buttonsActions();
    }

    public void first(){

        btnAc = findViewById(R.id.btnAc);
        btnDel = findViewById(R.id.btnDel);
        btnAns = findViewById(R.id.btnAns);
        btnPi = findViewById(R.id.btnPi);

        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnRes = findViewById(R.id.btnRes);
        btnSum = findViewById(R.id.btnSum);
        btnPunto = findViewById(R.id.btnPunto);
        btnIgual = findViewById(R.id.btnIgual);

        btn9 = findViewById(R.id.btn9);
        btn8 = findViewById(R.id.btn8);
        btn7 = findViewById(R.id.btn7);
        btn6 = findViewById(R.id.btn6);
        btn5 = findViewById(R.id.btn5);
        btn4 = findViewById(R.id.btn4);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn0 = findViewById(R.id.btn0);

        txtIntroducido = findViewById(R.id.txtIntroducido);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void buttonsActions(){

        btnAc.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnAns.setOnClickListener(this);
        btnPi.setOnClickListener(this);

        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnRes.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnPunto.setOnClickListener(this);
        btnIgual.setOnClickListener(this);

        btn9.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn0.setOnClickListener(this);
    }


/*
        @Override
        public void onClick(View v) {
            Button introducido = (Button)v;
            txtIntroducido.setText(txtIntroducido.getText().toString() + introducido.getText().toString());
        }
*/

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnAc:
                operacion(btnAc);
                break;
            case R.id.btnDel:
                operacion(btnDel);
                break;
            case R.id.btnAns:
                operacion(btnAns);
                break;
            case R.id.btnPi:
                digitos(btnPi);
                break;
            case R.id.btnDiv:
                operacion(btnDiv);
                break;
            case R.id.btnMul:
                operacion(btnMul);
                break;
            case R.id.btnRes:
                operacion(btnRes);
                break;
            case R.id.btnSum:
                operacion(btnSum);
                break;
            case R.id.btn9:
                digitos(btn9);
                break;
            case R.id.btn8:
                digitos(btn8);
                break;
            case R.id.btn7:
                digitos(btn7);
                break;
            case R.id.btn6:
                digitos(btn6);
                break;
            case R.id.btn5:
                digitos(btn5);
                break;
            case R.id.btn4:
                digitos(btn4);
                break;
            case R.id.btn3:
                digitos(btn3);
                break;
            case R.id.btn2:
                digitos(btn2);
                break;
            case R.id.btn1:
                digitos(btn1);
                break;
            case R.id.btn0:
                digitos(btn0);
                break;
            case R.id.btnPunto:
                digitos(btnPunto);
                break;
            case R.id.btnIgual:
                operacion(btnIgual);
                break;

        }
    }

    public void digitos(Button b){
        txtIntroducido.setText(txtIntroducido.getText()+""+b.getText());
    }

    public void operacion(Button  b) {
    }
}