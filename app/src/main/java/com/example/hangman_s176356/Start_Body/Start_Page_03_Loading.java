package com.example.hangman_s176356.Start_Body;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.hangman_s176356.MainActivity;
import com.example.hangman_s176356.R;

public class Start_Page_03_Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page_03__loading);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start_Page_03_Loading.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },7000);
    }
}