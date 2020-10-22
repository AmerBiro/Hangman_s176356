package com.example.hangman_s176356.End_Game_Body;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hangman_s176356.R;
import com.example.hangman_s176356.Start_Body.Start_Page_03_Loading;

public class End_Game extends AppCompatActivity {

    ImageView play_again, play_again_logo, yes, no;
    Animation play_againANI, play_again_logoANI, yesANI, noANI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end__game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        play_again = findViewById(R.id.play_again);
        play_again_logo = findViewById(R.id.play_again_logo);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        play_againANI = AnimationUtils.loadAnimation(this, R.anim.play_again);
        play_again_logoANI = AnimationUtils.loadAnimation(this, R.anim.play_again_logo);
        yesANI = AnimationUtils.loadAnimation(this, R.anim.yes);
        noANI = AnimationUtils.loadAnimation(this, R.anim.no);

        play_again.setAnimation(play_againANI);
        play_again_logo.setAnimation(play_again_logoANI);
        yes.setAnimation(yesANI);
        no.setAnimation(noANI);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(End_Game.this, Start_Page_03_Loading.class);
                startActivity(intent);
                finish();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finish();
            }
        });

    }
}