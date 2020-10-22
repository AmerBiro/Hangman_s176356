package com.example.hangman_s176356;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.example.hangman_s176356.Game_Body.*;
import com.example.hangman_s176356.Start_Body.*;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;


    private Rules_Fragment rules_fragment;
    private Game_Fragment game_fragment;
    private Score_Fragment score_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layut);


        rules_fragment = new Rules_Fragment();
        game_fragment = new Game_Fragment();
        score_fragment = new Score_Fragment();

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);

        viewPagerAdapter.addFragment(rules_fragment, "Rules");
        viewPagerAdapter.addFragment(game_fragment, "Game");
        viewPagerAdapter.addFragment(score_fragment, "Score");

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1);
        tabLayout.getTabAt(0).setIcon(R.drawable.rules);
        tabLayout.getTabAt(1).setIcon(R.drawable.game);
        tabLayout.getTabAt(2).setIcon(R.drawable.score);
////////////////////////////////////////////////////////////////////////////////

    }
}