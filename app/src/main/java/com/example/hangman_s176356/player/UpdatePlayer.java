package com.example.hangman_s176356.player;
import com.example.hangman_s176356.R;
import com.example.hangman_s176356.game.HangmanGame;
import com.example.hangman_s176356.database.Player;
import com.example.hangman_s176356.databinding.PlayerUpdatePlayerBinding;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class UpdatePlayer extends AppCompatActivity {
    private PlayerUpdatePlayerBinding binding;

    String playerId, playerName, playerBirthDate, playerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_update_player);


        binding = PlayerUpdatePlayerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //First we call this
        getAndSetIntentData();

        //Set actionbar playerName after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(playerName);
        }

        binding.updatePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                Player myDB = new Player(UpdatePlayer.this);
                playerName = binding.UPplayerName.getText().toString().trim();
                playerBirthDate = binding.UPplayerBirthDate.getText().toString().trim();
                playerScore = binding.UPplayerScore.getText().toString().trim();
                myDB.updateData(playerId, playerName, playerBirthDate, playerScore);
            }
        });
        binding.deletePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        binding.UPplayerScore.setEnabled(false);
        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdatePlayer.this, HangmanGame.class);
                intent.putExtra("playerName", String.valueOf(playerName));
                intent.putExtra("playerScore", String.valueOf(playerScore));

                intent.putExtra("playerId", String.valueOf(playerId));

                startActivityForResult(intent, 1);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("playerId") && getIntent().hasExtra("playerName") &&
                getIntent().hasExtra("playerBirthDate") && getIntent().hasExtra("playerScore")){
            //Getting Data from Intent
            playerId = getIntent().getStringExtra("playerId");
            playerName = getIntent().getStringExtra("playerName");
            playerBirthDate = getIntent().getStringExtra("playerBirthDate");
            playerScore = getIntent().getStringExtra("playerScore");

            //Setting Intent Data
            binding.UPplayerName.setText(playerName);
            binding.UPplayerBirthDate.setText(playerBirthDate);
            binding.UPplayerScore.setText(playerScore);
            Log.d("stev", playerName +" "+ playerBirthDate +" "+ playerScore);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + playerName + " ?");
        builder.setMessage("Are you sure you want to delete " + playerName + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Player myDB = new Player(UpdatePlayer.this);
                myDB.deleteOneRow(playerId);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
