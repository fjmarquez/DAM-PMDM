package iesnervion.fjmarquez.boletin5_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listaEquiposNBA;
    private String[] equiposNBA = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Milwaukee Bucks",
                                    "Charlotte Hornets", "Chicago Bulls", "Cleveland Cavaliers", "LA Clippers",
                                    "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Houston Rockets",
                                    "Indiana Pacers", "Sacramento Kings", "LA Lakers", "Memphis Grizzlies",
                                    "Miami Heat", "NY Nicks", "Orlando Magic", "New Orleans Pelicans",
                                    "Philadelphia 76", "Phoenix Suns", "Portland Trail Brazers", "San Antonio Spurs",
                                    "Oklahoma Thunder", "Toronto Raptors", "Utah Jazz", "GS Warriors",
                                    "Washington Wizards", "Minnesota Timberwolves"};
    private int[] imgEquiposNBA = {R.drawable.atlanta, R.drawable.boston, R.drawable.brooklyn, R.drawable.bucks
                                , R.drawable.charlotte, R.drawable.chicago, R.drawable.cleveland, R.drawable.clippers
                                , R.drawable.dallas, R.drawable.denver, R.drawable.detroit, R.drawable.houston, R.drawable.indiana
                                , R.drawable.kings, R.drawable.lakers, R.drawable.mephis, R.drawable.miami, R.drawable.nicks, R.drawable.orlando
                                , R.drawable.pelicans, R.drawable.philadelphia, R.drawable.phoenix, R.drawable.portland, R.drawable.spurs
                                , R.drawable.thunder, R.drawable.toronto, R.drawable.utah, R.drawable.warriors, R.drawable.wizards, R.drawable.wolves};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaEquiposNBA = (findViewById(R.id.listaEquiposNBA));

        listaEquiposNBA.setAdapter(new AdaptadorEquipos(this, equiposNBA, imgEquiposNBA));
    }
}