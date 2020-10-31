package com.example.hangman_s176356;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.hangman_s176356.adapters.MainPage_Fragments_Adapter;
import com.example.hangman_s176356.databinding.ActivityMainBinding;
import com.example.hangman_s176356.mainpage_fragments.Page01_RulesFragment;
import com.example.hangman_s176356.mainpage_fragments.Page02_GameFragment;
import com.example.hangman_s176356.mainpage_fragments.Page03_ScoreFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private Page01_RulesFragment page01Rules_fragment;
    private Page02_GameFragment page02Game_fragment;
    private Page03_ScoreFragment page03Score_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        page01Rules_fragment = new Page01_RulesFragment();
        page02Game_fragment = new Page02_GameFragment();
        page03Score_fragment = new Page03_ScoreFragment();

        binding.tabLayut.setupWithViewPager(binding.viewPager);
        MainPage_Fragments_Adapter mainPageAdapter = new MainPage_Fragments_Adapter(getSupportFragmentManager(), 0);

        mainPageAdapter.addFragment(page01Rules_fragment, "Rules");
        mainPageAdapter.addFragment(page02Game_fragment, "Game");
        mainPageAdapter.addFragment(page03Score_fragment, "Score");

        binding.viewPager.setAdapter(mainPageAdapter);
        binding.viewPager.setCurrentItem(1);
        binding.tabLayut.getTabAt(0).setIcon(R.drawable.rules);
        binding.tabLayut.getTabAt(1).setIcon(R.drawable.game);
        binding.tabLayut.getTabAt(2).setIcon(R.drawable.score);
////////////////////////////////////////////////////////////////////////////////

    }
}