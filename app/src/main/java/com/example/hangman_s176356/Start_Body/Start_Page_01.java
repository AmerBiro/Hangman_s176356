package com.example.hangman_s176356.Start_Body;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.hangman_s176356.R;

public class Start_Page_01 extends AppCompatActivity {

    private static int SPLASH_SCREEB = 7500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page_01);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start_Page_01.this, Start_Page_02.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEB);

    }
}