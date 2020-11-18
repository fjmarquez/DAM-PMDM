package iesnervion.fjmarquez.recyclerviewnba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Team> teamArrayList;
    private RecyclerView rvTeams;
    private RecyclerView.Adapter rvTeamsAdapter;
    private RecyclerView.LayoutManager rvTeamsLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        rvTeams = findViewById(R.id.rvTeams);
        rvTeams.setHasFixedSize(true);
        rvTeamsLayoutManager = new LinearLayoutManager(this);
        rvTeamsAdapter = new RVTeamsAdapter(teamArrayList);
        rvTeams.setLayoutManager(rvTeamsLayoutManager);
        rvTeams.setAdapter(rvTeamsAdapter);


    }

    private void initList(){
        teamArrayList = new ArrayList<>();
        teamArrayList.add(new Team("Atlanta Hawks", R.drawable.atlanta));
        teamArrayList.add(new Team("Boston Celtics", R.drawable.boston));
        teamArrayList.add(new Team("Milwaukee Bucks", R.drawable.bucks));
        teamArrayList.add(new Team("Chicago Bulls", R.drawable.bulls));
        teamArrayList.add(new Team("Cleveland Cavaliers", R.drawable.cavs));
        teamArrayList.add(new Team("Los Angeles Clippers", R.drawable.clippers));
        teamArrayList.add(new Team("Dallas Mavericks", R.drawable.dallas));
        teamArrayList.add(new Team("Denver Nuggets", R.drawable.denver));
        teamArrayList.add(new Team("Detroit Pistons", R.drawable.detroit));
        teamArrayList.add(new Team("Memphis Grizzlies", R.drawable.grizzlies));
        teamArrayList.add(new Team("Charlotte Hornets", R.drawable.hornets));
        teamArrayList.add(new Team("Houston Rockets", R.drawable.houston));
        teamArrayList.add(new Team("Indiana Pacers", R.drawable.indiana));
        teamArrayList.add(new Team("Los Angeles Lakers", R.drawable.lakers));
        teamArrayList.add(new Team("Miami Heat", R.drawable.miami));
        teamArrayList.add(new Team("Minesota Timberwolves", R.drawable.minesota));
        teamArrayList.add(new Team("Brooklyn Nets", R.drawable.nets));
        teamArrayList.add(new Team("New York Nicks", R.drawable.nicks));
        teamArrayList.add(new Team("Orlando Magic", R.drawable.orlando));
        teamArrayList.add(new Team("New Orleans Pelicans", R.drawable.orleans));
        teamArrayList.add(new Team("Philadelphia Sixers", R.drawable.philadelphia));
        teamArrayList.add(new Team("Portland Trail Blazers", R.drawable.portland));
        teamArrayList.add(new Team("Sacramento Kings", R.drawable.sacramento));
        teamArrayList.add(new Team("Seatle SuperSonics", R.drawable.seatle));
        teamArrayList.add(new Team("San Antonio Spurs", R.drawable.spurs));
        teamArrayList.add(new Team("Phoenix Suns", R.drawable.suns));
        teamArrayList.add(new Team("Oklahoma Thunder", R.drawable.thunder));
        teamArrayList.add(new Team("Toronto Raptors", R.drawable.toronto));
        teamArrayList.add(new Team("Utah Jazz", R.drawable.utah));
        teamArrayList.add(new Team("Golden State Warriors", R.drawable.warriors));
        teamArrayList.add(new Team("Washington Wizards", R.drawable.wizards));

    }
}