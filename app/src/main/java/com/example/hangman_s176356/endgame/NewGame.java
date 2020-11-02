package com.example.hangman_s176356.endgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.hangman_s176356.R;
import com.example.hangman_s176356.animation.Page_03_loading;
import com.example.hangman_s176356.databinding.GameNewGameBinding;

public class NewGame extends AppCompatActivity {
    private GameNewGameBinding binding;

    Animation play_againANI, play_again_logoANI, yesANI, noANI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_new_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = GameNewGameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        play_againANI = AnimationUtils.loadAnimation(this, R.anim.play_again);
        play_again_logoANI = AnimationUtils.loadAnimation(this, R.anim.play_again_logo);
        yesANI = AnimationUtils.loadAnimation(this, R.anim.yes);
        noANI = AnimationUtils.loadAnimation(this, R.anim.no);

        binding.playAgain.setAnimation(play_againANI);
        binding.playAgainLogo.setAnimation(play_again_logoANI);
        binding.yes.setAnimation(yesANI);
        binding.no.setAnimation(noANI);

        binding.yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGame.this, Page_03_loading.class);
                startActivity(intent);
                finish();
            }
        });

        binding.no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finish();
            }
        });

    }
}