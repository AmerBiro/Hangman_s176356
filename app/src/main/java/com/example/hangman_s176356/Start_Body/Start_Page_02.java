package com.example.hangman_s176356.Start_Body;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hangman_s176356.MainActivity;
import com.example.hangman_s176356.R;

public class Start_Page_02 extends AppCompatActivity {

    private static int SPLASH_SCREEB = 6000;

    Animation rightToLeft, leftToRight01, leftToRight02, leftToRight03, leftToRight04,
            leftToRight05, leftToRight06, leftToRight07;
    ImageView logo, h, a, n, g, m, aa, nn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page_02);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        leftToRight01 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_01);
        leftToRight02 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_02);
        leftToRight03 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_03);
        leftToRight04 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_04);
        leftToRight05 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_05);
        leftToRight06 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_06);
        leftToRight07 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_07);

        logo = findViewById(R.id.logo);
        h = findViewById(R.id.h);
        a = findViewById(R.id.a);
        n = findViewById(R.id.n);
        g = findViewById(R.id.g);
        m = findViewById(R.id.m);
        aa = findViewById(R.id.aa);
        nn = findViewById(R.id.nn);

        logo.setAnimation(rightToLeft);
        h.setAnimation(leftToRight01);
        a.setAnimation(leftToRight02);
        n.setAnimation(leftToRight03);
        g.setAnimation(leftToRight04);
        m.setAnimation(leftToRight05);
        aa.setAnimation(leftToRight06);
        nn.setAnimation(leftToRight07);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start_Page_02.this, Start_Page_03_Loading.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEB);

    }
}