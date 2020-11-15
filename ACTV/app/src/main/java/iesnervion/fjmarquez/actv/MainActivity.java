package iesnervion.fjmarquez.actv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<team> teamList;
    private AutoCompleteTextView teamACTV;
    AutoCompleteTeamAdapter teamAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTeamList();

        teamACTV = findViewById(R.id.actvNba);
        teamAdapter = new AutoCompleteTeamAdapter(this, teamList);

        teamACTV.setAdapter(teamAdapter);



    }

    private void fillTeamList(){
        teamList = new ArrayList<>();
        teamList.add(new team("Atlanta Hawks", R.drawable.atlanta));
        teamList.add(new team("Boston Celtics", R.drawable.boston));
        teamList.add(new team("Milwaukee Bucks", R.drawable.bucks));
        teamList.add(new team("Chicago Bulls", R.drawable.bulls));
        teamList.add(new team("Cleveland Cavaliers", R.drawable.cavs));
        teamList.add(new team("Los Angeles Clippers", R.drawable.clippers));
        teamList.add(new team("Dallas Mavericks", R.drawable.dallas));
        teamList.add(new team("Denver Nuggets", R.drawable.denver));
        teamList.add(new team("Detroit Pistons", R.drawable.detroit));
        teamList.add(new team("Memphis Grizzlies", R.drawable.grizzlies));
        teamList.add(new team("Charlotte Hornets", R.drawable.hornets));
        teamList.add(new team("Houston Rockets", R.drawable.houston));
        teamList.add(new team("Indiana Pacers", R.drawable.indiana));
        teamList.add(new team("Los Angeles Lakers", R.drawable.lakers));
        teamList.add(new team("Miami Heat", R.drawable.miami));
        teamList.add(new team("Minesota Timberwolves", R.drawable.minesota));
        teamList.add(new team("Brooklyn Nets", R.drawable.nets));
        teamList.add(new team("New York Nicks", R.drawable.nicks));
        teamList.add(new team("Orlando Magic", R.drawable.orlando));
        teamList.add(new team("New Orleans Pelicans", R.drawable.orleans));
        teamList.add(new team("Philadelphia Sixers", R.drawable.philadelphia));
        teamList.add(new team("Portland Trail Blazers", R.drawable.portland));
        teamList.add(new team("Sacramento Kings", R.drawable.sacramento));
        teamList.add(new team("Seatle SuperSonics", R.drawable.seatle));
        teamList.add(new team("San Antonio Spurs", R.drawable.spurs));
        teamList.add(new team("Phoenix Suns", R.drawable.suns));
        teamList.add(new team("Oklahoma Thunder", R.drawable.thunder));
        teamList.add(new team("Toronto Raptors", R.drawable.toronto));
        teamList.add(new team("Utah Jazz", R.drawable.utah));
        teamList.add(new team("Golden State Warriors", R.drawable.warriors));
        teamList.add(new team("Washington Wizards", R.drawable.wizards));

    }


}
