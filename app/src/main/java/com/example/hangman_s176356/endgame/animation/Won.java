package com.example.hangman_s176356.endgame.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.hangman_s176356.R;
import com.example.hangman_s176356.databinding.AnimationWonBinding;
import com.example.hangman_s176356.endgame.NewGame;

public class Won extends AppCompatActivity {
    String number_of;
    private AnimationWonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_won);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = AnimationWonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getAndSetIntentData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Won.this, NewGame.class);
                startActivity(intent);
                finish();
            }
        },7000);
    }


    void getAndSetIntentData(){
        if(getIntent().hasExtra("number_of")){
            //Getting Data from Intent
            number_of = getIntent().getStringExtra("number_of");

            //Setting Intent Data
            binding.numberOf.setText(number_of + " times");
            Log.d("stev", number_of);
        }else{
            Toast.makeText(this, "No number to show", Toast.LENGTH_SHORT).show();
            binding.numberOf.setText("");
        }
    }

}