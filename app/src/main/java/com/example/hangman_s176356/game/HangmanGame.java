package com.example.hangman_s176356.game;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hangman_s176356.*;
import com.example.hangman_s176356.database.Player;
import com.example.hangman_s176356.databinding.GameHangmanBinding;
import com.example.hangman_s176356.endgame.endgame.Lose;
import com.example.hangman_s176356.endgame.endgame.Won;
import com.example.hangman_s176356.logic.Logic;
import com.example.hangman_s176356.main.MainPage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HangmanGame extends AppCompatActivity implements View.OnClickListener {
    private GameHangmanBinding binding;

    private Logic logic = new Logic();

    String playerId, playerName, playerScore;

    Button button;
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_hangman);

        binding = GameHangmanBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imageView.setVisibility(View.INVISIBLE);

        //First we call this
        getAndSetIntentData();

        binding.gusse.setText(logic.getFirstandLastLetter());

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("playerName") &&
                getIntent().hasExtra("playerScore")){
            //Getting Data from Intent
            playerName = getIntent().getStringExtra("playerName");
            playerScore = getIntent().getStringExtra("playerScore");
            playerId = getIntent().getStringExtra("playerId");

            //Setting Intent Data
            binding.playerName.setText(playerName);
            binding.playerScore.setText(playerScore);
            Log.d("stev", playerName +" "+  playerScore);
        }else{
            Toast.makeText(this, "No player has been created.", Toast.LENGTH_SHORT).show();
            binding.playerName.setText("");
            binding.playerScore.setText("");
        }
    }


    @Override
    public void onClick(View view) {
        button = findViewById(view.getId());
        int count = 0;
        clickMe(button);
        count ++;
    }

    private void clickMe(Button button){
        String myLetter = (button.getText().toString().toLowerCase());
        logic.gætBogstav(myLetter);
        binding.imageView.setVisibility(View.VISIBLE);
        binding.gusse.setText(logic.getSynligtOrd());
        button.setVisibility(View.INVISIBLE);

        switch (logic.getAntalForkerteBogstaver()){
            case 1:
                binding.imageView.setImageResource(R.drawable.galge);
                break;
            case 2:
                binding.imageView.setImageResource(R.drawable.forkert1);
                break;
            case 3:
                binding.imageView.setImageResource(R.drawable.forkert2);
                break;
            case 4:
                binding.imageView.setImageResource(R.drawable.forkert3);
                break;
            case 5:
                binding.imageView.setImageResource(R.drawable.forkert4);
                break;
            case 6:
                binding.imageView.setImageResource(R.drawable.forkert5);
                break;
            case 7:
                binding.imageView.setImageResource(R.drawable.forkert6);
                break;
            default:
                break;
        }
        if (logic.erSpilletVundet()){
            if (!getIntent().hasExtra("playerName") &&
                    !getIntent().hasExtra("playerScore")){
                Intent intent = new Intent(HangmanGame.this, MainPage.class);
                Toast.makeText(this, "You've won!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }else {
                Intent intent = new Intent(HangmanGame.this, Won.class);
                intent.putExtra("number_of", String.valueOf(logic.getAntalForkerteBogstaver()));
                int score = Integer.parseInt(playerScore.trim());
                score = score*2;
                playerScore = Integer.toString(score);
                intent.putExtra("playerScore", String.valueOf(playerScore));

                Player myDB = new Player(HangmanGame.this);
                myDB.updateScore(playerId, playerScore);

                startActivity(intent);
                finish();
            }

        }else if (logic.erSpilletTabt()){
            if (!getIntent().hasExtra("playerName") &&
                    !getIntent().hasExtra("playerScore")){
                Intent intent = new Intent(HangmanGame.this, MainPage.class);
                Toast.makeText(this, "You've lost!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "Du er tabt og spillet er slut!", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(HangmanGame.this, Lose.class);
                        intent.putExtra("right_word", String.valueOf(logic.getOrdet()));
                        int score = Integer.parseInt(playerScore.trim());
                        score = score/2;
                        playerScore = Integer.toString(score);
                        intent.putExtra("playerScore", String.valueOf(playerScore));

                        Player myDB = new Player(HangmanGame.this);
                        myDB.updateScore(playerId, playerScore);

                        startActivity(intent);
                        finish();
                    }
                },2000);
            }

        }

    }
}