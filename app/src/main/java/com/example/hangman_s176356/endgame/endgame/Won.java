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
import com.example.hangman_s176356.databinding.AnimationWonBinding;

public class Won extends AppCompatActivity {
    String number_of, playerScore;
    private AnimationWonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_won);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = AnimationWonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Won.this, MainPage.class);
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

        getAndSetIntentData();

    }


    void getAndSetIntentData(){
        if(getIntent().hasExtra("number_of") &&
                getIntent().hasExtra("playerScore")){
            //Getting Data from Intent
            number_of = getIntent().getStringExtra("number_of");
            playerScore = getIntent().getStringExtra("playerScore");

            //Setting Intent Data
            binding.numberOf.setText(number_of + " times");
            binding.playerScore.setText("Your new score is: " + playerScore);
            Log.d("stev", number_of);
        }else{
            Toast.makeText(this, "No number to show", Toast.LENGTH_SHORT).show();
            binding.numberOf.setText("");
        }
    }

}