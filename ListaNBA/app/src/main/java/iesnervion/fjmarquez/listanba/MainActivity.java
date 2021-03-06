package iesnervion.fjmarquez.listanba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listaEquipos;
    String[] equiposNBA = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Milwaukee Bucks",
            "Charlotte Hornets", "Chicago Bulls", "Cleveland Cavaliers", "LA Clippers",
            "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Houston Rockets",
            "Indiana Pacers", "Sacramento Kings", "LA Lakers", "Memphis Grizzlies",
            "Miami Heat", "NY Nicks", "Orlando Magic", "New Orleans Pelicans",
            "Philadelphia 76", "Phoenix Suns", "Portland Trail Brazers", "San Antonio Spurs",
            "Oklahoma Thunder", "Toronto Raptors", "Utah Jazz", "Golden State Warriors",
            "Washington Wizards", "Minnesota Timberwolves"};
    int[] imgEquiposNBA = {R.drawable.atlanta, R.drawable.boston, R.drawable.nets, R.drawable.bucks
            , R.drawable.hornets, R.drawable.bulls, R.drawable.cavs, R.drawable.clippers
            , R.drawable.dallas, R.drawable.denver, R.drawable.detroit, R.drawable.houston, R.drawable.indiana
            , R.drawable.sacramento, R.drawable.lakers, R.drawable.grizzlies, R.drawable.miami, R.drawable.nicks, R.drawable.orlando
            , R.drawable.orleans, R.drawable.philadelphia, R.drawable.suns, R.drawable.portland, R.drawable.spurs
            , R.drawable.thunder, R.drawable.toronto, R.drawable.utah, R.drawable.warriors, R.drawable.wizards, R.drawable.minesota};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaEquipos = findViewById(R.id.listaEquipo);

        listaEquipos.setAdapter(new Adaptador(this, equiposNBA, imgEquiposNBA));


        listaEquipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String equipo = equiposNBA[position];
                int img = imgEquiposNBA[position];

                Intent i = new Intent(MainActivity.this, TeamDetails.class);
                i.putExtra("IMG", img);
                i.putExtra("TEAM", equipo);
                startActivity(i);

                //Toast.makeText(MainActivity.this, "item click " + equiposNBA[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}