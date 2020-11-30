package iesnervion.fjmarquez.intent1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntent = findViewById(R.id.btnIntent);

        btnActions();

    }


    public void btnActions(){
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("iesnervion.fjmarquez.recyclerviewnba");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found

                }else if (launchIntent == null){
                    Toast.makeText(MainActivity.this, "La aplicacion no se ha encontrado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}