package com.example.hangman_s176356.endgame.endgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.hangman_s176356.main.MainPage;
import com.example.hangman_s176356.R;
import com.example.hangman_s176356.databinding.AnimationLoseBinding;
import com.example.hangman_s176356.logic.Logic;

public class Lose extends AppCompatActivity {
    private AnimationLoseBinding binding;
    private Logic logic = new Logic();
    String right_word, playerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_lose);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = AnimationLoseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rightWord.setText(logic.getSynligtOrd());
        getAndSetIntentData();

        binding.playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lose.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        });

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finish();
            }
        });

    }


    void getAndSetIntentData(){
        if(getIntent().hasExtra("right_word")){
            //Getting Data from Intent
            right_word = getIntent().getStringExtra("right_word");
            playerScore = getIntent().getStringExtra("playerScore");

            //Setting Intent Data
            binding.rightWord.setText(right_word);
            binding.playerScore.setText("Your new score is: " + playerScore);

            Log.d("stev", right_word);
        }else{
            Toast.makeText(this, "No words to show", Toast.LENGTH_SHORT).show();
            binding.rightWord.setText("");
        }
    }

}