package iesnervion.fjmarquez.listanba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamDetails extends AppCompatActivity {

    private ImageView ivTeam;
    private TextView tvTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);

        ivTeam = findViewById(R.id.detailImg);
        tvTeam = findViewById(R.id.detailName);

        Intent i = getIntent();

        String teamDetail = i.getStringExtra("TEAM");
        int imgDetail = i.getIntExtra("IMG",-1);

        ivTeam.setImageResource(imgDetail);
        tvTeam.setText(teamDetail);
    }
}