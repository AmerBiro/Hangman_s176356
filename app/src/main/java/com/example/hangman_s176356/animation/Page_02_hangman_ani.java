package com.example.hangman_s176356.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hangman_s176356.R;
import com.example.hangman_s176356.databinding.ActivityStartPage02Binding;

public class Page_02_hangman_ani extends AppCompatActivity {
    private ActivityStartPage02Binding binding;


    private static int SPLASH_SCREEB = 6000;

    Animation rightToLeft, leftToRight01, leftToRight02, leftToRight03, leftToRight04,
            leftToRight05, leftToRight06, leftToRight07;
    ImageView logo, h, a, n, g, m, aa, nn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page_02);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = ActivityStartPage02Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        leftToRight01 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_01);
        leftToRight02 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_02);
        leftToRight03 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_03);
        leftToRight04 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_04);
        leftToRight05 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_05);
        leftToRight06 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_06);
        leftToRight07 = AnimationUtils.loadAnimation(this, R.anim.left_to_right_07);

        binding.logo.setAnimation(rightToLeft);
        binding.h.setAnimation(leftToRight01);
        binding.a.setAnimation(leftToRight02);
        binding.n.setAnimation(leftToRight03);
        binding.g.setAnimation(leftToRight04);
        binding.m.setAnimation(leftToRight05);
        binding.aa.setAnimation(leftToRight06);
        binding.nn.setAnimation(leftToRight07);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Page_02_hangman_ani.this, Page_03_loading.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEB);
    }
}