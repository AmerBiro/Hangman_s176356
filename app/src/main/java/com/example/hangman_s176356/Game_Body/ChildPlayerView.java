package com.example.hangman_s176356.Game_Body;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hangman_s176356.*;

public class ChildPlayerView extends AppCompatActivity {

    ImageView childPlayerIcon;
    TextView childPlayerName, childPlayerAge, childPlayerScore;

    String playerName;
    int playerAge, playerScore, playerIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_player_view);

        childPlayerIcon = findViewById(R.id.playerChildIcon);
        childPlayerScore = findViewById(R.id.playerChildScore);
        childPlayerAge = findViewById(R.id.playerChildAge);
        childPlayerName = findViewById(R.id.playerChildName);

        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("childPlayerIcon")
                && getIntent().hasExtra("childPlayerScore")
                && getIntent().hasExtra("childPlayerAge")
                && getIntent().hasExtra("childPlayerName")){
            playerIcon = getIntent().getIntExtra("childPlayerIcon", 1);
            playerScore = getIntent().getIntExtra("childPlayerScore", 1);
            playerAge = getIntent().getIntExtra("childPlayerAge", 1);
            playerName = getIntent().getStringExtra("childPlayerName");
        }else Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
    }

    private void setData(){
        childPlayerName.setText("" + playerName);
        childPlayerScore.setText("" + playerScore);
        childPlayerAge.setText("" + playerAge);
        childPlayerIcon.setImageResource(playerIcon);
    }
}