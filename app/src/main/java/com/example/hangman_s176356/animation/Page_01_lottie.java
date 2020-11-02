package com.example.hangman_s176356.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.hangman_s176356.R;

public class Page_01_lottie extends AppCompatActivity {

    private static int SPLASH_SCREEB = 7500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_01_lottie);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Page_01_lottie.this, Page_02_hangman_ani.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEB);
    }
}