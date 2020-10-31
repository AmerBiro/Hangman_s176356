package com.example.hangman_s176356.childpages;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hangman_s176356.*;
import com.example.hangman_s176356.databinding.ActivityChildPlayerViewBinding;

public class Page03_3_ChildScore extends AppCompatActivity {
    private ActivityChildPlayerViewBinding binding;

    String playerName;
    int playerAge, playerScore, playerIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_player_view);


        binding = ActivityChildPlayerViewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

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
        binding.playerChildName.setText("" + playerName);
        binding.playerChildScore.setText("" + playerScore);
        binding.playerChildAge.setText("" + playerAge);
        binding.playerChildIcon.setImageResource(playerIcon);
    }
}